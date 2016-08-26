package aholg.model;

public class Coordinate {
	private Color color;
	private int x;
	private int y;
	Coordinate(int x,int y,Color color){
		this.x=x;
		this.y=y;
		this.color=color;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}
