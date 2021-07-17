package Section06ExecutorFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for ( int i=0 ; i<5 ; i++ ) {
            executorService.execute(new Task(i));
        }
        executorService.shutdown();
    }
}

/*
Output
Task id = 0 running, thread id = 11
Task id = 1 running, thread id = 11
Task id = 2 running, thread id = 11
Task id = 3 running, thread id = 11
Task id = 4 running, thread id = 11
 */
