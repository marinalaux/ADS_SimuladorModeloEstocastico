package br.feevale.ads.simuladorestocastico.gui;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

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
