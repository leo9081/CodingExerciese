package com.yi.interviewquestions.GoogleIntern;

import org.w3c.dom.Node;

public class TreeListTravers {
    /*
              1
             / \
             2->3
            / \ / \
           4->5->6->7

        Node
        * leftChild 
        * rightChild 
        * peer 
     */

    class Node{
        Node leftChild;
        Node rightChild;
        Node peer;
        public Node(){

        }
    }

    public Node connectPerfectBinaryTree(Node root){
        Node temp = root;

        while(temp != null && temp.leftChild!=null){
            Node left = temp.leftChild;
            while(temp!=null){
                temp.leftChild.peer = temp.rightChild;
                if(temp.peer != null){
                    temp.rightChild.peer = temp.peer.leftChild;
                }
                temp = temp.peer;
            }

            temp = left;
        }
        return root;
    }
}
