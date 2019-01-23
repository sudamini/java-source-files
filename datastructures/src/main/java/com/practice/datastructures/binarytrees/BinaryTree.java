package com.practice.datastructures.binarytrees;

import java.util.Objects;

/*
This class holds all the nodes in a tree
 */
class BinaryTree implements iBinaryTree {

    private static final int DEFAULT_LEVELS = 3;

    /* a binary search tree of 3 levels has 15 modes if its full*/
    private static final int TOTAL_NODES = 15;
    TreeNode root;

    class TreeNode {
        int data;
        TreeNode right;
        TreeNode left;

        TreeNode( int in_data ) {
            data = in_data;
            right = null;
            left = null;
        }
    }


    @Override
    public TreeNode find( int key ) {
        TreeNode currentNode = root;
        while ( currentNode != null && currentNode.data!= key  ) {
            if ( key >= currentNode.data ) {
                currentNode = currentNode.right;
            } else {
                currentNode = currentNode.left;
            }
        }
        return currentNode;
    } // end method
    /*
   WORKS
    */
    TreeNode findRecursive( TreeNode root, int key) {

        if ( root == null) {
            System.out.println("Key " + key + " not found. ");
            return root;
        }
        if (root.data == key) {
            return root;
        }
        if (key >= root.data)
            return findRecursive( root.right, key);
        else
            return findRecursive(root.left, key );
    } // end method
    /*
    WORKS
     */
    int findMinimum( TreeNode root) {
        // keep going left till you reach end
        TreeNode current = root;
        if( current.left == null ) {
            return current.data;
        } else {
            current = current.left;
            return findMinimum(current);
        }
    } // end method

    /*
    WORKS
     */
    int findMaximum( TreeNode root ) {
        // keep going right till you reach end
        TreeNode current = root;
        if( current.right == null ) {
            return current.data;
        } else {
            current = current.right;
            return findMaximum(current);
        }
    }

    TreeNode deleteRecursive(int data) {
        return null;
    }

    /*
    This will do all types of traversals by default.
     */
    @Override
    public void traverse() {
        System.out.println( "Pre order");
        preOrderTraversal( root );
        System.out.println( "In order");
        inOrderTraversal( root );
        System.out.println( "Post order");
        postOrderTraversal( root );
    }
    //root, left, right
    private void preOrderTraversal( TreeNode root ) {
        TreeNode current = root;
        if( current != null ) {
            System.out.println ( root.data );
            preOrderTraversal(current.left);
            preOrderTraversal(current.right);
        }
    }
    //left, root, right
    private void inOrderTraversal( TreeNode root ){
        TreeNode current = root;
        if( current != null ) {
            inOrderTraversal( current.left);
            System.out.println( current.data);
            inOrderTraversal( current.right );
        }
    } // end method

    //left, right, root
    private void postOrderTraversal( TreeNode root ){
        TreeNode current = root;
        if( current != null ){
            postOrderTraversal(current.left);
            postOrderTraversal(current.right);
            System.out.println(current.data);
        }
    }

    @Override
    public TreeNode insert( int newKey ) {
        TreeNode result = find( newKey );
        if ( result != null ) {
            System.out.println("Key already exists");
            return result;
        }
        return insert( root, newKey );
    }
    /*
    WORKS
     */
    public void print( TreeNode node ) {
        if( node != null ) {
            System.out.println( node.data);
            print(node.right);
            print(node.left);
        }
    }
    /*
    WORKS
     */
    public int size( TreeNode node ) {
        if ( node == null ) {
            return 0;
        } else {
            return 1 + size(node.right) + size( node.left) ;
        }
    }
    /*
    WORKS
     */
    private TreeNode insert( TreeNode root, int newKey ){
        TreeNode current = root;
        if ( current == null ) {
            current = new TreeNode( newKey );
            return current;
        } else {
            if( newKey < current.data ) {
                current.left = insert( current.left, newKey );
            } else {
                current.right = insert( current.right, newKey );
            }
        }
        return current;
    }

    /*
     */
    @Override
    public TreeNode delete( int key ) {
        if ( Objects.isNull( find ( key )) ){
            System.out.println ("Key not present in binary tree ");
            return null;
        }
       return delete( root, key );
    }

    // logic if you delete root
    private TreeNode delete( TreeNode root, int key ) {
        return null;
    }
}
