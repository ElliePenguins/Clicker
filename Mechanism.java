import java.util.concurrent.ThreadLocalRandom;

public class Mechanism extends Thread {

	Manager manager;
	Mouse mouse;
	int delay;
	boolean click;
	boolean delayStart;
	boolean randomTime;
	boolean randomClick;

	boolean stop = false;

	Mechanism(Manager m, Mouse mouse, int d, boolean rc, boolean c, boolean ds, boolean rt) {
		this.manager = m;
		this.mouse = mouse;
		this.delay = d;
		this.randomClick= rc;
		this.click = c;
		this.delayStart = ds;
		this.randomTime = rt;
		System.out.println("DELAY: " + ds);
	}

	// Separate these out into their own methods
	// and call them from run().
	public void run() {
		int numberOfLocations = manager.getNumberOfEntries();
		int[] value = new int[2];
		int timeDelay = delay;
		while (true) {
			if(this.stop == true) {
				break;
			}
			for(int i = 0; i < numberOfLocations; i++) {
				if (this.randomTime) {
					timeDelay = this.generator(delay);
				}
				if (this.delayStart) {
					try {
						Thread.sleep(delay * 60000);
					} catch (Exception e) {
						System.out.println("Delay Fail");
					}
				} else {
					this.delayStart = true;
				}
				if(this.stop == true) {
					break;
				}

				if (this.randomClick) {
					value = manager.get(this.generator(0,
						manager.getNumberOfEntries()-1));
				} else {
					value = manager.get(i);
				}
				mouse.moveMouse(value[0], value[1]);
				System.out.println("move.");
				if (this.click) {
					mouse.clickMouse();
					System.out.println("click.");
				}
			}
		}
		System.out.println("Thread Stop.");
	}

	// Pass it delay, to use passed delay as max.
	int generator(int max) {
		int number = ThreadLocalRandom.current().nextInt(1, max+1);
		System.out.println("NUMBER: " + number);
		return number;
	}

	int generator(int min, int max) {
		int number = ThreadLocalRandom.current().nextInt(min, max+1);
		System.out.println("NUMBER: " + number);
		return number;
	}

	public void end() {
		this.stop = true;	
	}

}
