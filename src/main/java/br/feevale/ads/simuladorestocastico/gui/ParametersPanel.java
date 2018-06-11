package br.feevale.ads.simuladorestocastico.gui;

import br.feevale.ads.simuladorestocastico.model.Developer;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Painel de parâmetros do simulador
 */
public class ParametersPanel extends JPanel {
    
    /**
     * Construtor
     * 
     * @param dev
     * @param callbackSimular
     */
    public ParametersPanel(Developer dev, Runnable callbackSimular) {
        
        super(new GridLayout(10, 1));
        setBorder(BorderFactory.createTitledBorder("Parâmetros para simulação"));
        
        // Cria cópia dos dados de probabilidades de pontos do desenvolvedor
        Developer originalDev = new Developer();
        originalDev.setProbabilidadePontos(dev.getProbabilidadePontos());
        
        ProbsTextField umPonto = new ProbsTextField(dev.getProbabilidadePontos().get("1"), "Probabilidade 1 ponto", (probs) -> {
            dev.changeProbabilidade("1", probs);
        });
        ProbsTextField doisPontos = new ProbsTextField(dev.getProbabilidadePontos().get("2"), "Probabilidade 2 pontos", (probs) -> {
            dev.changeProbabilidade("2", probs);
        });
        ProbsTextField tresPontos = new ProbsTextField(dev.getProbabilidadePontos().get("3"), "Probabilidade 3 pontos", (probs) -> {
            dev.changeProbabilidade("3", probs);
        });
        ProbsTextField cincoPontos = new ProbsTextField(dev.getProbabilidadePontos().get("5"), "Probabilidade 5 pontos", (probs) -> {
            dev.changeProbabilidade("5", probs);
        });
        ProbsTextField oitoPontos = new ProbsTextField(dev.getProbabilidadePontos().get("8"), "Probabilidade 8 pontos", (probs) -> {
            dev.changeProbabilidade("8", probs);
        });
        ProbsTextField trezePontos = new ProbsTextField(dev.getProbabilidadePontos().get("13"), "Probabilidade 13 pontos", (probs) -> {
            dev.changeProbabilidade("13", probs);
        });
        ProbsTextField vinteUmPontos = new ProbsTextField(dev.getProbabilidadePontos().get("21"), "Probabilidade 21 pontos", (probs) -> {
            dev.changeProbabilidade("21", probs);
        });
        QuantityTextField quantityTextField = new QuantityTextField(10, "Quantidade de tarefas a simular", (quantity) -> {
            dev.changeQuantityTasks(quantity);
        });
        dev.setQuantityTaks(10);
        
        JButton recarregar = new JButton("Recarregar parâmetros");
        recarregar.addActionListener((ActionEvent e) -> {
            dev.setProbabilidadePontos(originalDev.getProbabilidadePontos());
            for (Component component : getComponents()) {
                if (component instanceof ProbsTextField) {
                    ((ProbsTextField)component).resetValue();
                }
            }
        });
        
        JButton simular = new JButton("Simular!");
        simular.addActionListener((ActionEvent e) -> {
            callbackSimular.run();
        });
        
        add(recarregar);
        add(umPonto);
        add(doisPontos);
        add(tresPontos);
        add(cincoPontos);
        add(oitoPontos);
        add(trezePontos);
        add(vinteUmPontos);
        add(quantityTextField);
        add(simular);
    }
}
