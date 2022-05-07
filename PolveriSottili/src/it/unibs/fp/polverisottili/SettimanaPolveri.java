package it.unibs.fp.polverisottili;

public class SettimanaPolveri {

	private static final String VISUALIZZAZIONE_GIORNO_E_VALORE_POLVERI = "Giorno:%d  Valore:%d\n";
	private static final String INTESTAZIONE_SETTIMANA = "Questa e' la settimana %d dell'anno %d\n";
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
	
	public boolean allarmeMassimo() {
		if(valoreMassimo() > LIMITE_MAX)
			return true;
		return false;
	}
	
	public boolean allarmeMedio() {
		if(valoreMedio() > LIMITE_MEDIO)
			return true;
		return false;
	}
	
	private int valoreMassimo() {
		int valoreMax = valori[0];
		for(int i = 0; i < valori.length; i++) {
			if(valori[i] > valoreMax)
				valoreMax = valori[i];
			
		}
		return valoreMax;			
	}
	
	private int valoreMedio() {
		int totale = 0;
		for(int i = 0; i < valori.length; i++) {
			totale = totale + valori[i];
		}
		return totale / valori.length;
	}
	
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