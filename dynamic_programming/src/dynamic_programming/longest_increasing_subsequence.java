package dynamic_programming;

import java.util.Arrays;

public class longest_increasing_subsequence extends dp_problem {
	public static void main(String[] args) {
		// int[] integers = getintegers(10);
		int[] integers = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };
		int[] integers_clone = integers.clone();
		Arrays.sort(integers_clone);

		int[][] dp_table = construct_dp_table(integers, integers_clone);
		int[] solution = new int[dp_table[dp_table.length - 1][dp_table.length - 1]];

		int m = dp_table.length - 1;
		int n = m;
		int counter = solution.length - 1;

		while (m > 0 && n > 0) {
			if (integers[m - 1] == integers_clone[n - 1]) {
				solution[counter] = integers[m-1];
				counter--;
				m--;
				n--;
			} else {
				if(dp_table[m-1][n] > dp_table[m][n-1]) {
					m--;
				} else {
					n--;
				}
			}
		}

		System.out.println(Arrays.toString(solution));
	}

	public static int[][] construct_dp_table(int[] integers, int[] integers_clone) {
		int[][] mem = new int[integers.length + 1][integers_clone.length + 1];

		for (int i = 0; i < mem.length; i++) {
			mem[0][i] = 0;
			mem[i][0] = 0;
			if (i >= 1) {
				for (int j = 1; j < mem.length; j++) {
					if (integers[i - 1] == integers_clone[j - 1]) {
						mem[i][j] = mem[i - 1][j - 1] + 1;
					} else {
						mem[i][j] = Math.max(mem[i - 1][j], mem[i][j - 1]);
					}
				}
			}
		}

		return mem;
	}
}
