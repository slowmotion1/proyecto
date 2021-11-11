/*
Copyright (c) 2000 The Regents of the University of California.
All rights reserved.

Permission to use, copy, modify, and distribute this software for any
purpose, without fee, and without written agreement is hereby granted,
provided that the above copyright notice and the following two
paragraphs appear in all copies of this software.

IN NO EVENT SHALL THE UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR
DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES ARISING OUT
OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF THE UNIVERSITY OF
CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY WARRANTIES,
INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY
AND FITNESS FOR A PARTICULAR PURPOSE.  THE SOFTWARE PROVIDED HEREUNDER IS
ON AN "AS IS" BASIS, AND THE UNIVERSITY OF CALIFORNIA HAS NO OBLIGATION TO
PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS, OR MODIFICATIONS.
*/

// This is a project skeleton file

import java.io.PrintStream;
import java.util.Vector;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.*;
import java.util.Set;

/** This class is used for representing the inheritance tree during code
    generation. You will need to fill in some of its methods and
    potentially extend it in other useful ways. */
class CgenClassTable extends SymbolTable {

    /** All classes in the program, represented as CgenNode */
    private Vector<CgenNode> nds;

    /** This is the stream to which assembly instructions are output */
    private PrintStream str;

    private int stringclasstag;
    private int intclasstag;
    private int boolclasstag;

    /********************** mis variables***************************************/
    public int c_size;
    public Hashtable<String, LinkedList<String>> va = new Hashtable<String, LinkedList<String>>();
    public Hashtable<AbstractSymbol, SymbolTable> OT;
    public Hashtable<AbstractSymbol,Hashtable<AbstractSymbol, Integer>> MT;
    public int labelcont;
    public AbstractSymbol currentClass;
    public AbstractSymbol filename;
    public int currentSize;
    public Hashtable<AbstractSymbol, Integer> tags;
    public Hashtable<Integer,AbstractSymbol> tags1;

    // The following methods emit code for constants and global
    // declarations.
    private int tag = 0;
    public void label(){
        labelcont++;
    }

    /** Emits code to start the .data segment and to
     * declare the global names.
     * */
    private void codeGlobalData() {
        // The following global names must be defined first.
        /*
            .data
            .align  2
            .globl  class_nameTab
            .globl  Main_protObj
            .globl  Int_protObj
            .globl  String_protObj
            .globl  bool_const0
            .globl  bool_const1
            .globl  _int_tag
            .globl  _bool_tag
            .globl  _string_tag
        */
        str.print("  .data\n" + CgenSupport.ALIGN);
        str.println(CgenSupport.GLOBAL + CgenSupport.CLASSNAMETAB);
        str.print(CgenSupport.GLOBAL);
        CgenSupport.emitProtObjRef(TreeConstants.Main, str);
        str.println("");
        str.print(CgenSupport.GLOBAL);
        CgenSupport.emitProtObjRef(TreeConstants.Int, str);
        str.println("");
        str.print(CgenSupport.GLOBAL);
        CgenSupport.emitProtObjRef(TreeConstants.Str, str);
        str.println("");
        str.print(CgenSupport.GLOBAL);
        BoolConst.falsebool.codeRef(str);
        str.println("");
        str.print(CgenSupport.GLOBAL);
        BoolConst.truebool.codeRef(str);
        str.println("");
        str.println(CgenSupport.GLOBAL + CgenSupport.INTTAG);
        str.println(CgenSupport.GLOBAL + CgenSupport.BOOLTAG);
        str.println(CgenSupport.GLOBAL + CgenSupport.STRINGTAG);

        // We also need to know the tag of the Int, String, and Bool classes
        // during code generation.
        /*
            _int_tag:
                .word  x
            _bool_tag:
                .word  y
            _string_tag:
                .word  z
        */
        str.println(CgenSupport.INTTAG + CgenSupport.LABEL
              + CgenSupport.WORD + intclasstag);
        str.println(CgenSupport.BOOLTAG + CgenSupport.LABEL
              + CgenSupport.WORD + boolclasstag);
        str.println(CgenSupport.STRINGTAG + CgenSupport.LABEL
              + CgenSupport.WORD + stringclasstag);
    }

    /** Generates memory manager code */
    private void codeMemoryManager() {
        /*
            .globl  _MemMgr_TEST
            _MemMgr_TEST:
            .word  0/1
        */
        str.println(CgenSupport.GLOBAL + "_MemMgr_TEST");
        str.println("_MemMgr_TEST:");
        str.println(CgenSupport.WORD + ((Flags.cgen_Memmgr_Test == Flags.GC_TEST) ? "1" : "0"));
    }

    /** Emits code to start the .text segment and to
     * declare the global names.
     * */
    private void codeGlobalText() {
        /*
            .globl  heap_start
            heap_start:
                .word  0
                .text
                .globl  Main_init
                .globl  Int_init
                .globl  String_init
                .globl  Bool_init
                .globl  Main.main
        */
        str.println(CgenSupport.GLOBAL + CgenSupport.HEAP_START);
        str.print(CgenSupport.HEAP_START + CgenSupport.LABEL);
        str.println(CgenSupport.WORD + 0);
        str.println("  .text");
        str.print(CgenSupport.GLOBAL);
        CgenSupport.emitInitRef(TreeConstants.Main, str);
        str.println("");
        str.print(CgenSupport.GLOBAL);
        CgenSupport.emitInitRef(TreeConstants.Int, str);
        str.println("");
        str.print(CgenSupport.GLOBAL);
        CgenSupport.emitInitRef(TreeConstants.Str, str);
        str.println("");
        str.print(CgenSupport.GLOBAL);
        CgenSupport.emitInitRef(TreeConstants.Bool, str);
        str.println("");
        str.print(CgenSupport.GLOBAL);
        CgenSupport.emitMethodRef(TreeConstants.Main, TreeConstants.main_meth, str);
        str.println("");
    }


    /** Emits code to reserve space for and initialize all of the
     * constants.  Class names should have been added to the string
     * table (in the supplied code, is is done during the construction
     * of the inheritance graph), and code for emitting string constants
     * as a side effect adds the string's length to the integer table.
     * The constants are emmitted by running through the stringtable and
     * inttable and producing code for each entry. */
    private void codeConstants() {
        // Add constants that are required by the code generator.
        AbstractTable.stringtable.addString("");
        AbstractTable.inttable.addString("0");
        // string constants
        AbstractTable.stringtable.codeStringTable(stringclasstag, str);
        // int constants
        AbstractTable.inttable.codeStringTable(intclasstag, str);
        // true/false constant definition
        BoolConst.falsebool.codeDef(boolclasstag, str);
        BoolConst.truebool.codeDef(boolclasstag, str);
    }

    /** Creates data structures representing basic Cool classes (Object,
     * IO, Int, Bool, String).  Please note: as is this method does not
     * do anything useful; you will need to edit it to make if do what
     * you want.
     * */
    private void installBasicClasses() {
        AbstractSymbol filename
            = AbstractTable.stringtable.addString("<basic class>");

        // A few special class names are installed in the lookup table
        // but not the class list.  Thus, these classes exist, but are
        // not part of the inheritance hierarchy.  No_class serves as
        // the parent of Object and the other special classes.
        // SELF_TYPE is the self class; it cannot be redefined or
        // inherited.  prim_slot is a class known to the code generator.
        addId(TreeConstants.No_class,
              new CgenNode(new class_(0,
                    TreeConstants.No_class,
                    TreeConstants.No_class,
                    new Features(0),
                    filename),
               CgenNode.Basic, this));

        addId(TreeConstants.SELF_TYPE,
              new CgenNode(new class_(0,
                    TreeConstants.SELF_TYPE,
                    TreeConstants.No_class,
                    new Features(0),
                    filename),
               CgenNode.Basic, this));

        addId(TreeConstants.prim_slot,
              new CgenNode(new class_(0,
                    TreeConstants.prim_slot,
                    TreeConstants.No_class,
                    new Features(0),
                    filename),
               CgenNode.Basic, this));

        // The Object class has no parent class. Its methods are
        //        cool_abort() : Object    aborts the program
        //        type_name() : Str        returns a string representation
        //                                 of class name
        //        copy() : SELF_TYPE       returns a copy of the object
        class_ Object_class =
            new class_(0,
                 TreeConstants.Object_,
                 TreeConstants.No_class,
                 new Features(0)
               .appendElement(new method(0,
                      TreeConstants.cool_abort,
                      new Formals(0),
                      TreeConstants.Object_,
                      new no_expr(0)))
               .appendElement(new method(0,
                      TreeConstants.type_name,
                      new Formals(0),
                      TreeConstants.Str,
                      new no_expr(0)))
               .appendElement(new method(0,
                      TreeConstants.copy,
                      new Formals(0),
                      TreeConstants.SELF_TYPE,
                      new no_expr(0))),
                 filename);

        installClass(new CgenNode(Object_class, CgenNode.Basic, this));

        // The IO class inherits from Object. Its methods are
        //        out_string(Str) : SELF_TYPE  writes a string to the output
        //        out_int(Int) : SELF_TYPE      "    an int    "  "     "
        //        in_string() : Str            reads a string from the input
        //        in_int() : Int                "   an int     "  "     "
        class_ IO_class =
            new class_(0,
                 TreeConstants.IO,
                 TreeConstants.Object_,
                 new Features(0)
               .appendElement(new method(0,
                      TreeConstants.out_string,
                      new Formals(0)
                    .appendElement(new formal(0,
                           TreeConstants.arg,
                           TreeConstants.Str)),
                      TreeConstants.SELF_TYPE,
                      new no_expr(0)))
               .appendElement(new method(0,
                      TreeConstants.out_int,
                      new Formals(0)
                    .appendElement(new formal(0,
                           TreeConstants.arg,
                           TreeConstants.Int)),
                      TreeConstants.SELF_TYPE,
                      new no_expr(0)))
               .appendElement(new method(0,
                      TreeConstants.in_string,
                      new Formals(0),
                      TreeConstants.Str,
                      new no_expr(0)))
               .appendElement(new method(0,
                      TreeConstants.in_int,
                      new Formals(0),
                      TreeConstants.Int,
                      new no_expr(0))),
                 filename);

        installClass(new CgenNode(IO_class, CgenNode.Basic, this));

        // The Int class has no methods and only a single attribute, the
        // "val" for the integer.
        class_ Int_class =
            new class_(0,
                 TreeConstants.Int,
                 TreeConstants.Object_,
                 new Features(0)
               .appendElement(new attr(0,
                    TreeConstants.val,
                    TreeConstants.prim_slot,
                    new no_expr(0))),
                 filename);

        installClass(new CgenNode(Int_class, CgenNode.Basic, this));

        // Bool also has only the "val" slot.
        class_ Bool_class =
            new class_(0,
                 TreeConstants.Bool,
                 TreeConstants.Object_,
                 new Features(0)
               .appendElement(new attr(0,
                    TreeConstants.val,
                    TreeConstants.prim_slot,
                    new no_expr(0))),
                 filename);

        installClass(new CgenNode(Bool_class, CgenNode.Basic, this));

        // The class Str has a number of slots and operations:
        //       val                              the length of the string
        //       str_field                        the string itself
        //       length() : Int                   returns length of the string
        //       concat(arg: Str) : Str           performs string concatenation
        //       substr(arg: Int, arg2: Int): Str substring selection
        class_ Str_class =
            new class_(0,
                 TreeConstants.Str,
                 TreeConstants.Object_,
                 new Features(0)
               .appendElement(new attr(0,
                    TreeConstants.val,
                    TreeConstants.Int,
                    new no_expr(0)))
               .appendElement(new attr(0,
                    TreeConstants.str_field,
                    TreeConstants.prim_slot,
                    new no_expr(0)))
               .appendElement(new method(0,
                      TreeConstants.length,
                      new Formals(0),
                      TreeConstants.Int,
                      new no_expr(0)))
               .appendElement(new method(0,
                      TreeConstants.concat,
                      new Formals(0)
                    .appendElement(new formal(0,
                           TreeConstants.arg,
                           TreeConstants.Str)),
                      TreeConstants.Str,
                      new no_expr(0)))
               .appendElement(new method(0,
                      TreeConstants.substr,
                      new Formals(0)
                    .appendElement(new formal(0,
                           TreeConstants.arg,
                           TreeConstants.Int))
                    .appendElement(new formal(0,
                           TreeConstants.arg2,
                           TreeConstants.Int)),
                      TreeConstants.Str,
                      new no_expr(0))),
                 filename);

        installClass(new CgenNode(Str_class, CgenNode.Basic, this));
    }

    // The following creates an inheritance graph from
    // a list of classes.  The graph is implemented as
    // a tree of `CgenNode', and class names are placed
    // in the base class symbol table.
    private void installClass(CgenNode nd) {
        AbstractSymbol name = nd.getName();
        if (probe(name) != null) return;
        nds.addElement(nd);
        addId(name, nd);
    }

    private void installClasses(Classes cs) {
        for (Enumeration e = cs.getElements(); e.hasMoreElements(); ) {
            installClass(new CgenNode((Class_)e.nextElement(),
              CgenNode.NotBasic, this));
        }
    }

    private void buildInheritanceTree() {
        for (Enumeration e = nds.elements(); e.hasMoreElements(); ) {
            setRelations((CgenNode)e.nextElement());
        }
    }

    private void setRelations(CgenNode nd) {
        CgenNode parent = (CgenNode)probe(nd.getParent());
        nd.setParentNd(parent);
        parent.addChild(nd);
    }

    /** Constructs a new class table and invokes the code generator */
    public CgenClassTable(Classes cls, PrintStream str) {
        labelcont=0;
        nds = new Vector();

        this.str = str;

        stringclasstag = 4 /* Change to your String class tag here */;
        intclasstag =    2 /* Change to your Int class tag here */;
        boolclasstag =   3 /* Change to your Bool class tag here */;

        enterScope();
        if (Flags.cgen_debug) System.out.println("Building CgenClassTable");

        installBasicClasses();
        installClasses(cls);
        buildInheritanceTree();

        code(cls, str);

        exitScope();
    }

    /** This method is the meat of the code generator.  It is to be
        filled in programming assignment 5 */
    public void code(Classes cls, PrintStream str) {
        if (Flags.cgen_debug) System.out.println("coding global data");
        codeGlobalData();

        if (Flags.cgen_debug) System.out.println("coding memory manager");
        codeMemoryManager();

        if (Flags.cgen_debug) System.out.println("coding constants");
        codeConstants();

        //                 Add your code to emit
        //                   - prototype objects
        //                   - class_nameTab
        //                   - dispatch tables
        str.print(CgenSupport.CLASSNAMETAB.concat(CgenSupport.LABEL));
        for(int i = 0; i <cls.getLength()+5; i++){
          str.println(CgenSupport.WORD + CgenSupport.STRCONST_PREFIX + (i+5));
        }

        Hashtable<String, LinkedList> mth = new Hashtable<String, LinkedList>();
        Hashtable<String, LinkedList> pare = new Hashtable<String, LinkedList>();
        Hashtable<String, LinkedList<String>> attrib = new Hashtable<String, LinkedList<String>>();
        Hashtable<String, LinkedList<attr>> trib = new Hashtable<String, LinkedList<attr>>();
        this.tags = new Hashtable<AbstractSymbol, Integer>();
        this.tags1 = new Hashtable<Integer, AbstractSymbol>();
        Hashtable<AbstractSymbol, SymbolTable> tab = new Hashtable<AbstractSymbol, SymbolTable>();


        this.OT = new Hashtable<AbstractSymbol, SymbolTable>();
        this.MT = new Hashtable<AbstractSymbol, Hashtable<AbstractSymbol, Integer>>();
        for(int i=0; i < this.nds.size(); i++) {
          CgenNode nd = this.nds.elementAt(i);
          SymbolTable st = new SymbolTable();
          // Scope Global
          st.enterScope();
          this.OT.put(nd.name, st);
          Pair p=new Pair(CgenSupport.SELF,0);
          this.OT.get(nd.name).addId(TreeConstants.self, p);
          this.MT.put(nd.name, new Hashtable<AbstractSymbol, Integer>());
      }

        LinkedList<String> basic_c = new LinkedList<String>();
        basic_c.add("Object");
        basic_c.add("IO");
        basic_c.add("Int");
        basic_c.add("Bool");
        basic_c.add("String");

        this.find(root(), mth, pare, attrib,trib, str);
        this.setTags(this.root());


        for(Enumeration e = cls.getElements(); e.hasMoreElements();){
          class_ current_class = (class_) e.nextElement();
          basic_c.add(current_class.name.toString());
        }


        for(int i=0; i < this.nds.size(); i++) {
          CgenNode nd = this.nds.elementAt(i);
          SymbolTable st = new SymbolTable();
          // Scope Global
          st.enterScope();
          tab.put(nd.name, st);
          Pair p=new Pair(CgenSupport.SELF,0);
          tab.get(nd.name).addId(TreeConstants.self, p);
      }





        str.print(CgenSupport.CLASSOBJTAB.concat(CgenSupport.LABEL));
        for(int i = 0; i<basic_c.size(); i++){
          str.println(CgenSupport.WORD + basic_c.get(i) + CgenSupport.PROTOBJ_SUFFIX);
          str.println(CgenSupport.WORD + basic_c.get(i) + CgenSupport.CLASSINIT_SUFFIX);
        }

        //Imprime los DISPTAB utilizando la hash de methodos y padres
        printDispatchTab(root(), true, str);

        //impimientdo protObj
        int det = 3; //predefino el tamano predeterminado
        for(int i = 0; i<basic_c.size(); i++){
          str.print(basic_c.get(i) + CgenSupport.PROTOBJ_SUFFIX + CgenSupport.LABEL);

          if(pare.containsKey(basic_c.get(i))){
            LinkedList<AbstractSymbol> p_list = pare.get(basic_c.get(i));
            for(int j = 0; j<p_list.size(); j++){
              j=p_list.size() - 1;
              if(attrib.containsKey(p_list.get(j).toString())){
                LinkedList<String> att_list = attrib.get(basic_c.get(i));
                LinkedList<String> att_list2 = attrib.get(p_list.get(j).toString());
                LinkedList<attr> att_list3 = trib.get(basic_c.get(i));
                LinkedList<attr> att_list4 = trib.get(p_list.get(j).toString());
                  if(att_list2 != null){
                    att_list.addAll(att_list2);
                    attrib.put(basic_c.get(i), att_list);
                    att_list4.addAll(att_list3);
                    trib.put(basic_c.get(i), att_list4);
                  }
              }
            }
          }

          if(attrib.containsKey(basic_c.get(i))){
            det= det + attrib.get(basic_c.get(i)).size();
          }
          str.println(CgenSupport.WORD + i);
          str.println(CgenSupport.WORD + det);
          str.println(CgenSupport.WORD + basic_c.get(i) + CgenSupport.DISPTAB_SUFFIX);

          if(trib.containsKey(basic_c.get(i))){
            LinkedList<attr> aaa = trib.get(basic_c.get(i));
            for(int j = 0; j<aaa.size(); j++){
              attr v_serch = aaa.get(j);
              if(v_serch.type_decl == TreeConstants.Int) {
                    str.print(CgenSupport.WORD);
                    ((IntSymbol) AbstractTable.inttable.lookup("0")).codeRef(str);
                    str.println();
                } else if(v_serch.type_decl == TreeConstants.Bool) {
                    str.print(CgenSupport.WORD);
                    BoolConst.falsebool.codeRef(str);
                    str.println();
                } else if(v_serch.type_decl == TreeConstants.Str) {
                    str.print(CgenSupport.WORD);
                    ((StringSymbol) AbstractTable.stringtable.lookup("")).codeRef(str);
                    str.println();
                } else {
                    this.str.println(CgenSupport.WORD + "0");
                }
            }
          }

          det=3;
        }


        if (Flags.cgen_debug) System.out.println("coding global text");

        codeGlobalText();

        printInit(this.root());

        printMethods(root(), tab,attrib, str);

    }





    public void setTags(CgenNode nd) {
        this.tags.put(nd.name, this.tag);
        this.tags1.put(this.tag, nd.name);
        Enumeration children = nd.getChildren();
        while(children.hasMoreElements()) {
            CgenNode ch = (CgenNode) children.nextElement();
            this.tag++;
            setTags(ch);
        }
    }




    private void printDispatchTab(CgenNode nd, boolean reverse, PrintStream str) {
        this.str.print(nd.name + CgenSupport.DISPTAB_SUFFIX + CgenSupport.LABEL);
        Vector<AbstractSymbol> cls = new Vector<AbstractSymbol>();
        Vector<AbstractSymbol> names = new Vector<AbstractSymbol>();
        Vector<CgenNode> parents = this.getParents(nd, reverse);
        for(int j=0; j < parents.size(); j++) {
            CgenNode parent = parents.elementAt(j);
            for(int k=0; k < parent.features.getLength(); k++) {
                Feature F = (Feature) parent.features.getNth(k);
                if (F instanceof method) {
                    method meth = (method) F;
                    if(!names.contains(meth.name)) {
                        cls.add(parent.name);
                        names.add(meth.name);
                    } else {
                        int index = names.indexOf(meth.name);
                        names.remove(index);
                        cls.remove(index);
                        cls.add(index, parent.name);
                        names.add(index, meth.name);
                    }
                }
            }
        }
        for(int j=0; j < nd.features.getLength(); j++) {
            Feature F = (Feature) nd.features.getNth(j);
            if (F instanceof method) {
                method meth = (method) F;
                if(!names.contains(meth.name)) {
                    cls.add(nd.name);
                    names.add(meth.name);
                } else {
                    int index = names.indexOf(meth.name);
                    names.remove(index);
                    cls.remove(index);
                    cls.add(index, nd.name);
                    names.add(index, meth.name);
                }
            }
        }
        for(int i=0; i < cls.size(); i++) {
            this.MT.get(nd.name).put(names.elementAt(i), i);
            str.println(CgenSupport.WORD + cls.elementAt(i) + "." + names.elementAt(i));
        }
        Enumeration children = nd.getChildren();
        while(children.hasMoreElements()) {
            CgenNode ch = (CgenNode) children.nextElement();
            printDispatchTab(ch, true, str);
        }
    }

    private void printMethods(CgenNode nd, Hashtable<AbstractSymbol, SymbolTable> tab,Hashtable<String, LinkedList<String>> attrib, PrintStream s) {
      if(nd.name != TreeConstants.Object_ && nd.name != TreeConstants.IO
              && nd.name != TreeConstants.Int && nd.name != TreeConstants.Bool
              && nd.name != TreeConstants.Str) {
              for(int j=0; j < nd.features.getLength(); j++) {
                  Feature f = (Feature) nd.features.getNth(j);
                  if (f instanceof method) {
                      method m = (method) f;
                      s.println(nd.name + CgenSupport.METHOD_SEP + m.name+":");
                      int size = CgenSupport.DEFAULT_OBJFIELDS;
                      CgenSupport.emitPrologue(size, s);
                      this.currentSize = CgenSupport.DEFAULT_OBJFIELDS;
                      this.currentClass = nd.name;
                      this.filename = nd.filename;
                      this.OT.get(nd.name).enterScope();
                      for(int k=m.formals.getLength()-1,l=0; k >= 0; k--,l++) {
                          formal fc = (formal) m.formals.getNth(k);
                          this.OT.get(nd.name).addId(fc.name, new Pair(CgenSupport.FP, size+l));
                      }
                      m.expr.code(str, this);
                      this.OT.get(nd.name).exitScope();
                      CgenSupport.emitEpilogue(size + m.formals.getLength(), false, str);
                  }
              }
          }
      Enumeration children = nd.getChildren();
      while(children.hasMoreElements()) {
          CgenNode ch = (CgenNode) children.nextElement();
          this.printMethods(ch, tab, attrib, s);
      }
    }



    public class Pair {

        private String loc;
        private int offset;

        public Pair(String loc, int offset) {
            this.loc = loc;
            this.offset = offset;
        }

        public String getLoc() {
            return this.loc;
        }

        public int getOffset() {
            return this.offset;
        }

    }

    public int getMaxChild(CgenNode nd) {
    int tag = this.tags.get(nd.name);
    Enumeration children = nd.getChildren();
    while(children.hasMoreElements()) {
        CgenNode ch = (CgenNode) children.nextElement();
        tag = (int)Math.max(tag, getMaxChild(ch));
    }
    return tag;
}

    public int getMaxChild(int i){
      CgenNode nd =(CgenNode)this.probe(tags1.get(i));
      return getMaxChild(nd);
    }



    private void printInit(CgenNode nd) {
        // Hacemos la definicion de init

        str.println(nd.name + CgenSupport.CLASSINIT_SUFFIX + ":");
        // Obtenemos el size que devemos reservar
        int size = 3;
        // Hacemos el prologo
        CgenSupport.emitPrologue(size, str);
        // Si el nodo es diferente de object llamamos al init del parent
        if(nd.name != TreeConstants.Object_) {
            CgenSupport.emitJal(nd.getParent() + CgenSupport.CLASSINIT_SUFFIX, str);
        }
        // Recorremos los features
        for(int j=0; j < nd.features.getLength(); j++) {
            Feature f = (Feature) nd.features.getNth(j);
            // si es un atributo
            if (f instanceof attr) {
                attr a = (attr) f;
                if(!(a.init instanceof no_expr)) {
                    // llamamos a code del init
                    int currentSize = CgenSupport.DEFAULT_OBJFIELDS;
                    this.currentClass = nd.name;
                    this.filename = nd.filename;
                    a.init.code(str, this);
                    // el resultado queda en ACC lo guardamos en el offset de $s0
                    CgenSupport.emitStore(CgenSupport.ACC, 3, CgenSupport.SELF, str);
                }
            }
        }
        // Hacemos el epilogo
        CgenSupport.emitEpilogue(size, true, str);
        Enumeration children = nd.getChildren();
        while(children.hasMoreElements()) {
            CgenNode ch = (CgenNode) children.nextElement();
            this.printInit(ch);
        }
    }

    public boolean compare(LinkedList<AbstractSymbol> clasee, AbstractSymbol metodoo,LinkedList<AbstractSymbol> paren, Hashtable<String, LinkedList> mth, int j, PrintStream str){
      String ff = String.valueOf(j);
      j++;
      while(j < paren.size()){
        if((mth.get(paren.get(j).toString())).contains(metodoo)){
          j =  Integer.parseInt(ff);
          return false;
        }else{
          j++;
        }
      }
      j =  Integer.parseInt(ff);
      return !(clasee.contains(metodoo));
    }

    public void find(CgenNode nd, Hashtable mth, Hashtable pare, Hashtable<String,LinkedList<String>> attrib,Hashtable<String,LinkedList<attr>> trib, PrintStream str){
      LinkedList<AbstractSymbol> obj_meth = new LinkedList<AbstractSymbol>();
      for(int a = 0; a<nd.features.getLength(); a++){
        Feature F = (Feature) nd.features.getNth(a);
        if (F instanceof method) {
            method meth = (method) F;
            obj_meth.add(meth.name);
        }
        if(F instanceof attr){
          attr atributo = (attr) F;
          if(attrib.containsKey(nd.name.toString())){
            LinkedList<String> att_list = attrib.get(nd.name.toString());
            LinkedList<String> att_list2 = va.get(nd.name.toString());
            LinkedList<attr> aaa = trib.get(nd.name.toString());
            aaa.add(atributo);
            trib.put(nd.name.toString(), aaa);
            att_list.add(atributo.name.toString());
            attrib.put(nd.name.toString(), att_list);
            va.put(nd.name.toString(), att_list2);
          }else{
            LinkedList<String> att_list = new LinkedList<String>();
            LinkedList<String> att_list3 = new LinkedList<String>();
            LinkedList<attr> att_list2 = new LinkedList<attr>();
            att_list2.add(atributo);
            att_list.add(atributo.name.toString());
            att_list3.add(atributo.name.toString());
            attrib.put(nd.name.toString(), att_list);
            trib.put(nd.name.toString(), att_list2);
            va.put(nd.name.toString(), att_list3);
          }
        }

      }



      Vector<CgenNode> parrrr = this.getParents((CgenNode)nd, true);
      LinkedList<AbstractSymbol> parenlist = new LinkedList<AbstractSymbol>();
      for(int k = 0; k<parrrr.size(); k++){
        parenlist.add(((CgenNode)parrrr.elementAt(k)).name);
      }
      mth.put(nd.name.toString(), obj_meth);
      pare.put(nd.name.toString(), parenlist);

      int cont = 0;
      for(Enumeration e = nd.getChildren(); e.hasMoreElements();){
        LinkedList<AbstractSymbol> list_meth = new LinkedList<AbstractSymbol>();
          class_ current_class = (class_) e.nextElement();

        for(int k = 0; k<current_class.features.getLength(); k++){
          Feature F = (Feature) current_class.features.getNth(k);
          if (F instanceof method) {
              method meth = (method) F;
              list_meth.add(meth.name);
          }
          if(F instanceof attr){
            attr atributo = (attr) F;
            if(attrib.containsKey(current_class.name.toString())){
              LinkedList<String> att_list = attrib.get(current_class.name.toString());
              LinkedList<String> att_list2 = va.get(current_class.name.toString());
              LinkedList<attr> aaa = trib.get(current_class.name.toString());
              aaa.add(atributo);
              trib.put(current_class.name.toString(), aaa);
              att_list.add(atributo.name.toString());
              attrib.put(current_class.name.toString(), att_list);
              va.put(current_class.name.toString(), att_list2);
            }else{
              LinkedList<String> att_list = new LinkedList<String>();
              LinkedList<String> att_list3 = new LinkedList<String>();
              LinkedList<attr> att_list2 = new LinkedList<attr>();
              att_list2.add(atributo);
              att_list.add(atributo.name.toString());
              att_list3.add(atributo.name.toString());
              attrib.put(current_class.name.toString(), att_list);
              trib.put(current_class.name.toString(), att_list2);
              va.put(current_class.name.toString(), att_list3);
            }
          }
        }
        Vector<CgenNode> parents = this.getParents((CgenNode)current_class, true);
        LinkedList<AbstractSymbol> par_list = new LinkedList<AbstractSymbol>();
        for(int k = 0; k<parents.size(); k++){
          par_list.add(((CgenNode)parents.elementAt(k)).name);
        }

        mth.put(current_class.name.toString(), list_meth);
        pare.put(current_class.name.toString(), par_list);

        CgenNode nde = (CgenNode)current_class;
        Enumeration children = nde.getChildren();
        while(children.hasMoreElements()) {
            CgenNode ch = (CgenNode) children.nextElement();
            this.find(ch, mth, pare, attrib, trib, str);
        }

      }
    }

    public Vector<CgenNode> getParents(CgenNode nd, boolean reverse) {
        if(nd.name == TreeConstants.Object_) {
            return new Vector<CgenNode>();
        } else {
            Vector<CgenNode> parents = new Vector<CgenNode>();
            CgenNode parent = (CgenNode) nd.getParentNd();
            while(parent.name != TreeConstants.Object_) {
                if(reverse)
                    parents.add(0, parent);
                else
                    parents.add(parent);

                parent = parent.getParentNd();
            }
            if(reverse)
                parents.add(0, parent);
            else
                parents.add(parent);

            return parents;
        }
    }

    /** Gets the root of the inheritance tree */
    public CgenNode root() {
        return (CgenNode)probe(TreeConstants.Object_);
    }

}
