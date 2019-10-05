package code;

public class StatementSequence {
	private Statement statement = null;
	private StatementSequence stmtSeq = null;

	public StatementSequence() {

	}

	public void parse() {
		statement = new Statement();
		statement.parse();

		String token = ParseTree.tokens[ParseTree.location];
		if (token.equals("IF") || token.equals("WHILE") || token.equals("INPUT") || token.equals("OUTPUT")
				|| token.equals("CASE") || (token.substring(0, 3).equals("ID["))) {
			stmtSeq = new StatementSequence();
			stmtSeq.parse();
		}
	}

	public void execute() {

	}

	public void print() {

	}

}
