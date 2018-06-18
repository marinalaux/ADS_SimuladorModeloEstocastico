package br.feevale.ads.simuladorestocastico.gui;

import br.feevale.ads.simuladorestocastico.model.Developer;
import br.feevale.ads.simuladorestocastico.util.SimulatorUtil;
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
        
        HistogramPanel histogram = new HistogramPanel();
        ParametersPanel params = new ParametersPanel(dev, () -> {
            float media = 0;
            for (int i = 0; i < 10; i++) {
                dev.simulate();
                media += dev.getTimeAverage();
                histogram.updateHistogram(dev.getEstatisticas());
                histogram.updateMedia(dev);
            }
            media = media / 10;
            SimulatorUtil.copyToClipboard(dev.toString() + "\n" + "Media da media: " + media);
            System.out.println(dev.toString());
            System.out.println("Media da media: " + media);
        });
        
        add(histogram, BorderLayout.CENTER);
        add(params, BorderLayout.EAST);
    }
    
    
}
