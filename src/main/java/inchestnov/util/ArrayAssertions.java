package inchestnov.util;

import lombok.experimental.UtilityClass;

import static org.junit.jupiter.api.Assertions.*;

@UtilityClass
public final class ArrayAssertions {

    /**
     * Assert that <code>expected[i] == actual[i]</code> for all i from 0 to expected.length.
     */
    public static void assertArrayPrefixEquals(int[] expected, int[] actual) {
        if (expected == null) {
            assertNull(actual);
            return;
        }
        assertNotNull(expected);
        assertNotNull(actual);

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

}
