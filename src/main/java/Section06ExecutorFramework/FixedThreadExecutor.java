package Section06ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for ( int i=0 ; i<10 ; i++ ) {
            executorService.execute(new Task(i));
        }
        executorService.shutdown();
    }
}

/*
Output
Task id = 1 running, thread id = 12
Task id = 2 running, thread id = 13
Task id = 0 running, thread id = 11
Task id = 3 running, thread id = 12
Task id = 4 running, thread id = 12
Task id = 5 running, thread id = 12
Task id = 6 running, thread id = 12
Task id = 7 running, thread id = 12
Task id = 8 running, thread id = 11
Task id = 9 running, thread id = 13
 */
