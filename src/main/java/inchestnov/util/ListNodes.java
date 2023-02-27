package inchestnov.util;

import leetcode.ListNode;
import lombok.experimental.UtilityClass;

import java.util.*;

/**
 * Utility-class for easy create {@link ListNode}
 */
@UtilityClass
public class ListNodes {

    public ListNode ofValues(int... values) {
        Objects.requireNonNull(values, "values must not be null");
        return ofValues(Arrays.stream(values).boxed().toList());
    }

    public ListNode ofValues(List<Integer> values) {
        Objects.requireNonNull(values, "values must not be null");

        // Do not modify input list
        List<Integer> list = new ArrayList<>(values);
        Collections.reverse(list);

        return list.stream()
            .map(ListNode::new)
            .reduce((next, prev) -> {
                prev.next = next;
                return prev;
            })
            .orElse(null);
    }

}
