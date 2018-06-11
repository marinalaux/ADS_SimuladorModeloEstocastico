package br.feevale.ads.simuladorestocastico.util;

import br.feevale.ads.simuladorestocastico.model.Task;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.distribution.AbstractRealDistribution;
import org.apache.commons.math3.distribution.EnumeratedIntegerDistribution;
import org.apache.commons.math3.distribution.ExponentialDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;

/**
 * Projeto....: SimuladorModeloEstocastico Criado em..: 11/06/2018, 00:39:56
 * Arquivo....: SimulatorUtil.java
 *
 * @author Pablo Oliveira (jntpablo)
 */
public class SimulatorUtil {

    public static int getDistribuitionPointsByPorcentage(int[] numsToGenerate, double[] discreteProbabilities) {
        EnumeratedIntegerDistribution distribution = new EnumeratedIntegerDistribution(numsToGenerate, discreteProbabilities);
        return distribution.sample();
    }

    public static long getValueToExponentialDistribution(double mean) {
        ExponentialDistribution exp = new ExponentialDistribution(mean);
        return getSampleValue(exp);
    }

    public static long getValueToNormalDistribution(double mean, double dp) {
        NormalDistribution normal = new NormalDistribution(/*rand */2.90, 1.40);
        return getSampleValue(normal);
    }

    private static long getSampleValue(AbstractRealDistribution dist) {
        return Math.round(dist.sample());
    }

    public static List<Task> generateRandomTasks(int[] numsToGenerate, double[] discreteProbabilities, int quantityTaks) {
        List<Task> tasks = new ArrayList<Task>();
        for (int i = 0; i < quantityTaks; i++) {
            int points = getDistribuitionPointsByPorcentage(numsToGenerate, discreteProbabilities);
            Task task = new Task();
            task.setPoints(points);
            //TODO: GERAR TEMPO;
            tasks.add(task);
        }
        return tasks;
    }

}
