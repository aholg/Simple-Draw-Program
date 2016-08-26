package aholg.model;
//make abstract?
public class Command {
	private String type;
	private Shape shape;
	private Color color;
	private Canvas canvas;
	public Command(String type, Shape shape, Color color, Canvas canvas) {
		
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
	public Color getColor() {
		return color;
	}
	public Canvas getCanvas() {
		return canvas;
	}
	
	
}
