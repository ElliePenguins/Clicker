import java.awt.Robot;
import java.awt.MouseInfo;

class Mouse {

	int x;
	int y;
	Robot r; 

	public Mouse() {
		System.out.println("Creating Mouse.");
		try {
			this.r = new Robot();
		} catch (Exception e) {
			System.out.println("Could not construct robot.");
		}
	}

	void getCurrentMouse() {
		this.x = (int)MouseInfo.getPointerInfo().getLocation().getX();
		this.y = (int)MouseInfo.getPointerInfo().getLocation().getY();
		System.out.println("X: " + x + " - Y: " + y);
	}
		
	void moveMouse(int x, int y) {
		this.r.mouseMove(x,y);
	}
}
