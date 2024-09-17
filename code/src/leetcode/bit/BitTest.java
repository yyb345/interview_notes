package leetcode.bit;

import java.util.BitSet;

public class BitTest {

    public static void main(String[] args) {
        BitSet bitSet=new BitSet(256);
        bitSet.set(7);
        bitSet.set(8);
        bitSet.set(65);

        bitSet.get(8);

        System.out.println(65>>6);
//        System.out.println(1<<8);
//        System.out.println(1<<7 | 1<<8);

    }
}
