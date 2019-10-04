package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CoreScanner {
	// file that is going to be read from
	public File f;
	// scanner that is going to read from the file
	public Scanner in;

	// This is the constructor for the scanner
	public CoreScanner(String fileName) throws FileNotFoundException {
		f = new File(fileName);
		in = new Scanner(f);

	}

	// This method reads in the file and places and splits up the tokens into an
	// array.
	public String[] scan() {
		// tokens will consist of the tokens that we have read from the file
		ArrayList<String> tokens = new ArrayList<>();

		// separators are separators that we can skip over when scanning the source code
		Set<Character> separators = new HashSet<>();
		separators.add(' ');
		separators.add('.');
		separators.add('\n');
		separators.add('\t');
		separators.add('\'');

		// importantChars are important characters that are technically separators, but
		// must be separated from text as they are their own important keywords
		// This includes all the mathematical operators, and different assignment
		// operators
		Set<Character> importantChars = new HashSet<>();

		importantChars.add(':');
		importantChars.add(';');
		importantChars.add(',');
		importantChars.add('=');
		importantChars.add('!');
		importantChars.add('+');
		importantChars.add('*');
		importantChars.add('-');
		importantChars.add('/');

		// Reads in each line from file and adds keywords and other important words to
		// tokens
		String nextLine;
		while (in.hasNext()) {
			nextLine = in.nextLine();
			int pos = 0;
			String next = "";
			// Reads in each word/sep/important char and adds only words/important chars to
			// tokens array list
			while (pos < nextLine.length()) {
				next = nextWordOrSeparatorOrImportant(nextLine, pos, separators, importantChars);
				pos += next.length();

				if (!separators.contains(next.charAt(0))) {
					tokens.add(next);
				}
			}

		}

		// converts tokens array list to a tokens string array
		Object[] tokensObArr = tokens.toArray();

		// convert Object array to String array
		String[] tokensArray = Arrays.copyOf(tokensObArr, tokensObArr.length, String[].class);

		return tokensArray;
	}

	// this pre-processes the token array into a more readable format for the parser
	public String[] preprocess(String[] tokens) {
		// this map contains all the mappings of how I want tokens to look
		Map<String, String> tokenMap = new HashMap<String, String>();
		tokenMap.put("program", "PROGRAM");
		tokenMap.put("begin", "BEGIN");
		tokenMap.put("end", "END");
		tokenMap.put("else", "ELSE");

		tokenMap.put("int", "INT");

		tokenMap.put("if", "IF");
		tokenMap.put("then", "THEN");
		tokenMap.put("else", "ELSE");
		tokenMap.put("endif", "ENDIF");

		tokenMap.put("input", "INPUT");
		tokenMap.put("output", "OUTPUT");

		tokenMap.put("while", "WHILE");
		tokenMap.put("endwhile", "ENDWHILE");
		
		tokenMap.put("case", "CASE");
		tokenMap.put("of", "OF");
		tokenMap.put("id","ID");
		tokenMap.put("|", "BAR");
		

		tokenMap.put(";", "SEMICOLON");
		tokenMap.put(",", "COMMA");
		tokenMap.put("=", "EQUALS");
		tokenMap.put("(", "LEFTPARENTHESIS");
		tokenMap.put(")", "RIGHTPARENTHESIS");

		ArrayList<String> preprocessedTokens = new ArrayList<>();
		// below takes every token and changes it to the easier to read language.
		for (int i = 0; i < tokens.length; i++) {
			if (tokenMap.containsKey(tokens[i])) {
				preprocessedTokens.add(tokenMap.get(tokens[i]));

			} else if (tokens[i].equals(":")) {
				if (tokens[i + 1].equals("=")) {
					// Note that Assign operator is both the colon and equals operator
					preprocessedTokens.add("ASSIGN");
					// jumps an extra step to account for consuming the equals sign
					i++;
				} else {
					preprocessedTokens.add("COLON");
				}
				// below finds if the token is > or >=
			} else if (tokens[i].equals(">")) {

				if (tokens[i + 1].equals("=")) {
					preprocessedTokens.add("GREATERTHANOREQUALTO");
					i++;
				} else {
					preprocessedTokens.add("GREATERTHAN");
				}

				// below finds if the token is < or <=
			} else if (tokens[i].equals("<")) {

				if (tokens[i + 1].equals("=")) {
					preprocessedTokens.add("LESSTHANOREQUALTO");
					i++;
				} else {
					preprocessedTokens.add("LESSTHAN");
				}

			} else {
				// gotta error check every character in the id token, thus we loop through each
				// and every character to make sure its a number or a letter
				// Hopefully they dont care if we have variables with both numbers and letter
				// like dog1
				
				
				for (int j = 0; j < tokens[i].length(); j++) {
					
					
					char c = tokens[i].charAt(j);
					if ((!Character.isDigit(c)) && (!Character.isLetter(c))) {
						System.out.println("ERROR: Character '" + c + "' is not allowed in input stream");
						System.exit(0);
					}
					
					

				}

				// adds token to tokens array
				preprocessedTokens.add("ID[" + tokens[i] + "]");
			}
		}
		preprocessedTokens.add("EOF");

		// below converts the Array List of strings to an array of strings
		Object[] tokensObArr = preprocessedTokens.toArray();

		// convert Object array to String array
		String[] tokensArray = Arrays.copyOf(tokensObArr, tokensObArr.length, String[].class);

		return tokensArray;
	}

	private static String nextWordOrSeparatorOrImportant(String text, int position, Set<Character> separators,
			Set<Character> importantChars) {
		assert text != null : "Violation of: text is not null";
		assert separators != null : "Violation of: separators is not null";
		assert 0 <= position : "Violation of: 0 <= position";
		assert position < text.length() : "Violation of: position < |text|";

		int count = 0;
		char returnedPiece = 'a';
		String returned = "";
		if (separators.contains(text.charAt(position))) {
			while (count < text.substring(position, text.length()).length()) {
				returnedPiece = text.charAt(position + count);
				if (separators.contains(text.charAt(position + count))) {
					returned = returned + returnedPiece;
					count++;
				} else {
					count = text.substring(position, text.length()).length();
				}
			}
			count = 0;
		} else if (importantChars.contains(text.charAt(position))) {
			returned = returned + text.charAt(position);
		} else {
			while (count < text.substring(position, text.length()).length()) {
				returnedPiece = text.charAt(position + count);
				if ((!separators.contains(text.charAt(position + count)))
						&& !importantChars.contains(text.charAt(position + count))) {
					returned = returned + returnedPiece;
					count++;
				} else {
					count = text.substring(position, text.length()).length();
				}
			}
			count = 0;
		}
		return returned;
	}

}
