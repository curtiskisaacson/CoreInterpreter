package code;

public class Comparator {
	private Expression firstExpression = null;
	private Expression secondExpression = null;

	private int prod = -1;

	public Comparator() {

	}

	public void parse() {
		firstExpression = new Expression();
		firstExpression.parse();
		
		if ((ParseTree.tokens[ParseTree.location].equals("EQUALS")) || ((ParseTree.tokens[ParseTree.location].equals( "EQUALS")) ||((ParseTree.tokens[ParseTree.location].equals( "EQUALS"))))) {
			switch(ParseTree.tokens[ParseTree.location]) {
			
			case "EQUALS": prod = 1;break;
			case "LESSTHAN": prod = 2; break;
			case "LESSTHANOREQUALTO": prod = 3; break;
			}
			ParseTree.location++;
		} else {
			System.out.println("ERROR: Comparator keyword expected and not Found");
			System.exit(0);
		}
		
		secondExpression = new Expression();
		
		secondExpression.parse();
		
		
	}

	public void execute() {

	}

	public void print() {

	}

}
