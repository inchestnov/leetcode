package leetcode;

import org.junit.jupiter.api.Test;

class TestListNodeAssertions {

    @Test
    void test_assert() {
        int[] numbers = {1, 2, 3};
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNodeAssertions.assertEquals(numbers, head);
    }

}