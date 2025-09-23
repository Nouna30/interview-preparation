package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class HeightBalancedBinaryTree {

    // https://www.algoexpert.io/questions/height-balanced-binary-tree
    //
    // NOTES:
    // Traverse every node and find the height at each node.
    // If height diff of two subtrees > 1, return back -1, else return 1 + max(left, right)
    // If height comes as negative, means not height balanced.
    // Else this is height balanced

    // This is an input class. Do not edit.
    private static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        int height = calcHeight(tree);
        return height > 0;
    }

    private int calcHeight(BinaryTree node) {
        if (node == null) return 0;

        int leftHeight = calcHeight(node.left);
        int rightHeight = calcHeight(node.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

}
