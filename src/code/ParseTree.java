package code;

import java.util.HashMap;
import java.util.Map;

public class ParseTree {

	public static Map<String,Integer> symbolTable = new HashMap<>();
	private Program root = null;
	public static String[] tokens = null;
	public static int location = 0;
	public ParseTree(String[] tokens) {
		
		this.root = new Program();
		ParseTree.symbolTable.clear();
		ParseTree.location = 0;
		ParseTree.tokens = tokens;
		
	}
	
	public void parse() {
		root.parse();
	}
	
	public void execute() {
		root.execute();
	}
	
	public void print() {
		root.print();
	}
	
	
	
}
