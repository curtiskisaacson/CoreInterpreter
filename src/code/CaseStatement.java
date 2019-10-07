package code;

import java.util.Map;

public class CaseStatement {

	private CaseLine caseLine = null;
	private Expression expression = null;
	private DeclaredID declaredID = null;
	
	public CaseStatement() {
		
	}
	
	public void parse() {
		if(ParseTree.tokens[ParseTree.location] == "CASE") {
			ParseTree.location++;
		}else {
			System.out.println("ERROR: case keyword expected and not Found");
			System.exit(0);
		}
		
		declaredID = new DeclaredID();
		declaredID.parse();
		
		if(ParseTree.tokens[ParseTree.location] == "OF") {
			ParseTree.location++;
		}else {
			System.out.println("ERROR: of keyword expected and not Found");
			System.exit(0);
		}
		
		caseLine = new CaseLine();
		caseLine.parse();
		
		if(ParseTree.tokens[ParseTree.location] == "ELSE") {
			ParseTree.location++;
		}else {
			System.out.println("ERROR: else keyword expected and not Found");
			System.exit(0);
		}
		
		expression = new Expression();
		expression.parse();
		
		if(ParseTree.tokens[ParseTree.location] == "END") {
			ParseTree.location++;
		}else {
			System.out.println("ERROR: end keyword expected and not Found");
			System.exit(0);
		}
		
		if(ParseTree.tokens[ParseTree.location] == "SEMICOLON") {
			ParseTree.location++;
		}else {
			System.out.println("ERROR: semicolon after case statement expected and not Found");
			System.exit(0);
		}
		
	}
	
	public void execute() {
		
		
		String name = declaredID.execute();
		Map<Integer,Integer> casesAndValues = caseLine.execute();
		
		int valueOfID = ParseTree.symbolTable.get(name);
		if(casesAndValues.containsKey(valueOfID)) {
			ParseTree.symbolTable.put(name, casesAndValues.get(valueOfID));
		}else {
			ParseTree.symbolTable.put(name, expression.execute());
		}
		
		
		
	}
	
	public void print() {
		System.out.print("case ");
		declaredID.print();
		System.out.println(" of");
		ParseTree.indentCount++;
		caseLine.print();
		
		System.out.println();
		for (int i = 0; i < ParseTree.indentCount; i++) {
			System.out.print("  ");
		}
		System.out.print("else ");
		expression.print();
		System.out.print(";");
		ParseTree.indentCount--;
		
	}
}
