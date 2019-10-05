package code;

public class DeclaredID {
	

	public DeclaredID() {

	}

	public void parse() {
		String id = ParseTree.tokens[ParseTree.location].substring(3, ParseTree.tokens[ParseTree.location].length()-1);
		
		if(!ParseTree.symbolTable.containsKey(id)) {
			System.out.println("ERROR: You must declare variable "+id+" before using it");
			System.exit(0);
		}else {
			ParseTree.location++;
		}
	}

	public void execute() {

	}

	public void print() {

	}

}
