package com.practice.datastructures.binarytrees;

public interface iBinaryTree<TreeNode> {

    TreeNode find(int key );
    TreeNode delete (int key );
    void traverse();
    TreeNode insert(int newKey );

}
