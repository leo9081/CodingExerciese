package com.yi.interviewquestions.Facebook;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class BuildBinarySearchTree {
    class Node{
        Node left;
        Node right;
        Node parent;
        int val;
        public Node(int val){
            this.val = val;
        }
    }

    public Node buildTree(String input){
        Node root = new Node(input.charAt(0) - '0');
        Node pointer = root;
        boolean dirc = true;//left
        for(int i = 1 ; i < input.length(); i++){
            if(input.charAt(i) == '('){

            }
            else if(input.charAt(i) == ')'){
                if(input.charAt(i-1) != '(') {
                    pointer = pointer.parent;
                }
                dirc = !dirc;
            }else {
                Node n = new Node(input.charAt(i) - '0');
                n.parent = pointer;
                if(dirc) pointer.left = n;
                else pointer.right = n;
                pointer = n;
            }
        }
        return root;
    }

    public void levelOrderTriversal(Node root){
        Queue<Node> d = new LinkedList<>();
        d.offer(root);
        while(!d.isEmpty()){
            int size = d.size();
            for(int i = 0 ; i< size; i++){
                Node t = d.poll();
                System.out.print(t.val);
                if(t.left != null) d.offer(t.left);
                if(t.right != null) d.offer(t.right);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String input = "5(6(4)(3))(7()())";
        BuildBinarySearchTree b = new BuildBinarySearchTree();
        Node root = b.buildTree(input);
        b.levelOrderTriversal(root);
    }
}
