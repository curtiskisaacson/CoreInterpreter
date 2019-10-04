package code;

public class Statement {
	private AssignStatement assignStatement = null;
	private IfStatement ifStatement = null;
	private LoopStatement loopStatement = null;
	private InStatement inStatement = null;
	private OutStatement outStatement = null;
	private CaseStatement caseStatement = null;
	private int prodNum = -1;
	
	public Statement() {
		
	}
	
	public void parse() {
		switch(ParseTree.tokens[ParseTree.location]) {
		
		
		
		
		}
	}
	
	public void execute() {
		
	}
	
	public void print() {
		
	}
}
