package DataStructure.ExampleLRUCache;

import java.util.HashMap;

public class ExampleLRUCache {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    public void addNode(DLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(DLinkedNode node){
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public void moveToHead(DLinkedNode node){
        removeNode(node);
        addNode(node);
    }

    public DLinkedNode popTail(){
        DLinkedNode t = tail.prev;
        removeNode(t);
        return t;
    }


    //key, order
    HashMap<Integer, DLinkedNode> cache;
    DLinkedNode head, tail;
    int size;
    int capacity;
    public ExampleLRUCache(int capacity) {
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<Integer, DLinkedNode>();
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);

        if(node == null) return -1;

        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if(node == null){
            node = new DLinkedNode();
            node.key = key;
            node.value = value;

            addNode(node);
            cache.put(key, node);

            size++;

            if(size > capacity){
                DLinkedNode t = popTail();
                cache.remove(t.key);
                size--;
            }
        }else{
            node.value = value;
            moveToHead(node);
        }
    }


}
