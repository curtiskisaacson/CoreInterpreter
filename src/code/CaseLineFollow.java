package code;

import java.util.HashMap;
import java.util.Map;

public class CaseLineFollow {
	private CaseLine caseLine = null;
	
	
	public CaseLineFollow() {
		
	}
	
	public void parse() {
		if(ParseTree.tokens[ParseTree.location].equals("BAR")) {
			ParseTree.location++;
			caseLine = new CaseLine();
			caseLine.parse();
		}
	}
	
	public Map<Integer,Integer> execute() {
		Map<Integer,Integer> returnMap = new HashMap<>();
		if(caseLine != null) {
			returnMap = caseLine.execute();
		}
		return returnMap;
	}
	
	public void print() {
		if(caseLine != null) {
		System.out.println("|");
		caseLine.print();
		}
	}
}
