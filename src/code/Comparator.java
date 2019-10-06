package code;

public class Comparator {
	private Expression firstExpression = null;
	private Expression secondExpression = null;

	private int prod = -1;

	public Comparator() {

	}

	public void parse() {
		firstExpression = new Expression();
		firstExpression.parse();

		if ((ParseTree.tokens[ParseTree.location].equals("EQUALS"))
				|| ((ParseTree.tokens[ParseTree.location].equals("LESSTHAN"))
						|| ((ParseTree.tokens[ParseTree.location].equals("LESSTHANOREQUALSTO"))))) {
			switch (ParseTree.tokens[ParseTree.location]) {

			case "EQUALS":
				prod = 1;
				break;
			case "LESSTHAN":
				prod = 2;
				break;
			case "LESSTHANOREQUALTO":
				prod = 3;
				break;
			}
			ParseTree.location++;
		} else {
			System.out.println("ERROR: Comparator keyword expected and not Found");
			System.exit(0);
		}

		secondExpression = new Expression();

		secondExpression.parse();

	}

	public boolean execute() {
		int first = firstExpression.execute();
		int second = secondExpression.execute();
		boolean returnValue = false;

		switch (prod) {
		case 1:
			returnValue = (first == second);
			break;
		case 2:
			returnValue = (first < second);
			break;
		case 3:
			returnValue = (first <= second);
			break;

		}

		return returnValue;

	}

	public void print() {
		switch (prod) {
		case 1:
			firstExpression.print();
			System.out.print("=");
			secondExpression.print();
			break;
		case 2:
			firstExpression.print();
			System.out.print("<");
			secondExpression.print();
			break;
		case 3:
			firstExpression.print();
			System.out.print("<=");
			secondExpression.print();
			break;

		}
	}

}
