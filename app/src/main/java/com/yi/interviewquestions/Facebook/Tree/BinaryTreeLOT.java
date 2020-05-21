package com.yi.interviewquestions.Facebook.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class BinaryTreeLOT {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0 ; i < size; i++){
                TreeNode temp = q.poll();
                level.add(temp.val);
                if(temp.leftNode!=null) q.offer(temp.leftNode);
                if(temp.rightNode!=null) q.offer(temp.rightNode);
            }

            result.add(level);
        }

        return result;
    }
}
