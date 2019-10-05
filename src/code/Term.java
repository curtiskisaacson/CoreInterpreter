package code;

public class Term {

	private Factor factor = null;
	private Term term = null;
	private int prod = -1;
	
	public Term() {
		
	}
	
	public void parse() {
		factor = new Factor();
		factor.parse();
		if(ParseTree.tokens[ParseTree.location].equals("TIMES")) {
			ParseTree.location++;
			term = new Term();
			term.parse();	
			prod = 2;
		}else {
			prod = 1;
		}
		
		
	}
	
	public int execute() {
		int value = Integer.MIN_VALUE;
		if(prod ==1) {
			value = factor.execute();
		}else if(prod ==2) {
			value = factor.execute() * term.execute();
		}
		
		return value;
	}
	
	public void print() {
		
	}
}
