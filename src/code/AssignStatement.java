package code;

public class AssignStatement {

	private DeclaredID declaredID = null;
	private Expression expression = null;

	public AssignStatement() {

	}

	public void parse() {
		declaredID = new DeclaredID();
		declaredID.parse();

		if (ParseTree.tokens[ParseTree.location] == "ASSIGN") {
			ParseTree.location++;
		} else {
			System.out.println("ERROR: \":=\" keyword expected and not Found");
			System.exit(0);
		}

		expression = new Expression();
		expression.parse();

		if (ParseTree.tokens[ParseTree.location] == "SEMICOLON") {
			ParseTree.location++;
		} else {
			System.out.println("ERROR: Semicolon after assign statment expected and not Found");
			System.exit(0);
		}

	}

	public void execute() {

	}

	public void print() {

	}
}
