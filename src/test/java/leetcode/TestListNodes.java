package leetcode;

import inchestnov.util.ListNodes;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static asserts.ListNodeAssert.*;
import static org.junit.jupiter.api.Assertions.*;

class TestListNodes {

    @Test
    void testOfValues_exceptionThrown() {
        Assertions.assertThatThrownBy(() -> ListNodes.ofValues((List) null))
            .isInstanceOf(NullPointerException.class)
            .hasMessageContaining("must not be null");
    }

    @Test
    void testOfValues_emptyList() {
        assertNull(ListNodes.ofValues(List.of()));
    }

    @Test
    void testOfValues_singleItem() {
        ListNode listNode = ListNodes.ofValues(1);
        assertNotNull(listNode);
        assertEquals(1, listNode.val);
        assertNull(listNode.next);
    }

    @Test
    void testOfValues_fromArray() {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNodes.ofValues(nums);

        assertThat(head).isEqualsTo(nums);
    }

}