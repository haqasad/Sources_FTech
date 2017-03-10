package haq.asad.classwork;

import org.junit.Test;
import junit.framework.AssertionFailedError;
import static org.junit.Assert.assertEquals;

public class TestClass {
	
	String messageGood = "This is a good name";
	String messageBad = "This is a bad name";
	String messageBlank = "";
	
	String varNameBad = "Asad";
	Name checkNameBad = new Name(varNameBad);
	
	String varNameGood = "God";
	Name checkNameGood = new Name(varNameGood);
	
	
	@Test
	public void testPrintMessage1() {				
		assertEquals(messageBad, checkNameBad.verifyName());
	}
	
	@Test
	public void testPrintMessage2() {				
		assertEquals(messageGood, checkNameGood.verifyName());
	}
	
	@Test
	public void testPrintMessage3() {		
		try {
			assertEquals("testPrintMessage3() has failed, moving to testPrintMessage4()", messageGood, checkNameBad.verifyName());
		} catch (AssertionFailedError e) {
			testPrintMessage4();
		}
	}
	
	@Test
	public void testPrintMessage4() {
		try {
			assertEquals("testPrintMessage4() has failed, moving to testPrintMessage5()", messageBad, checkNameGood.verifyName());
		} catch (AssertionFailedError e) {
			testPrintMessage5();
		}
	}
	
	@Test
	public void testPrintMessage5() {
		try {
			assertEquals("testPrintMessage5() has failed, moving to testPrintMessage6()", messageBlank, checkNameGood.verifyName());
		} catch (AssertionFailedError e) {
			testPrintMessage6();
		}
	}
	
	@Test
	public void testPrintMessage6() {
		try {
			assertEquals("Last Test", messageBlank, checkNameBad.verifyName());
		} catch (AssertionFailedError e) {
			System.out.println("Testing Finished");
		}
	}

}
