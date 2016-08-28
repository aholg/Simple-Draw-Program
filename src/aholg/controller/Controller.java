package aholg.controller;

import aholg.model.Canvas;
import aholg.model.Command;
import aholg.model.CommandParser;
import aholg.model.Line;
import aholg.model.NoCommandFoundException;
import aholg.model.Observer;
import aholg.model.Rectangle;

/**
 * This class takes requests from the view and calls the correct methods in the
 * model and in a safe order.
 * 
 * @author Anton
 *
 */
public class Controller {
	private Observer observer;
	private CommandParser parser;
	private Canvas canvas;

	/**
	 * Constructor
	 * 
	 * @param observer
	 *            Observer object sent along to the model.
	 */
	public Controller(Observer observer) {
		this.observer = observer;
		parser = new CommandParser();

	}

	/**
	 * Takes an input string to parse and create a new command.
	 * 
	 * @param input
	 *            Input String to parse.
	 * @throws Exception
	 *             Exception if unexpected null was returned from the parser
	 *             method.
	 */
	public void newCommand(String input) throws NoCommandFoundException, Exception {
		Command command = parseInput(input);
		if (command == null) {
			throw new NoCommandFoundException("Command not found");
		}
		String type = command.getType();
		if (type.equals("Canvas")) {
			canvas = command.getCanvas();
			canvas.addObserver(observer);
			canvas.newCanvas();

		}
		if (canvas != null) {
			if (type.equals("Line")) {

				canvas.newLine((Line) command.getShape());

			} else if (type.equals("Rectangle")) {

				canvas.newRectangle((Rectangle) command.getShape());

			} else if (type.equals("Bucket")) {

				canvas.colorFill(command.getColor());

			} else if (type.equals("Quit")) {
				System.exit(1);
			} else if (type.equals("Help")) {
				observer.notify("Create canvas: C w h");
				observer.notify("Create line: L x1 y1 x2 y2");
				observer.notify("Create rectangle: R x1 y1 x2 y2");
				observer.notify("Color area: B x y c");
				observer.notify("Quit: Q");
				return;
			}
		} else {
			throw new Exception("Canvas needs to be created before drawing shapes.");
		}

		canvas.printCanvas();
	}

	/**
	 * Parses a string and creates a new command if match was found.
	 * 
	 * @param input
	 *            - Input to be parsed.
	 * @return - An object containing information about a command.
	 * @throws Exception
	 *             - Thrown if no matching command was found.
	 */
	private Command parseInput(String input) throws NoCommandFoundException, Exception {
		return parser.parseInput(input);
	}
}
