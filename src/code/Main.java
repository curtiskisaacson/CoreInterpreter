package code;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        CoreScanner CS = new CoreScanner("hey");

        Scanner in = new Scanner(System.in);


        String[] tokens = CS.scan(in);

        for(int i = 0; i< tokens.length; i++){
            System.out.println(tokens[i]);
        }
    }
}
