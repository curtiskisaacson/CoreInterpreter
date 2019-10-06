package code;

public class Constant {
	private int value;

	public Constant() {
		
	}
	
	public void parse() {
		//checks each character in constant string is a constant
		String number = ParseTree.tokens[ParseTree.location].substring(3, ParseTree.tokens[ParseTree.location].length()-1);
		
		for(int i = 0; i<number.length(); i++) {
			
			if((!Character.isDigit(number.charAt(i)))&&(number.charAt(i) != '-')) {
				System.out.println("ERROR: "+number+" is not a constant");
				System.exit(0);
			}
			
		}
		value = Integer.parseInt(number);
		
		ParseTree.location++;
		
	}
	
	public int execute() {
		return value;
	}
	
	public void print() {
		System.out.print(value);
	}
}
