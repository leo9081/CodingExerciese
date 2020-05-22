package com.yi.interviewquestions.Facebook.Tree;

public class DiameterofBinaryTree {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        max = 0;
        helper(root);
        return max-1;
    }

    public int helper(TreeNode root){
        if(root == null) return 0;

        int left = helper(root.leftNode);
        int right = helper(root.rightNode);

        max = Math.max(max, left + right+1);
        return Math.max(left, right)+1;
    }
}