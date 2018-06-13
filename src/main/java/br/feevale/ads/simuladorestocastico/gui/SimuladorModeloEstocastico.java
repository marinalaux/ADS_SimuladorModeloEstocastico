package br.feevale.ads.simuladorestocastico.gui;

import br.feevale.ads.simuladorestocastico.gui.TabPanel;
import br.feevale.ads.simuladorestocastico.model.Developer;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

/**
 * Simulador de modelo estocástico - Teoria de filas
 */
public class SimuladorModeloEstocastico extends JFrame {

    private List<Developer> developers;

    public SimuladorModeloEstocastico() {
        Platform.setImplicitExit(false);
        InitializeGUI();
        loadDevsFromJson();
        addDevelopersIntoScreen();
        setVisible(Boolean.TRUE);
    }

    private void InitializeGUI() {
        try {
            setTitle("Simulador de Modelo Estocástico - Teoria de filas");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            setSize(1024, 768);
            setLocationRelativeTo(null);
            setExtendedState(JFrame.MAXIMIZED_BOTH);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadDevsFromJson() {
        java.lang.reflect.Type listType = new TypeToken<ArrayList<Developer>>() {
        }.getType();
        this.developers = new GsonBuilder().create().fromJson(new InputStreamReader(SimuladorModeloEstocastico.class.getResourceAsStream("/dados.json")), listType);
    }

    private void addDevelopersIntoScreen() {
        JTabbedPane tabbedPane = new JTabbedPane();
        for (Developer developer : developers) {
            tabbedPane.add("Desenvolvedor #" + developer.getNome(), new TabPanel(developer));
        }
        getContentPane().add(tabbedPane);
    }
}
