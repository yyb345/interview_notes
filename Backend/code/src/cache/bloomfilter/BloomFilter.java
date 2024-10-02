package cache.bloomfilter;
import java.util.BitSet;

public class BloomFilter<T> {
    private BitSet bitSet;
    private int size;
    private int hashFunctions;

    public BloomFilter(int size, int hashFunctions) {
        this.size = size;
        this.hashFunctions = hashFunctions;
        this.bitSet = new BitSet(size);
    }

    public void add(T value) {
        for (int i = 0; i < hashFunctions; i++) {
            int hash = hashFunction(i, value);
            bitSet.set(hash % size);
        }
    }

    public boolean contains(T value) {
        for (int i = 0; i < hashFunctions; i++) {
            int hash = hashFunction(i, value);
            if (!bitSet.get(hash % size)) {
                return false;
            }
        }
        return true;
    }

    private int hashFunction(int index, T value) {
        return Math.abs(value.hashCode() + index);
    }

//    public void serialize(String fileName) {
//        try {
//            FileOutputStream fileOut = new FileOutputStream(fileName);
//            ObjectOutputStream out = new ObjectOutputStream(fileOut);
//            out.writeObject(this);
//            out.close();
//            fileOut.close();
//            System.out.println("Bloom Filter serialized successfully and saved as " + fileName);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    public static BloomFilter deserialize(String fileName) {
//        BloomFilter bloomFilter = null;
//        try {
//            FileInputStream fileIn = new FileInputStream(fileName);
//            ObjectInputStream in = new ObjectInputStream(fileIn);
//            bloomFilter = (BloomFilter) in.readObject();
//            in.close();
//            fileIn.close();
//            System.out.println("Bloom Filter deserialized successfully from " + fileName);
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return bloomFilter;
//    }

    public static void main(String[] args) {
        BloomFilter bloomFilter = new BloomFilter(100, 3);
        bloomFilter.add("apple");
        bloomFilter.add("banana");

        System.out.println(bloomFilter.contains("apple")); // true
        System.out.println(bloomFilter.contains("orange")); // false
    }
}