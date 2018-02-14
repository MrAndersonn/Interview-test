import java.util.Arrays;

/**
 * Created by Neo on 21.08.2017.
 */
public class MyHashMap {
    private   int TABLE_SIZE = 128;
    private int size=0;
    private MyEntry[] table;

    public MyHashMap() {
        table = new MyEntry[TABLE_SIZE];

    }
    public MyHashMap(int capacity) {
        TABLE_SIZE = capacity;
        table = new MyEntry[TABLE_SIZE];
    }
    public double get(int key) {
        int hash = Math.abs(key % TABLE_SIZE);
        while (table[hash] != null && table[hash].getKey() != key)
            hash = (hash + 1) % TABLE_SIZE;
        if (table[hash] == null)
            return -1;
        else
            return table[hash].getValue();
    }

    public void put(int key, double value) {
        int hash = Math.abs(key % TABLE_SIZE);
        int previosHash =hash;
        while (table[hash] != null && table[hash].getKey() != key) {
            hash = (hash + 1) % TABLE_SIZE;
            if (previosHash==hash)
            {
//                Out of memory of HashMap
                return ;
            }
        }
        if (table[hash]==null){
            size++;
        }
        table[hash] = new MyEntry(key, value);

    }

    public int getSize() {
        return size;
    }

    class MyEntry {
        private int key;
        private double value;

        MyEntry(int key, double value) {
            this.key = key;
            this.value = value;
        }

        int getKey() {
            return key;
        }

        double getValue() {
            return value;
        }

        @Override
        public String toString() {
            return '[' +
                    "key=" + key +
                    ", value=" + value +
                    ']';
        }
    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "table=" + Arrays.toString(table) +
                '}';
    }
}