package com.yi.interviewquestions.ThirtyLeetCodingChallenge;

import java.util.Arrays;

public class ConstructBinarySearchTreefromPreorderTraversal {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


    //personal solution:
    public TreeNode bstFromPreorder2(int[] preorder) {
        if(preorder== null || preorder.length == 0) return null;

        Arrays.sort(preorder);
        int size = preorder.length;
        int mid = size/2;
        TreeNode root = new TreeNode(preorder[mid]);
        root.left = bstFromPreorder2(Arrays.copyOfRange(preorder, 0, mid));
        root.right = bstFromPreorder2(Arrays.copyOfRange(preorder,mid+1,size));

        return root;

    }

    //solution that fits the quesiton
    int i = 0;
    public TreeNode bstFromPreorder(int[] arr) {
        return helper(arr, Integer.MAX_VALUE);
    }

    public TreeNode helper(int[] arr, int bound) {
        if (i == arr.length || arr[i] > bound) return null;
        TreeNode root = new TreeNode(arr[i++]);
        root.left = helper(arr, root.val);
        root.right = helper(arr, bound);
        return root;
    }



    public static void main(String[] args){
        int[] input = new int[]{8,5,1,7,10,12};
    }
}
