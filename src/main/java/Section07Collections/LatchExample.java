package Section07Collections;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LatchExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for ( int i=0 ; i<4 ; i++ ) {
            executorService.execute(new Worker(i,countDownLatch));
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Processing completed...");

        executorService.shutdown();
    }

}

/*

Output :
Id = 0 started working...
Id = 1 started working...
Id = 2 started working...
Id = 3 started working...
Id = 4 started working...
Processing completed...

If countDownLatch.await() is commented, then output :
Processing completed...
Id = 0 started working...
Id = 1 started working...
Id = 2 started working...
Id = 3 started working...
Id = 4 started working...

So, main method is blocked until the countDownLatch.countDown() is called 5 times
Try changing the loop limit to 4 and observe

 */
