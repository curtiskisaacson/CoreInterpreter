package code;

public class AssignStatement {

	private DeclaredID declaredID = null;
	private Expression expression = null;
	public AssignStatement() {

	}

	public void parse() {
		declaredID = new DeclaredID();
		declaredID.parse();
		
		if(ParseTree.tokens[ParseTree.location] == "ASSIGN") {
			ParseTree.location++;
		}else {
			System.out.println("ERROR: \":=\" keyword expected and not Found");
			System.exit(0);
		}
		
		expression = new Expression();
		expression.parse();
		
	}

	public void execute() {

	}

	public void print() {

	}
}
