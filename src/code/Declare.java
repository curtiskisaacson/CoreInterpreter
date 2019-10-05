package code;

public class Declare {

	private IDList idList = null;
	
	public Declare() {
		
	}
	
	public void parse() {
		if(ParseTree.tokens[ParseTree.location] == "INT") {
			ParseTree.location++;
		}else {
			System.out.println("ERROR: int keyword expected and not Found");
			System.exit(0);
		}
		
		idList = new IDList();
		idList.parse();
		
		if(ParseTree.tokens[ParseTree.location] == "SEMICOLON") {
			ParseTree.location++;
		}else {
			System.out.println("ERROR: semicolon expected and not Found");
			System.exit(0);
		}
	}
	
	public void execute() {
		
	}
	
	public void print() {
		
	}
}
