package leetcode;

import inchestnov.util.ListNodeUtils;
import inchestnov.util.TreeNodeUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class TestTreeNodeUtils {

    @Test
    void testOfValues_exceptionThrown() {
        assertThatThrownBy(() -> ListNodeUtils.ofValues((List) null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("must not be null");
    }

    @Test
    void testOfValues_emptyList() {
        assertNull(TreeNodeUtils.ofValues(List.of()));
    }

    @Test
    void testOfValues_singleItem() {
        TreeNode treeNode = TreeNodeUtils.ofValues(1);
        assertNotNull(treeNode);
        assertEquals(1, treeNode.val);
        assertNull(treeNode.left);
        assertNull(treeNode.right);
    }

    @Test
    void testOfValues_leftSubTree() {
        TreeNode root = TreeNodeUtils.ofValues(Arrays.asList(1, 2, null, 3, null, 4, null, 5, null));
        assertThat(root.val).isEqualTo(1);

        assertThat(root.left.val).isEqualTo(2);
        assertThat(root.right).isNull();

        assertThat(root.left.left.val).isEqualTo(3);
        assertThat(root.left.right).isNull();

        assertThat(root.left.left.left.val).isEqualTo(4);
        assertThat(root.left.left.right).isNull();

        assertThat(root.left.left.left.left.val).isEqualTo(5);
        assertThat(root.left.left.left.right).isNull();

        assertThat(root.left.left.left.left.left).isNull();
        assertThat(root.left.left.left.left.right).isNull();
    }

    @Test
    void testOfValues_fromArray() {
        Integer[] nums = {-10, 9, 20, null, null, 15, 7};
        TreeNode root = TreeNodeUtils.ofValues(nums);
        assertThat(root.val).isEqualTo(-10);

        assertThat(root.left.val).isEqualTo(9);
        assertThat(root.right.val).isEqualTo(20);

        assertThat(root.left.left).isNull();
        assertThat(root.left.right).isNull();

        assertThat(root.right.left.val).isEqualTo(15);
        assertThat(root.right.right.val).isEqualTo(7);

        assertThat(root.right.left.left).isNull();
        assertThat(root.right.left.right).isNull();
        assertThat(root.right.right.left).isNull();
        assertThat(root.right.right.right).isNull();
    }

    @Test
    void testOfValues_fromList() {
        TreeNode root = TreeNodeUtils.ofValues(Arrays.asList(
                1, 4, 4, null, 2, 2, null, 1, null, 6, 8, null, null, null, null, 1, 3
        ));

        assertThat(root.val).isEqualTo(1);

        assertThat(root.left.val).isEqualTo(4);
        assertThat(root.right.val).isEqualTo(4);

        assertThat(root.left.left).isNull();
        assertThat(root.left.right.val).isEqualTo(2);

        assertThat(root.right.left.val).isEqualTo(2);
        assertThat(root.right.right).isNull();

        assertThat(root.left.right.left.val).isEqualTo(1);
        assertThat(root.left.right.right).isNull();

        assertThat(root.right.left.left.val).isEqualTo(6);
        assertThat(root.right.left.right.val).isEqualTo(8);

        assertThat(root.left.right.left.left).isNull();
        assertThat(root.left.right.left.right).isNull();

        assertThat(root.right.left.left.left).isNull();
        assertThat(root.right.left.left.right).isNull();

        assertThat(root.right.left.right.left.val).isEqualTo(1);
        assertThat(root.right.left.right.right.val).isEqualTo(3);

        assertThat(root.right.left.right.left.left).isNull();
        assertThat(root.right.left.right.left.right).isNull();

        assertThat(root.right.left.right.right.left).isNull();
        assertThat(root.right.left.right.right.right).isNull();
    }

}