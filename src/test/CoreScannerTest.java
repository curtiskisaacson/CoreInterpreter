package test;

import code.CoreScanner;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

public class CoreScannerTest {

	@Test
	public void scanTest() {
		CoreScanner CS = null;
		try {
			CS = new CoreScanner("CoreFiles/CoreSource1.core");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(CS);

		String[] actual = CS.scan();
		
		String[] expected = { "PROGRAM", "INT", "ID[x]", "COMMA", "ID[y]", "COMMA", "ID[z]", "SEMICOLON", "BEGIN",
				"INPUT", "ID[x]", "COMMA", "ID[y]", "SEMICOLON", "ID[z]", "ASSIGN", "ID[x]", "SEMICOLON", "ID[x]",
				"ASSIGN", "ID[y]", "SEMICOLON", "ID[y]", "ASSIGN", "ID[z]", "SEMICOLON", "OUTPUT", "ID[x]", "SEMICOLON",
				"OUTPUT", "ID[y]", "SEMICOLON", "END", "EOF" };
		Assert.assertArrayEquals(expected, actual);
	}

}
