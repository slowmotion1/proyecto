import java.io.PrintStream;
import java.util.*;

/** This class may be used to contain the semantic information such as
 * the inheritance graph.  You may use it or not as you like: it is only
 * here to provide a container for the supplied methods.  */
class ClassTable {
    public int semantErrors;
    private PrintStream errorStream;
    public Hashtable<AbstractSymbol,AbstractSymbol> hp =new Hashtable<AbstractSymbol, AbstractSymbol>();
    //CLASE,OBJTABLE
    public Hashtable<AbstractSymbol,SymbolTable> obj= new Hashtable<AbstractSymbol,SymbolTable>();
    //clase, hash(nombremeth, firma)
    public Hashtable<AbstractSymbol,Hashtable<AbstractSymbol,method>> meth= new Hashtable<AbstractSymbol,Hashtable<AbstractSymbol,method>>();
    protected AbstractSymbol C= TreeConstants.Object_;
    protected AbstractSymbol filename;
    /** Creates data structures representing basic Cool classes (Object,
     * IO, Int, Bool, String).  Please note: as is this method does not
     * do anything useful; you will need to edit it to make if do what
     * you want.
     * */
    public method lookupmeth(AbstractSymbol a, AbstractSymbol cl){
    	return meth.get(cl).get(a);
    }
    public method lookupmethP(AbstractSymbol a, AbstractSymbol cl){
    	Vector<AbstractSymbol> vec=getParents(cl);
    	method m=null;
    	for (int i=0;i<vec.size() ;i++) {
    		m=meth.get(vec.elementAt(i)).get(a);
    		if (m!=null) {
    			break;
    		}
    	}

    	return m;
    }
    public void addobj(AbstractSymbol a,AbstractSymbol t){
    	obj.get(this.C).addId(a,t);
    }
    public AbstractSymbol lookupobj(AbstractSymbol a,AbstractSymbol a1){
    	Vector<AbstractSymbol> vec=getParents(a1);
    	AbstractSymbol a2=null;
    	for (int i=0;i<vec.size() ;i++) {
    		a2=(AbstractSymbol)obj.get(vec.elementAt(i)).lookup(a);
    		if (a2!=null) {
    			break;
    		}
    	}
    	return a2;
    }
    public void enterscope(){
    	obj.get(this.C).enterScope();
    }
    public void exitscope(){
    	obj.get(this.C).exitScope();
    }
    private void installBasicClasses() {
	AbstractSymbol filename
	    = AbstractTable.stringtable.addString("<basic class>");







	// The following demonstrates how to create dummy parse trees to
	// refer to basic Cool classes.  There's no need for method
	// bodies -- these are already built into the runtime system.

	// IMPORTANT: The results of the following expressions are
	// stored in local variables.  You will want to do something
	// with those variables at the end of this method to make this
	// code meaningful.

	// The Object class has no parent class. Its methods are
	//        cool_abort() : Object    aborts the program
	//        type_name() : Str        returns a string representation
	//                                 of class name
	//        copy() : SELF_TYPE       returns a copy of the object

	class_c Object_class =
	    new class_c(0,
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

	// The IO class inherits from Object. Its methods are
	//        out_string(Str) : SELF_TYPE  writes a string to the output
	//        out_int(Int) : SELF_TYPE      "    an int    "  "     "
	//        in_string() : Str            reads a string from the input
	//        in_int() : Int                "   an int     "  "     "

	class_c IO_class =
	    new class_c(0,
		       TreeConstants.IO,
		       TreeConstants.Object_,
		       new Features(0)
			   .appendElement(new method(0,
					      TreeConstants.out_string,
					      new Formals(0)
						  .appendElement(new formalc(0,
								     TreeConstants.arg,
								     TreeConstants.Str)),
					      TreeConstants.SELF_TYPE,
					      new no_expr(0)))
			   .appendElement(new method(0,
					      TreeConstants.out_int,
					      new Formals(0)
						  .appendElement(new formalc(0,
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

	// The Int class has no methods and only a single attribute, the
	// "val" for the integer.

	class_c Int_class =
	    new class_c(0,
		       TreeConstants.Int,
		       TreeConstants.Object_,
		       new Features(0)
			   .appendElement(new attr(0,
					    TreeConstants.val,
					    TreeConstants.prim_slot,
					    new no_expr(0))),
		       filename);

	// Bool also has only the "val" slot.
	class_c Bool_class =
	    new class_c(0,
		       TreeConstants.Bool,
		       TreeConstants.Object_,
		       new Features(0)
			   .appendElement(new attr(0,
					    TreeConstants.val,
					    TreeConstants.prim_slot,
					    new no_expr(0))),
		       filename);

	// The class Str has a number of slots and operations:
	//       val                              the length of the string
	//       str_field                        the string itself
	//       length() : Int                   returns length of the string
	//       concat(arg: Str) : Str           performs string concatenation
	//       substr(arg: Int, arg2: Int): Str substring selection

	class_c Str_class =
	    new class_c(0,
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
						  .appendElement(new formalc(0,
								     TreeConstants.arg,
								     TreeConstants.Str)),
					      TreeConstants.Str,
					      new no_expr(0)))
			   .appendElement(new method(0,
					      TreeConstants.substr,
					      new Formals(0)
						  .appendElement(new formalc(0,
								     TreeConstants.arg,
								     TreeConstants.Int))
						  .appendElement(new formalc(0,
								     TreeConstants.arg2,
								     TreeConstants.Int)),
					      TreeConstants.Str,
					      new no_expr(0))),
		       filename);
	    hp.put(Object_class.getName(),TreeConstants.No_class);
	    hp.put(IO_class.getName(),Object_class.getName());
	    hp.put(Int_class.getName(),Object_class.getName());
	    hp.put(Bool_class.getName(),Object_class.getName());
	    hp.put(Str_class.getName(),Object_class.getName());
	    installBasicMethod(Object_class);
	    installBasicMethod(IO_class);
	    installBasicMethod(Int_class);
	    installBasicMethod(Bool_class);
	    installBasicMethod(Str_class);

	/* Do somethind with Object_class, IO_class, Int_class,
           Bool_class, and Str_class here */

    }

        public void installBasicMethod(class_c cls){
    	SymbolTable simbT= new SymbolTable();
    	meth.put(cls.getName(),new Hashtable<AbstractSymbol,method>());
	    simbT.enterScope();
      obj.put(cls.name, simbT);
	    for (int i=0;i<cls.features.getLength(); i++) {
	    	Feature f= (Feature)cls.features.getNth(i);
	    	if(f instanceof method){
	    		method m = (method)f;
	    		meth.get(cls.getName()).put(m.name,m);
	    	}
	    	else{
	    		attr a=(attr)f;
	    		obj.get(cls.name).addId(a.name, a.type_decl);
	    	}

	    }
    }
    public void installMethod(class_c cls){
    	SymbolTable simbT= new SymbolTable();
	    simbT.enterScope();
	    meth.put(cls.getName(),new Hashtable<AbstractSymbol,method>());
      	obj.put(cls.name, simbT);
	    for (int i=0;i<cls.features.getLength(); i++) {
	    	Feature f= (Feature)cls.features.getNth(i);
	    	if(f instanceof method){
	    		method m = (method)f;
	    		if(meth.get(cls.getName()).get(m.name)==null){
	    			meth.get(cls.getName()).put(m.name,m);
	    		}
	    		else{
	    			SemantErrors.methodMultiplyDefined(m.name, errorStream);
	    		}
	    	}
	    	else{
	    		attr a=(attr)f;
	    		if(obj.get(cls.name).probe(a.name)==null){
	    			obj.get(cls.name).addId(a.name, a.type_decl);
	    		}
	    		else{
	    			SemantErrors.attrMultiplyDefined(a.name, errorStream);
	    		}
	    	}

	    }
    }



	public boolean verifh(AbstractSymbol c, class_c c1){
		boolean basic=(c==TreeConstants.SELF_TYPE||c==TreeConstants.IO||c==TreeConstants.Object_||c==TreeConstants.Str||c==TreeConstants.Int||c==TreeConstants.Bool);
		if(basic){
			semantError(c1);
			SemantErrors.basicClassRedefined(c,errorStream);
			return false;
		}
		else if(hp.get(c)!=null){
			semantError(c1);
			SemantErrors.classPreviouslyDefined(c, errorStream);
			return false;
		}
		else{
			return true;
		}
	}

	public boolean verifp(AbstractSymbol c,AbstractSymbol cp, class_c c1){
		boolean basic = (cp==TreeConstants.SELF_TYPE||cp==TreeConstants.Str||cp==TreeConstants.Int||cp==TreeConstants.Bool);
		if(basic) {
			SemantErrors.cannotInheritClass(c, cp, semantError(c1));
			return false;
		} else if(hp.get(cp) == null) {
			SemantErrors.inheritsFromAnUndefinedClass(c, cp, semantError(c1));
			return false;
		}

		return true;
	}


	public boolean hasCycle(AbstractSymbol c, Vector<AbstractSymbol> v){
		if(c==TreeConstants.Object_){
			return false;
		}else if(v.contains(c)){
			return true;
		}else{
			v.addElement(c);
			return hasCycle(hp.get(c),v);
		}
	}









    public ClassTable(Classes cls) {
    Vector<AbstractSymbol> v= new Vector();
	installBasicClasses();
	semantErrors = 0;
	errorStream = System.err;
	//verifica que no este redefinda y que no sea basica
	for (int x=0;x<cls.getLength() ;x++) {
		class_c tn=(class_c)cls.getNth(x);
		if(verifh(tn.getName(), tn)){
			hp.put(tn.getName(),tn.getParent());
		} else {
			System.err.println("Compilation halted due to static semantic errors.");
	 	   	System.exit(1);
		}
	}
	//verifica existencia de padres, que no sea heredado de basics
	for (int x=0;x<cls.getLength() ;x++) {
		class_c tn=(class_c)cls.getNth(x);
		if(!verifp(tn.getName(),tn.getParent(), tn)){
			System.err.println("Compilation halted due to static semantic errors.");
	 	   	System.exit(1);
		}
	}
	//verifica que la clase no sea ciclica
	for (int x=cls.getLength()-1;x>=0 ;x--) {
		class_c tn=(class_c)cls.getNth(x);
		v.clear();
		if(hasCycle(tn.getName(),v)){
			SemantErrors.inheritanceCycle(tn.getName(),semantError(tn));
		}
	}

	if(semantErrors > 0) {
		System.err.println("Compilation halted due to static semantic errors.");
	 	System.exit(1);
	}



	for (int x=cls.getLength()-1;x>=0 ;x--) {
		class_c tn=(class_c)cls.getNth(x);
		installMethod(tn);
	}

	if(hp.get(TreeConstants.Main)==null){
		semantError();
		SemantErrors.noClassMain(errorStream);
	} else {
		if(meth.get(TreeConstants.Main).get(TreeConstants.main_meth) == null) {
			SemantErrors.noMainMethodInMainClass(semantError());
		}
	}


    }

    /** Prints line number and file name of the given class.
     *
     * Also increments semantic error count.
     *
     * @param c the class
     * @return a print stream to which the rest of the error message is
     * to be printed.
     *
     * */
    // Esto cambia la current class al name dado
    public void setCurrentClass(AbstractSymbol name) {
        this.C = name;
    }

    // Esto cambia el filename al filename dado
    public void setFilename(AbstractSymbol filename) {
        this.filename = filename;
    }

    // Devuelve true si la current class es Main
    public boolean mainClass() {
        return this.C == TreeConstants.Main;
    }

    // Devuelve los parents dado un nombre de alguna clase
    public Vector<AbstractSymbol> getParents(AbstractSymbol name) {
        AbstractSymbol parent=name;
        Vector<AbstractSymbol> vec= new Vector<AbstractSymbol>();
        while(parent!=TreeConstants.Object_ ){
        	vec.addElement(parent);
        	parent= hp.get(parent);
        }
        vec.addElement(TreeConstants.Object_);
        return vec;
    }

    // Verifica si una clase existe en el grafo de herencia
    public boolean classExists(AbstractSymbol name) {
        return name == TreeConstants.SELF_TYPE || this.hp.containsKey(name);
    }

    // devuleve true si t1 <= t2
    public boolean LE(AbstractSymbol t1, AbstractSymbol t2) {
    	if (t1==t2) {
    		return true;
    	}
        else if (t1==TreeConstants.SELF_TYPE) {
        	if (getParents(this.C).contains(t2)) {
        		return true;
        	}

        }
        else if (t1==TreeConstants.Object_) {
        	return false;

        }
        else if (t2==TreeConstants.SELF_TYPE) {
        	if (getParents(t1).contains(this.C)) {
        		return true;
        	}

        }
        else if(getParents(t1).contains(t2)){
        	return true;
        }

        return false;

    }

    // devuelve el LUB entre dos tipos
    public AbstractSymbol LUB(AbstractSymbol t1, AbstractSymbol t2) {
    	if (t1==TreeConstants.SELF_TYPE) {
    		t1=C;

    	}
    	if (t2==TreeConstants.SELF_TYPE) {
    		t2=C;
    	}
    	Vector<AbstractSymbol> vect1= getParents(t1);
    	Vector<AbstractSymbol> vect2= getParents(t2);
    	Vector<AbstractSymbol> vec= new Vector<AbstractSymbol>();
    	AbstractSymbol lub=TreeConstants.Object_;

        if (vect1.size()>vect2.size()) {
        	vec=vect2;
        	for (int i=0;i<vec.size();i++) {
        		if (vect1.contains(vec.elementAt(i))) {
        			lub=vec.elementAt(i);
        			break;
        		 }
        	}
        }
        else{
        	vec=vect1;
        	for (int i=0;i<vec.size();i++) {
        		if (vect2.contains(vec.elementAt(i))) {
        			lub=vec.elementAt(i);
        			break;
        		 }
        	}
        }

        return lub;
    }

    // Manejo de errores
    public PrintStream semantError(class_c c) {
        return this.semantError(c.getFilename(), c);
    }

    /*
        Este metodo es el que tienen que utilizar dentro de cool-tree.java
        por ejemplo
        OMC.semantError(this); estando en algun nodo
    */
    public PrintStream semantError(TreeNode t) {
        return this.semantError(this.filename, t);
    }

    /** Prints the file name and the line number of the given tree node.
     *
     * Also increments semantic error count.
     *
     * @param filename the file name
     * @param t the tree node
     * @return a print stream to which the rest of the error message is
     * to be printed.
     *
     * */
    public PrintStream semantError(AbstractSymbol filename, TreeNode t) {
	errorStream.print(filename + ":" + t.getLineNumber() + ": ");
	return semantError();
    }

    /** Increments semantic error count and returns the print stream for
     * error messages.
     *
     * @return a print stream to which the error message is
     * to be printed.
     *
     * */
    public PrintStream semantError() {
	semantErrors++;
	return errorStream;
    }

    /** Returns true if there are any static semantic errors. */
    public boolean errors() {
	return semantErrors != 0;
    }
}
