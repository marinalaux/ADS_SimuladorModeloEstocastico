package br.feevale.ads.simuladorestocastico.gui;

import br.feevale.ads.simuladorestocastico.model.Developer;
import br.feevale.ads.simuladorestocastico.model.Estatisticas;
import br.feevale.ads.simuladorestocastico.model.Interval;
import br.feevale.ads.simuladorestocastico.model.Task;
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
import javax.swing.JTextField;
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
     * Média dos minutos por pontos
     */
    private JTextField media;
    
    /**
     * Construtor
     */
    public HistogramPanel() {
        super();
        setBorder(BorderFactory.createTitledBorder("Histograma"));
        fxPanel = new JFXPanel();
        add(fxPanel);
        media = new JTextField();
        add(media);
    }

    /**
     * Atualiza histograma
     * 
     * @param estatisticas
     */
    public void updateHistogram(Estatisticas estatisticas) {
        Platform.runLater(() -> {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 1200, 800);
            BarChart<String,Number> chart = new BarChart<>(new CategoryAxis(), new NumberAxis());
            chart.setVerticalGridLinesVisible(false);
            chart.setLegendVisible(false);
            XYChart.Series serie = new XYChart.Series();
            
            for (Interval interval : estatisticas.getIntervals()) {
                serie.getData().add(new XYChart.Data(String.valueOf(interval.getEndValue()), interval.getQuantityValues()));
            }
            
            chart.getData().add(serie);
            root.setCenter(chart);
            fxPanel.setScene(scene);
            SwingUtilities.invokeLater(() -> {
                revalidate();
                repaint();
            });
        });

    }
    
    public void updateMedia(Developer dev) {
        media.setText(String.valueOf(dev.getTimeAverage()));
    }
    
}
