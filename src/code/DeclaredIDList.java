package code;

public class DeclaredIDList {
	private DeclaredID id = null;
	private DeclaredIDList idList = null;
	
	public DeclaredIDList() {
		
	}
	
	public void parse() {
		id = new DeclaredID();
		id.parse();
		
		if(ParseTree.tokens[ParseTree.location] == "COMMA") {
			ParseTree.location++;
			idList = new DeclaredIDList();
			idList.parse();
		}
	}
	
	public void execute() {
		
	}
	
	public void print() {
		
	}
}
