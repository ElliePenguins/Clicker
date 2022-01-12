/*
 * MIT License
 * Copyright (c) 2022 ElliePenguins 
 *
 */

import java.util.Vector;

/* Keeps track of all of the values that are added, removed. */

class Manager {

	Vector<int[]> locations = new Vector<>();
	int numberOfEntries = 0;

	void add(int x, int y) {
		int location[] = new int[2];

		location[0] = x;
		location[1] = y;

		this.locations.add(location);
	}

	void add(int[] location) {
		System.out.println("X: " + location[0] + " Y: " + location[1]);
		this.locations.add(location);
		this.numberOfEntries++;
	}

	int[] get(int number) {
		int[] value = new int[2]; 
		if (this.numberOfEntries > 0 && number < this.numberOfEntries) {
			value = this.locations.elementAt(number);
		}

		return value;
	}

	String[] getList() {
		String[] array = new String[this.numberOfEntries];
		for(int i = 0; i < this.numberOfEntries; i++){
			array[i] = new String(i+1 + ":  " + this.locations.elementAt(i)[0] + 
				" X " + this.locations.elementAt(i)[1]);
		}
		return array;
	}

	int getNumberOfEntries() {
		return this.numberOfEntries;
	}

	void delete(int number) {
		System.out.println("Entries: " + this.numberOfEntries);

		// Allows Clear to work on the most recent entry
		// when none are selected, faster deletes without
		// needing an extra button.
		if (number < 0) {
			number = this.numberOfEntries-1;
		}

		if (this.numberOfEntries > 0) {
			this.locations.remove(number);
			this.numberOfEntries--;
			System.out.println("Delete one");
		}
	}

	void debug() {
		int length = this.locations.size();
		System.out.println("Length: " + length);

		for ( int i = 0; i < this.locations.size()-1; i++) {
			System.out.println("X: " + this.get(i)[0] + " Y: " + this.get(i)[1]);
		}
	}
}
