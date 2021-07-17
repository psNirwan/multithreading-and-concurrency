package Section07Collections;

import java.util.ArrayList;
import java.util.List;

public class ListExample {

    public static void main(String[] args) throws InterruptedException {

        List<Integer> integerList = new ArrayList<>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for ( int i=0 ; i<1000 ; i++ ) {
                    integerList.add(i);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for ( int i=0 ; i<1000 ; i++ ) {
                    integerList.add(i);
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

/*
Output :
Exception in thread "Thread-0" java.lang.ArrayIndexOutOfBoundsException: 163
	at java.util.ArrayList.add(ArrayList.java:465)
	at Section07Collections.ListExample$1.run(ListExample.java:15)
	at java.lang.Thread.run(Thread.java:748)
 */
