package aholg.view;

import java.util.Scanner;

import aholg.controller.Controller;
import aholg.model.Observer;

/**
 * This class takes commands from the standard inputstream and passes it on to the controller.
 * @author Anton
 *
 */
public class Console implements Observer {

	/**
	 * Reads input from stdin and passes it to the controller.
	 * @param run - Run while run==true.
	 */
	public Console(boolean run) {
		String input;
		Controller controller = new Controller(this);
		
		while (run ==true) {
			System.out.println("Enter a command: ");
			Scanner in = new Scanner(System.in);
			input = in.nextLine();
			try {
				controller.newCommand(input);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	 /**
     * Prints output to stdout.
     *
     * @param output String to be printed.
     */
	@Override
	public void notify(String result) {
		System.out.println(result);
	}

}
