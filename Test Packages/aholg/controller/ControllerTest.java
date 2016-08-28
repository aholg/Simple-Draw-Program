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
	 * Simple test function for testing the parsing and execution of commands.
	 * Complete test cases for the whole program needs to be done.
	 */
	@Test
	public void testNewCommand() throws NoCommandFoundException, Exception {
		
		
			doTestIllegalCommand("asfhaghag");
			doTestIllegalCommand("null");
			doTestIllegalCommand("C 0 0");
			doTestIllegalCommand("C 02 02");
			doTestIllegalCommand("L 02 02 02 0");
			doTestIllegalCommand("R 02 02 02 0");
			doTestIllegalCommand("B 02 02 0");
			doTestIllegalCommand("c2020");
			doTestIllegalCommand("L 10 10 15 10");
			doTestIllegalCommand("R 10 10 15 10");
			doTestIllegalCommand("B 10 10 1");
			
			
			doTestEligibleCommand("C 20 20");
			doTestEligibleCommand("C 40 20");
			doTestEligibleCommand("L 10 10 15 10");
			doTestEligibleCommand("R 10 10 15 10");
			doTestEligibleCommand("R 10 10 15 15");
			doTestEligibleCommand("B 10 10 1");
			doTestEligibleCommand("B 1 10 h");
			doTestEligibleCommand("B 1 10 L");
			doTestEligibleCommand("C 1000 2000");
			doTestEligibleCommand("B 1 10 i");
			doTestEligibleCommand("Q");
		}
		
		
	

	
	public void doTestIllegalCommand(String input){
		
		try {
			controller.newCommand(input);
			fail("did not throw an NoCommandFoundException for fault command: "+ input);
		} catch (NoCommandFoundException e) {
			// success
			
		}catch(Exception e){
			//success
		}
	}
	public void doTestEligibleCommand(String input){
		try {
			controller.newCommand(input);
		} catch (NoCommandFoundException e) {
			fail("A NoCommandFoundException was thrown for: "+ input);
		}
		catch(Exception e){
			fail("An exception was thrown for: "+ input);
		}
	}

}
