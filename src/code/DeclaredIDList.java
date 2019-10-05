package code;

import java.util.ArrayList;

public class DeclaredIDList {
	private DeclaredID id = null;
	private DeclaredIDList idList = null;

	public DeclaredIDList() {

	}

	public void parse() {
		id = new DeclaredID();
		id.parse();

		if (ParseTree.tokens[ParseTree.location] == "COMMA") {
			ParseTree.location++;
			idList = new DeclaredIDList();
			idList.parse();
		}
	}

	public ArrayList<String> execute() {
		ArrayList<String> returnStrings = new ArrayList<>();
		returnStrings.add(id.execute());
		if(idList != null) {
			returnStrings.addAll(0, idList.execute());
		}
		
		return returnStrings;
	}

	public void print() {

	}
}
