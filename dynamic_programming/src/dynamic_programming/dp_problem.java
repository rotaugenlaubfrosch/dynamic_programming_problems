package dynamic_programming;

import java.util.Arrays;

public class dp_problem {
	// returns random string
	static String getstring(int length) {
		String result = "";
		String alphabet = "ABCDEFG";
		while (result.length() < length) {
			result += alphabet.charAt((int) (Math.random() * 6));
		}
		System.out.println("String " + result + " was generated.");
		return result;
	}
	
	// returns random int array with unique elements
	static int[] getintegers(int length) {
		int res[] = new int[length];
		for(int i = 0; i < res.length; i++) {
			res[i] = i;
		}
		for(int i = 0; i < res.length; i++) {
			int storage = res[i];
			int random = (int) (Math.random()*length);
			res[i] = res[random];
			res[random] = storage;
		}
		System.out.println("Generated array: " + Arrays.toString(res));
		return res;
	}
}
