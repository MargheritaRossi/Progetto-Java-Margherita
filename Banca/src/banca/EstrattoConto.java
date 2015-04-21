/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banca;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Margherita
 */

        
public class EstrattoConto implements Serializable{
        /*Una operazione è composta da importo e data*/
	private double importo;
	private Date data;
        private Conto saldo; 
        private int tipo;

	public EstrattoConto(double importo, Date data, int tipo){
            /*Controllo se l'importo è 0 e in tal caso do errore*/
		if (importo == 0)
			throw new RuntimeException("Nota. Errore, si sta cercando di fare una operazione con importo uguale a 0");
		this.importo = importo;
		this.data = data;
                this.tipo=tipo;
	}

        @Override
	public String toString() {
            /*descrizione dell'operazione svolta*/
		String descrizione = "\nOperazione effettuata: ";
		if (tipo == 1){
                    //in caso di versamento
			descrizione = descrizione + "VERSAMENTO € ";
                }
		else {
                    //in caso di prelievo
			descrizione = descrizione + "PRELIEVO € ";

                }
		descrizione = descrizione + this.importo + " - " + this.data;
		return descrizione;
	}	
}


