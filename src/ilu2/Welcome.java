package ilu2;

public class Welcome {

	private static final String[] hello = { "Hello", "HELLO" };

	public static String welcome(String input) {
		if (input.isBlank())
			return "Hello, my friend";
		String[] listeNom = input.split(",");
		StringBuilder sb = initStringBuilder(input);

		for (int i = 0; i < listeNom.length; i++) {
			sb.append(", " + listeNom[i].substring(0, 1).toUpperCase() + listeNom[i].substring(1));
		}

		if (isUpperString(input))
			sb.append(" !");

		return sb.toString();
	}

	private static boolean isUpperString(String input) {
		return input.equals(input.toUpperCase());
	}

	private static StringBuilder initStringBuilder(String input) {
		if (isUpperString(input))
			return new StringBuilder(hello[1]);
		return new StringBuilder(hello[0]);
	}

}
