package simuladormodeloestocastico;

import org.apache.commons.math3.distribution.AbstractRealDistribution;
import org.apache.commons.math3.distribution.EnumeratedIntegerDistribution;
import org.apache.commons.math3.distribution.ExponentialDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;

/**
 *
 */
public class SimuladorModeloEstocastico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // O tempo de produção será gerado com base na distribuição de frequências (comportamento) identificado
        
        // A pontuação da tarefa será gerada de forma aleatória, conforme uma probabilidade
        
        // 
        int[] numsToGenerate = new int[]{1, 2, 3, 5, 8};
        double[] discreteProbabilities = new double[]{0.35, 0.35, 0.25, 0.01, 0.04};

        EnumeratedIntegerDistribution distribution = new EnumeratedIntegerDistribution(numsToGenerate, discreteProbabilities);
        
        for (int i = 0; i < 50; i++) {

            int sample = distribution.sample();

            System.out.println(sample);            
        }
        

        
        /*
            Dev 177:
                Pontos: Média(2.25)
                Tempos: Média(207.41)
            Dev 187:
                Pontos: Média(2.90); DP(1.40)
                Tempos: Média(295.57)
            Dev 231:
                Pontos: Média(2.60)
                Tempos: Média(202.28) */     
        
//        RandomGenerator rand = new JDKRandomGenerator(10);//rand será utilizado para mexer com o seed
//        //Distribuições para tempos
//        ExponentialDistribution exp = new ExponentialDistribution(/*rand, */295.57); 
//        //Tentativa de distribuição para pontos do dev 187
//        NormalDistribution normal   = new NormalDistribution(/*rand */ 2.90, 1.40);
//        
//        printSamples(normal);
    }
    
    public static void printSamples(AbstractRealDistribution dist){
        for (int i = 0; i < 50; i++) {
            System.out.println(Math.round(dist.sample()));
        }
    }
    
}
