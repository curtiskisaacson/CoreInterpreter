package code;

public class IDList {
	private ID id = null;
	private IDList idList = null;
	
	public IDList() {
		
	}
	
	public void parse() {
		id = new ID();
		id.parse();
		
		if(ParseTree.tokens[ParseTree.location] == "COMMA") {
			ParseTree.location++;
			idList = new IDList();
			idList.parse();
		}
	}
	
	public void execute() {
		//nothing needed
	}
	
	public void print() {
		
	}
}
