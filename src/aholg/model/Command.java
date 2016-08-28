package aholg.model;


/**
 * Holds information about a command.
 * @author Anton
 *
 */
public class Command {
	private String type;
	private Shape shape;
	private Node color;
	private Canvas canvas;
	
	/**
	 * Creates a new command.
	 * @param type - Holds the type of command: 'Canvas','Line','Rectangle','Bucket','Quit','Help'.
	 * @param shape - If type is either a 'Line' or 'Rectangle' then the shape of that type is stored in this param, otherwise it is null.
	 * @param color - If type is 'Bucket' then a color object is stored here, otherwise null.
	 * @param canvas - If type is 'Canvas' then a canvas object is stored, otherwise null.
	 */
	public Command(String type, Shape shape, Node color, Canvas canvas) {
		
		this.type = type;
		this.shape = shape;
		this.color = color;
		this.canvas = canvas;
	}
	public String getType() {
		return type;
	}
	public Shape getShape() {
		return shape;
	}
	public Node getColor() {
		return color;
	}
	public Canvas getCanvas() {
		return canvas;
	}
	
	
}
