package code;

public class CaseLine {

	private Constant constant = null;
	private ConstantList constantList = null;
	private Expression expression = null;
	private CaseLineFollow caseLineFollow = null;
	
	public CaseLine() {
		
	}
	
	public void parse() {
		constant = new Constant();
		constant.parse();
		
		constantList = new ConstantList();
		constantList.parse();
		
		if (ParseTree.tokens[ParseTree.location] == "COLON") {
			ParseTree.location++;
		} else {
			System.out.println("ERROR: \":\" keyword expected and not Found");
			System.exit(0);
		}
		
		expression = new Expression();
		expression.parse();
		
		caseLineFollow = new CaseLineFollow();
		caseLineFollow.parse();
	}
	
	public void execute() {
		
	}
	
	public void print() {
		
	}
	
}
