package asserts;

import leetcode.ListNode;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class ListNodeAssert extends AbstractAssert<ListNodeAssert, ListNode> {

    private ListNodeAssert(ListNode actual) {
        super(actual, ListNodeAssert.class);
    }

    public static ListNodeAssert assertThat(ListNode actual) {
        return new ListNodeAssert(actual);
    }

    public ListNodeAssert isEqualsTo(int[] nums) {
        isNotNull();
        Assertions.assertThat(nums).isNotNull();

        ListNode iterator = actual;
        for (int i = 0; i < nums.length; i++) {
            Assertions.assertThat(iterator.val).isEqualTo(nums[i]);
            iterator = iterator.next;
        }

        Assertions.assertThat(iterator).isNull();

        return this;
    }

}
