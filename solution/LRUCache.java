import java.util.HashMap;

/**
 * Problem: Implement LRU Cache.
 *
 * @author  Vamsi Krishna Myalapalli
 * @version 1.0
 * @since   2019-12-27
 */

class Record {
    int key, value;
    Record left, right;
}

public class LRUCache {

    private HashMap<Integer, Record> hashMap;
    private Record start, end;
    private static int LRU_SIZE = 4; // Size of cache

    public LRUCache() {
        hashMap = new HashMap<>();
    }

    public int get(int key) {
        if (hashMap.containsKey(key)) {
            Record record = hashMap.get(key);
            removeNode(record);
            addAtTop(record);
            System.out.println("GET:  Fetched data from cache: [" + key + "," + record.value + "]");
            return record.value;
        }
        System.out.println("MISS: Could not find " +  key + " in cache.");
        return -1;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key))
        {
            Record record = hashMap.get(key);
            record.value = value;
            removeNode(record);
            addAtTop(record);
        } else {
            Record newNode = new Record();
            newNode.left = newNode.right = null;
            newNode.value = value;
            newNode.key = key;
            if (hashMap.size() >= LRU_SIZE) {
                System.out.println();
                System.out.println("INFO: Cache Size exceeded. Kicking out: " + end.key);
                hashMap.remove(end.key);
                removeNode(end);
            }
            addAtTop(newNode);
            hashMap.put(key, newNode);
            System.out.println("PUT:  Stored data into cache: [" + key + "," + value + "]");
        }
    }

    public void addAtTop(Record node) {
        node.right = start;
        node.left = null;
        if (start != null) {
            start.left = node;
        }
        start = node;
        if (end == null) {
            end = start;
        }
    }

    public void removeNode(Record node) {
        if (node.left != null) {
            node.left.right = node.right;
        } else {
            start = node.right;
        }
        if (node.right != null) {
            node.right.left = node.left;
        } else {
            end = node.left;
        }
    }


    public static void main(String[] args) {
        LRUCache lrucache = new LRUCache();

        System.out.println("INFO: Created a KV Store Cache with Size: " + LRU_SIZE);

        lrucache.put(1, 1);
        lrucache.put(10, 15);
        lrucache.put(15, 10);
        lrucache.put(10, 16);
        lrucache.put(12, 15);
        lrucache.put(18, 10);
        lrucache.put(13, 16);

        lrucache.get(1);
        lrucache.get(10);
        lrucache.get(15);

        lrucache.put(32,76);
        lrucache.get(12);
        lrucache.get(32);
    }

}




/*
Output:
—————————

INFO: Created a KV Store Cache with Size: 4
PUT:  Stored data into cache: [1,1]
PUT:  Stored data into cache: [10,15]
PUT:  Stored data into cache: [15,10]
PUT:  Stored data into cache: [12,15]

INFO: Cache Size exceeded. Kicking out: 1
PUT:  Stored data into cache: [18,10]

INFO: Cache Size exceeded. Kicking out: 15
PUT:  Stored data into cache: [13,16]
MISS: Could not find 1 in cache.
GET:  Fetched data from cache: [10,16]
MISS: Could not find 15 in cache.

INFO: Cache Size exceeded. Kicking out: 12
PUT:  Stored data into cache: [32,76]
MISS: Could not find 12 in cache.
GET:  Fetched data from cache: [32,76]


*/
