package ilu2;

public class Welcome {

	public static String welcome(String input) {
		StringBuilder sb = new StringBuilder("Hello, ");
		sb.append(input.substring(0, 1).toUpperCase());
		sb.append(input.substring(1));
		return sb.toString();
	}

}
