package code;

import java.util.ArrayList;
import java.util.Scanner;

public class InStatement {
	private DeclaredIDList declaredIDList = null;

	public InStatement() {

	}

	public void parse() {
		if (ParseTree.tokens[ParseTree.location] == "INPUT") {
			ParseTree.location++;
		} else {
			System.out.println("ERROR: input keyword expected and not Found");
			System.exit(0);
		}
		declaredIDList = new DeclaredIDList();
		declaredIDList.parse();

		if (ParseTree.tokens[ParseTree.location] == "SEMICOLON") {
			ParseTree.location++;
		} else {
			System.out.println("ERROR: Semicolon after input statement expected and not Found");
			System.exit(0);
		}
	}

	public void execute() {
		Scanner in = new Scanner(System.in);

		ArrayList<String> names = declaredIDList.execute();
		for (String name : names) {
			while (!in.hasNextInt()) {
				in.next();
			}
			int value = in.nextInt();
			// checks every character in string

			ParseTree.symbolTable.put(name, value);
		}
		
		in.close();

	}

	public void print() {
		System.out.print("input ");
		declaredIDList.print();
		System.out.print(";");
	}

}
