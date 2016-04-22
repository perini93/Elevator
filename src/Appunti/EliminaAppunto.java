/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appunti;

import Controller.Applicazione;
import Database.MySql.DeleteQuery;
import Database.MySql.ListeQuery;
import Libri.ListaLibriPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author te4o
 */
public class EliminaAppunto implements ActionListener{
    
    private CardLayout card;
    private JPanel container;

    public EliminaAppunto(CardLayout card, JPanel container) {
        this.card = card;
        this.container = container;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        DeleteQuery deleteQuery = new DeleteQuery();
        deleteQuery.eliminaAppunto();
        
        JOptionPane.showMessageDialog(null, "Appunto eliminato correttamente.", "Eliminazione Confermata", JOptionPane.INFORMATION_MESSAGE);
        
        Applicazione.svuotaAppunti();
        
        ListeQuery dQuery = new ListeQuery();
        dQuery.caricaAppunti();
        
        Applicazione.back.remove(Applicazione.back.size()-1);

        ListaAppuntiPanel appunti = new ListaAppuntiPanel(card, container);
        container.add(appunti, "appunti");
        card.show(container, "appunti");
        
    }
    
}
