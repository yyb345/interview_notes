package async;

import org.apache.spark.sql.sources.In;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.util.*;

public class AsyncReactorTest {

    private static List<String> words = Arrays.asList(
            "the",
            "quick",
            "brown",
            "fox",
            "jumped",
            "over",
            "the",
            "lazy",
            "dog"
    );

    void print111(Integer value){
        System.out.println(value);
    }

    @Test
    public void asyncTest(){
//        Flux<String> fewWords = Flux.just("Hello", "World");
//        Flux<String> manyWords = Flux.fromIterable(words);
//
//        //fewWords.subscribe(System.out::println);
//        //System.out.println();
//        manyWords.subscribe(print111());

        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5);

        flux
                .map(number -> number * 2)
                .filter(result -> result > 5)
                .subscribe(
                        value -> print111(value),
                        error -> System.err.println("发生错误: " + error),
                        () -> System.out.println("处理完成")
                );
    }

    String xxx(String[] strs){
        int index = 10;
        return strs[0].substring(0,index+1);
    }

    public static String longestCommonPrefix (String[] strs) {
        // write code here

        if(strs==null){
            return null;
        }

        if(strs.length==1){
            return strs[0];
        }

        //
        int index=0;
        char currentChar;
        boolean stop = false;
        while(index<strs[0].length() &&  !stop ){

            currentChar= strs[0].charAt(index);
            for(int i=1;i<strs.length;i++){

                if(index==strs[i].length()){
                    stop = true;
                    break;
                }
                if(currentChar!=strs[i].charAt(index)){
                    stop = true;
                    break;
                }

            }

            if(stop || index==strs[0].length()){
                break;
            }
            index++;
        }


        return strs[0].substring(0,index);
    }

    @Test
    public void strTest(){

//        Map<Character,Integer> map = new HashMap<>();
//        for(int i=0;i<windowSize && (i+startIndex)<s.length();i++){
//            char cc = s.charAt(i+startIndex);
//            if(!map.containsKey(cc)){
//                return false;
//            }
//            map.put(cc,map.get(cc)-1);
//        }
//
//        for(Map.Entry<Character,Integer> entry:map.entrySet()){
//            if(entry.getValue()!=0){
//                return false;
//            }
//        }

    }
}
