package code;

public class CoreParser {
	
	private ParseTree parseTree = null;
	public CoreParser(ParseTree parseTree) {
		this.parseTree = parseTree;
	}
	
	public void parse() {
		this.parseTree.parse();
	}
	
}
