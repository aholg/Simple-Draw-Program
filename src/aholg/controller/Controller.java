package aholg.controller;

import aholg.model.Canvas;
import aholg.model.Command;
import aholg.model.CommandParser;
import aholg.model.Line;
import aholg.model.Observer;
import aholg.model.Rectangle;

/**
 * This class takes requests from the view and calls the correct methods in the model and in a safe order.
 * @author Anton
 *
 */
public class Controller {
	private Observer observer;
	private CommandParser parser;
	private Canvas canvas;

	/**
	 * Constructor
	 * @param observer Observer object sent along to the model. 
	 */
	public Controller(Observer observer) {
		this.observer = observer;
		parser = new CommandParser();

	}

	/**
	 * Takes an input string to parse and create a new command.
	 * @param input			Input String to parse.
	 * @throws Exception	Exception if unexpected null was returned from the parser method.
	 */
	public void newCommand(String input) throws Exception {
		Command command = parseInput(input);
		if (command == null) {
			throw new Exception("Command not found");
		}
		String type = command.getType();
		if (type.equals("Canvas")) {
			canvas = command.getCanvas();
			canvas.addObserver(observer);
			canvas.newCanvas();

		} else if (type.equals("Line")) {
			if (canvas != null) {
				canvas.newLine((Line) command.getShape());

			}
		} else if (type.equals("Rectangle")) {
			if (canvas != null) {
				canvas.newRectangle((Rectangle) command.getShape());

			}
		} else if (type.equals("Bucket")) {
			if (canvas != null) {
				canvas.colorFill(command.getColor());

			}
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

		canvas.printCanvas();
	}

	public Command parseInput(String input) throws Exception {
		return parser.parseInput(input);
	}
}