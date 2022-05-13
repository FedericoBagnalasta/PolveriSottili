package it.unibs.fp.polverisottili;

import it.unibs.fp.mylib.InputDati;

public class Main {

	private static final int ANNO_MAX = 2022;
	private static final int ANNO_MIN = 0;
	private static final int NUM_GIORNI_SETTIMANA = 7;
	private static final int MAX_NUM_SETTIMANA = 53;
	private static final int MIN_NUM_SETTIMANA = 1;
	private static final String INSERIMENTO_LIVELLO_POLVERI = "Inserisci il valore di polveri sottili del giorno %d: ";
	private static final String INSERIMENTO_NUM_SETTIMANA = "Inserisci il numero della settimana: ";
	private static final String INSERIMENTO_ANNO = "Inserisci l'anno della settimana interessata: ";
	private static final String INSERIMENTO_NUOVA_SETTIMANA = "\nVuoi inserire i dati di una nuova settimana?";
	private static final String LIVELLO_ACCETTABILE_POLVERI_SOTTILI = "In questa settimana i valori di polveri sottili sono accettabili";
	private static final String ATTENZIONE_SUPERAMENTO_LIVELLO_MEDIO_E_MAX = "Il valore medio e massimo di polveri sottili e' stato superato questa settimana";
	private static final String ATTENZIONE_SUPERAMENTO_LIVELLO_MEDIO = "Il valore medio di polveri sottili e' stato superato questa settimana";
	private static final String ATTENZIONE_SUPERAMENTO_LIVELLO_MAX = "Il valore massimo di polveri sottili e' stato superato questa settimana";
	private static final String MESSAGGIO_DI_BENVENUTO = "Benvenuto in Polveri Sottili";

	public static void main(String[] args) {
		System.out.println(MESSAGGIO_DI_BENVENUTO);
		boolean continua = false;
		do {
			SettimanaPolveri settimana = inserisciSettimana();
			System.out.println(settimana.toString());
			if(settimana.allarmeMassimo() && settimana.allarmeMedio()) {
				System.out.println(ATTENZIONE_SUPERAMENTO_LIVELLO_MEDIO_E_MAX);
			}
			else if(settimana.allarmeMassimo()) {
				System.out.println(ATTENZIONE_SUPERAMENTO_LIVELLO_MAX);
			}
			else if(settimana.allarmeMedio()) {
				System.out.println(ATTENZIONE_SUPERAMENTO_LIVELLO_MEDIO);
			}
			else {
				System.out.println(LIVELLO_ACCETTABILE_POLVERI_SOTTILI);
			}
			continua = InputDati.yesOrNo(INSERIMENTO_NUOVA_SETTIMANA);	
		} while(continua);
	}
	
	/**
	 * Metodo che istanzia un oggetto di tipo SettimanaPolveri con valori inseriti dall'utente
	 * @return
	 */
	public static SettimanaPolveri inserisciSettimana() {
		int anno = InputDati.leggiIntero(INSERIMENTO_ANNO, ANNO_MIN, ANNO_MAX);
		int numeroSettimana = InputDati.leggiIntero(INSERIMENTO_NUM_SETTIMANA, MIN_NUM_SETTIMANA , MAX_NUM_SETTIMANA);
		int valori[] = new int[NUM_GIORNI_SETTIMANA];
		for(int i = 0; i < NUM_GIORNI_SETTIMANA; i++) {
			valori[i] = InputDati.leggiIntero(String.format(INSERIMENTO_LIVELLO_POLVERI, i + 1));   
		}
		return new SettimanaPolveri(anno, numeroSettimana, valori);
	}
}