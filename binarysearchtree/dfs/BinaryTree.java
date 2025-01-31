package Datastructure.binarysearchtree.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {
    TreeNode root; // root node of the binary tree

    BinaryTree(){
        root = null;
    }

    // Method to insert a new node in the binary tree
    public void add(int value) {
        root = addRecursive(root, value);
    }

    private TreeNode addRecursive(TreeNode current, int value){
        // Base case: If the current node is null, create a new node with the value
        if (current == null) {
            return new TreeNode(value);
        }
        if(value < current.data){
            current.left = addRecursive(current.left,value);
        }else if(value > current.data){
            current.right = addRecursive(current.right,value);
        }
        return current;
    }

    //root left right
    public  void findPreOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        System.out.print(print(node.data));
        System.out.print(" ");
        findPreOrderTraversal(node.left);
        findPreOrderTraversal(node.right);
    }

    //left right root
    public  void findPostOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        findPostOrderTraversal(node.left);
        findPostOrderTraversal(node.right);
        System.out.print(print(node.data));
        System.out.print(" ");
    }

    //left root right
     public  void findInOrderTraversal(TreeNode node){
        if(node == null){
            return;
        }
        findInOrderTraversal(node.left);
        System.out.print(print(node.data));
        System.out.print(" ");
        findInOrderTraversal(node.right);
    }

    public int print(int data){
        return data;
    }

    //
    public List<List<Integer>> levelOrderTraversal(TreeNode root){
        // List to store the result of each level
        List<List<Integer>> result = new ArrayList<>();
        // If the tree is empty, return an empty list
        if(root == null){
           return result;
        }
        // Queue to keep track of nodes to visit
        Queue<TreeNode> queue  =  new LinkedList<>();
        queue.add(root); // Add the root node to the queue

        //Loop until there are no more nodes to process
        while(!queue.isEmpty()){
            // List to store nodes of the current level
            List<Integer> currentLevel = new ArrayList<>();
            int levelSize = queue.size(); // Number of nodes at the current level
            for(int i = 0 ; i < levelSize ; i++){
                TreeNode currentNode =  queue.poll(); // Remove the front node from the queue
                currentLevel.add(currentNode.data); // Add the node's value to the current level list

                //Add left child to the queue if the currentNode has a left child
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                //Add right child to the queue if the currentNode has a left child
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }
            // Add the current level's nodes to the result
            result.add(currentLevel);
        }
        return result;
    }

   //maximum dept of binary tree
    public int maxDepthOfTree(TreeNode root){
        // Base case: If the node is null, the depth is 0
        if(root == null){
           return 0;
        }

        int leftDepth = maxDepthOfTree(root.left);
        int rightDepth = maxDepthOfTree(root.right);
        return 1+Math.max(leftDepth,rightDepth);
    }

    //check for balanced tree
    public boolean isBalanced(TreeNode root){
            return dfsHeight(root) !=1;
    }

    public int dfsHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = dfsHeight(root.left);
        if(leftHeight == -1){
            return -1;
        }
        int rightHeight = dfsHeight(root.right);
        if(rightHeight == -1){
            return -1;
        }
        if(Math.abs(leftHeight-rightHeight) > 1){
            return -1;
        }
        return Math.max(leftHeight,rightHeight)+1;

    }



}
