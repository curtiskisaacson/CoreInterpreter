package code;

import java.util.ArrayList;
import java.util.Scanner;

public class InStatement {
	private DeclaredIDList declaredIDList = null;
	
	public InStatement() {
		
	}
	
	public void parse() {
		if(ParseTree.tokens[ParseTree.location] == "INPUT") {
			ParseTree.location++;
		}else {
			System.out.println("ERROR: input keyword expected and not Found");
			System.exit(0);
		}
		declaredIDList = new DeclaredIDList();
		declaredIDList.parse();
		
		if(ParseTree.tokens[ParseTree.location] == "SEMICOLON") {
			ParseTree.location++;
		}else {
			System.out.println("ERROR: Semicolon after input statement expected and not Found");
			System.exit(0);
		}
	}
	
	public void execute() {
		Scanner in = new Scanner(System.in);
		String value = in.next();
		for(int i = 0;i<value.length();i++) {
			if(!Character.isDigit(value.charAt(i))) {
				System.out.println("ERROR:" + value+"is an invalid input");
				System.exit(0);
			}
		}
		int valueAsInt = Integer.parseInt(value);
		
		ArrayList<String> names = declaredIDList.execute();
		
		for(String name:names) {
			ParseTree.symbolTable.put(name, valueAsInt);
		}
			
	}
	
	public void print() {
		
	}
	
}
