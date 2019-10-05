package code;

public class CoreExecutor {

	private ParseTree parseTree = null;
	public CoreExecutor(ParseTree parseTree) {
		this.parseTree = parseTree;
	}
	
	public void execute() {
		this.parseTree.execute();
	}
}
