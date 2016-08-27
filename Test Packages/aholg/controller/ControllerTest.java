package aholg.controller;

import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.Test;


import aholg.model.NoCommandFoundException;
import aholg.view.Console;


public class ControllerTest {
	private Controller controller;
	private Console console;
	@Before
	public void setUp() throws Exception {
		this.console=new Console(false);
		this.controller=new Controller(console);
	}


	/**
	 * Simple test function for testing the parsing of commands. Complete test cases for the whole program needs to be done.
	 */
	@Test
	public void testNewCommand() {
		
		
			doTestIllegalCommand("asfhaghag");
			doTestIllegalCommand("null");
			doTestIllegalCommand("C 0 0");
			doTestIllegalCommand("C 02 02");
			doTestIllegalCommand("c2020");
			
			doTestEligibleCommand("C 20 20");
			doTestEligibleCommand("C 40 20");
			doTestEligibleCommand("L 10 10 15 10");
			doTestEligibleCommand("R 10 10 15 10");
			doTestEligibleCommand("B 10 10 1");
			doTestEligibleCommand("B 10 10 L");
			doTestEligibleCommand("Q");
		}
		
		
	

	
	public void doTestIllegalCommand(String input){
		
		try {
			controller.newCommand(input);
			fail("did not throw an NoCommandFoundException for fault command: "+ input);
		} catch (NoCommandFoundException e) {
			// success
			
		}catch(Exception e){
			fail("did not throw a NoCommandFoundException for fault command: "+ input);
		}
	}
	public void doTestEligibleCommand(String input){
		try {
			controller.newCommand(input);
		} catch (NoCommandFoundException e) {
			fail("An exception was thrown for: "+ input);
		}
		catch(Exception e){
			fail("An exception was thrown for: "+ input);
		}
	}

}
