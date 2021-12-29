package dynamic_programming;

public class shortest_common_superstring extends dp_problem {

	public static void main(String[] args) {
		String x = getstring(10);
		String y = getstring(10);

		// Naive approach (recursion, without memoization)
		System.out.println("SCS: " + recursion(x, y).length());
		System.out.println(construct_dp_table(x, y)[x.length()][y.length()]);
	}

	// Naive approach for SCS problem (recursion, without memoization)
	public static String recursion(String x, String y) {
		// check base case (one of the strings has length == 0)
		if (x.length() == 0 || y.length() == 0) {
			return x + y;
		}

		// check if last characters are equal
		if (x.charAt(x.length() - 1) == y.charAt(y.length() - 1)) {
			return recursion(x.substring(0, x.length() - 1), y.substring(0, y.length() - 1))
					+ x.substring(x.length() - 1);
		}

		// calculate both variants
		String remove_x = recursion(x.substring(0, x.length() - 1), y) + x.substring(x.length() - 1);
		String remove_y = recursion(x, y.substring(0, y.length() - 1)) + y.substring(y.length() - 1);

		// return shortest
		if (remove_x.length() < remove_y.length()) {
			return remove_x;
		}
		return remove_y;
	}

	// DP approach
	public static int[][] construct_dp_table(String x, String y) {
		int[][] mem = new int[x.length() + 1][y.length() + 1];

		for (int i = 0; i < mem.length; i++) {
			for (int j = 0; j < mem[0].length; j++) {
				if (i == 0) {
					mem[i][j] = j;
				} else if (j == 0) {
					mem[i][j] = i;
				} else if (x.charAt(i - 1) == y.charAt(j - 1)) {
					mem[i][j] = mem[i - 1][j - 1] + 1;
				} else {
					mem[i][j] = Math.min(mem[i - 1][j] + 1, mem[i][j - 1] + 1);
				}
			}
		}

		return mem;
	}

}
