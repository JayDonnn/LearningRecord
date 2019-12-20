package Algorithm.work1031.QingTingFM;

/**
 * 蜻蜓FM 笔试题
 * 设计LRUCache算法
 * 要求：
 * 1.创建时给出初始容量
 * 2.set(key, value):将记录(key,value)插入该结构。当缓存满时，将最久为使用的数据置换掉
 * 3.get(key):返回key对应的value
 * 4.能否在O(1)的时间复杂度内完成set和get
 * 4.对于某些读次数远大于写次数的场景，每次读需要更新访问数据，代价太高，如何进行优化。
 */

import java.util.HashMap;

class Node {
    public int key, val;
    public Node next, prev;
    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}

class DoubleList{
    private Node head, tail;
    private int size;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addFirst(Node x) {
        x.next = head.next;
        x.prev = head;
        head.next.prev = x;
        head.next = x;
        size++;
    }

    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    public Node removeLast() {
        if(tail.prev == head) {
            return null;
        }
        Node last = tail.prev;
        remove(last);
        return last;
    }

    public int size() {
        return size;
    }
}

public class LRUCache {

    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;
    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        set(key, val);
        return val;
    }

    public void set(int key, int val) {
        Node x = new Node(key, val);
        if (map.containsKey(key)) {
            cache.remove(map.get(key));
            cache.addFirst(x);
            map.put(key, x);
        } else {
            if(cap == cache.size()) {
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(x);
            map.put(key, x);
        }
    }

    public static void main(String[] args) {

    }

}
