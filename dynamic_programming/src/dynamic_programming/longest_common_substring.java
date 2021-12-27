package dynamic_programming;

public class longest_common_substring {

	public static void main(String[] args) {
		String x = getstring(10);
		String y = getstring(10);
		System.out.println("String x: " + x + " String y: " + y);
		int m = x.length();
		int n = y.length();

		int[][] dp_table = construct_dp_table(x, y, m, n);

		String lcs = "";

		while (m > 0 && n > 0) {
			if (x.charAt(m - 1) == y.charAt(n - 1)) {
				lcs += x.charAt(m - 1);
				m--;
				n--;
			} else if (dp_table[m - 1][n] > dp_table[m][n - 1]) {
				m--;
			} else {
				n--;
			}
		}
		System.out.println("LCS has length " + lcs.length());
		System.out.println("One LCS is " + new StringBuilder(lcs).reverse().toString());
	}

	public static int[][] construct_dp_table(String x, String y, int m, int n) {

		// memoization table
		int[][] mem = new int[m + 1][n + 1];

		// iterate over every cell
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				// if characters match, the LCSLength is LCSLength(X[0..i-1], Y[0..j-1]) + 1
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					mem[i][j] = 1 + mem[i - 1][j - 1];
					// else we get max(LCSLength(X[0..i-1], Y[0..j]), LCSLength(X[0..i], Y[0..j-1]))
				} else {
					mem[i][j] = Math.max(mem[i - 1][j], mem[i][j - 1]);
				}
			}
		}
		return mem;
	}

	public static String getstring(int length) {
		String result = "";
		String alphabet = "ABCDEFG";
		while (result.length() < length) {
			result += alphabet.charAt((int) (Math.random() * 6));
		}
		return result;
	}
}
