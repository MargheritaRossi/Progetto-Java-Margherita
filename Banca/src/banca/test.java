/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banca;

import static banca.Banca.load;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
/**
 *
 * @author Margherita
 */
public class test {

    
    public static void main(String[] args){
        
        int  t,s,p;
        Banca clienti=new Banca();
        String nome,cognome,CF;
        boolean b=false;
        double importo;
        Scanner sc = new Scanner(System.in);
        Persona intestatario;
        Conto conto_corrente;
        int numero_conto=0;
               
        Banca file = new Banca();
        //per recuperarmi data e ora 
        Calendar calendario = Calendar.getInstance();
        Date data =  calendario.getTime();
        calendario.set(Calendar.DAY_OF_MONTH, 1); // Primo giorno del mese
        calendario.add(Calendar.MONTH, 1); // Data con un mese in più
          Banca g= Banca.load();
               if (g!=null)
               { System.out.println("caricato db");clienti =g;}
                 //g = Banca.getSingleton()
                  
                
        System.out.println("Premi 1 per aprire un nuovo conto, 2 se vuoi accedere al tuo conto, 0 per uscire");
        p=sc.nextInt();
        if(p==1){
            
            
            System.out.println("inserisci il tuo nome");
            nome=sc.next();

            System.out.println("inserisci il tuo cognome");
            cognome=sc.next();
            System.out.println("inserisci il tuo cf");
            CF=sc.next();
            
            intestatario=new Persona(nome, cognome, CF);
            conto_corrente= new Conto(numero_conto,intestatario.getNome() , intestatario.getCognome(), intestatario.getCF());
            System.out.println(intestatario.getCF());
             System.out.println("FANCULO CITY");
            clienti.addConto(conto_corrente.getNumero(), intestatario.getNome() , intestatario.getCognome(), intestatario.getCF());
           System.out.println("numero conto  "+numero_conto);
           numero_conto++;
            b=true;
            
            do
            {
                System.out.println("che operazione vuoi fare?Premi 1 per versamento, per prelievo premi 2, per bonifico a terzi premi 3, per uscire premi 0");
                t = sc.nextInt();

                if (t==1)
                {
                    System.out.println("Inserisci importo");
                    importo=sc.nextDouble();
                    //clienti.clienti.get(clienti.numero_di_conto).versamento(importo, data);
                }
                if(t==2)
                {
                    System.out.println("Inserisci importo");
                    importo=sc.nextDouble();
                    clienti.clienti.get(0).prelievo(importo, data);
                    
                }
                if(t==3){
                    System.out.println("Inserisci importo");
                    importo=sc.nextDouble(); 
//                    clienti.trasferisci(clienti.numero_conto, clienti.numero_conto, 1, data);
                    System.out.println("Operazione andata a buon fine");
                }
                System.out.println("Vuoi effettuare altre operazioni? 1 e 2");
                s=sc.nextInt();
                if (s==2)
                {
                    
                  b=false;
                }
            }
            while(b);
                        
            String str=  clienti.clienti.get(0).stampaListaMovimenti();
            System.out.println(str);
            System.out.println(clienti.clienti.get(0));
            
        }
         
        else{
            if(p==2){
                System.out.println("Vuoi accedere al tuo conto? riempi i campi richiesti");
                System.out.println("inserisci il tuo numero di conto");
                numero_conto=sc.nextInt();
                
                            
               
                
                //intestatario=new Persona(nome, cognome, CF);
                System.out.println("\n\n   ****************************************");
                System.out.println("\nBenvenuto nella tua bancaonline");
                Persona pers;
                
                pers=clienti.clienti.get(numero_conto-1).getIntestatario();
                //System.out.println("Caro/a s" +intestatario.getNome() + ", benvenuto/a nella tua bancaonline!");
                System.out.println(" BU BU BUintestatario "+pers.getNome());
                System.out.println("Saldo"+clienti.clienti.get(numero_conto-1).stampaListaMovimenti());
                
                
            }
            
                else{
                    System.out.println("Peccato, torna a trovarci!");
                    return ;
                }
	
        }
        

        //crea l'eccezione
        try {
			//conto1.prelievo(3000, "02/02/02");
		}
		catch(RuntimeException e) {
			//System.out.println("Prelievo su c1 non riuscito: " + e.getMessage());
		}
        //Banca file = new Banca();
        //file.newFile();
        file.sàtore(clienti);
          
    }

}
