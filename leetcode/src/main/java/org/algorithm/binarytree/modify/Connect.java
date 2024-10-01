package org.algorithm.binarytree.modify;

import java.util.ArrayList;
import java.util.List;

/**
 * 117
 * Given a binary tree
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL
 */
public class Connect {





    List<Node> list = new ArrayList<>();
    public Node connect(Node root) {

        dfs(root,0);

        return root;
    }

    void dfs(Node root,int depth){
        if(root==null){
            return;
        }
        if(list.size()==depth){
            list.add(root);
        }else {
            Node dpthNode = list.get(depth);
            dpthNode.next = root;
            list.remove(depth);
            list.add(depth,root);
        }

        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }



    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

}
