package light;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lz
 * @data 2019-08-24
 * @comment 描述
 */
public class light {
    private int state=1;
    private final Lock lock=new ReentrantLock();
    private Condition redCondition =lock.newCondition();
    private Condition yellowCondition= lock.newCondition();
    private Condition greenCondition=lock.newCondition();

    public void red(){
            try {
                lock.lock();
                while(state!=1){
                    redCondition.await();
                }
                for (int i = 0; i <5 ; i++) {
                    System.out.println(Thread.currentThread().getName()+":红灯亮下"+(i+1)+"下");
                    Thread.sleep(500);
                }
                state=2;
                yellowCondition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
    }

    public void yellow(){
        try {
            lock.lock();
            while(state!=2){
                yellowCondition.await();
            }
            for (int i = 0; i <3 ; i++) {
                System.out.println(Thread.currentThread().getName()+":黄灯亮下"+(i+1)+"下");
                Thread.sleep(500);
            }
            state=3;
            greenCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void green(){
        try {
            lock.lock();
            while(state!=3){
                greenCondition.await();
            }
            for (int i = 0; i <5 ; i++) {
                System.out.println(Thread.currentThread().getName()+":绿灯亮下"+(i+1)+"下");
                Thread.sleep(500);
            }
            state=1;
            redCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
