package test3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lz
 * @data 2019-08-24
 * @comment 描述
 */
public class repo{
    private final int capability=3;
    private int count;
//    private Lock lock=new ReentrantLock();
//    private Condition customerCondition = lock.newCondition();
//    private Condition productorCondition=lock.newCondition();

    public synchronized void product(){
        try {
//            lock.lock();
            while(count>=capability) {
                System.out.println("桌子上蛋糕已满，请等待！");
                wait();
             }
            System.out.println(Thread.currentThread().getName()+"生产了一个蛋糕，桌上有"+(++count)+"个蛋糕");
//            customerCondition.signal();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
           }
           notifyAll();
// finally {
//            lock.unlock();
//        }
    }

    public synchronized void customer(){
        try {
//            lock.lock();
            while(count<=0){
                System.out.println("桌上暂时没有蛋糕，请等待！");
                wait();
//              customerCondition.await();
            }
            System.out.println(Thread.currentThread().getName()+"吃了一个蛋糕，桌上还剩"+(--count)+"个蛋糕");
//            productorCondition.signal();
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyAll();
//        finally {
//            lock.unlock();
//        }
    }
}
