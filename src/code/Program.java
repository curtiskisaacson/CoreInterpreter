package code;

public class Program {
	private DeclareSequence declSeq = null;
	private StatementSequence stmtSeq = null;
	
	public Program() {
		
	}
	
	public void parse() {
		if(ParseTree.tokens[ParseTree.location] == "PROGRAM") {
			ParseTree.location++;
		}else {
			System.out.println("ERROR: Program keyword expected and not Found");
			System.exit(0);
		}
		
		this.declSeq= new DeclareSequence();
		declSeq.parse();
		//remember parse should automatically update ParseTree.location
		
		if(ParseTree.tokens[ParseTree.location] == "BEGIN") {
			ParseTree.location++;
		}else {
			System.out.println("ERROR: Begin keyword expected and not Found");
			System.exit(0);
		}
		
		stmtSeq = new StatementSequence();
		stmtSeq.parse();
		
		if(ParseTree.tokens[ParseTree.location] == "END") {
			ParseTree.location++;
		}else {
			System.out.println("ERROR: End keyword expected and not Found");
			System.exit(0);
		}
		
		if(ParseTree.tokens[ParseTree.location] == "EOF") {
			ParseTree.location++;
		}else {
			System.out.println("ERROR: End Of File expected and not Found");
			System.exit(0);
		}
		
	}
	
	public void execute() {
		declSeq.execute();
		stmtSeq.execute();
	}
	
	public void print() {
		
		
	}
	
	
	
}
