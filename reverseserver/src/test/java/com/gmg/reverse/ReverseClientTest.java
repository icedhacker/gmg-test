package com.gmg.reverse;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

import java.io.IOException;

public class ReverseClientTest {

    @Test
    public void reverseTextWithOneMessage() throws IOException {
        ReverseClient reverseClient = new ReverseClient();
        reverseClient.startConnection("127.0.0.1", 9999);
        String message = "this is a sample sentence";
        String response = reverseClient.sendMessage(message);
        assertThat(response).isEqualTo("siht si a elpmas ecnetnes");
    }

    @Test
    public void reverseTextWithMultipleMessages() throws IOException {
        ReverseClient reverseClient1 = new ReverseClient();
        reverseClient1.startConnection("127.0.0.1", 9999);
        String message1 = "this is the first sentence";
        String response1 = reverseClient1.sendMessage(message1);
        assertThat(response1).isEqualTo("siht si eht tsrif ecnetnes");
        String message2 = "this is the second sentence";
        String response2 = reverseClient1.sendMessage(message2);
        assertThat(response2).isEqualTo("siht si eht dnoces ecnetnes");
        String terminate = reverseClient1.sendMessage(".");
        assertThat(terminate).isEqualTo("good bye");
    }
}
