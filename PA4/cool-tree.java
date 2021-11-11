import java.util.Enumeration;
import java.io.PrintStream;
import java.util.Vector;
import java.util.LinkedList;
import java.util.*;
import java.util.Arrays;


/** Defines simple phylum Program */
abstract class Program extends TreeNode {

    protected Program(int lineNumber) {
        super(lineNumber);
    }

    public abstract void dump_with_types(PrintStream out, int n);
    public abstract void semant();
    public abstract void cgen(PrintStream s);

}


/** Defines simple phylum Class_ */
abstract class Class_ extends TreeNode {

    protected Class_(int lineNumber) {
        super(lineNumber);
    }

    public abstract void dump_with_types(PrintStream out, int n);
    public abstract AbstractSymbol getName();
    public abstract AbstractSymbol getParent();
    public abstract AbstractSymbol getFilename();
    public abstract Features getFeatures();

}


/** Defines list phylum Classes
    <p>
    See <a href="ListNode.html">ListNode</a> for full documentation. */
class Classes extends ListNode {

    public final static Class elementClass = Class_.class;

    /** Returns class of this lists's elements */
    public Class getElementClass() {
        return elementClass;
    }

    protected Classes(int lineNumber, Vector elements) {
        super(lineNumber, elements);
    }

    /** Creates an empty "Classes" list */
    public Classes(int lineNumber) {
        super(lineNumber);
    }

    /** Appends "Class_" element to this list */
    public Classes appendElement(TreeNode elem) {
        addElement(elem);
        return this;
    }

    public TreeNode copy() {
        return new Classes(lineNumber, copyElements());
    }

}


/** Defines simple phylum Feature */
abstract class Feature extends TreeNode {

    protected Feature(int lineNumber) {
        super(lineNumber);
    }

    public abstract void dump_with_types(PrintStream out, int n);

}


/** Defines list phylum Features
    <p>
    See <a href="ListNode.html">ListNode</a> for full documentation. */
class Features extends ListNode {

    public final static Class elementClass = Feature.class;
    /** Returns class of this lists's elements */

    public Class getElementClass() {
        return elementClass;
    }

    protected Features(int lineNumber, Vector elements) {
        super(lineNumber, elements);
    }

    /** Creates an empty "Features" list */
    public Features(int lineNumber) {
        super(lineNumber);
    }

    /** Appends "Feature" element to this list */
    public Features appendElement(TreeNode elem) {
        addElement(elem);
        return this;
    }

    public TreeNode copy() {
        return new Features(lineNumber, copyElements());
    }

}


/** Defines simple phylum Formal */
abstract class Formal extends TreeNode {

    protected Formal(int lineNumber) {
        super(lineNumber);
    }

    public abstract void dump_with_types(PrintStream out, int n);

}


/** Defines list phylum Formals
    <p>
    See <a href="ListNode.html">ListNode</a> for full documentation. */
class Formals extends ListNode {

    public final static Class elementClass = Formal.class;

    /** Returns class of this lists's elements */
    public Class getElementClass() {
        return elementClass;
    }

    protected Formals(int lineNumber, Vector elements) {
        super(lineNumber, elements);
    }

    /** Creates an empty "Formals" list */
    public Formals(int lineNumber) {
        super(lineNumber);
    }

    /** Appends "Formal" element to this list */
    public Formals appendElement(TreeNode elem) {
        addElement(elem);
        return this;
    }

    public TreeNode copy() {
        return new Formals(lineNumber, copyElements());
    }

}


/** Defines simple phylum Expression */
abstract class Expression extends TreeNode {

    protected Expression(int lineNumber) {
        super(lineNumber);
    }

    private AbstractSymbol type = null;

    public AbstractSymbol get_type() { return type; }

    public Expression set_type(AbstractSymbol s) { type = s; return this; }

    public abstract void dump_with_types(PrintStream out, int n);

    public void dump_type(PrintStream out, int n) {
        if (type != null)
            out.println(Utilities.pad(n) + ": " + type.getString());
        else
            out.println(Utilities.pad(n) + ": _no_type");
    }

    public abstract void code(PrintStream s, CgenClassTable cl);
    public abstract void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename);


}


/** Defines list phylum Expressions
    <p>
    See <a href="ListNode.html">ListNode</a> for full documentation. */
class Expressions extends ListNode {

    public final static Class elementClass = Expression.class;

    /** Returns class of this lists's elements */
    public Class getElementClass() {
        return elementClass;
    }

    protected Expressions(int lineNumber, Vector elements) {
        super(lineNumber, elements);
    }

    /** Creates an empty "Expressions" list */
    public Expressions(int lineNumber) {
        super(lineNumber);
    }

    /** Appends "Expression" element to this list */
    public Expressions appendElement(TreeNode elem) {
        addElement(elem);
        return this;
    }

    public TreeNode copy() {
        return new Expressions(lineNumber, copyElements());
    }

}


/** Defines simple phylum Case */
abstract class Case extends TreeNode {

    protected Case(int lineNumber) {
        super(lineNumber);
    }

    public abstract void dump_with_types(PrintStream out, int n);

}


/** Defines list phylum Cases
    <p>
    See <a href="ListNode.html">ListNode</a> for full documentation. */
class Cases extends ListNode {

    public final static Class elementClass = Case.class;

    /** Returns class of this lists's elements */
    public Class getElementClass() {
        return elementClass;
    }

    protected Cases(int lineNumber, Vector elements) {
        super(lineNumber, elements);
    }

    /** Creates an empty "Cases" list */
    public Cases(int lineNumber) {
        super(lineNumber);
    }

    /** Appends "Case" element to this list */
    public Cases appendElement(TreeNode elem) {
        addElement(elem);
        return this;
    }

    public TreeNode copy() {
        return new Cases(lineNumber, copyElements());
    }

}


/** Defines AST constructor 'program'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class program extends Program {

    public Classes classes;

    /** Creates "program" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for classes
      */
    public program(int lineNumber, Classes a1) {
        super(lineNumber);
        classes = a1;
    }

    public TreeNode copy() {
        return new program(lineNumber, (Classes)classes.copy());
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "program\n");
        classes.dump(out, n+2);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_program");
        for (Enumeration e = classes.getElements(); e.hasMoreElements(); ) {
        ((Class_)e.nextElement()).dump_with_types(out, n + 1);
        }
    }

    /** This method is the entry point to the semantic checker.  You will
        need to complete it in programming assignment 4.
    <p>
        Your checker should do the following two things:
    <ol>
    <li>Check that the program is semantically correct
    <li>Decorate the abstract syntax tree with type information
        by setting the type field in each Expression node.
        (see tree.h)
    </ol>
    <p>
    You are free to first do (1) and make sure you catch all semantic
        errors. Part (2) can be done in a second stage when you want
    to test the complete compiler.
    */
    public void semant() {
        /* ClassTable constructor may do some semantic analysis */
        ClassTable classTable = new ClassTable(classes);

        /* some semantic analysis code may go here */
/*        for(int cont = 0; cont < classes.getLength(); cont++){
          class_ cls = (class_)classes.getNth(cont);
          cls.cgen(classTable, s);
        }*/

        if (classTable.errors()) {
            System.err.println("Compilation halted due to static semantic errors.");
            System.exit(1);
        }
    }

    /** This method is the entry point to the code generator.  All of the work
      * of the code generator takes place within CgenClassTable constructor.
      * @param s the output stream
      * @see CgenClassTable
      * */
    public void cgen(PrintStream s) {
        // spim wants comments to start with '#'
        CgenClassTable codegen_classtable = new CgenClassTable(classes, s);

        ClassTable classTable = new ClassTable(classes);
          for (int x=0;x<classes.getLength() ;x++) {
              class_ tn=(class_)classes.getNth(x);
              tn.cgen(classTable, s);
          }

          if (classTable.errors()) {
              System.err.println("Compilation halted due to static semantic errors.");
              System.exit(1);
          }
    }

}


/** Defines AST constructor 'class_'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class class_ extends Class_ {

    public AbstractSymbol name;
    public AbstractSymbol parent;
    public Features features;
    public AbstractSymbol filename;

    /** Creates "class_" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for name
      * @param a1 initial value for parent
      * @param a2 initial value for features
      * @param a3 initial value for filename
      */
    public class_(int lineNumber, AbstractSymbol a1, AbstractSymbol a2, Features a3, AbstractSymbol a4) {
        super(lineNumber);
        name = a1;
        parent = a2;
        features = a3;
        filename = a4;
    }

    public TreeNode copy() {
        return new class_(lineNumber, copy_AbstractSymbol(name), copy_AbstractSymbol(parent), (Features)features.copy(), copy_AbstractSymbol(filename));
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "class_\n");
        dump_AbstractSymbol(out, n+2, name);
        dump_AbstractSymbol(out, n+2, parent);
        features.dump(out, n+2);
        dump_AbstractSymbol(out, n+2, filename);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_class");
        dump_AbstractSymbol(out, n + 2, name);
        dump_AbstractSymbol(out, n + 2, parent);
        out.print(Utilities.pad(n + 2) + "\"");
        Utilities.printEscapedString(out, filename.getString());
        out.println("\"\n" + Utilities.pad(n + 2) + "(");
        for (Enumeration e = features.getElements(); e.hasMoreElements();) {
        ((Feature)e.nextElement()).dump_with_types(out, n + 2);
        }
        out.println(Utilities.pad(n + 2) + ")");
    }

    public AbstractSymbol getName()     { return name; }
    public AbstractSymbol getParent()   { return parent; }
    public AbstractSymbol getFilename() { return filename; }
    public Features getFeatures()       { return features; }

    public void cgen(ClassTable OM, PrintStream s){
      for (int x=0;x<features.getLength() ;x++) {
          Feature f=(Feature)features.getNth(x);
          if(f instanceof method){
              ((method)f).cgen(OM, this.name, this.filename, s);
          }
          else{
              ((attr)f).cgen(OM, this.name, this.filename, s);
          }
      }
    }

}


/** Defines AST constructor 'method'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class method extends Feature {

    public AbstractSymbol name;
    public Formals formals;
    public AbstractSymbol return_type;
    public Expression expr;

    /** Creates "method" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for name
      * @param a1 initial value for formals
      * @param a2 initial value for return_type
      * @param a3 initial value for expr
      */
    public method(int lineNumber, AbstractSymbol a1, Formals a2, AbstractSymbol a3, Expression a4) {
        super(lineNumber);
        name = a1;
        formals = a2;
        return_type = a3;
        expr = a4;
    }

    public TreeNode copy() {
        return new method(lineNumber, copy_AbstractSymbol(name), (Formals)formals.copy(), copy_AbstractSymbol(return_type), (Expression)expr.copy());
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "method\n");
        dump_AbstractSymbol(out, n+2, name);
        formals.dump(out, n+2);
        dump_AbstractSymbol(out, n+2, return_type);
        expr.dump(out, n+2);
    }


    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_method");
        dump_AbstractSymbol(out, n + 2, name);
        for (Enumeration e = formals.getElements(); e.hasMoreElements();) {
            ((Formal)e.nextElement()).dump_with_types(out, n + 2);
        }
        dump_AbstractSymbol(out, n + 2, return_type);
        expr.dump_with_types(out, n + 2);
    }


    public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename, PrintStream s){
      s.println("asdfasdfasdfasdfasdf");
    }
}


/** Defines AST constructor 'attr'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class attr extends Feature {

    public AbstractSymbol name;
    public AbstractSymbol type_decl;
    public Expression init;

    /** Creates "attr" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for name
      * @param a1 initial value for type_decl
      * @param a2 initial value for init
      */
    public attr(int lineNumber, AbstractSymbol a1, AbstractSymbol a2, Expression a3) {
        super(lineNumber);
        name = a1;
        type_decl = a2;
        init = a3;
    }

    public TreeNode copy() {
        return new attr(lineNumber, copy_AbstractSymbol(name), copy_AbstractSymbol(type_decl), (Expression)init.copy());
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "attr\n");
        dump_AbstractSymbol(out, n+2, name);
        dump_AbstractSymbol(out, n+2, type_decl);
        init.dump(out, n+2);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_attr");
        dump_AbstractSymbol(out, n + 2, name);
        dump_AbstractSymbol(out, n + 2, type_decl);
        init.dump_with_types(out, n + 2);
    }

    public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename, PrintStream s){
      s.println("asdfasdasd");
    }

}


/** Defines AST constructor 'formal'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class formal extends Formal {

    public AbstractSymbol name;
    public AbstractSymbol type_decl;

    /** Creates "formal" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for name
      * @param a1 initial value for type_decl
      */
    public formal(int lineNumber, AbstractSymbol a1, AbstractSymbol a2) {
        super(lineNumber);
        name = a1;
        type_decl = a2;
    }

    public TreeNode copy() {
        return new formal(lineNumber, copy_AbstractSymbol(name), copy_AbstractSymbol(type_decl));
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "formal\n");
        dump_AbstractSymbol(out, n+2, name);
        dump_AbstractSymbol(out, n+2, type_decl);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_formal");
        dump_AbstractSymbol(out, n + 2, name);
        dump_AbstractSymbol(out, n + 2, type_decl);
    }

}


/** Defines AST constructor 'branch'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class branch extends Case {

    public AbstractSymbol name;
    public AbstractSymbol type_decl;
    public Expression expr;

    /** Creates "branch" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for name
      * @param a1 initial value for type_decl
      * @param a2 initial value for expr
      */
    public branch(int lineNumber, AbstractSymbol a1, AbstractSymbol a2, Expression a3) {
        super(lineNumber);
        name = a1;
        type_decl = a2;
        expr = a3;
    }

    public TreeNode copy() {
        return new branch(lineNumber, copy_AbstractSymbol(name), copy_AbstractSymbol(type_decl), (Expression)expr.copy());
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "branch\n");
        dump_AbstractSymbol(out, n+2, name);
        dump_AbstractSymbol(out, n+2, type_decl);
        expr.dump(out, n+2);
    }


    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_branch");
        dump_AbstractSymbol(out, n + 2, name);
        dump_AbstractSymbol(out, n + 2, type_decl);
        expr.dump_with_types(out, n + 2);
    }

}


/** Defines AST constructor 'assign'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class assign extends Expression {

    public AbstractSymbol name;
    public Expression expr;

    /** Creates "assign" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for name
      * @param a1 initial value for expr
      */
    public assign(int lineNumber, AbstractSymbol a1, Expression a2) {
        super(lineNumber);
        name = a1;
        expr = a2;
    }

    public TreeNode copy() {
        return new assign(lineNumber, copy_AbstractSymbol(name), (Expression)expr.copy());
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "assign\n");
        dump_AbstractSymbol(out, n+2, name);
        expr.dump(out, n+2);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_assign");
        dump_AbstractSymbol(out, n + 2, name);
        expr.dump_with_types(out, n + 2);
        dump_type(out, n);
    }

    /** Generates code for this expression.  This method is to be completed
      * in programming assignment 5.  (You may add or remove parameters as
      * you wish.)
      * @param s the output stream
      * */
    public void code(PrintStream s, CgenClassTable cl) {
      expr.code(s,cl);
        CgenSupport.emitStore(CgenSupport.ACC, 0, CgenSupport.SELF, s);
    }

    public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename){

    }

}


/** Defines AST constructor 'static_dispatch'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class static_dispatch extends Expression {

    public Expression expr;
    public AbstractSymbol type_name;
    public AbstractSymbol name;
    public Expressions actual;

    /** Creates "static_dispatch" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for expr
      * @param a1 initial value for type_name
      * @param a2 initial value for name
      * @param a3 initial value for actual
      */
    public static_dispatch(int lineNumber, Expression a1, AbstractSymbol a2, AbstractSymbol a3, Expressions a4) {
        super(lineNumber);
        expr = a1;
        type_name = a2;
        name = a3;
        actual = a4;
    }

    public TreeNode copy() {
        return new static_dispatch(lineNumber, (Expression)expr.copy(), copy_AbstractSymbol(type_name), copy_AbstractSymbol(name), (Expressions)actual.copy());
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "static_dispatch\n");
        expr.dump(out, n+2);
        dump_AbstractSymbol(out, n+2, type_name);
        dump_AbstractSymbol(out, n+2, name);
        actual.dump(out, n+2);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_static_dispatch");
        expr.dump_with_types(out, n + 2);
        dump_AbstractSymbol(out, n + 2, type_name);
        dump_AbstractSymbol(out, n + 2, name);
        out.println(Utilities.pad(n + 2) + "(");
        for (Enumeration e = actual.getElements(); e.hasMoreElements();) {
            ((Expression)e.nextElement()).dump_with_types(out, n + 2);
        }
        out.println(Utilities.pad(n + 2) + ")");
        dump_type(out, n);
    }

    /** Generates code for this expression.  This method is to be completed
      * in programming assignment 5.  (You may add or remove parameters as
      * you wish.)
      * @param s the output stream
      * */
      public void code(PrintStream s, CgenClassTable cl) {
        int offset=cl.MT.get(type_name).get(name);
        for (int i=0;i<actual.getLength();i++) {
            ((Expression)actual.getNth(i)).code(s,cl);
            CgenSupport.emitPush(CgenSupport.ACC,s);
        }
        expr.code(s,cl);

        int a=cl.labelcont;
        cl.label();

        CgenSupport.emitBne(CgenSupport.ACC,CgenSupport.ZERO,a,s);
        CgenSupport.emitLoadAddress(CgenSupport.ACC,"str_const0",s);
        int b=expr.lineNumber;
        CgenSupport.emitLoadImm(CgenSupport.T1,b,s);
        CgenSupport.emitJal("_dispatch_abort",s);

        CgenSupport.emitLabelDef(a,s);
        CgenSupport.emitLoadAddress(CgenSupport.T1,type_name+CgenSupport.DISPTAB_SUFFIX,s);
        CgenSupport.emitLoad(CgenSupport.T1,offset,CgenSupport.T1,s);
        CgenSupport.emitJalr(CgenSupport.T1,s);
      }

      public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename){

      }

}


/** Defines AST constructor 'dispatch'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class dispatch extends Expression {

    public Expression expr;
    public AbstractSymbol name;
    public Expressions actual;

    /** Creates "dispatch" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for expr
      * @param a1 initial value for name
      * @param a2 initial value for actual
      */
    public dispatch(int lineNumber, Expression a1, AbstractSymbol a2, Expressions a3) {
        super(lineNumber);
        expr = a1;
        name = a2;
        actual = a3;
    }

    public TreeNode copy() {
        return new dispatch(lineNumber, (Expression)expr.copy(), copy_AbstractSymbol(name), (Expressions)actual.copy());
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "dispatch\n");
        expr.dump(out, n+2);
        dump_AbstractSymbol(out, n+2, name);
        actual.dump(out, n+2);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_dispatch");
        expr.dump_with_types(out, n + 2);
        dump_AbstractSymbol(out, n + 2, name);
        out.println(Utilities.pad(n + 2) + "(");
        for (Enumeration e = actual.getElements(); e.hasMoreElements();) {
            ((Expression)e.nextElement()).dump_with_types(out, n + 2);
        }
        out.println(Utilities.pad(n + 2) + ")");
        dump_type(out, n);
    }

    /** Generates code for this expression.  This method is to be completed
      * in programming assignment 5.  (You may add or remove parameters as
      * you wish.)
      * @param s the output stream
      * */
      public void code(PrintStream s, CgenClassTable cl) {
        AbstractSymbol as=expr.get_type();
        if (as==TreeConstants.SELF_TYPE) {
            as=cl.currentClass;
        }
        int offset=cl.MT.get(as).get(name);
        for (int i=0;i<actual.getLength();i++) {
            ((Expression)actual.getNth(i)).code(s,cl);
            CgenSupport.emitPush(CgenSupport.ACC,s);
        }

        expr.code(s,cl);
        int a=cl.labelcont;
        cl.label();
        CgenSupport.emitBne(CgenSupport.ACC,CgenSupport.ZERO ,a,s);
        CgenSupport.emitLoadAddress(CgenSupport.ACC,"str_const0",s);
        int b=expr.lineNumber;
        CgenSupport.emitLoadImm(CgenSupport.T1,b,s);
        CgenSupport.emitJal("_dispatch_abort",s);
        CgenSupport.emitLabelDef(a,s);
        CgenSupport.emitLoad(CgenSupport.T1,2,CgenSupport.ACC,s);
        CgenSupport.emitLoad(CgenSupport.T1 ,offset,CgenSupport.T1,s);
        CgenSupport.emitJalr(CgenSupport.T1,s);
      }

      public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename){

      }

}


/** Defines AST constructor 'cond'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class cond extends Expression {

    public Expression pred;
    public Expression then_exp;
    public Expression else_exp;

    /** Creates "cond" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for pred
      * @param a1 initial value for then_exp
      * @param a2 initial value for else_exp
      */
    public cond(int lineNumber, Expression a1, Expression a2, Expression a3) {
        super(lineNumber);
        pred = a1;
        then_exp = a2;
        else_exp = a3;
    }

    public TreeNode copy() {
        return new cond(lineNumber, (Expression)pred.copy(), (Expression)then_exp.copy(), (Expression)else_exp.copy());
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "cond\n");
        pred.dump(out, n+2);
        then_exp.dump(out, n+2);
        else_exp.dump(out, n+2);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_cond");
        pred.dump_with_types(out, n + 2);
        then_exp.dump_with_types(out, n + 2);
        else_exp.dump_with_types(out, n + 2);
        dump_type(out, n);
    }

    /** Generates code for this expression.  This method is to be completed
      * in programming assignment 5.  (You may add or remove parameters as
      * you wish.)
      * @param s the output stream
      * */
      public void code(PrintStream s, CgenClassTable cl) {

        int end=cl.labelcont;
        cl.label();
        int f=cl.labelcont;
        cl.label();

        pred.code(s, cl);
        CgenSupport.emitLoad(CgenSupport.T1, 3, CgenSupport.ACC, s);
        CgenSupport.emitBeqz(CgenSupport.T1, f, s);
        then_exp.code(s,cl);
        CgenSupport.emitBranch(end, s);
        CgenSupport.emitLabelDef(f,s);
        else_exp.code(s,cl);
        CgenSupport.emitLabelDef(end,s);
      }

      public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename){

      }

}


/** Defines AST constructor 'loop'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class loop extends Expression {

    public Expression pred;
    public Expression body;

    /** Creates "loop" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for pred
      * @param a1 initial value for body
      */
    public loop(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        pred = a1;
        body = a2;
    }

    public TreeNode copy() {
        return new loop(lineNumber, (Expression)pred.copy(), (Expression)body.copy());
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "loop\n");
        pred.dump(out, n+2);
        body.dump(out, n+2);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_loop");
        pred.dump_with_types(out, n + 2);
        body.dump_with_types(out, n + 2);
        dump_type(out, n);
    }

    /** Generates code for this expression.  This method is to be completed
      * in programming assignment 5.  (You may add or remove parameters as
      * you wish.)
      * @param s the output stream
      * */
      public void code(PrintStream s, CgenClassTable cl) {
        int a=cl.labelcont;
        cl.label();
        CgenSupport.emitLabelDef(a,s);
        pred.code(s, cl);
        int b=cl.labelcont;
        cl.label();
        CgenSupport.emitLoad(CgenSupport.T1, 3, CgenSupport.ACC, s);
        CgenSupport.emitBeq(CgenSupport.T1, CgenSupport.ZERO, b, s);
        body.code(s, cl);
        CgenSupport.emitBranch(a, s);
        CgenSupport.emitLabelDef(b, s);

        CgenSupport.emitMove(CgenSupport.ACC, CgenSupport.ZERO, s);
      }

      public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename){

      }

}


/** Defines AST constructor 'typcase'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class typcase extends Expression {

    public Expression expr;
    public Cases cases;

    /** Creates "typcase" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for expr
      * @param a1 initial value for cases
      */
    public typcase(int lineNumber, Expression a1, Cases a2) {
        super(lineNumber);
        expr = a1;
        cases = a2;
    }

    public TreeNode copy() {
        return new typcase(lineNumber, (Expression)expr.copy(), (Cases)cases.copy());
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "typcase\n");
        expr.dump(out, n+2);
        cases.dump(out, n+2);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_typcase");
        expr.dump_with_types(out, n + 2);
        for (Enumeration e = cases.getElements(); e.hasMoreElements();) {
        ((Case)e.nextElement()).dump_with_types(out, n + 2);
        }
        dump_type(out, n);
    }

    /** Generates code for this expression.  This method is to be completed
      * in programming assignment 5.  (You may add or remove parameters as
      * you wish.)
      * @param s the output stream
      * */
      public void code(PrintStream s, CgenClassTable cl) {
        // Mandamos hacer code de expr para evaluarla
        expr.code(s,cl);
    	// Creamos un label que salta al primer branch si la expr no
        // resulta en void (0), en el caso de que expr no entre a ningun
        // branch entonces es el abort donde no hay match, en teoria tiene
        // que haber un label para salir
        int labelSalir = cl.labelcont;
        // incrementamos los labels
        cl.label();
    	//void abort
    	CgenSupport.emitBne("a0","x0", cl.labelcont, s);
    	CgenSupport.emitLoadAddress("a0","str_const0",s);
        int linen=expr.lineNumber;
        CgenSupport.emitLoadImm("t1",linen,s);
        CgenSupport.emitJal("_case_abort2",s);

    	Hashtable<Integer, branch> caseses=new Hashtable<Integer,branch>();
    	Integer a[]=new Integer[cases.getLength()]; ///arreglo de tags
    	for (int i=0;i<cases.getLength();i++) {
    		branch b = (branch)cases.getNth(i);
    		int tag= cl.tags.get(b.type_decl);
    		a[i]=tag;
    		caseses.put(tag,b);
    	}
    	Arrays.sort(a, Collections.reverseOrder()); //ordena del mas grande al mas peque;O

        int actual = cl.labelcont;
        cl.label();
        int siguiente = cl.labelcont;
        cl.label();
    	for (int i=0;i<cases.getLength();i++) {
    		branch b=caseses.get(a[i]);
            // definimos el label del branch
            CgenSupport.emitLabelDef(actual, s);

            CgenSupport.emitLoad("t1",0,"a0",s);
    		CgenSupport.emitBlti("t1",a[i],siguiente,s);
    		CgenSupport.emitBgti("t1",cl.getMaxChild(a[i]),siguiente,s); //GETMAXCHILD MODIFICADO PARA QUE RECIBA INT(TAG)
    		cl.OT.get(cl.currentClass).enterScope();
	        cl.OT.get(cl.currentClass).addId(b.name,new Pair(CgenSupport.FP,cl.currentSize));
            // hay que hacer store del resultado de expr en la nueva variable creada
	        CgenSupport.emitStore("a0", cl.currentSize, "fp", s);
            cl.currentSize++;
            b.expr.code(s,cl);
	        cl.currentSize--;
	        cl.OT.get(cl.currentClass).exitScope();
	        CgenSupport.emitBranch(labelSalir,s);
            if(!(i==cases.getLength() - 1)) {
                actual = siguiente;
                siguiente = cl.labelcont;
                cl.label();
            }
    	}
    	CgenSupport.emitLabelDef(siguiente, s);
        CgenSupport.emitJal("_case_abort", s);
        CgenSupport.emitLabelDef(labelSalir, s);
      }

      public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename){

      }

}


/** Defines AST constructor 'block'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class block extends Expression {

    public Expressions body;

    /** Creates "block" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for body
      */
    public block(int lineNumber, Expressions a1) {
        super(lineNumber);
        body = a1;
    }

    public TreeNode copy() {
        return new block(lineNumber, (Expressions)body.copy());
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "block\n");
        body.dump(out, n+2);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_block");
        for (Enumeration e = body.getElements(); e.hasMoreElements();) {
            ((Expression)e.nextElement()).dump_with_types(out, n + 2);
        }
        dump_type(out, n);
    }

    /** Generates code for this expression.  This method is to be completed
      * in programming assignment 5.  (You may add or remove parameters as
      * you wish.)
      * @param s the output stream
      * */
      public void code(PrintStream s, CgenClassTable cl) {
        for(int i=0;i<body.getLength();i++){
          ((Expression)body.getNth(i)).code(s,cl);
        }
      }

      public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename){

      }

}


/** Defines AST constructor 'let'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class let extends Expression {

    public AbstractSymbol identifier;
    public AbstractSymbol type_decl;
    public Expression init;
    public Expression body;

    /** Creates "let" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for identifier
      * @param a1 initial value for type_decl
      * @param a2 initial value for init
      * @param a3 initial value for body
      */
    public let(int lineNumber, AbstractSymbol a1, AbstractSymbol a2, Expression a3, Expression a4) {
        super(lineNumber);
        identifier = a1;
        type_decl = a2;
        init = a3;
        body = a4;
    }

    public TreeNode copy() {
        return new let(lineNumber, copy_AbstractSymbol(identifier), copy_AbstractSymbol(type_decl), (Expression)init.copy(), (Expression)body.copy());
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "let\n");
        dump_AbstractSymbol(out, n+2, identifier);
        dump_AbstractSymbol(out, n+2, type_decl);
        init.dump(out, n+2);
        body.dump(out, n+2);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_let");
        dump_AbstractSymbol(out, n + 2, identifier);
        dump_AbstractSymbol(out, n + 2, type_decl);
        init.dump_with_types(out, n + 2);
        body.dump_with_types(out, n + 2);
        dump_type(out, n);
    }

    /** Generates code for this expression.  This method is to be completed
      * in programming assignment 5.  (You may add or remove parameters as
      * you wish.)
      * @param s the output stream
      * */
      public void code(PrintStream s, CgenClassTable cl) {
        AbstractSymbol as = type_decl;
        if(as == TreeConstants.SELF_TYPE){
          as = cl.currentClass;
        }
        if(init instanceof no_expr){
          if(type_decl == TreeConstants.Int){
            CgenSupport.emitLoadInt(CgenSupport.ACC,(IntSymbol)AbstractTable.inttable.lookup("0"),s);
          }
          else if(type_decl == TreeConstants.Str){
            CgenSupport.emitLoadInt(CgenSupport.ACC,(IntSymbol)AbstractTable.stringtable.lookup(""),s);
          }
          else if(type_decl == TreeConstants.Bool){
            CgenSupport.emitLoadAddress("a0", "bool_constant0",s);
          }
          else{
            CgenSupport.emitMove("a0", "0", s);
          }
        }

        init.code(s,cl);
        CgenSupport.emitStore("a0", cl.currentSize, CgenSupport.FP, s);
        cl.OT.get(cl.currentClass).enterScope();
        cl.OT.get(cl.currentClass).addId(identifier, new Pair(CgenSupport.FP, cl.currentSize));
        cl.currentSize++;
        body.code(s,cl);
        cl.currentSize--;
        cl.OT.get(cl.currentClass).exitScope();
      }

      public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename){

      }

}


/** Defines AST constructor 'plus'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class plus extends Expression {

    public Expression e1;
    public Expression e2;

    /** Creates "plus" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      * @param a1 initial value for e2
      */
    public plus(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }

    public TreeNode copy() {
        return new plus(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "plus\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_plus");
        e1.dump_with_types(out, n + 2);
        e2.dump_with_types(out, n + 2);
        dump_type(out, n);
    }

    /** Generates code for this expression.  This method is to be completed
      * in programming assignment 5.  (You may add or remove parameters as
      * you wish.)
      * @param s the output stream
      * */
      public void code(PrintStream s, CgenClassTable cl) {
        e1.code(s, cl);
        CgenSupport.emitPush(CgenSupport.ACC, s);
        e2.code(s, cl);
        CgenSupport.emitPop(CgenSupport.T1, s);

        CgenSupport.emitAdd(CgenSupport.ACC, CgenSupport.T1, CgenSupport.ACC, s);

      }

      public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename){

      }

}


/** Defines AST constructor 'sub'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class sub extends Expression {

    public Expression e1;
    public Expression e2;
    /** Creates "sub" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      * @param a1 initial value for e2
      */
    public sub(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }

    public TreeNode copy() {
        return new sub(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "sub\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_sub");
        e1.dump_with_types(out, n + 2);
        e2.dump_with_types(out, n + 2);
        dump_type(out, n);
    }

    /** Generates code for this expression.  This method is to be completed
      * in programming assignment 5.  (You may add or remove parameters as
      * you wish.)
      * @param s the output stream
      * */
      public void code(PrintStream s, CgenClassTable cl) {
        e1.code(s, cl);
        CgenSupport.emitPush(CgenSupport.ACC, s);
        e2.code(s, cl);
        CgenSupport.emitPop(CgenSupport.T1, s);

        CgenSupport.emitSub(CgenSupport.ACC, CgenSupport.T1, CgenSupport.ACC, s);
      }

      public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename){

      }

}


/** Defines AST constructor 'mul'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class mul extends Expression {

    public Expression e1;
    public Expression e2;

    /** Creates "mul" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      * @param a1 initial value for e2
      */
    public mul(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }

    public TreeNode copy() {
        return new mul(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "mul\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_mul");
        e1.dump_with_types(out, n + 2);
        e2.dump_with_types(out, n + 2);
        dump_type(out, n);
    }

    /** Generates code for this expression.  This method is to be completed
      * in programming assignment 5.  (You may add or remove parameters as
      * you wish.)
      * @param s the output stream
      * */
      public void code(PrintStream s, CgenClassTable cl) {
        e1.code(s, cl);
        CgenSupport.emitPush(CgenSupport.ACC, s);
        e2.code(s, cl);
        CgenSupport.emitPop(CgenSupport.T1, s);

        CgenSupport.emitMul(CgenSupport.ACC, CgenSupport.T1, CgenSupport.ACC, s);
      }

      public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename){

      }

}


/** Defines AST constructor 'divide'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class divide extends Expression {

    public Expression e1;
    public Expression e2;

    /** Creates "divide" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      * @param a1 initial value for e2
      */
    public divide(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }

    public TreeNode copy() {
        return new divide(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "divide\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_divide");
        e1.dump_with_types(out, n + 2);
        e2.dump_with_types(out, n + 2);
        dump_type(out, n);
    }

    /** Generates code for this expression.  This method is to be completed
      * in programming assignment 5.  (You may add or remove parameters as
      * you wish.)
      * @param s the output stream
      * */
      public void code(PrintStream s, CgenClassTable cl) {
        int a=cl.labelcont;
        cl.label();

        int label1 = cl.labelcont;
        cl.label();
        int label2 = cl.labelcont;
        cl.label();

        e1.code(s, cl);
        CgenSupport.emitPush(CgenSupport.ACC, s);
        e2.code(s, cl);
        CgenSupport.emitPop(CgenSupport.T1, s);

        CgenSupport.emitBeqz(CgenSupport.ACC, label1, s);
        //hacer la divicion
        CgenSupport.emitDiv(CgenSupport.ACC, CgenSupport.T1, CgenSupport.ACC, s);
        CgenSupport.emitJump(label2, s);

        CgenSupport.emitLabelDef(label1, s);
        CgenSupport.emitJal(CgenSupport.DIV_BY_ZERO, s);

        CgenSupport.emitLabelDef(label2, s);
      }

      public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename){

      }

}


/** Defines AST constructor 'neg'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class neg extends Expression {

    public Expression e1;

    /** Creates "neg" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      */
    public neg(int lineNumber, Expression a1) {
        super(lineNumber);
        e1 = a1;
    }

    public TreeNode copy() {
        return new neg(lineNumber, (Expression)e1.copy());
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "neg\n");
        e1.dump(out, n+2);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_neg");
        e1.dump_with_types(out, n + 2);
        dump_type(out, n);
    }

    /** Generates code for this expression.  This method is to be completed
      * in programming assignment 5.  (You may add or remove parameters as
      * you wish.)
      * @param s the output stream
      * */
      public void code(PrintStream s, CgenClassTable cl) {
      e1.code(s,cl);
      CgenSupport.emitLoad("t1", 3, "a0", s);
      CgenSupport.emitNeg("t1", "t1", s);
      CgenSupport.emitPush("t1", s);
      CgenSupport.emitLoadAddress("a0", "Int_protObj", s);
      CgenSupport.emitJal("object.copy", s);
      CgenSupport.emitJal("Int_init", s);
      CgenSupport.emitPop("t1", s);
      CgenSupport.emitStore("t1", 3, "a0", s);

      }

      public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename){

      }

}


/** Defines AST constructor 'lt'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class lt extends Expression {

    public Expression e1;
    public Expression e2;

    /** Creates "lt" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      * @param a1 initial value for e2
      */
    public lt(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }

    public TreeNode copy() {
        return new lt(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "lt\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_lt");
        e1.dump_with_types(out, n + 2);
        e2.dump_with_types(out, n + 2);
        dump_type(out, n);
    }

    /** Generates code for this expression.  This method is to be completed
      * in programming assignment 5.  (You may add or remove parameters as
      * you wish.)
      * @param s the output stream
      * */
      public void code(PrintStream s, CgenClassTable cl) {
        e1.code(s,cl);
        CgenSupport.emitPush("a0", s);
        e2.code(s,cl);
        CgenSupport.emitLoad("t1", 3, "a0", s);
        CgenSupport.emitPop("a0", s);
        CgenSupport.emitLoad("t2", 3 , "a0", s);
        int a = cl.labelcont;
        cl.label();
        CgenSupport.emitLoadAddress("a0", "bool_const1", s);

        CgenSupport.emitBlt("t2", "t1", a, s);
        CgenSupport.emitLoadAddress("a0", "bool_const0", s);
        CgenSupport.emitLabelDef(a,s);
      }

      public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename){

      }

}


/** Defines AST constructor 'eq'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class eq extends Expression {

    public Expression e1;
    public Expression e2;

    /** Creates "eq" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      * @param a1 initial value for e2
      */
    public eq(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }

    public TreeNode copy() {
        return new eq(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "eq\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_eq");
        e1.dump_with_types(out, n + 2);
        e2.dump_with_types(out, n + 2);
        dump_type(out, n);
    }

    /** Generates code for this expression.  This method is to be completed
      * in programming assignment 5.  (You may add or remove parameters as
      * you wish.)
      * @param s the output stream
      * */
      public void code(PrintStream s, CgenClassTable cl) {
        int a = cl.labelcont;
        cl.label();

        e1.code(s,cl);
        CgenSupport.emitPush("a0", s );
        e1.code(s,cl);
        CgenSupport.emitPop(CgenSupport.T1, s);
        CgenSupport.emitMove(CgenSupport.T2,CgenSupport.ACC, s);
        CgenSupport.emitLoadAddress(CgenSupport.ACC, "bool_const1",s);
        CgenSupport.emitBeq(CgenSupport.T1, CgenSupport.T2, a, s);
        CgenSupport.emitLoadAddress("a1", "bool_const0",s);
        CgenSupport.emitJal("equality_test", s);
        CgenSupport.emitLabelDef(a,s);

      }

      public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename){

      }

}


/** Defines AST constructor 'leq'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class leq extends Expression {

    public Expression e1;
    public Expression e2;

    /** Creates "leq" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      * @param a1 initial value for e2
      */
    public leq(int lineNumber, Expression a1, Expression a2) {
        super(lineNumber);
        e1 = a1;
        e2 = a2;
    }

    public TreeNode copy() {
        return new leq(lineNumber, (Expression)e1.copy(), (Expression)e2.copy());
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "leq\n");
        e1.dump(out, n+2);
        e2.dump(out, n+2);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_leq");
        e1.dump_with_types(out, n + 2);
        e2.dump_with_types(out, n + 2);
        dump_type(out, n);
    }

    /** Generates code for this expression.  This method is to be completed
      * in programming assignment 5.  (You may add or remove parameters as
      * you wish.)
      * @param s the output stream
      * */
      public void code(PrintStream s, CgenClassTable cl) {
        e1.code(s,cl);
        CgenSupport.emitPush("a0",s);
        e2.code(s,cl);
        CgenSupport.emitLoad("t1", 3, "a0", s);
        CgenSupport.emitPop("a0", s);
        CgenSupport.emitLoad("t2", 3, "a0",s);

        int a = cl.labelcont;
        cl.label();
        CgenSupport.emitLoadAddress("a0", "bool_const1",s);
        CgenSupport.emitBleq("t2", "t1", a, s);
        CgenSupport.emitLoadAddress("a0", "bool_const0", s);
        CgenSupport.emitLabelDef(a,s);
      }

      public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename){

      }

}


/** Defines AST constructor 'comp'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class comp extends Expression {

    public Expression e1;

    /** Creates "comp" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      */
    public comp(int lineNumber, Expression a1) {
        super(lineNumber);
        e1 = a1;
    }

    public TreeNode copy() {
        return new comp(lineNumber, (Expression)e1.copy());
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "comp\n");
        e1.dump(out, n+2);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_comp");
        e1.dump_with_types(out, n + 2);
        dump_type(out, n);
    }

    /** Generates code for this expression.  This method is to be completed
      * in programming assignment 5.  (You may add or remove parameters as
      * you wish.)
      * @param s the output stream
      * */
      public void code(PrintStream s, CgenClassTable cl) {
        e1.code(s,cl);
        int a = cl.labelcont;
        cl.label();
        CgenSupport.emitLoad("t1", 3, "a0", s);
        CgenSupport.emitLoadAddress("a0", "bool_const1",s);
        CgenSupport.emitBeqz("t1",a,s);
        CgenSupport.emitLoadAddress("a0", "bool_const0",s);
        CgenSupport.emitLabelDef(a,s);

      }

      public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename){

      }

}


/** Defines AST constructor 'int_const'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class int_const extends Expression {

    public AbstractSymbol token;

    /** Creates "int_const" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for token
      */
    public int_const(int lineNumber, AbstractSymbol a1) {
        super(lineNumber);
        token = a1;
    }

    public TreeNode copy() {
        return new int_const(lineNumber, copy_AbstractSymbol(token));
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "int_const\n");
        dump_AbstractSymbol(out, n+2, token);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_int");
        dump_AbstractSymbol(out, n + 2, token);
        dump_type(out, n);
    }

    /** Generates code for this expression.  This method method is provided
      * to you as an example of code generation.
      * @param s the output stream
      * */
    public void code(PrintStream s, CgenClassTable cl) {
        CgenSupport.emitLoadInt(CgenSupport.ACC, (IntSymbol)AbstractTable.inttable.lookup(token.getString()), s);
    }

    public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename){
      this.set_type(TreeConstants.Int);
    }

}


/** Defines AST constructor 'bool_const'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class bool_const extends Expression {

    public Boolean val;

    /** Creates "bool_const" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for val
      */
    public bool_const(int lineNumber, Boolean a1) {
        super(lineNumber);
        val = a1;
    }

    public TreeNode copy() {
        return new bool_const(lineNumber, copy_Boolean(val));
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "bool_const\n");
        dump_Boolean(out, n+2, val);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_bool");
        dump_Boolean(out, n + 2, val);
        dump_type(out, n);
    }

    /** Generates code for this expression.  This method method is provided
      * to you as an example of code generation.
      * @param s the output stream
      * */
    public void code(PrintStream s, CgenClassTable cl) {
        CgenSupport.emitLoadBool(CgenSupport.ACC, new BoolConst(val), s);
    }

    public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename){
      this.set_type(TreeConstants.Bool);
    }

}


/** Defines AST constructor 'string_const'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class string_const extends Expression {

    public AbstractSymbol token;

    /** Creates "string_const" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for token
      */
    public string_const(int lineNumber, AbstractSymbol a1) {
        super(lineNumber);
        token = a1;
    }

    public TreeNode copy() {
        return new string_const(lineNumber, copy_AbstractSymbol(token));
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "string_const\n");
        dump_AbstractSymbol(out, n+2, token);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_string");
        out.print(Utilities.pad(n + 2) + "\"");
        Utilities.printEscapedString(out, token.getString());
        out.println("\"");
        dump_type(out, n);
    }

    /** Generates code for this expression.  This method method is provided
      * to you as an example of code generation.
      * @param s the output stream
      * */
    public void code(PrintStream s, CgenClassTable cl) {
        CgenSupport.emitLoadString(CgenSupport.ACC, (StringSymbol)AbstractTable.stringtable.lookup(token.getString()), s);
    }

    public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename){
      this.set_type(TreeConstants.Str);
    }

}


/** Defines AST constructor 'new_'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class new_ extends Expression {

    public AbstractSymbol type_name;

    /** Creates "new_" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for type_name
      */
    public new_(int lineNumber, AbstractSymbol a1) {
        super(lineNumber);
        type_name = a1;
    }

    public TreeNode copy() {
        return new new_(lineNumber, copy_AbstractSymbol(type_name));
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "new_\n");
        dump_AbstractSymbol(out, n+2, type_name);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_new");
        dump_AbstractSymbol(out, n + 2, type_name);
        dump_type(out, n);
    }

    /** Generates code for this expression.  This method is to be completed
      * in programming assignment 5.  (You may add or remove parameters as
      * you wish.)
      * @param s the output stream
      * */
      public void code(PrintStream s, CgenClassTable cl) {
        AbstractSymbol as=type_name;
          if (as==TreeConstants.SELF_TYPE) {
             s.println("la  t1 class_objTab\nlw  t2 0(s0)\nsll t2 t2 3\naddu    t1 t1 t2\nmove    s1 t1\nlw  a0 0(t1)\njal Object.copy\nlw  t1 4(s1)\njalr        t1");
          } else {
          CgenSupport.emitLoadAddress(CgenSupport.ACC, as+"_protObj",s);
          CgenSupport.emitJal("Object.copy",s);
          CgenSupport.emitJal(as+"_init",s);}
      }

      public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename){

      }

}


/** Defines AST constructor 'isvoid'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class isvoid extends Expression {

    public Expression e1;

    /** Creates "isvoid" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for e1
      */
    public isvoid(int lineNumber, Expression a1) {
        super(lineNumber);
        e1 = a1;
    }

    public TreeNode copy() {
        return new isvoid(lineNumber, (Expression)e1.copy());
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "isvoid\n");
        e1.dump(out, n+2);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_isvoid");
        e1.dump_with_types(out, n + 2);
        dump_type(out, n);
    }

    /** Generates code for this expression.  This method is to be completed
      * in programming assignment 5.  (You may add or remove parameters as
      * you wish.)
      * @param s the output stream
      * */
      public void code(PrintStream s, CgenClassTable cl) {
        e1.code(s,cl);
        CgenSupport.emitMove("t1", "a0", s);
        CgenSupport.emitLoadAddress("a0", "bool_const0", s);
        int a = cl.labelcont;
        cl.label();

        CgenSupport.emitBeq("s0", "t1", a, s);
        CgenSupport.emitLoadAddress("a0", "bool_const1", s);
        CgenSupport.emitLabelDef(a,s);
      }

      public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename){
        e1.cgen(OM,C,filename);
        this.set_type(TreeConstants.Bool);
      }

}


/** Defines AST constructor 'no_expr'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class no_expr extends Expression {

    /** Creates "no_expr" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      */
    public no_expr(int lineNumber) {
        super(lineNumber);
    }

    public TreeNode copy() {
        return new no_expr(lineNumber);
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "no_expr\n");
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_no_expr");
        dump_type(out, n);
    }

    /** Generates code for this expression.  This method is to be completed
      * in programming assignment 5.  (You may add or remove parameters as
      * you wish.)
      * @param s the output stream
      * */
      public void code(PrintStream s, CgenClassTable cl) {
      }

      public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename){
        this.set_type(TreeConstants.No_type);
      }

}


/** Defines AST constructor 'object'.
    <p>
    See <a href="TreeNode.html">TreeNode</a> for full documentation. */
class object extends Expression {

    public AbstractSymbol name;

    /** Creates "object" AST node.
      *
      * @param lineNumber the line in the source file from which this node came.
      * @param a0 initial value for name
      */
    public object(int lineNumber, AbstractSymbol a1) {
        super(lineNumber);
        name = a1;
    }

    public TreeNode copy() {
        return new object(lineNumber, copy_AbstractSymbol(name));
    }

    public void dump(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "object\n");
        dump_AbstractSymbol(out, n+2, name);
    }

    public void dump_with_types(PrintStream out, int n) {
        dump_line(out, n);
        out.println(Utilities.pad(n) + "_object");
        dump_AbstractSymbol(out, n + 2, name);
        dump_type(out, n);
    }

    /** Generates code for this expression.  This method is to be completed
      * in programming assignment 5.  (You may add or remove parameters as
      * you wish.)
      * @param s the output stream
      * */
      public void code(PrintStream s, CgenClassTable cl) {

        if(this.name==TreeConstants.self){
            CgenSupport.emitMove("a0","s0",s);
        }
        else{
            CgenSupport.emitLoad(CgenSupport.ACC, 0, "a0", s);
        }
      }

      public void cgen(ClassTable OM, AbstractSymbol C, AbstractSymbol filename){

      }

}
