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
	}
	
	public void execute() {
		
	}
	
	public void print() {
		
	}
}
