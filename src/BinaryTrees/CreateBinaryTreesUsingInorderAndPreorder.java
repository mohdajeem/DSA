package BinaryTrees;
import java.util.*;

import javax.swing.tree.TreeNode;

public class CreateBinaryTreesUsingInorderAndPreorder { 

    public static void main(String[] args){
        System.out.print("Create Binary Trees Using Inorder and Preorder");
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder){

        Map<Integer,Integer> inMap= new HashMap<Integer,Integer>();


        // put entire inorder value, its index into hashMap
        for(int i = 0;i<inorder.length;i++){
            inMap.put(inorder[i], i);
        }

        TreeNode root = buildTree(preorder, 0,preorder.length-1,inorder,0,inorder.length-1, inMap);
        return root;
    }

    public static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap){

        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;
        
        root.left = buildTree(preorder, preStart+1, preStart + numsLeft, inorder, inStart, inRoot-1, inMap);

        root.right = buildTree(preorder, preStart+numsLeft+1, preEnd, inorder, inRoot+1,inEnd, inMap);
    }




    
}
