/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banca;


import java.util.Date;
import java.io.Serializable;
/**
 *
 * @author Margherita
 */

public class Conto implements Serializable{
    /*creo una variabile privata (affinchè la possa modificare solo questa 
     * classe e per esser sicura le assegno il tipo double*/
    private Persona intestatario;
    private double saldo;
    //private int numero;
    private int tipo;
    private int interesse;
    private int numero_di_conto=0;
    private EstrattoConto[] movimenti;
   // private static long prossimoNumeroConto = 999;
    // Attributo per consentire la numerazione progressiva dei conti
    //private static int progressivoConti = 0;
    /*Setto a 0,0 la variabile saldo*/
    public Conto(int numero_conto, String n, String c, String s){
         // Attribuisco un numero al conto e incremento il progressivo
       // numero = progressivoConti++;
        saldo = 0.0;
       this.movimenti = new EstrattoConto[0];
       this.intestatario=new Persona(n,c,s);
       System.out.println("ti inculo a fuoco"+this.numero_di_conto);
       this.numero_di_conto=numero_conto;
        
    }

    /*Versamento che riceverà una variabile double "importo" in pratica al 
     *saldo presente in conto va aggiunta la quantità da depositare. 
     *Inoltre il metodo è void (non ritorna nulla)*/
    public void versamento(double importo, Date data){
        tipo=1;
         /*ogni nuovo versamento deve comparire nell'estratto conto*/
        EstrattoConto e = new EstrattoConto(importo, data, tipo);
     
        /*creo una lista dei movimenti*/
	EstrattoConto[] nuovaListaMovimenti = new EstrattoConto[this.movimenti.length + 1];
        
        for (int i=0; i < this.movimenti.length; i++)
            nuovaListaMovimenti[i] = this.movimenti[i];
        nuovaListaMovimenti[nuovaListaMovimenti.length - 1] = e;
        this.movimenti = nuovaListaMovimenti;

        /*calcolo effettivo del saldo dopo il versamento*/
        saldo+= importo;
    }
    
    /*Prelievo*/
    public void prelievo(double importo, Date data){
        tipo=2;
        /*Inserisco un controllo. Se l'importo è <= Saldo è possibile prelevare*/
        if(importo<=saldo){
            /*ogni nuovo prelievo deve comparire nell'estratto conto*/
            EstrattoConto e = new EstrattoConto(importo, data,tipo);
        /*creo una lista dei movimenti*/
	EstrattoConto[] nuovaListaMovimenti = new EstrattoConto[this.movimenti.length + 1];
        for (int i=0; i < this.movimenti.length; i++)
			nuovaListaMovimenti[i] = this.movimenti[i];
        nuovaListaMovimenti[nuovaListaMovimenti.length - 1] = e;
        this.movimenti = nuovaListaMovimenti;
        /*calcolo effettivo del saldo dopo il prelievo*/
        saldo -= importo; 
        }
        else{
            System.err.println("Saldo insufficiente. La somma da prelevare è maggiore del saldo presente");
        }
    }
    
    
    public int aggiungiInteressi() {
		if (this.saldo < 100)
			return 0;
		if ((this.saldo >= 1000) && (this.saldo < 10000)){
			this.saldo = this.saldo*102/100;
                        interesse=2;
                }
		if (this.saldo >= 10000){
			this.saldo = this.saldo*103/100;
                        interesse =3;
                }
                return interesse;
	}
    
    
    /*metodo per stampare la lista dei movimenti*/
    public String stampaListaMovimenti() {
        String str=new String();
		for (int i=0; i < this.movimenti.length; i++)
			str=str+" "+(this.movimenti[i]);
                return str;
	}
	
    @Override
	public String toString() {
		String descrizione = intestatario.getNome()+" - "+intestatario.getCognome()+" - "+ "CONTO CORRENTE"  + " - SALDO: " + getSaldo() + " - INTERESSE: " +aggiungiInteressi()+ " % ";
		return descrizione;
	}
    
    /*Saldo. Il metodo è double visto che 
     *restituisce il saldo (che è double)*/
    public double getSaldo(){
        return saldo;
    }
    
    //metodo che restituisce il numero di conto
    public int getNumero(){
         return numero_di_conto;
     }
    
    // Metodo che restituisce l'intestatario

    public Persona getIntestatario(){
      return intestatario;
    }
}