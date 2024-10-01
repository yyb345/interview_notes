package rateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RateLimiterTest {

    public static void main(String[] args){

        RateLimiter rateLimiter = new RateLimiter(5, 10,1, TimeUnit.SECONDS);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(new Runnable() {
            @Override
            public void run() {

                ThreadLocal<Integer> num = new ThreadLocal<>();
                num.set(0);
                while(true){
                    if(rateLimiter.tryAcquire()){
                        try {
                            System.out.println(String.format("Thread %s call num %d","1",num.get()));
                            num.set(num.get()+1);
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
//                        System.out.println(String.format("Thread %s miss","1"));
                    }
                }


            }
        });


//        executorService.submit(new Runnable() {
//            @Override
//            public void run() {
//                ThreadLocal<Integer> num = new ThreadLocal<>();
//                num.set(0);
//
//                while(true){
//                    if(rateLimiter.tryAcquire()){
//                        try {
//                            System.out.println(String.format("Thread %s call num %d","2",num.get()));
//                            num.set(num.get()+1);
//                            Thread.sleep(500);
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }else {
////                        System.out.println(String.format("Thread %s miss","2"));
//                    }
//                }
//
//            }
//        });


        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdownNow();

    }
}
