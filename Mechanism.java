public class Mechanism extends Thread {

	Manager manager;
	Mouse mouse;
	int delay;
	boolean random;
	boolean click;
	boolean delayStart;

	boolean stop = false;

	Mechanism(Manager m, Mouse mouse, int d, boolean r, boolean c, boolean ds) {
		this.manager = m;
		this.mouse = mouse;
		this.delay = d;
		this.random = random;
		this.click = c;
		this.delayStart = ds;
		System.out.println("DELAY: " + ds);
	}

	// Separate these out into their own methods
	// and call them from run().
	public void run() {
		int numberOfLocations = manager.getNumberOfEntries();
		int[] value = new int[2];
		while (true) {
			if(this.stop == true) {
				break;
			}
			for(int i = 0; i < numberOfLocations; i++) {
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

				value = manager.get(i);
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

	public void end() {
		this.stop = true;	
	}

}
