package code;

public class ConstantList {

	private Constant constant = null;
	private ConstantList constantList = null;

	public ConstantList() {

	}

	public void parse() {
		if (ParseTree.tokens[ParseTree.location].equals("COMMA")) {
			ParseTree.location++;

			constant = new Constant();
			constant.parse();

			constantList = new ConstantList();
			constantList.parse();

		}

	}

	public void execute() {

	}

	public void print() {

	}
}
