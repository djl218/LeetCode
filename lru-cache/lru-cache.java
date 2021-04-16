import java.util.Hashtable;

/*
HashMap is an unsynchronized datastructure, which means it's not thread-safe, 
but because it doesn't need to maintain thread safety, it has much less overhead, thus has better performance.

Hashtable is a synchronized, thread-safe datastructure. So, in a multi-threaded environment where you care 
about thread safety for data structures you are using, using a HashMap is a no go. As expected, Hashtable, 
because it has to maintain these guarantees, has higher overhead and lower performance.

ConcurrentHashMap is a newer implementation that pretty much offers the same functionality of Hashtable, 
but it's implemented in a way with less overhead, so better performance. Not better than a regular ol HashMap though.
*/

class DLinkedNode {
    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;
}

class LRUCache {
    int capacity;
    int count;
    Hashtable<Integer, DLinkedNode> cache;
    DLinkedNode head;
    DLinkedNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        cache = new Hashtable<>();
        head = new DLinkedNode();
        tail = new DLinkedNode();
        
        head.prev = null;
        head.next = tail;
        
        tail.next = null;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;

        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            
            cache.put(key, newNode);
            count++;
            if (count > capacity) {
                DLinkedNode last = popTail();
                cache.remove(last.key);
                count--;
            }
            addNode(newNode);
        } else {
            node.value = value;
            moveToHead(node);
        }  
    }
    
    private void addNode(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        
        head.next.prev = node;
        head.next = node;
    }
    
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private DLinkedNode popTail() {
        DLinkedNode last = tail.prev;
        removeNode(last);
        return last;
    }
    
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */