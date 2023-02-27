package inchestnov.util;

import lombok.experimental.UtilityClass;

import java.util.Objects;

/**
 * Utility-class for easy create array of integers.
 */
@UtilityClass
public final class IntArrays {

    /**
     * Return arrays of integers created from varargs.
     */
    public int[] intArrayOf(int ... nums) {
        Objects.requireNonNull(nums, "nums must not be null");
        return nums;
    }

    public int[][] intArrayOf(int[] ... nums) {
        Objects.requireNonNull(nums, "nums must not be null");
        return nums;
    }

}
