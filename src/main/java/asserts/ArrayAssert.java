package asserts;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class ArrayAssert extends AbstractAssert<ArrayAssert, int[]> {

    private ArrayAssert(int[] actual) {
        super(actual, ArrayAssert.class);
    }

    public static ArrayAssert assertThat(int[] actual) {
        return new ArrayAssert(actual);
    }

    public ArrayAssert hasPrefix(int[] prefix) {
        if (prefix == null) {
            isNull();
            return this;
        }

        isNotNull();
        Assertions.assertThat(prefix.length).isLessThanOrEqualTo(actual.length);

        for (int i = 0; i < prefix.length; i++) {
            Assertions.assertThat(actual[i]).isEqualTo(prefix[i]);
        }

        return this;
    }

}
