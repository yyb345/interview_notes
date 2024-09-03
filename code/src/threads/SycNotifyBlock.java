package threads;

public class SycNotifyBlock implements Runnable{


    Object lock;

    SycNotifyBlock(Object lock){
        lock = lock;
    }
    @Override
    public void run() {
        synchronized (lock){
            lock.notify();
        }

    }
}
