class Start {
	public static void main(String[] data) {
		String[] h1 = new String[3];
		h1[0] = "A";
		h1[1] = "10";
		h1[2] = "A";
		Engine e = new Engine();
		e.prepare(h1);
		e.printAll(h1, 0, 0);
		int best = 0;
		for (int i = 0; i < e.possibles.length; i++) {
			System.out.println(e.possibles[i]);
			if (e.possibles[i] <= 21 && e.possibles[i] > best) {
				best = e.possibles[i];
			}
		}
		if (best == 0) {
			int minimum = e.possibles[0];
			for (int i = 0; i < e.possibles.length; i++) {
				if (e.possibles[i] < minimum) {
					minimum = e.possibles[i];
				}
			}
			best = minimum;
		}
		System.out.println("The best is " + best);
	}
}
class Engine {
	int[] possibles;    // default value is null
	int current;        // default value is 0
	void prepare(String[] data) {
		int total = 1;  // no default value
		for (int i = 0; i < data.length; i++) {
			if (data[i].equals("A")) {
				total = total * 2;
			}
		}
		possibles = new int[total];
	}

	void printAll(String[] data, int level, int sum) {
		if (level == data.length) {
			// System.out.println(sum);
			possibles[current] = sum;
			current++;
			return;
		}
		if (data[level].equals("A")) {
			printAll(data, level + 1, sum + 1);
			printAll(data, level + 1, sum + 11);
		}
		if (data[level].equals("2"))  printAll(data, level + 1, sum + 2);
		if (data[level].equals("3"))  printAll(data, level + 1, sum + 3);
		if (data[level].equals("4"))  printAll(data, level + 1, sum + 4);
		if (data[level].equals("5"))  printAll(data, level + 1, sum + 5);
		if (data[level].equals("6"))  printAll(data, level + 1, sum + 6);
		if (data[level].equals("7"))  printAll(data, level + 1, sum + 7);
		if (data[level].equals("8"))  printAll(data, level + 1, sum + 8);
		if (data[level].equals("9"))  printAll(data, level + 1, sum + 9);
		if (data[level].equals("10")) printAll(data, level + 1, sum + 10);
		if (data[level].equals("J"))  printAll(data, level + 1, sum + 10);
		if (data[level].equals("Q"))  printAll(data, level + 1, sum + 10);
		if (data[level].equals("K"))  printAll(data, level + 1, sum + 10);
	}
}
