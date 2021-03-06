/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application.Controller;

import Appunti.Appunto;
import Database.Connection.ConnessioneDB;
import Libri.Libro;
import QeA.Domanda;
import Studente.Studente;
import Università.Corsi.Corso;
import Università.Facolta.Facoltà;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author te4o
 */
public class Applicazione {

    public static Connection DBconnection = new ConnessioneDB().connect();
        
    public static Studente guest;
    public static boolean utenteLoggato = false;
    
    public static ArrayList<String> back = new ArrayList<>();

    public static String facoltàPremuta;
    public static String corsoPremuto;
    
    //per ogni nuova ArrayList, aggiungere il suo metodo svuota e inserirlo nel logout()
    
    public static ArrayList<String> listaFacoltàXRamo = new ArrayList<>();
    public static ArrayList<String> ramiFacoltà = new ArrayList<>();
    public static ArrayList<Corso> listaCorsiAttuali = new ArrayList<>();
    public static ArrayList<Facoltà> listaFacoltàAttuali = new ArrayList<>();
    public static ArrayList<Libro> listaLibriAttuali = new ArrayList<>();
    public static ArrayList<Domanda> listaDomandeAttuali = new ArrayList<>();
    public static ArrayList<Appunto> listaAppuntiAttuali = new ArrayList<>();
    public static ArrayList<String> risposteAttuali = new ArrayList<>();  
    
    public static Libro libroAttuale = new Libro("", "", "", "", "", 0);
    public static Domanda domandaAttuale = new  Domanda("", 0, "", "");
    public static Appunto appuntoAttuale = new Appunto("", "", 0, "");
    
    public static ArrayList<Appunto> appuntiGuest = new ArrayList<>();
    public static ArrayList<Libro> libriGuest = new ArrayList<>();
    public static ArrayList<Domanda> domandeGuest = new ArrayList<>();

    public static void inizializzaUtente(String email, String password, String telefono){
    
        guest = new Studente(email, password, telefono);
        guest.setNickname();
        guest.setNome();
        guest.setCognome();
        
        utenteLoggato = true;
    }
    
    public static void eliminaUtente(){
        guest = new Studente("", "","");
        utenteLoggato = false;
    }
    
    public static void svuotaCorsi() {
        listaCorsiAttuali.clear();
    }
    
    public static void svuotaFacoltà() {
        listaFacoltàAttuali.clear();
    }
    
    public static void svuotaLibri() {
        listaLibriAttuali.clear();
    }
    
    public static void svuotaDomande() {
        listaDomandeAttuali.clear();
    }
    
    public static void svuotaAppunti() {
        listaAppuntiAttuali.clear();
    }
    
    public static void svuotaRisposte() {
        risposteAttuali.clear();
    }
    
    public static void svuotaMieiDati() {
        appuntiGuest.clear();
        libriGuest.clear();
        domandeGuest.clear();
    }
    
    public static void svuotaListaFacoltàXRamo(){
        listaFacoltàXRamo.clear();
    }
    
    public static void svuotaRami(){
        ramiFacoltà.clear();
    }
    
    public static void logout(){
       
        eliminaUtente();
        
        svuotaCorsi();;
        svuotaFacoltà();
        svuotaLibri();
        svuotaDomande();
        svuotaAppunti();
        svuotaRisposte();
        svuotaMieiDati();
        svuotaListaFacoltàXRamo();
        svuotaRami();
    }

}
