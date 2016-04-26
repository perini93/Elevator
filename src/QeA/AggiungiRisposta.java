/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QeA;

import Controller.Applicazione;
import Database.MySql.InsertQuery;
import Database.MySql.ListeQuery;
import Libri.AggiungiLibroPanel;
import Libri.ListaLibriPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;

/**
 *
 * @author adrian
 */
public class AggiungiRisposta implements ActionListener{
    
    private CardLayout card;
    private JPanel container;
    private JTextArea titolo;
    

    public AggiungiRisposta(CardLayout card, JPanel container, JTextArea titolo) {
        this.card = card;
        this.container = container;
        this.titolo = titolo;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        InsertQuery insertQuery = new InsertQuery();
        
        insertQuery.inserisciRisposta(titolo.getText());
        
        JOptionPane.showMessageDialog(null, "Risposta aggiunta correttamente.", "Aggiunta Confermata", JOptionPane.INFORMATION_MESSAGE);

        Applicazione.svuotaRisposte();
        
        ListeQuery dQuery = new ListeQuery();
        dQuery.caricaRisposteDomanda();
        
        Applicazione.back.remove(Applicazione.back.size()-1);
        ListaDomandePanel ldp = new ListaDomandePanel(card, container);
        DomandaPanel domanda = new DomandaPanel(card, container);
   
        container.add(ldp, "domande");
        card.show(container, "domande");
      
    }
}