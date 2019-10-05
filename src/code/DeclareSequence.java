package code;

public class DeclareSequence {
	private Declare decl = null;
	private DeclareSequence declseq = null;
	
	public DeclareSequence() {
		
	}
	
	public void parse() {
		decl = new Declare();
		decl.parse();
		
		//below jumps looks ahead 1 to look if there is another int declaration ahead
		if(ParseTree.tokens[ParseTree.location + 1] == "INT") {
			declseq = new DeclareSequence();
			declseq.parse();
		}
	}
	
	public void execute() {
		decl.execute();
		if(declseq != null) {
			declseq.execute();
		}
	}
	
	public void print() {
		
	}
}
