package edu.ucsb.cs56.tutorials.expression_parsing;
import javax.script.*;

/** Demo1 is a demo (originally was "EvalScript") from website
    referenced below, modified to evaluate the result of a Javascript
    expression passed in as argument 0 on command line


    @see <a href="http://docs.oracle.com/javase/7/docs/technotes/guides/scripting/programmer_guide/#jsengine">http://docs.oracle.com/javase/7/docs/technotes/guides/scripting/programmer_guide/#jsengine</a>


*/

public class Demo1 {
    public static void main(String[] args) throws Exception {

	if (args.length != 1) {
	    System.out.println("Usage: java Demo1 'javascriptExpression'");
	    System.exit(1);
	}

        // create a script engine manager
        ScriptEngineManager factory = new ScriptEngineManager();
        // create a JavaScript engine
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        // evaluate JavaScript code from String
        String result = engine.eval(args[0]).toString();

	System.out.println("result=" + result);

	try {
	    double resultD = Double.parseDouble(result); 
	    System.out.printf("As a double, result=%f\n",resultD);
	} catch (NumberFormatException nfe ) {
	    System.out.println("Not a numeric result");
	}
	
    }
}
