package com.practice.datastructures.binarytrees;
import com.practice.datastructures.binarytrees.BinaryTree.TreeNode;

public class MiniBinaryTreeSimulator {

    public static void main ( String[] args ) {
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree. new TreeNode(10);
        TreeNode right = tree. new TreeNode( 15);
        TreeNode left = tree. new TreeNode( 8);
        root.right = right;
        root.left = left;
        tree.root = root;

        tree.insert(25);
        tree.insert(9);
        tree.insert(7);

        tree.traverse();



    }
}
