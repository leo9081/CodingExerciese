package com.yi.interviewquestions.Facebook.Tree;

public class DiameterofBinaryTree {
    int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        helper(root);
        return max;
    }

    public int helper(TreeNode root){
        if(root == null) return 0;

        int left = helper(root.leftNode);
        int right = helper(root.rightNode);

        max = Math.max(max, left+right);

        return Math.max(left, right)+1;
    }
}