package aholg.view;

import java.util.Scanner;

import aholg.controller.Controller;
import aholg.model.Observer;

public class Console implements Observer {

	public Console() {
		String input;
		Controller controller = new Controller(this);
		boolean quit = false;
		while (quit == false) {
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

	@Override
	public void notify(String result) {
		System.out.println(result);
	}

}
