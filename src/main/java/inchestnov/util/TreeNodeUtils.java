package inchestnov.util;

import leetcode.TreeNode;
import lombok.experimental.UtilityClass;

import java.util.*;

/**
 * Utility-class for easy create {@link TreeNode}
 */
@UtilityClass
public class TreeNodeUtils {

    public TreeNode ofValues(Integer... values) {
        Objects.requireNonNull(values, "values must not be null");
        return ofValues(Arrays.stream(values).toList());
    }

    /**
     * Returns TreeNode, created from bfs-order.
     */
    public TreeNode ofValues(List<Integer> values) {
        Objects.requireNonNull(values, "values must not be null");

        if (values.isEmpty()) {
            return null;
        }

        TreeNode root = new TreeNode(values.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty() && index < values.size()) {
            TreeNode next = queue.poll();

            Optional.ofNullable(values.get(index++)).ifPresent(left -> {
                next.left = new TreeNode(left);
                queue.add(next.left);
            });

            Optional.ofNullable(values.get(index++)).ifPresent(right -> {
                next.right = new TreeNode(right);
                queue.add(next.right);
            });
        }


        return root;
    }

}
