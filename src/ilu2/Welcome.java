package ilu2;

public class Welcome {

	private static final String[] hello = { "Hello", "HELLO" };

	public static String welcome(String input) {
		if (input.isBlank())
			return "Hello, my friend";
		String[] listeNom = input.split(",");
		StringBuilder sbu = new StringBuilder(hello[1]);
		StringBuilder sbl = new StringBuilder(hello[0]);

		for (int i = 0; i < listeNom.length; i++) {
			if (isUpperString(listeNom[i]))
				sbu.append(", " + listeNom[i]);
			else
				sbl.append(", " + listeNom[i].substring(0, 1).toUpperCase() + listeNom[i].substring(1));
		}

		sbu.append(" !");

		return fusionString(sbu, sbl);
	}

	private static boolean isUpperString(String input) {
		return input.equals(input.toUpperCase());
	}

	private static String fusionString(StringBuilder sbu, StringBuilder sbl) {
		if (sbl.toString().equals("Hello"))
			return sbu.toString();
		if (sbu.toString().equals("HELLO !"))
			return sbl.toString();
		return sbl.toString() + ". AND " + sbu.toString();
	}

}
