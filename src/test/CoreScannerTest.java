package test;

import code.CoreScanner;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

public class CoreScannerTest {

	@Test
	public void scanTestSource1() {
		CoreScanner CS = null;
		try {
			CS = new CoreScanner("CoreFiles/CoreSource1.core");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(CS);

		String[] actual = CS.scan();
		
		String[] expected = {"program","int","x",",","y",",","z",";","begin","input","x",",","y",";","z",":","=","x",";","x",":","=","y",";","y",":","=","z",";","output","x",";","output","y",";","end"};
		
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void scanTestSource2() {
		CoreScanner CS = null;
		try {
			CS = new CoreScanner("CoreFiles/CoreSource2.core");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(CS);

		String[] actual = CS.scan();
		
		String[] expected = {"program","int","x",",","y",",","z",";","begin","input","x",",","y",";","z",":","=","x",";","x",":","=","y",";","y",":","=","z",";","output","x",";","output","y",";","end"};
		
		Assert.assertArrayEquals(expected, actual);
	}
	
	
	@Test
	public void scanTestSource3() {
		CoreScanner CS = null;
		try {
			CS = new CoreScanner("CoreFiles/CoreSource3.core");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(CS);

		String[] actual = CS.scan();
		
		String[] expected = {"program","int","x",";","begin","x",":","=","5",";","end"};
		
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void preprocessTest() {
		
		CoreScanner CS = null;
		try {
			CS = new CoreScanner("CoreFiles/CoreSource1.core");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(CS);

		String[] actual = CS.scan();
		actual = CS.preprocess(actual);
		
		
		String[] expected = { "PROGRAM", "INT", "ID[x]", "COMMA", "ID[y]", "COMMA", "ID[z]", "SEMICOLON", "BEGIN",
				"INPUT", "ID[x]", "COMMA", "ID[y]", "SEMICOLON", "ID[z]", "ASSIGN", "ID[x]", "SEMICOLON", "ID[x]",
				"ASSIGN", "ID[y]", "SEMICOLON", "ID[y]", "ASSIGN", "ID[z]", "SEMICOLON", "OUTPUT", "ID[x]", "SEMICOLON",
				"OUTPUT", "ID[y]", "SEMICOLON", "END", "EOF" };
		
		Assert.assertArrayEquals(expected,actual);
	}

}
