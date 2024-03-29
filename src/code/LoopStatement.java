package code;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class LoopStatement {
private Condition cond = null;
private StatementSequence stmtSeq = null;
	
	public LoopStatement() {
		
	}
	
	public void parse() {
		if (ParseTree.tokens[ParseTree.location] == "WHILE") {
			ParseTree.location++;
		} else {
			System.out.println("ERROR: while keyword expected and not Found");
			System.exit(0);
		}
		
		cond = new Condition();
		cond.parse();
		
		if (ParseTree.tokens[ParseTree.location] == "BEGIN") {
			ParseTree.location++;
		} else {
			System.out.println("ERROR: begin keyword expected and not Found");
			System.exit(0);
		}
		
		stmtSeq = new StatementSequence();
		stmtSeq.parse();
		
		if (ParseTree.tokens[ParseTree.location] == "ENDWHILE") {
			ParseTree.location++;
		} else {
			System.out.println("ERROR: endwhile keyword expected and not Found");
			System.exit(0);
		}
		
		if (ParseTree.tokens[ParseTree.location] == "SEMICOLON") {
			ParseTree.location++;
		} else {
			System.out.println("ERROR: Semicolon after loop statement expected and not Found");
			System.exit(0);
		}
	}
	
	public void execute() {
		while(cond.execute() ) {
			stmtSeq.execute();
		}
	}
	
	public void print() {
		System.out.print("while ");
		cond.print();
		System.out.print(" begin");
		ParseTree.indentCount++;
		stmtSeq.print();
		ParseTree.indentCount--;
		System.out.println();
		for (int i = 0; i < ParseTree.indentCount; i++) {
			System.out.print("  ");
		}
		System.out.print("endwhile;");
	}
}
