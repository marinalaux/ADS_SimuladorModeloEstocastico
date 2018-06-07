package simuladormodeloestocastico;

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
     */
    public ParametersPanel() {
        
        super(new GridLayout(8, 1));
        setBorder(BorderFactory.createTitledBorder("Parâmetros para simulação"));
        
        ProbsTextField umPonto = new ProbsTextField("Probabilidade 1 ponto");
        ProbsTextField doisPontos = new ProbsTextField("Probabilidade 2 pontos");
        ProbsTextField tresPontos = new ProbsTextField("Probabilidade 3 pontos");
        ProbsTextField cincoPontos = new ProbsTextField("Probabilidade 5 pontos");
        ProbsTextField oitoPontos = new ProbsTextField("Probabilidade 8 pontos");
        ProbsTextField trezePontos = new ProbsTextField("Probabilidade 13 pontos");
        ProbsTextField vinteUmPontos = new ProbsTextField("Probabilidade 21 pontos");
        
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
