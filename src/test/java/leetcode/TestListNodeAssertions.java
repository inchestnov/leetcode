package leetcode;

import asserts.ListNodeAssert;
import org.junit.jupiter.api.Test;

class TestListNodeAssertions {

    @Test
    void test_isEqualsTo() {
        int[] numbers = {1, 2, 3};
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNodeAssert.assertThat(head).isEqualsTo(numbers);
    }

}