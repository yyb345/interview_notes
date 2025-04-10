package org.algorithm;

import java.util.Hashtable;
import java.util.Map;

/**
 * 146
 * 1 <-> 2 <-> 3
 * head是最新的数据
 * tail是最久的数据
 */
public class LRUCache {

    class EntryNode {
        int key;
        int value;
        EntryNode pre;
        EntryNode next;
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(EntryNode node) {
        node.pre = head;
        node.next = head.next;

        head.next.pre = node;
        head.next = node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(EntryNode node){
        EntryNode pre = node.pre;
        EntryNode next = node.next;

        pre.next = next;
        next.pre = pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(EntryNode node){
        this.removeNode(node);
        this.addNode(node);
    }

    // pop the current tail.
    private EntryNode popTail(){
        EntryNode res = tail.pre;
        this.removeNode(res);
        return res;
    }

    private Map<Integer, EntryNode>
            cache = new Hashtable<>();
    private int count;
    private int capacity;
    // 这两个都是虚拟节点，没存储实际的任何数据
    private EntryNode head, tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new EntryNode();
        head.pre = null;

        tail = new EntryNode();
        tail.next = null;

        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {

        EntryNode node = cache.get(key);
        if(node == null){
            return -1; // should raise exception here.
        }

        // move the accessed node to the head;
        this.moveToHead(node);

        return node.value;
    }


    public void put(int key, int value) {
        EntryNode node = cache.get(key);

        if(node == null){

            EntryNode newNode = new EntryNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if(count > capacity){
                // pop the tail
                EntryNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        }else{
            // update the value.
            node.value = value;
            this.moveToHead(node);
        }
    }

    public static void main(String[] args){
        LRUCache lruCache = new LRUCache(4);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        lruCache.put(4,4);
        lruCache.put(5,5);

        System.out.println(lruCache.get(5));

    }
}

