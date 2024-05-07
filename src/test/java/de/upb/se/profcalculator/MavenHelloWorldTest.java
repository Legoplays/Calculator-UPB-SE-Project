package de.upb.se.profcalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MavenHelloWorldTest {

    @Test
    public void helloWorld() {
        System.out.println("Hello World, from Maven!");
        Assertions.assertNotEquals(1, 0);
    }
}
