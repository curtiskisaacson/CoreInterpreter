package code;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class CoreInterpreter {

    public static void main(String[] args) {

    	//String fileName = args[0];
    	//String inputFileName = args[1];
        CoreScanner CS = null;
		try {
			CS = new CoreScanner("CoreFiles/CoreSourceAdding2Ints.core");
		} catch (FileNotFoundException e) {
			System.out.println("ERROR : File Not Found");
			System.exit(0);
		}

        Scanner in = new Scanner(System.in);

        String[] tokens = CS.scan();
        tokens = CS.preprocess(tokens);
        
        ParseTree parseTree = new ParseTree(tokens);
        CoreParser coreParser = new CoreParser(parseTree);
        coreParser.parse();
        
        
        
        CorePrinter corePrinter = new CorePrinter(parseTree);
        corePrinter.print();
        
        //CoreExecutor coreExecutor = new CoreExecutor(parseTree);
        //coreExecutor.execute();
        //System.out.println("\nEXECUTING COMPLETE");
        
        
        
        in.close();
    }
}
