package code;

public class OutStatement {

	private Expression expression = null;
	public OutStatement() {

	}

	public void parse() {
		if(ParseTree.tokens[ParseTree.location] == "OUTPUT") {
			ParseTree.location++;
		}else {
			System.out.println("ERROR: output keyword expected and not Found");
			System.exit(0);
		}
		
		expression = new Expression();
		expression.parse();
		
		if(ParseTree.tokens[ParseTree.location] == "SEMICOLON") {
			ParseTree.location++;
		}else {
			System.out.println("ERROR: Semicolon after output statement expected and not Found");
			System.exit(0);
		}

	}

	public void execute() {
		System.out.println(expression.execute());
		
	}

	public void print() {
		System.out.print("output ");
		expression.print();
		System.out.print(";");
	}
}
