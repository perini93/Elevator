/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database.MySql;

import Controller.Applicazione;
import Università.Corsi.CaricaCorsi;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author te4o
 */
public class DeleteQuery {
    
    public void eliminaLibro(){
        
        if (Applicazione.libroAttuale.getStudente().equals(Applicazione.guest.getEmail())) {
            
            String eliminaLibro = "delete from libri where titolo='"+Applicazione.libroAttuale.getTitolo()+"'";

            try{
                    PreparedStatement ps1 = Applicazione.connection.prepareStatement(eliminaLibro);
                    ps1.execute();

                    }   catch (SQLException ex) {   
                    Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
    }
    
    public void eliminaAppunto(){
        
        if (Applicazione.appuntoAttuale.getStudente().equals(Applicazione.guest.getEmail()))  {
            
            String eliminaAppunto = "delete from appunti where nome='"+Applicazione.appuntoAttuale.getNome()+"'";

            try{
                    PreparedStatement ps1 = Applicazione.connection.prepareStatement(eliminaAppunto);
                    ps1.execute();

                    }   catch (SQLException ex) {   
                    Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
    }
    
    public void eliminaDomanda(){
        
        if (Applicazione.domandaAttuale.getStudente().equals(Applicazione.guest.getEmail())) {
            
            String eliminaDomanda = "delete from domande where titolo='"+Applicazione.domandaAttuale.getTitolo()+"'";

            try{
                    PreparedStatement ps1 = Applicazione.connection.prepareStatement(eliminaDomanda);
                    ps1.execute();

                    }   catch (SQLException ex) {   
                    Logger.getLogger(CaricaCorsi.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
    }
}
