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
	public File f;
	public Scanner in;

	public CoreScanner(String fileName) throws FileNotFoundException {
		f = new File(fileName);
		in = new Scanner(f);

	}

	public String[] scan() {
		ArrayList<String> tokens = new ArrayList<>();
		Set<Character> separators = new HashSet<>();

		separators.add(' ');
		separators.add('.');
		separators.add('\n');
		separators.add('\t');
		separators.add('\'');
		
		
		Set<Character> importantChars = new  HashSet<>();
		
		importantChars.add(':');
		importantChars.add(';');
		importantChars.add(',');
		importantChars.add('=');
		importantChars.add('!');
		importantChars.add('+');
		importantChars.add('*');
		importantChars.add('-');
		importantChars.add('/');

		String nextLine;
		while (in.hasNext()) {
			nextLine = in.nextLine();
			int pos = 0;
			String next = "";

			while (pos < nextLine.length()) {
				next = nextWordOrSeparatorOrImportant(nextLine, pos, separators,importantChars);
				pos += next.length();

				if (!separators.contains(next.charAt(0))) {
					tokens.add(next);
				}
			}

		}

		Object[] tokensObArr = tokens.toArray();

		// convert Object array to String array
		String[] tokensArray = Arrays.copyOf(tokensObArr, tokensObArr.length, String[].class);

		return tokensArray;
	}

	public String[] preprocess(String[] tokens) {
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

		tokenMap.put(";", "SEMICOLON");

		ArrayList<String> preprocessedTokens = new ArrayList<>();

		return (String[]) preprocessedTokens.toArray();
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
			returned = returned+text.charAt(position);
		} else {
			while (count < text.substring(position, text.length()).length()) {
				returnedPiece = text.charAt(position + count);
				if ((!separators.contains(text.charAt(position + count)))&&!importantChars.contains(text.charAt(position+count))) {
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
