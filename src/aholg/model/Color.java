package aholg.model;

public class Color {
	private String color;
	private int x;
	private int y;
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
