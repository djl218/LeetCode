// n = number of keys, b = hashmap.length
// Time: O(n / b)
// Space: O(n + b)

class Entry {
    int entryKey;
    int entryValue;
    
    public Entry(int entryKey, int entryValue) {
        this.entryKey = entryKey;
        this.entryValue = entryValue;
    }
}

class Bucket {
    List<Entry> bucket;
    
    public Bucket() {
        this.bucket = new ArrayList<>();
    }
    
    public void bucketPut(int key, int value) {
        boolean found = false;
        for (Entry entry : bucket) {
            if (entry.entryKey == key) {
                entry.entryValue = value;
                found = true;
                break;
            }
        }
        if (!found) {
            bucket.add(new Entry(key, value));
        }
    }
    
    public int bucketGet(int key) {
        for (Entry entry : bucket) {
            if (entry.entryKey == key) {
                return entry.entryValue;
            }
        }
        return -1;
    }
    
    public void bucketRemove(int key) {
        for (Entry entry : bucket) {
            if (entry.entryKey == key) {
                bucket.remove(entry);
                break;
            }
        }
    }
}

class MyHashMap {
    Bucket[] hashMap;
    int hashLength = 10_000;

    public MyHashMap() {
        this.hashMap = new Bucket[hashLength];
        for (int i = 0; i < hashLength; i++) {
            hashMap[i] = new Bucket();
        }
    }
    
    public void put(int key, int value) {
        int hashKey = key % hashLength;
        hashMap[hashKey].bucketPut(key, value);
    }
    
    public int get(int key) {
        int hashKey = key % hashLength;
        return hashMap[hashKey].bucketGet(key);
    }
    
    public void remove(int key) {
        int hashKey = key % hashLength;
        hashMap[hashKey].bucketRemove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */