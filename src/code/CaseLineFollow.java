package code;

public class CaseLineFollow {
	private CaseLine caseLine = null;
	
	
	public CaseLineFollow() {
		
	}
	
	public void parse() {
		if(ParseTree.tokens[ParseTree.location].equals("BAR")) {
			caseLine = new CaseLine();
			caseLine.parse();
		}
	}
	
	public void execute() {
		
	}
	
	public void print() {
		
	}
}
