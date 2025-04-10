package org.algorithm.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 138
 */
public class CopyRandomList138 {

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {

        if(head==null){
            return null;
        }

        Map<Node,Node> map = new HashMap<>();


        // 1. fill next
        Node newNode = null;
        Node ret =null;
        Node iter = head;
        while(iter!=null){
            if(newNode==null){
                newNode = new Node(iter.val);
                ret = newNode;
            }else {
                newNode.next = new Node(iter.val);
                newNode = newNode.next;
            }

            map.put(iter,newNode);
            iter = iter.next;
        }

        // 2. fill random
        Node oldIter = head;
        Node newIter = ret;

        while(oldIter!=null){
            if(oldIter.random!=null){
                newIter.random = map.get(oldIter.random);
            }
            oldIter = oldIter.next;
            newIter = newIter.next;
        }

        return ret;
    }
}
