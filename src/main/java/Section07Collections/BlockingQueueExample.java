package Section07Collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

    public static void main(String[] args) {

        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);
        FirstWorker firstWorker = new FirstWorker(blockingQueue);
        SecondWorker secondWorker = new SecondWorker(blockingQueue);

        new Thread(firstWorker).start();
        new Thread(secondWorker).start();
    }

}

class FirstWorker implements Runnable{

    private BlockingQueue<Integer> blockingQueue;

    public FirstWorker(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        int counter = 1;
        while (true) {
            try {
                blockingQueue.put(counter);
                System.out.println("putting items in the queue... " + counter);
                counter++;
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class SecondWorker implements Runnable{

    private BlockingQueue<Integer> blockingQueue;

    public SecondWorker(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer counter = blockingQueue.take();
                System.out.println("taking items from the queue... " + counter);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/*
Output :
putting items in the queue... 1
taking items from the queue... 1
putting items in the queue... 2
putting items in the queue... 3
putting items in the queue... 4
putting items in the queue... 5
putting items in the queue... 6
putting items in the queue... 7
putting items in the queue... 8
putting items in the queue... 9
putting items in the queue... 10
putting items in the queue... 11
taking items from the queue... 2
putting items in the queue... 12
taking items from the queue... 3
putting items in the queue... 13

Logic :
maximum insert allowed is 10, we consume slower than producing,
hence, putting item is printed from 2 to 11 in a go.
 */
