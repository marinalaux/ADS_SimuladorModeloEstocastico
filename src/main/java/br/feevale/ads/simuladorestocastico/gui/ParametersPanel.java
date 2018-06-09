package br.feevale.ads.simuladorestocastico.gui;

import br.feevale.ads.simuladorestocastico.model.Developer;
import java.awt.GridLayout;
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
     */
    public ParametersPanel(Developer dev) {
        
        super(new GridLayout(8, 1));
        setBorder(BorderFactory.createTitledBorder("Parâmetros para simulação"));
        
        ProbsTextField umPonto = new ProbsTextField(dev.getProbabilidadePontos().get("1"), "Probabilidade 1 ponto", (probs) -> {
            System.out.println("probs 1 ponto: " + probs);
        });
        ProbsTextField doisPontos = new ProbsTextField(dev.getProbabilidadePontos().get("2"), "Probabilidade 2 pontos", (probs) -> {
            
        });
        ProbsTextField tresPontos = new ProbsTextField(dev.getProbabilidadePontos().get("3"), "Probabilidade 3 pontos", (probs) -> {
            
        });
        ProbsTextField cincoPontos = new ProbsTextField(dev.getProbabilidadePontos().get("5"), "Probabilidade 5 pontos", (probs) -> {
            
        });
        ProbsTextField oitoPontos = new ProbsTextField(dev.getProbabilidadePontos().get("8"), "Probabilidade 8 pontos", (probs) -> {
            
        });
        ProbsTextField trezePontos = new ProbsTextField(dev.getProbabilidadePontos().get("13"), "Probabilidade 13 pontos", (probs) -> {
            
        });
        ProbsTextField vinteUmPontos = new ProbsTextField(dev.getProbabilidadePontos().get("21"), "Probabilidade 21 pontos", (probs) -> {
            
        });
        
        JButton simular = new JButton("Simular!");
        
        add(umPonto);
        add(doisPontos);
        add(tresPontos);
        add(cincoPontos);
        add(oitoPontos);
        add(trezePontos);
        add(vinteUmPontos);
        add(simular);
        
    }
    
}
