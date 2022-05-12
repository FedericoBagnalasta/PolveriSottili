package it.unibs.fp.polverisottili;

public class SettimanaPolveri {

	private static final String VISUALIZZAZIONE_GIORNO_E_VALORE_POLVERI = "Giorno:%d  Valore:%d\n";
	private static final String INTESTAZIONE_SETTIMANA = "\nQuesta e' la settimana %d dell'anno %d\n";
	private static final int LIMITE_MEDIO = 50;
	private static final int LIMITE_MAX = 80;
	private int anno;
	private int numeroSettimana;
	private int valori[];
	
	
	public SettimanaPolveri(int anno, int numeroSettimana, int valori[]) {
		this.anno = anno;
		this.numeroSettimana = numeroSettimana;
		this.valori = valori;	
	}
	
	/**
	 * Metodo che verifica il superamento del valore di polveri sottili massimo per un giorno
	 * @return
	 */
	public boolean allarmeMassimo() {
		if(valoreMassimo() > LIMITE_MAX)
			return true;
		return false;
	}
	
	/**
	 * Metodo che verifica il superamento del valore medio di polveri sottili nel corso di una settimana
	 * @return
	 */
	public boolean allarmeMedio() {
		if(valoreMedio() > LIMITE_MEDIO)
			return true;
		return false;
	}
	
	/**
	 * Metodo per il calcolo del valore massimo di polveri sottili raggiunto in una settimana 
	 * @return
	 */
	private int valoreMassimo() {
		int valoreMax = valori[0];
		for(int i = 0; i < valori.length; i++) {
			if(valori[i] > valoreMax)
				valoreMax = valori[i];			
		}
		return valoreMax;			
	}
	
	/**
	 * Metodo per calcolare il valore medio di polvere sottili di una settimana
	 * @return
	 */
	private int valoreMedio() {
		int totale = 0;
		for(int i = 0; i < valori.length; i++) {
			totale = totale + valori[i];
		}
		return totale / valori.length;
	}
	
	/**
	 * Metodo che permette di visualizzare i dati relativi all'inquinamento da polveri sottili di una settimana
	 */
	public String toString() {
		StringBuffer sf = new StringBuffer();
		String intestazione = String.format(INTESTAZIONE_SETTIMANA, numeroSettimana, anno);
		sf.append(intestazione);
		for(int i = 0; i < valori.length; i++) {
			sf.append(String.format(VISUALIZZAZIONE_GIORNO_E_VALORE_POLVERI, i + 1, valori[i]));
		}
		return sf.toString();
	}
}