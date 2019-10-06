package code;

public class Statement {
	private AssignStatement assignStatement = null;
	private IfStatement ifStatement = null;
	private LoopStatement loopStatement = null;
	private InStatement inStatement = null;
	private OutStatement outStatement = null;
	private CaseStatement caseStatement = null;
	private int prod = -1;

	public Statement() {

	}

	public void parse() {
		String token = ParseTree.tokens[ParseTree.location];

		if (token.equals("IF")) {
			prod = 1;
			ifStatement = new IfStatement();
			ifStatement.parse();
		} else if (token.equals("WHILE")) {

			prod = 2;

			loopStatement = new LoopStatement();
			loopStatement.parse();

		} else if (token.equals("INPUT")) {
			prod = 3;
			inStatement = new InStatement();
			inStatement.parse();

		} else if (token.equals("OUTPUT")) {
			prod = 4;
			outStatement = new OutStatement();
			outStatement.parse();
		} else if (token.equals("CASE")) {
			prod = 5;
			caseStatement = new CaseStatement();
			caseStatement.parse();

		} else if ((token.substring(0, 3).equals("ID["))) {
			prod = 6;
			assignStatement = new AssignStatement();
			assignStatement.parse();

		} else {
			System.out.println("ERROR: Expected Statement, was not found");
			System.exit(0);
		}
	}

	public void execute() {
		switch (prod) {
		case 1:
			ifStatement.execute();
			break;
		case 2:
			loopStatement.execute();
			break;
		case 3:
			inStatement.execute();
			break;
		case 4:
			outStatement.execute();
			break;
		case 5:
			caseStatement.execute();
			break;
		case 6:
			assignStatement.execute();
			break;
		}
	}

	public void print() {
		System.out.println();
		for (int i = 0; i < ParseTree.indentCount; i++) {
			System.out.print("  ");
		}
		switch (prod) {
		case 1:
			ifStatement.print();
			break;
		case 2:
			loopStatement.print();
			break;
		case 3:
			inStatement.print();
			break;
		case 4:
			outStatement.print();
			break;
		case 5:
			caseStatement.print();
			break;
		case 6:
			assignStatement.print();
			break;
		}
	}
}
