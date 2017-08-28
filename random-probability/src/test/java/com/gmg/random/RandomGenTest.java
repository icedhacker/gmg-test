package com.gmg.random;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.data.Percentage;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RandomGenTest {
    private RandomGen randomGen;

    @Test
    public void shouldReturnRandomNumberMatchingProbability() {
        int[] randomNums = {-1, 0, 1, 2, 3};
        double[] probabilities = {0.01, 0.3, 0.58, 0.1, 0.01};
        randomGen = new RandomGen(randomNums, probabilities);
        Map<Integer, Integer> randomCount = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int num = randomGen.nextNum();
            int count = 1;
            if (randomCount.containsKey(num)) {
                count = randomCount.get(num) + 1;
            }
            randomCount.put(num, count);
        }
        System.out.println(randomCount);
        assertThat(randomCount.get(-1)).isCloseTo(100, Percentage.withPercentage(25));
        assertThat(randomCount.get(0)).isCloseTo(3000, Percentage.withPercentage(25));
        assertThat(randomCount.get(1)).isCloseTo(5800, Percentage.withPercentage(25));
        assertThat(randomCount.get(2)).isCloseTo(1000, Percentage.withPercentage(25));
        assertThat(randomCount.get(3)).isCloseTo(100, Percentage.withPercentage(25));
    }
}
