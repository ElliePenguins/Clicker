import java.awt.Robot;
import java.awt.MouseInfo;
import java.awt.event.InputEvent;

class Mouse {

	Robot r; 

	public Mouse() {
		System.out.println("Creating Mouse.");
		try {
			this.r = new Robot();
		} catch (Exception e) {
			System.out.println("Could not construct robot.");
		}
	}

	int[] getCurrentMouse() {
		int values[] = new int[2];

		values[0] = (int)MouseInfo.getPointerInfo().getLocation().getX();
		values[1] = (int)MouseInfo.getPointerInfo().getLocation().getY();

		System.out.println("X: " + values[0] + " - Y: " + values[1]);
		return values; 
	}
		
	void moveMouse(int x, int y) {
		this.r.mouseMove(x,y);
	}

	void clickMouse() {
		this.r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		try {
			// Need a sensitivity setting.
			Thread.sleep(50);
		} catch(Exception e) {
			System.out.println("Mouse delay fail");
		}
		this.r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
}
