package code;

public class CorePrinter {
	
	private ParseTree parseTree = null;
	public CorePrinter(ParseTree parseTree) {
		this.parseTree = parseTree;
	}
	
	public void print() {
		this.parseTree.print();
	}
	
}
