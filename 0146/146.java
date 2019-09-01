/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 
*/

class LRUCache {
    private class Node{
        Node prve;
        Node next;
        int val;
        int key;
    }
    
    private int capacity;
    private HashMap<Integer, Node> set;
    private int cash;
    private Node head;
    private Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cash = 0;
        this.set  = new HashMap<Integer,Node>();
        this.head = new Node();
        this.head.prve = null;
        this.tail = new Node();
        this.tail.prve = head;
        this.tail.next = null;
        this.head.next = tail;
        
    }
    
    public int get(int key) {
        Node node = set.get(key);
        if(node == null){
            return -1;
        }else{
            moveToHead(node);
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        Node node = set.get(key);
        if(node==null){
            Node newNode = new Node();
        newNode.val = value;
        newNode.key = key;
        addNode(newNode);
        this.set.put(key,newNode);
        if(this.cash>this.capacity){
            removeTail();
            }
        }else{
            node.val = value;
            moveToHead(node);
        }
       
        
    }
    
    public void moveToHead(Node node){
        if(node.prve==this.head){
            return;
        }else if(node.next==this.tail){
            node.prve.next=this.tail;
            this.tail.prve = node.prve;
            node.prve = this.head;
            node.next = this.head.next;
            this.head.next.prve = node;
            this.head.next = node;
        }else{
            Node r = node.next;
            Node l = node.prve;
            l.next = r;
            r.prve = l;
            node.prve = this.head;
            node.next = this.head.next;
            this.head.next.prve = node;
            this.head.next = node;
        }
    }
    
    public void addNode(Node node){
        node.prve = this.head;
        node.next = this.head.next;
        this.head.next.prve = node;
        this.head.next = node;
        this.cash++;
    }
    
    public void removeTail(){
        if(this.tail.prve == this.head){
            return;
        }
        set.remove(this.tail.prve.key);
        Node rem = this.tail.prve;
        this.tail.prve = rem.prve;
        rem.prve.next = this.tail;
        rem.next = null;
        rem.prve = null;
        this.cash--;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */