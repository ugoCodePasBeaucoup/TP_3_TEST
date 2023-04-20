package ilu2;

public class Welcome {

	public static String welcome(String input) {
		if (input.isBlank())
			return "Hello, my friend";

		StringBuilder sb = new StringBuilder("Hello, ");

		if (isUpperString(input)) {
			sb.append(input);
			sb.append(" !");
		} else {
			sb.append(input.substring(0, 1).toUpperCase());
			sb.append(input.substring(1));
		}
		return sb.toString();
	}

	private static boolean isUpperString(String input) {
		return input.equals(input.toUpperCase());
	}

}
