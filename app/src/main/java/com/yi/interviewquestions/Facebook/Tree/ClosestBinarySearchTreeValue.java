package com.yi.interviewquestions.Facebook.Tree;

import java.util.Stack;

public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        Stack<TreeNode> stack = new Stack();
        long pred = Long.MIN_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.leftNode;
            }
            root = stack.pop();

            if (pred <= target && target < root.val)
                return Math.abs(pred - target) < Math.abs(root.val - target) ? (int)pred : root.val;

            pred = root.val;
            root = root.rightNode;
        }
        return (int)pred;
    }
}
