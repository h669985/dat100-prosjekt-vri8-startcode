package no.hvl.dat100.prosjekt.modell;

import java.util.Random;

import no.hvl.dat100.prosjekt.TODO;

public class KortUtils {

	/**
	 * Sorterer en samling. Rekkefølgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 * 
	 * @param samling
	 * 			samling av kort som skal sorteres. 
	 */
	public static void sorter(KortSamling samling) { //Insertion sort
		// Hent arrayet med kort fra KortSamling-objektet
		Kort[] bunke = samling.getSamling();

		// Gå gjennom arrayet, starter fra det andre kortet (indeks 1)
		for (int i = 1; i < bunke.length; i++) {
			// Velg gjeldende kort
			Kort gjeldendeKort = bunke[i];
			// Initialiser en variabel j for å peke på kortet rett bak
			int j = i - 1;

			/* While-løkken brukes til å sammenligne og sortere kortene
			*  Løkken vil fortsette så lenge begge betingelsene er sanne:
			* 	1. j er innenfor indeksene i arrayet (>= 0), slik at vi ikke går utenfor.
			* 	2. Enten er kortet på indeks j null, eller kortet på indeks j er større enn gjeldendeKort.
			*  Dette sikrer at kortene blir sortert i stigende rekkefølge basert på sammenligningen definert i compareTo-metoden. */
			while (j >= 0 && (bunke[j] == null || (gjeldendeKort != null && bunke[j] != null && bunke[j].compareTo(gjeldendeKort) > 0))) {
				// Flytt kortet på indeks j ett hakk til høyre for å gi plass til gjeldendeKort
				bunke[j + 1] = bunke[j];
				// Gå tilbake til forrige kort (venstre i arrayet)
				j--;
			}

			// Plasser gjeldendeKort på riktig plass i den sorterte rekkefølgen
			bunke[j + 1] = gjeldendeKort;
		}
	}


	/**
	 * Stokkar en kortsamling. 
	 * 
	 * @param samling
	 * 			samling av kort som skal stokkes. 
	 */
	public static void stokk(KortSamling samling) {
		Kort[] bunke = samling.getSamling();
		Random random = new Random();

		// Går gjennom hele bunken en gang
		for (int i = 0; i < bunke.length; i++) {
			// Velger et tilfeldig kort fra bunken
			int kaos = random.nextInt(bunke.length);

			// Bytter plass mellom det neste kortet i bunken og det tilfeldige valgte kortet fra bunken
			Kort hjelpekort = bunke[i];
			bunke[i] = bunke[kaos];
			bunke[kaos] = hjelpekort;
		}
	}
}
