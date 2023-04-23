package ilu2;

public class Welcome {

	private static final String[] hello = { "Hello", "HELLO" };

	public static String welcome(String input) {
		if (input.isBlank())
			return "Hello, my friend";

		input = input.replaceAll(" ", "");
		String[] listeNom = input.split(",");
		listeNom = formatListeNom(listeNom);
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
					sbl.append(" and " + listeNom[i].substring(1, 2).toUpperCase() + listeNom[i].substring(2));
				else
					sbl.append(", " + listeNom[i].substring(1, 2).toUpperCase() + listeNom[i].substring(2));
				if (listeNom[i].charAt(0) != '1')
					sbl.append(" (x" + listeNom[i].charAt(0) + ")");
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
					sbu.append(" AND " + listeNom[i].substring(1));
				else
					sbu.append(", " + listeNom[i].substring(1));
				nbUppAdd++;
				if (listeNom[i].charAt(0) != '1')
					sbu.append(" (x" + listeNom[i].charAt(0) + ")");
			}
		}
		sbu.append(" !");
		return sbu;
	}

	private static String[] formatListeNom(String[] listeNom) {
		String[] newListeNom = new String[listeNom.length];
		int[] nb = new int[listeNom.length];
		int nbNom = 0;
		int pos;
		for (int i = 0; i < listeNom.length; i++) {
			if ((pos = posInTab(newListeNom, nbNom, listeNom[i])) != -1)
				nb[pos]++;
			else {
				newListeNom[nbNom] = listeNom[i];
				nb[nbNom] = 1;
				nbNom++;
			}
		}
		return addNumberToFront(newListeNom, nb, nbNom);
	}

	private static int posInTab(String[] tab, int size, String nom) {
		for (int i = 0; i < size; i++) {
			if (tab[i].toUpperCase().equals(nom.toUpperCase()))
				return i;
		}
		return -1;
	}

	private static String[] addNumberToFront(String[] listeNom, int[] val, int size) {
		String[] newListeNom = new String[size];
		for (int i = 0; i < size; i++)
			newListeNom[i] = val[i] + listeNom[i];
		return newListeNom;
	}

}
