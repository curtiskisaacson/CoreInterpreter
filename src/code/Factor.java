package code;

public class Factor {
	private Constant constant = null;
	private DeclaredID declaredID = null;
	private Expression expression = null;
	private int prod  = -1;
	
	public Factor() {
		
	}
	
	public void parse() {
		if(ParseTree.tokens[ParseTree.location].equals("LEFTPARENTHESIS")) {
			ParseTree.location++;
			prod = 1;
			expression = new Expression();
			expression.parse();
			
			if (ParseTree.tokens[ParseTree.location] == "RIGHTPARENTHESIS") {
				ParseTree.location++;
			} else {
				System.out.println("ERROR: Right parenthesis keyword expected and not Found");
				System.exit(0);
			}
			
			
		}else if(Character.isDigit(ParseTree.tokens[ParseTree.location].charAt(3))){
			prod = 2;
			constant = new Constant();
			constant.parse();
			
		}else if(!Character.isDigit(ParseTree.tokens[ParseTree.location].charAt(3))) {
			prod = 3;
			declaredID = new DeclaredID();
			declaredID.parse();
		} else {
			System.out.println("ERROR: Unexpected Token encountered");
			System.exit(0);
		}
	}
	
	public int execute() {
		int value = Integer.MAX_VALUE;
		if(prod == 1) {
			value = expression.execute();
		}else if(prod == 2) {
			value = constant.execute();
		}else if(prod == 3) {
			value = ParseTree.symbolTable.get(declaredID.execute());
		}
		return value;
	}
	
	public void print() {
		
	}
}
