package code;

public class Expression {

	private Term term = null;
	private Expression expression = null;
	private int prod = -1;
	
	public Expression() {

		
	}

	public void parse() {

		term = new Term();
		term.parse();
		
		if(ParseTree.tokens[ParseTree.location].equals("PLUS")) {
			prod = 2;
			ParseTree.location++;
			expression = new Expression();
			expression.parse();
		}else if (ParseTree.tokens[ParseTree.location].equals("MINUS")) {
			prod = 3;
			ParseTree.location++;
			expression = new Expression();
			expression.parse();
		}else {
			prod = 1;
		}
	}

	public int execute() {
		int value = Integer.MAX_VALUE;
		if(prod ==1) {
			value = term.execute();
		} else if(prod ==2) {
			value = term.execute() + expression.execute();
		}else if(prod ==3) {
			value = term.execute() - expression.execute();
		}
		return value;
	}

	public void print() {
		
		if(prod ==1) {
			term.print();
		} else if(prod ==2) {
			term.print();
			System.out.println("+");
			expression.print();
		}else if(prod ==3) {
			term.print();
			System.out.println("-");
			expression.print();
		}
		
	}
}
