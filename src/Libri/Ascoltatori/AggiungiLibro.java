/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libri.Ascoltatori;

import Database.Query.InsertQuery;
import Application.Controller.Applicazione;
import Application.Vista.Grafica;
import Database.Query.ListeQuery;
import Libri.Vista.AggiungiLibroPanel;
import Libri.Vista.ListaLibriPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

/**
 *
 * @author te4o
 */
public class AggiungiLibro implements ActionListener{

    private JTextArea titolo;
    private JTextArea descrizione;
    private JSpinner prezzo;

    public AggiungiLibro(JTextArea titolo, JTextArea descrizione, JSpinner prezzo) {
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        InsertQuery.inserisciLibro(titolo.getText(), descrizione.getText(), (Integer)prezzo.getValue());
        
        JOptionPane.showMessageDialog(null, "Libro aggiunto correttamente.", "Aggiunta Confermata", JOptionPane.INFORMATION_MESSAGE);

        Applicazione.svuotaLibri();
        
        ListeQuery.caricaLibri();
        
        Applicazione.back.remove(Applicazione.back.size()-1);

        ListaLibriPanel libri = new ListaLibriPanel();
        Grafica.container.add(libri, "libri");
        Grafica.card.show(Grafica.container, "libri");
        
        AggiungiLibroPanel.clearForm();
    }
}
