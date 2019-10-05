package code;

public class IfStatement {
	private Condition condition = null;
	private StatementSequence stmtSeq = null;
	private StatementSequence elseStmtSeq = null;

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
		} else if (ParseTree.tokens[ParseTree.location] == "ELSE") {
			ParseTree.location++;
			elseStmtSeq = new StatementSequence();
			elseStmtSeq.parse();
			
			if (ParseTree.tokens[ParseTree.location] == "ENDIF") {
				ParseTree.location++;
			} else {
				System.out.println("ERROR: endif keyword expected and not Found");
				System.exit(0);
			}
			
		}else {
			System.out.println("ERROR: Unexpected Token within if statement");
			System.exit(0);
		}
		
		if(ParseTree.tokens[ParseTree.location] == "SEMICOLON") {
			ParseTree.location++;
		}else {
			System.out.println("ERROR: Semicolon after if statement expected and not Found");
			System.exit(0);
		}

	}

	public void execute() {

	}

	public void print() {

	}
}
