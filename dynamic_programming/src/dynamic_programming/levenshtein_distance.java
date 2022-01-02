package dynamic_programming;

public class levenshtein_distance extends dp_problem {

	public static void main(String[] args) {
		String x = getstring(10);
		String y = getstring(10);
		x = "Saturday";
		y = "Sundady";
		// Find Levenshtein distance
		int[][] dp_table = new int[x.length() + 1][y.length() + 1];
		int cost;
		for (int i = 0; i < dp_table.length; i++) {
			for (int j = 0; j < dp_table[0].length; j++) {
				if (i == 0 || j == 0) {
					dp_table[i][j] = i + j;
				} else {
					if (x.charAt(i - 1) == y.charAt(j - 1)) {
						cost = 0;
					} else {
						cost = 1;
					}
					dp_table[i][j] = Math.min(dp_table[i - 1][j] + 1,
							Math.min(dp_table[i][j - 1] + 1, dp_table[i - 1][j - 1] + cost));
				}
			}
		}
		System.out.println("The Levenshtein distance is " + dp_table[dp_table.length - 1][dp_table[0].length - 1]);
	}

}
