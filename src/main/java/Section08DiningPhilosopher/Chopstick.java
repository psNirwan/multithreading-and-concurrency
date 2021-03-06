package Section08DiningPhilosopher;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {

    private Lock lock;
    private int id;

    public Chopstick( int id) {
        this.lock = new ReentrantLock();
        this.id = id;
    }

    public boolean pickUp(Philosopher philosopher, State state) throws InterruptedException{
        if( this.lock.tryLock(10, TimeUnit.MILLISECONDS)){
            System.out.println(philosopher+" picked up "+state.toString()+" "+this);
            return true;
        }
        return false;
    }

    public void putDown(Philosopher philosopher, State state) {
        this.lock.unlock();
        System.out.println(philosopher+" put down "+this);
    }

    @Override
    public String toString() {
        return "Chopstick-"+this.id;
    }
}
