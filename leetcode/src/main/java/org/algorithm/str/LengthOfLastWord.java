package org.algorithm.str;

/**
 * 58
 * 最后一个单词的长度
 */
public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {

        int len=0;
        int h=s.length()-1;
        while(h>=0 && s.charAt(h)==' ') {h--;}

        while (h>=0){
            if(s.charAt(h)!=' '){
                len++;
            }else {
                break;
            }
            h--;
        }

        return len;
    }

    public static void main(String[] args) {

       // "Hello World"
       // "   fly me   to   the moon  "
       // "luffy is still joyboy"
       // "a"
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
        System.out.println(lengthOfLastWord("a"));
    }
}
