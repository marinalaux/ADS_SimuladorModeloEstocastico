package br.feevale.ads.simuladorestocastico.gui;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

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
        fxPanel = new JFXPanel();
        add(fxPanel);
    }

    /**
     * Atualiza histograma
     */
    public void updateHistogram() {
        Platform.runLater(() -> {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root);
            BarChart<String,Number> chart = new BarChart<>(new CategoryAxis(), new NumberAxis());
            chart.setVerticalGridLinesVisible(false);
            chart.setLegendVisible(false);
            XYChart.Series serie = new XYChart.Series();
            serie.getData().add(new XYChart.Data("1", 1));
            serie.getData().add(new XYChart.Data("2", 1));
            serie.getData().add(new XYChart.Data("3", 10));
            chart.getData().add(serie);
            root.setCenter(chart);
            fxPanel.setScene(scene);
            SwingUtilities.invokeLater(() -> {
                revalidate();
                repaint();
            });
        });

    }
    
}
