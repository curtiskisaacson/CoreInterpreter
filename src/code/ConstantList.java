package code;

import java.util.ArrayList;

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

	public ArrayList<Integer> execute() {
		ArrayList<Integer> returnList = new ArrayList<>();
		returnList.add(constant.execute());
		
		if(constantList != null) {
			returnList.addAll(constantList.execute());
		}
		
		return returnList;
	}

	public void print() {

	}
}
