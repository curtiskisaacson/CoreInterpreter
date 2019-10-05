package code;

public class InStatement {
	private DeclaredIDList declaredIDList = null;
	
	public InStatement() {
		
	}
	
	public void parse() {
		if(ParseTree.tokens[ParseTree.location] == "INPUT") {
			ParseTree.location++;
		}else {
			System.out.println("ERROR: input keyword expected and not Found");
			System.exit(0);
		}
		declaredIDList = new DeclaredIDList();
		declaredIDList.parse();
		
		if(ParseTree.tokens[ParseTree.location] == "SEMICOLON") {
			ParseTree.location++;
		}else {
			System.out.println("ERROR: Semicolon after input statement expected and not Found");
			System.exit(0);
		}
	}
	
	public void execute() {
		
	}
	
	public void print() {
		
	}
	
}
