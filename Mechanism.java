public class Mechanism extends Thread {

	Manager manager;
	Mouse mouse;
	int delay;
	boolean random;

	boolean stop = false;

	Mechanism(Manager m, Mouse mouse, int d, boolean r) {
		this.manager = m;
		this.mouse = mouse;
		this.delay = d;
		this.random = random;
	}

	public void run() {
		int numberOfLocations = manager.getNumberOfEntries();
		int[] value = new int[2];
		while (true) {
			if(this.stop == true) {
				break;
			}
			for(int i = 0; i < numberOfLocations; i++) {
				if(this.stop == true) {
					break;
				}

				value = manager.get(i);

				try {
					Thread.sleep(delay * 60000);
				} catch (Exception e) {
					System.out.println("Delay Fail");
				}

				mouse.moveMouse(value[0], value[1]);
				System.out.println("click.");
			}
		}
		System.out.println("Thread Stop.");
	}

	public void end() {
		this.stop = true;	
	}

}
