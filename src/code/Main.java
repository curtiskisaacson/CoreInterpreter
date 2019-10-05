package code;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        CoreScanner CS = null;
		try {
			CS = new CoreScanner("CoreFiles/CoreSource1.core");
		} catch (FileNotFoundException e) {
			System.out.println("ERROR : File Not Found");
			System.exit(0);
		}

        Scanner in = new Scanner(System.in);


        String[] tokens = CS.scan();
        tokens = CS.preprocess(tokens);

//        for(int i = 0; i< tokens.length; i++){
//            System.out.println(tokens[i]);
//        }
        System.out.println("\nSCANNING COMPLETE");
        ParseTree parseTree = new ParseTree(tokens);
        CoreParser coreParser = new CoreParser(parseTree);
        coreParser.parse();
        
        System.out.println("\nPARSING COMPLETE");
        
        CoreExecutor coreExecutor = new CoreExecutor(parseTree);
        coreExecutor.execute();
        System.out.println("\nEXECUTING COMPLETE");
        in.close();
    }
}
