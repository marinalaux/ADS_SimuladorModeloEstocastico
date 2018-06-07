package simuladormodeloestocastico;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Painel do historama
 */
public class HistogramPanel extends JPanel {
    
    /**
     * Construtor
     */
    public HistogramPanel() {
        super();
        setBorder(BorderFactory.createTitledBorder("Histograma"));
        add(new JLabel("Histograma"));
    }
    
}
