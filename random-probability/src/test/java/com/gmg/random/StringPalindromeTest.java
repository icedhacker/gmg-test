package com.gmg.random;

import org.assertj.core.data.Percentage;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class StringPalindromeTest {
    private StringPalindrome stringPalindrome = new StringPalindrome();

    @Test
    public void shouldReturnNumberOfPalindromes() {
        String word = "sabcdcbafdxyzwzyxkxyz";
        int actual = stringPalindrome.findPalindromes(word);
        assertThat(actual).isEqualTo(3);
    }
}
