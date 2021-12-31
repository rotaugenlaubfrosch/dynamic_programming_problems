package dynamic_programming;

import java.util.Arrays;

public class matrix_multiplication extends dp_problem {

	public static void main(String[] args) {
		// There are a total of n-1 matrices
		int n = 5;
		// matrices are of size [i]x[i-1] (i>=1)
		int[] input = getintegers(n);
		
		for(int i = 0; i < input.length; i++) {
			input[i] += 5;
		}
		
		System.out.println("Array: " + Arrays.toString(input));

		int[][] dp_table = construct_dp_table(input);

		System.out.println("Minimum number of operations is " + dp_table[1][n - 1]);

	}

	public static int[][] construct_dp_table(int[] input) {
		int n = input.length;
		
		int[][] mem = new int[n + 1][n + 1];

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= n - i + 1; j++) {
				int k = j + i - 1;
				mem[j][k] = Integer.MAX_VALUE;
				for (int l = j; k < n && l <= k - 1; l++) {
					int cost = mem[j][l] + mem[l + 1][k] + input[j - 1] * input[l] * input[k];
					if (cost < mem[j][k]) {
						mem[j][k] = cost;
					}
				}
			}
		}
		return mem;
	}

}
