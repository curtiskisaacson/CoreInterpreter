package code;

public class Constant {

	public Constant() {
		
	}
	
	public void parse() {
		//checks each character in constant string is a constant
		String number = ParseTree.tokens[ParseTree.location].substring(3, ParseTree.tokens[ParseTree.location].length()-1);
		
		for(int i = 0; i<number.length(); i++) {
			
			if(!Character.isDigit(number.charAt(i))) {
				System.out.println("ERROR: "+number+" is not a constant");
				System.exit(0);
			}
			
		}
		
		ParseTree.location++;
		
	}
	
	public void execute() {
		
	}
	
	public void print() {
		
	}
}
