package it.unibs.fp.polverisottili;

import it.unibs.fp.mylib.InputDati;

public class Main {

	private static final int MAX_NUM_SETTIMANA = 53;
	private static final int MIN_NUM_SETTIMANA = 1;
	private static final String INSERIMENTO_LIVELLO_POLVERI = "Inserisci il valore di polveri sottili del giorno %d: ";
	private static final String INSERIMENTO_NUM_SETTIMANA = "Inserisci il numero della settimana: ";
	private static final String INSERIMENTO_ANNO = "Inserisci l'anno della settimana: ";
	private static final String INSERIMENTO_NUOVA_SETTIMANA = "Vuoi inserire i dati di una nuova settimana?";
	private static final String ATTENZIONE_SUPERAMENTO_LIVELLO_MEDIO = "Il valore medio di polveri sottili e' stato superato questa settimana";
	private static final String ATTENZIONE_SUPERAMENTO_LIVELLO_MAX = "Il valore massimo di polveri sottili e' stato superato questa settimana";
	private static final String MESSAGGIO_DI_BENVENUTO = "Benvenuto in Polveri Sottili";

	public static void main(String[] args) {
		System.out.println(MESSAGGIO_DI_BENVENUTO);
		boolean continua = false;
		do {
			SettimanaPolveri settimana = inserisciSettimana();
			System.out.println(settimana.toString());
			if(settimana.allarmeMassimo()) {
				System.out.println(ATTENZIONE_SUPERAMENTO_LIVELLO_MAX);
			}
			if(settimana.allarmeMedio()) {
				System.out.println(ATTENZIONE_SUPERAMENTO_LIVELLO_MEDIO);
			}
			continua = InputDati.yesOrNo(INSERIMENTO_NUOVA_SETTIMANA);
			
		} while(continua);

	}
	
	public static SettimanaPolveri inserisciSettimana() {
		int anno = InputDati.leggiIntero(INSERIMENTO_ANNO);
		int numeroSettimana = InputDati.leggiIntero(INSERIMENTO_NUM_SETTIMANA, MIN_NUM_SETTIMANA , MAX_NUM_SETTIMANA);
		int valori[] = new int[7];
		for(int i = 0; i < 7; i++) {
			valori[i] = InputDati.leggiIntero(String.format(INSERIMENTO_LIVELLO_POLVERI, i + 1));   //riga da completare dato che non si vede in teams
		}
		return new SettimanaPolveri(anno, numeroSettimana, valori);
	}
}