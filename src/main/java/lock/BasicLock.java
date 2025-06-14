package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BasicLock {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Runnable task = () -> {
            lock.lock();

            try {
                System.out.println(Thread.currentThread().getName() + " acquired lock! ");
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                System.out.println(Thread.currentThread().getName() + " releasing lock! ");
                lock.unlock();
            }
        };

        new Thread(task, "Thread - 1").start();
        new Thread(task, "Thread - 2").start();
    }
}
