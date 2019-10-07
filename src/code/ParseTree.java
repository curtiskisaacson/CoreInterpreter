package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ParseTree {
	public static Scanner dataFileIn = null;
	
	public static int indentCount = 0;
	public static Map<String,Integer> symbolTable = new HashMap<>();
	private Program root = null;
	public static String[] tokens = null;
	public static int location = 0;
	public ParseTree(String[] tokens, String dataFileName) {
		
		
		File dataFile = new File(dataFileName);
		
		try {
			dataFileIn = new Scanner(dataFile);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Data file not found");
			System.exit(0);
		}
		
		this.root = new Program();
		
		//resets the important elements if multiple calls to constructor
		ParseTree.symbolTable.clear();
		ParseTree.location = 0;
		ParseTree.tokens = tokens;
		
	}
	
	public void parse() {
		root.parse();
	}
	
	public void execute() {
		root.execute();
		ParseTree.dataFileIn.close();
	}
	
	public void print() {
		root.print();
	}
	
	
	
}
