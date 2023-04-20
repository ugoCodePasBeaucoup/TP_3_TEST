package ilu2;

public class Welcome {

	public static String welcome(String input) {
		String[] listeNom = input.split(",");

		if (input.isBlank())
			return "Hello, my friend";

		StringBuilder sb = new StringBuilder("Hello");
		for (int i = 0; i < listeNom.length; i++) {
			if (isUpperString(listeNom[i])) {
				sb.append(", " + listeNom[i] + " !");
			} else {
				sb.append(", " + listeNom[i].substring(0, 1).toUpperCase() + listeNom[i].substring(1));
			}
		}

		return sb.toString();
	}

	private static boolean isUpperString(String input) {
		return input.equals(input.toUpperCase());
	}

}
