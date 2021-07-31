import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCondition implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();


    @Override
    public void run() {
        try{
            lock.lock();
            condition.await();
            System.out.println("Thread is running");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException{
        ReentrantLockCondition reentrantLockCondition = new ReentrantLockCondition();
        Thread t1 = new Thread(reentrantLockCondition);
        t1.start();
        Thread.sleep(5000);
        lock.lock();
        condition.signal();
        Thread.sleep(5000);
        lock.unlock();

    }

}
