package Datastructure.binarysearchtree.dfs;

import java.util.Arrays;
import java.util.List;

// root left right
public class BinaryTreeLauncher {

    public  void findPreOrderTraversal(TreeNode node){
        if(node == null){
          return;
        }
        System.out.println(print(node.data));
        findPreOrderTraversal(node.left);
        findPreOrderTraversal(node.right);
    }

    public int print(int data){
        return data;
    }

    public static void main(String[] args) {
      BinaryTree binaryTree = new BinaryTree();
      binaryTree.add(5);
      binaryTree.add(3);
      binaryTree.add(7);
      binaryTree.add(1);
      binaryTree.add(4);
      binaryTree.add(2);
      binaryTree.add(6);
      binaryTree.add(7);

      System.out.println("--------Pre order traversal-------");
      binaryTree.findPreOrderTraversal(binaryTree.root);
        System.out.println();

        System.out.println("--------Post order traversal-------");
        binaryTree.findPostOrderTraversal(binaryTree.root);
        System.out.println();

        System.out.println("--------In order traversal-------");
        binaryTree.findInOrderTraversal(binaryTree.root);
        System.out.println();

        System.out.println("--------Level Order traversal-------");
        List<List<Integer>> lists = binaryTree.levelOrderTraversal(binaryTree.root);
        for (List<Integer> level : lists) {
            System.out.println(level);
        }

        System.out.println("--------Max depth tree-------");
        System.out.println(binaryTree.maxDepthOfTree(binaryTree.root));
        System.out.println("--------is balanced tree-------");
        System.out.println(binaryTree.isBalanced(binaryTree.root));
    }

}
