package com.gmg.random;

public class StringPalindrome {

    public int findPalindromes(String word) {
        char[] charArray = word.toCharArray();
        int count = 0;
        for (int i = 1; i < charArray.length; i++) {
            int j = -1, k = -1;
            if (charArray[i] == charArray[i-1]) {
                j = i - 1;
                k = i;
                count++;
            } else if ((i+1) < charArray.length) {
                if (charArray[i-1] == charArray[i+1]) {
                    j = i - 1;
                    k = i + 1;
                    count++;
                }
            }
        }
        return count;
    }
}
