package code;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class CoreInterpreter {

    public static void main(String[] args) {

    	String fileName = args[0];
    	String dataFileName = args[1];
        CoreScanner CS = null;
		try {
			
			CS = new CoreScanner(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR : File Not Found");
			System.exit(0);
		}

        Scanner in = new Scanner(System.in);

        String[] tokens = CS.scan();
        tokens = CS.preprocess(tokens);
        
        for(String t:tokens) {
        	System.out.println(t);
        }
        ParseTree parseTree = new ParseTree(tokens, dataFileName);
        CoreParser coreParser = new CoreParser(parseTree);
        coreParser.parse();
        
        
        
        CorePrinter corePrinter = new CorePrinter(parseTree);
        corePrinter.print();
        
        CoreExecutor coreExecutor = new CoreExecutor(parseTree);
        coreExecutor.execute();
        
        
        
        
        in.close();
    }
}
