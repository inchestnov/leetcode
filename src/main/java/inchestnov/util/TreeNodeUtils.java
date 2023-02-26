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
        appendNextTwoElementsRecursive(root, values, 1);
        return root;
    }

    private void appendNextTwoElementsRecursive(TreeNode root, List<Integer> source, int index) {
        if (root == null || source.size() <= index) {
            return;
        }

        Integer leftValue = source.get(index);
        if (leftValue != null) {
            TreeNode leftChild = new TreeNode(leftValue);
            root.left = leftChild;
        }

        Integer rightValue = source.get(index + 1);
        if (rightValue != null) {
            TreeNode rightChild = new TreeNode(rightValue);
            root.right = rightChild;
        }

        appendNextTwoElementsRecursive(root.left, source, index + 2);
        appendNextTwoElementsRecursive(root.right, source, index + 4);
    }

}
