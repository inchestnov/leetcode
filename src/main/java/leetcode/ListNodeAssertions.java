package leetcode;

import lombok.experimental.UtilityClass;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

@UtilityClass
public class ListNodeAssertions {

    public void assertEquals(int[] nums, ListNode head) {
        assertNotNull(nums);

        ListNode iterator = head;
        for (int i = 0; i < nums.length; i++) {
            Assertions.assertEquals(nums[i], iterator.val);
            iterator = iterator.next;
        }

        assertNull(iterator);
    }

}
