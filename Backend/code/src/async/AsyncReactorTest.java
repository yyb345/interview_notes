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

    public void print111(Integer value){
        System.out.println(value);
    }

    @Test
    public void asyncTest(){

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
}
