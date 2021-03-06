/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.Query;

import Appunti.Appunto;
import Application.Controller.Applicazione;
import Database.Connection.ConnessioneDB;
import Libri.Libro;
import QeA.Domanda;
import Università.Corsi.Ascoltatori.CaricaCorsi;
import Università.Facolta.Facoltà;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author te4o
 */
public class InfoQuery {
    
    public static void caricaInfoLibro(){
    
        String selectInfoLibro = "select * from libri where facoltà=? and corso=? and titolo=?";
        
         try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectInfoLibro);
                ps1.setString(1, Applicazione.facoltàPremuta);
                ps1.setString(2, Applicazione.corsoPremuto);
                ps1.setString(3,Applicazione.libroAttuale.getTitolo());

                ResultSet rs = ps1.executeQuery();

                while(rs.next()){

                    String nomeLibro = rs.getString("titolo");
                    String descrizioneLibro = rs.getString("descrizione");
                    String idLibro = rs.getString("id");
                    String emailLibro = rs.getString("studente");
                    String telefonoLibro = rs.getString("telefono");
                    int prezzoLibro = rs.getInt("prezzo");
                
                    Applicazione.libroAttuale = new Libro(nomeLibro, descrizioneLibro, idLibro, telefonoLibro,emailLibro,  prezzoLibro);

                }
                }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    public static void caricaInfoDomanda(){
    
        String selectInfoDomanda = "select * from domande where facoltà=? and corso=? and titolo=?";
        
         try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectInfoDomanda);
                ps1.setString(1, Applicazione.facoltàPremuta);
                ps1.setString(2, Applicazione.corsoPremuto);
                ps1.setString(3,Applicazione.domandaAttuale.getTitolo());

                ResultSet rs = ps1.executeQuery();

                while(rs.next()){

                    String titoloDomanda = rs.getString("titolo");
                    String testoDomanda = rs.getString("domanda");
                    String studenteDomanda = rs.getString("studente");
                    int likeDomanda = rs.getInt("like");

                    Applicazione.domandaAttuale = new Domanda(titoloDomanda, likeDomanda, testoDomanda, studenteDomanda);

                }
                }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    public static void caricaInfoAppunto(){
    
        String selectInfoDomanda = "select * from appunti where facoltà=? and corso=? and nome=?";
        
         try{
                PreparedStatement ps1 = Applicazione.DBconnection.prepareStatement(selectInfoDomanda);
                ps1.setString(1, Applicazione.facoltàPremuta);
                ps1.setString(2, Applicazione.corsoPremuto);
                ps1.setString(3,Applicazione.appuntoAttuale.getNome());

                ResultSet rs = ps1.executeQuery();

                while(rs.next()){

                    String nomeAppunto = rs.getString("nome");
                    String descrizioneAppunto = rs.getString("descrizione");
                    int mediaAppunto = rs.getInt("media");
                    String emailAppunto = rs.getString("studente");

                    Applicazione.appuntoAttuale = new Appunto(nomeAppunto, descrizioneAppunto, mediaAppunto, emailAppunto);

                }
                }   catch (SQLException ex) {   
                Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

}