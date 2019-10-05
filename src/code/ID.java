package code;

public class ID {
	
	
	public ID() {

	}

	public void parse() {
		// Checks to see if there is an ID token here.
		if (!ParseTree.tokens[ParseTree.location].substring(0, 3).equals("ID[")) {
			System.out.println("ERROR: ID expected and not Found");
			System.exit(0);
		}
		// gets the id without the brackets
		String id = ParseTree.tokens[ParseTree.location].substring(3, ParseTree.tokens[ParseTree.location].length()-1);

		//checks if ID starts with digit
		if (Character.isDigit(id.charAt(0))) {
			System.out.println("ERROR: Variable " + id + " cannot begin with a digit");
			System.exit(0);
		}

		//checks for double declaration
		if (!ParseTree.symbolTable.containsKey(id)) {
			ParseTree.symbolTable.put(id, null);
			ParseTree.location++;
			
		} else {
			System.out.println("ERROR: ID " + id + " is declared more than once");
			System.exit(0);
		}
	}

	public void execute() {

	}

	public void print() {

	}

}
