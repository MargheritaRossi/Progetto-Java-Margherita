/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banca;
import java.io.Serializable;
/**
 *
 * @author Margherita
 */
public class Persona implements Serializable{
    String nome;
    String cognome;
    String CF;
    int numero_c;

//    String intestatario;
    public Persona (String nome, String cognome,String CF)
    {
       this.nome=nome;
       this.cognome=cognome;
       this.CF=CF;
    }
     
    public String getNome(){
        return nome;
    }
    
    public void setNome(String n){
        nome=n;
    }
    
    public String getCognome(){
        return cognome;
    }
    
    public void setCognome(String c){
        cognome=c;
    }
    
    public String getCF(){
       return CF;
    }
    
    public void setCF(String cf){
        CF=cf;
    }
    
    /*public String getIntestatario(){
        return intestatario;
    }
    public void setIntestatario(String nome, String cognome){
        intestatario=nome+cognome;
    }*/
  

  
}
