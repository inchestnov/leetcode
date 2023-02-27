package inchestnov.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestIntArrays {

    @Test
    void testIntArrayOf_nullParameter() {
        Assertions.assertThatThrownBy(() -> IntArrays.intArrayOf((int[]) null))
            .isInstanceOf(NullPointerException.class)
            .hasMessageContaining("must not be null");
    }

    @Test
    void testIntArrayOf() {
        int[] expected = {1, 2, 3};
        int[] actual = IntArrays.intArrayOf(1, 2, 3);

        assertArrayEquals(expected, actual);
    }

    @Test
    void testIntArrayOfTwoDimensional() {
        int[][] expected = {{1, 2, 3}, {2, 3, 4}};
        int[][] actual = IntArrays.intArrayOf(
                IntArrays.intArrayOf(1, 2, 3),
                IntArrays.intArrayOf(2, 3, 4)
        );

        assertArrayEquals(expected, actual);
    }

}