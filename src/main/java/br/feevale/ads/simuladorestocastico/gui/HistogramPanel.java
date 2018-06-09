package br.feevale.ads.simuladorestocastico.gui;

import javafx.embed.swing.JFXPanel;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * Painel do historama
 */
public class HistogramPanel extends JPanel {

    /**
     * Painel JavaFX
     */
    private JFXPanel fxPanel;
    
    /**
     * Construtor
     */
    public HistogramPanel() {
        super();
        setBorder(BorderFactory.createTitledBorder("Histograma"));
        JFXPanel fxPanel = new JFXPanel();
    }

    /**
     * Atualiza histograma
     */
    public void updateHistogram() {
        
    }
    
}
