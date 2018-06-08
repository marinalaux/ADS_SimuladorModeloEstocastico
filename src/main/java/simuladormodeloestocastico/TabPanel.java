package simuladormodeloestocastico;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 * Painel da aba
 */
public class TabPanel extends JPanel {
    
    /**
     * Construtor
     * 
     * @param dev
     */
    public TabPanel(Developer dev) {
        super(new BorderLayout());
        
        ParametersPanel params = new ParametersPanel(dev);
        HistogramPanel histogram = new HistogramPanel();
        
        add(histogram, BorderLayout.CENTER);
        add(params, BorderLayout.EAST);
    }
    
}
