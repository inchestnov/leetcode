package inchestnov.util;

import lombok.experimental.UtilityClass;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@UtilityClass
public final class ArrayAssertions {

    /**
     * Assert that <code>expected[i] == actual[i]</code> for all i from 0 to expected.length.
     */
    public static void assertArrayPrefixEquals(int[] expected, int[] actual) {
        Objects.requireNonNull(expected, "expected must not be null");
        Objects.requireNonNull(expected, "actual must not be null");

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

}
