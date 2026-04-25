package test.java.Lesson12;

import main.java.Lesson12.Factorial;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class FactorialJUnit5Test {

    @Test
    void testFactorialOfZero() {
        assertEquals(1, Factorial.calculate(0));
    }

    @Test
    void testFactorialOfOne() {
        assertEquals(1, Factorial.calculate(1));
    }

    @Test
    void testFactorialOfFive() {
        assertEquals(120, Factorial.calculate(5));
    }

    @Test
    void testFactorialOfTen() {
        assertEquals(3628800, Factorial.calculate(10));
    }

    @Test
    void testNegativeNumberThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.calculate(-5);
        });
    }
}

