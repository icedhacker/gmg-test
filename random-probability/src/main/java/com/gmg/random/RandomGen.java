package com.gmg.random;

import java.util.Random;

public class RandomGen {
    private int[] randomNums;
    private double[] probabilities;

    RandomGen(int[] randomNums, double[] probabilities) {
        this.randomNums = randomNums;
        this.probabilities = probabilities;
    }

    /**
     Returns one of the randomNums. When this method is called multiple times over a long period,
     it should return the numbers roughly with the initialized probabilities.
    **/
    public int nextNum() {
        int n = randomNums.length;
        if (n == 0 || probabilities.length == 0 || probabilities.length != n) {
            throw new RuntimeException("Unable to generate next number.");
        }

        double[] prefixSums = new double[n];
        prefixSums[0] = probabilities[0] * 100;
        for (int i = 1; i < n; i++) {
            prefixSums[i] = prefixSums[i-1] + (probabilities[i] * 100);
        }

        Random random = new Random();
        int randomNum = (random.nextInt(Integer.MAX_VALUE) % ((int)Math.floor(prefixSums[n - 1]))) + 1;
        int index = binaryFind(prefixSums, randomNum, 0, n);
        return randomNums[index];
    }

    private int binaryFind(double[] prefixSums, int randomNum, int left, int right) {
        int mid;
        while (left < right) {
            mid = (left + right) / 2;
            if (randomNum > prefixSums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
