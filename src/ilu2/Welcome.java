package ilu2;

public class Welcome {

	private static final String[] hello = { "Hello", "HELLO" };

	public static String welcome(String input) {
		if (input.isBlank())
			return "Hello, my friend";

		String[] listeNom = input.split(",");
		int nbUpp = searchNbUpp(listeNom);

		StringBuilder sbl = creatLowerString(listeNom, listeNom.length - nbUpp);
		StringBuilder sbu = creatUpperString(listeNom, nbUpp);

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

	private static int searchNbUpp(String[] listeNom) {
		int nb = 0;
		for (int i = 0; i < listeNom.length; i++) {
			if (isUpperString(listeNom[i]))
				nb++;
		}
		return nb;
	}

	private static StringBuilder creatLowerString(String[] listeNom, int nbLow) {
		StringBuilder sbl = new StringBuilder(hello[0]);
		int nbLowAdd = 0;
		for (int i = 0; i < listeNom.length; i++) {
			if (!isUpperString(listeNom[i])) {
				if (nbLowAdd > 0 && nbLowAdd == nbLow - 1)
					sbl.append(" and " + listeNom[i].substring(0, 1).toUpperCase() + listeNom[i].substring(1));
				else
					sbl.append(", " + listeNom[i].substring(0, 1).toUpperCase() + listeNom[i].substring(1));
				nbLowAdd++;
			}
		}

		return sbl;
	}

	private static StringBuilder creatUpperString(String[] listeNom, int nbUpp) {
		StringBuilder sbu = new StringBuilder(hello[1]);
		int nbUppAdd = 0;
		for (int i = 0; i < listeNom.length; i++) {
			if (isUpperString(listeNom[i])) {
				if (nbUppAdd > 0 && nbUppAdd == nbUpp - 1)
					sbu.append(" AND " + listeNom[i]);
				else
					sbu.append(", " + listeNom[i]);
				nbUppAdd++;
			}
		}
		sbu.append(" !");
		return sbu;
	}

}
