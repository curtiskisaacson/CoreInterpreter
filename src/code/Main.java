package code;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        CoreScanner CS = null;
		try {
			CS = new CoreScanner("hey");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        Scanner in = new Scanner(System.in);


        String[] tokens = CS.scan();
        tokens = CS.preprocess(tokens);

        for(int i = 0; i< tokens.length; i++){
            System.out.println(tokens[i]);
        }
    }
}
