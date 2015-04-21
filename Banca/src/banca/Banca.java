/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package banca;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.*;
import java.io.Serializable;
/**
 *
 * @author Margherita
 * 
 */
public class Banca implements Serializable {
   ArrayList <Conto> clienti;
   /*cercare in arraylist hasnext cosi so la posizione dell'array*/
    private int tipo;
    public Banca(){
        }
    
    public void addConto(int numero_conto, String nome, String cognome, String CF){
        int i = clienti.size()+1;
        Conto bk = new Conto(i, nome,cognome, CF);
        clienti.add(bk);
      
        
    }
    //restituisce il saldo dato un numero di conto
    public String getIntestatario(int n)  {
      for(int j=0; j<clienti.size(); j++)
      {
           Conto temp = (Conto) clienti.get(j);
           if(temp.getNumero()==n){
                return "Conto codice "+temp.getNumero()+" con importo "+temp.getIntestatario();
           }
      }
      return "Conto non trovato!";
  }
    
    /*METODI DI GESTIONE DEL FILE BINARIO*/

   //Metodo che permette la memorizzazione dell'oggetto Conto e di tutti gli oggetti relativi nel file binario//
   public static boolean store(Banca g){
      try{
         FileOutputStream file = new FileOutputStream("BANANA.txt");
         ObjectOutputStream out = new ObjectOutputStream(file);
         out.writeObject(g);
         out.close();
         return true;
      }catch(Exception e){ return false;}

   }
     public static boolean sàtore(Banca g){
      try{
         FileOutputStream file = new FileOutputStream("BANANA.txt");
         ObjectOutputStream out = new ObjectOutputStream(file);
         out.writeObject(g);
         out.close();
         return true;
      }catch(Exception e){ return false;}

   }

   //Metodo che carica l'oggetto Conto dal file binario//
   public static Banca load(){
      try
      {
       FileInputStream fis = new FileInputStream("BANANA.txt");
       ObjectInputStream in = new ObjectInputStream(fis);
       Banca g= (Banca)in.readObject();
       in.close();
       return g;
     }
     catch (Exception e){return null;}
   }

    

    // Metodo che trasferisce una somma di denaro da un conto ad un altro
    /* public boolean trasferisci(Conto n1, Conto n2, double importo, Date data){
        Conto uscita = null;
        Conto entrata = null; 

        for(int j=0; j<clienti.size(); j++){
            Conto temp = (Conto) clienti.get(j);
            if(numero_conto==n1){
                uscita = temp;
            }
            if(numero_conto==n2){
                entrata = temp;
            }
        }
        if(uscita!=null && entrata!=null){
            uscita.prelievo(importo,data);
            entrata.versamento(importo,data);
            return true;
        }
        return false;
    }*/
    
     
}