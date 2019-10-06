package code;

import java.util.ArrayList;

public class ConstantList {

	private Constant constant = null;
	private ConstantList constantList = null;
	int prod = -1;

	public ConstantList() {

	}

	public void parse() {
		if (ParseTree.tokens[ParseTree.location].equals("COMMA")) {
			ParseTree.location++;
			prod = 1;

			constant = new Constant();
			constant.parse();

			constantList = new ConstantList();
			constantList.parse();

		}

	}

	public ArrayList<Integer> execute() {
		ArrayList<Integer> returnList = new ArrayList<>();

		if (prod == 1) {
			returnList.add(constant.execute());

			if (constantList != null) {
				returnList.addAll(constantList.execute());
			}
		}

		return returnList;
	}

	public void print() {
		if (prod == 1) {
			System.out.print(",");
			constant.print();
			constantList.print();
		}
	}
}
