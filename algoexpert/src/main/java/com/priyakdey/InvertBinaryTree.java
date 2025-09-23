package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class InvertBinaryTree {

    // https://www.algoexpert.io/questions/invert-binary-tree
    //
    // NOTES:
    // Recursively go down the tree and invert each child.

    public static void invertBinaryTree(BinaryTree tree) {
        invertBinaryTreeInternal(tree);
    }

    private static BinaryTree invertBinaryTreeInternal(BinaryTree tree) {
        if (tree == null || tree.left == null && tree.right == null) {
            return tree;
        }

        BinaryTree left = tree.left;
        BinaryTree right = tree.right;

        tree.left = invertBinaryTreeInternal(right);
        tree.right = invertBinaryTreeInternal(left);
        return tree;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
