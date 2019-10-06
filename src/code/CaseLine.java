package code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CaseLine {

	private Constant constant = null;
	private ConstantList constantList = null;
	private Expression expression = null;
	private CaseLineFollow caseLineFollow = null;
	
	public CaseLine() {
		
	}
	
	public void parse() {
		constant = new Constant();
		constant.parse();
		
		constantList = new ConstantList();
		constantList.parse();
		
		if (ParseTree.tokens[ParseTree.location] == "COLON") {
			ParseTree.location++;
		} else {
			System.out.println("ERROR: \":\" keyword expected and not Found");
			System.exit(0);
		}
		
		expression = new Expression();
		expression.parse();
		
		caseLineFollow = new CaseLineFollow();
		caseLineFollow.parse();
	}
	
	public Map<Integer,Integer> execute() {
		Map<Integer,Integer> casesAndValues = new HashMap<>();
		ArrayList<Integer> cases = new ArrayList<>();
		cases.add(constant.execute());
		cases.addAll(constantList.execute());
		int value = expression.execute();
		
		for(int i = 0; i<cases.size(); i++) {
			casesAndValues.put(cases.get(i), value);
		}
		
		casesAndValues.putAll(caseLineFollow.execute());
		
		return casesAndValues;
	}
	
	public void print() {
		for (int i = 0; i < ParseTree.indentCount; i++) {
			System.out.print("  ");
		}
		constant.print();
		constantList.print();
		System.out.print(":");
		expression.print();
		caseLineFollow.print();
	}
	
}
