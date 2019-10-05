package code;

public class Condition {
private Comparator comparator = null;
private Condition condition = null;
private int prod = -1;

	
	public Condition() {
		
	}
	
	public void parse() {
		if(ParseTree.tokens[ParseTree.location].equals("NOT")) {
			ParseTree.location++;
			
			if (ParseTree.tokens[ParseTree.location] == "LEFTPARENTHESIS") {
				ParseTree.location++;
			} else {
				System.out.println("ERROR: Left Parenthesis keyword expected and not Found");
				System.exit(0);
			}
			
			condition = new Condition();
			condition.parse();
			
			if (ParseTree.tokens[ParseTree.location] == "RIGHTPARENTHESIS") {
				ParseTree.location++;
			} else {
				System.out.println("ERROR: Right Parenthesis keyword expected and not Found");
				System.exit(0);
			}
			
			prod = 2;
			
			
		}else {
			
			comparator = new Comparator();
			comparator.parse();
			
			if (ParseTree.tokens[ParseTree.location] == "OR") {
				ParseTree.location++;
				
				condition = new Condition();
				condition.parse();
				prod = 3;
			} else {
				prod = 1;
			}
			
		}
	}
	
	public boolean execute() {
		boolean returnValue = false;
		if(prod == 1) {
			returnValue = comparator.execute();
		}
		
		if(prod == 2) {
			returnValue = !(condition.execute());
		}
		
		if(prod == 3) {
			returnValue = comparator.execute() || condition.execute();
		}
		
		
		return returnValue;
	}
	
	public void print() {
		
	}
}
