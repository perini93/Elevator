/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appunti.Vista;

import Appunti.Ascoltatori.GoToAppunto;
import Appunti.Ascoltatori.GoToAggiungiAppunto;
import Application.Controller.Applicazione;
import Header.TopPanel;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Te4o
 */
public class ListaAppuntiPanel extends JPanel{
    
    private JButton[] appunti = new JButton[Applicazione.listaAppuntiAttuali.size()];

    public ListaAppuntiPanel() {
    
        TopPanel top = new TopPanel("Appunti "+Applicazione.corsoPremuto);
        
        JPanel panel = new JPanel(new GridLayout(Applicazione.listaAppuntiAttuali.size()+2, 1));
        
        JPanel searchPanel = new JPanel();
            JTextField searchField = new JTextField(30);
            searchField.setHorizontalAlignment(SwingConstants.CENTER);
            searchField.setFont(new Font("Arial", Font.PLAIN, 20));
            JButton searchButton = new JButton("Search");
            searchPanel.add(searchField);
            searchPanel.add(searchButton);

        panel.add(searchPanel);
        
        JButton addAppunto = new JButton("Aggiungi Appunto");
        GoToAggiungiAppunto aggiungiAppunto = new GoToAggiungiAppunto();
        addAppunto.addActionListener(aggiungiAppunto);
        
        panel.add(addAppunto);

        GoToAppunto goToAppunto = new GoToAppunto();
        
        for (int i = 0; i < Applicazione.listaAppuntiAttuali.size(); i++) {
            appunti[i] = new JButton();
            appunti[i].setText(Applicazione.listaAppuntiAttuali.get(i).getNome());
            appunti[i].addActionListener(goToAppunto);
            panel.add(appunti[i]);
        }
        
        JScrollPane scrollPanel = new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setPreferredSize(new Dimension(650, 450));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);
        
        add(top);
        add(scrollPanel);
    }
    
}
