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
		
		if(ParseTree.tokens[ParseTree.location] == "Semicolon") {
			ParseTree.location++;
		}else {
			System.out.println("ERROR: Semicolon expected and not Found");
			System.exit(0);
		}

	}

	public void execute() {

	}

	public void print() {

	}
}
