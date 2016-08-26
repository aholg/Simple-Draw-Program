package aholg.model;

/**
 * Class responsible for parsing a input string and creating command objects to be passed on.
 * @author Anton
 *
 */
public class CommandParser {
	//stopped here make zeroes
	private static final String CANVAS_COMMAND = "C\\s[1-9]\\d*\\s[1-9]\\d*";
	private static final String LINE_COMMAND = "L\\s[0-9]\\d*\\s[0-9]\\d*\\s[0-9]\\d*\\s[0-9]\\d*";
	private static final String RECTANGLE_COMMAND = "R\\s[1-9]\\d*\\s[1-9]\\d*\\s[1-9]\\d*\\s[1-9]\\d*";
	private static final String BUCKET_COMMAND = "B\\s[1-9]\\d*\\s[1-9]\\d*\\s[A-Za-z0-9]?";
	private static final String QUIT_COMMAND = "Q";

	/**
	 * Parses a string and matches it with canvas commands.
	 * 
	 * @param input
	 *            String to be parsed
	 * @return A command object containing info about the command.
	 * @throws Exception
	 *             Exception if no matching command was found.
	 */
	public Command parseInput(String input) throws Exception {
		String trimmedInput = input.trim();

		if (trimmedInput.matches(CANVAS_COMMAND)) {
			String[] split = trimmedInput.split("\\W+");
			int width = Integer.parseInt(split[1]);
			int height = Integer.parseInt(split[2]);
			return new Command("Canvas", null, null, new Canvas(width, height));
		} else if (trimmedInput.matches(LINE_COMMAND)) {
			String[] split = trimmedInput.split("\\W+");
			int x1 = Integer.parseInt(split[1]);
			int y1 = Integer.parseInt(split[2]);
			int x2 = Integer.parseInt(split[3]);
			int y2 = Integer.parseInt(split[4]);
			return new Command("Line", new Line(x1, y1, x2, y2), null, null);
		} else if (trimmedInput.matches(RECTANGLE_COMMAND)) {
			String[] split = trimmedInput.split("\\W+");
			int x1 = Integer.parseInt(split[1]);
			int y1 = Integer.parseInt(split[2]);
			int x2 = Integer.parseInt(split[3]);
			int y2 = Integer.parseInt(split[4]);
			return new Command("Rectangle", new Rectangle(x1, y1, x2, y2), null, null);
		} else if (trimmedInput.matches(BUCKET_COMMAND)) {
			String[] split = trimmedInput.split("\\W+");
			int x = Integer.parseInt(split[1]);
			int y = Integer.parseInt(split[2]);
			String color = split[3];

			return new Command("Bucket", null, new Color(x, y, color), null);
		} else if (input.matches(QUIT_COMMAND)) {
			return new Command("Quit", null, null, null);
		} else if (input.matches("help")) {
			return new Command("Help", null, null, null);
		} else {
			throw new Exception(
					"The input '" + input + "' did not match any known command. Type help to get list of commands.");
		}

	}
}
