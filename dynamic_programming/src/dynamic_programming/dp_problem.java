package dynamic_programming;

public class dp_problem {
	static String getstring(int length) {
		String result = "";
		String alphabet = "ABCDEFG";
		while (result.length() < length) {
			result += alphabet.charAt((int) (Math.random() * 6));
		}
		System.out.println("String " + result + " was generated.");
		return result;
	}
}
