package simuladormodeloestocastico;

import org.apache.commons.math3.distribution.ExponentialDistribution;

/**
 *
 */
public class SimuladorModeloEstocastico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ExponentialDistribution exp = new ExponentialDistribution(295.57);
        for (int i = 0; i < 50; i++) {
            System.out.println(exp.sample());
        }
        
    }
    
}
