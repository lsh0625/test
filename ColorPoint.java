package Test;

public class  ColorPoint extends Point{

	public static void main(String[] args) {
		ColorPoint cp = new ColorPoint(5, 5, "YELLOW");
		 cp.setPoint(10, 20);
		 cp.setColor("GREEN");
		 cp.show();
	}
		 public ColorPoint(int x, int y, String color) {
			 super(x,y);
		 }
				String color=setColor("GREEN");
				String point=setPoint(10,20);
				String setPoint(int x,int y){
					return x +", "+ y;
				}
				String setColor(String color) {
					return color;
				}
				void show() {	
					System.out.println(color+"색으로 ("+point+")");
				}
}
class Point {
	 private int x, y;
	 public Point(int x, int y) {
	 this.x = x;
	 this.y = y;
	 }
	 public int getX() {
	 return x;
	 }
	 public int getY() {
	 return y;
	 }
	 protected void move(int x, int y) {
	 this.x = x;
	 this.y = y;
	 }
}
