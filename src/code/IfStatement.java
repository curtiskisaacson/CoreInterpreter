package code;

public class IfStatement {
	private Condition condition = null;
	private StatementSequence stmtSeq = null;
	private StatementSequence elseStmtSeq = null;
	int prod = -1;

	public IfStatement() {

	}

	public void parse() {

		if (ParseTree.tokens[ParseTree.location] == "IF") {
			ParseTree.location++;
		} else {
			System.out.println("ERROR: if keyword expected and not Found");
			System.exit(0);
		}

		condition = new Condition();
		condition.parse();

		if (ParseTree.tokens[ParseTree.location] == "THEN") {
			ParseTree.location++;
		} else {
			System.out.println("ERROR: then keyword expected and not Found");
			System.exit(0);
		}

		stmtSeq = new StatementSequence();
		stmtSeq.parse();

		if (ParseTree.tokens[ParseTree.location] == "ENDIF") {
			ParseTree.location++;
			prod = 1;
		} else if (ParseTree.tokens[ParseTree.location] == "ELSE") {
			ParseTree.location++;
			elseStmtSeq = new StatementSequence();
			elseStmtSeq.parse();

			if (ParseTree.tokens[ParseTree.location] == "ENDIF") {
				ParseTree.location++;
				prod = 2;
			} else {
				System.out.println("ERROR: endif keyword expected and not Found");
				System.exit(0);
			}

		} else {
			System.out.println("ERROR: Unexpected Token within if statement");
			System.exit(0);
		}

		if (ParseTree.tokens[ParseTree.location] == "SEMICOLON") {
			ParseTree.location++;
		} else {
			System.out.println("ERROR: Semicolon after if statement expected and not Found");
			System.exit(0);
		}

	}

	public void execute() {
		if (prod == 1) {
			if (condition.execute()) {
				stmtSeq.execute();
			}
		}

		if (prod == 2) {

			if (condition.execute()) {
				stmtSeq.execute();
			} else {
				elseStmtSeq.execute();
			}
		}

	}

	public void print() {

	}
}
