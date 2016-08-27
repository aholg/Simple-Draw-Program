package aholg.model;

/**
 * Holds a color and a coordinate to be used for bucket fill.
 * @author Anton
 *
 */
public class Color {
	private String color;
	private int x;
	private int y;
	
	/**
	 * Creates a new color object.
	 * @param x - X coordinate.
	 * @param y - Y coordinate.
	 * @param color - Color to be used.
	 */
	public Color(int x,int y, String color){
		this.color=color;
		this.x=x;
		this.y=y;
	}
	String getColor() {
		return color;
	}
	int getX() {
		return x;
	}
	int getY() {
		return y;
	}
}
