package light;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lz
 * @data 2019-08-19
 * @comment 描述
 */
public class Light {
    private int state =1;
    private final Lock lock =new ReentrantLock();
    private Condition Redcondition = lock.newCondition();
    private Condition Yellowcondition = lock.newCondition();
    private Condition Greencondition = lock.newCondition();

    public void red(){
        try {
            lock.lock();
            while(state!=1){
                Redcondition.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println("红灯亮"+(i+1)+"次");
                Thread.sleep(1000);
            }
            state=2;
            Yellowcondition.signal();
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
                Yellowcondition.await();
            }
            for (int i = 0; i < 4; i++) {
                System.out.println("黄灯亮"+(i+1)+"次");
                Thread.sleep(1000);
            }
            state=3;
            Greencondition.signal();
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
                Greencondition.await();
            }
            for (int i = 0; i < 3; i++) {
                System.out.println("绿灯亮"+(i+1)+"次");
                Thread.sleep(1000);
            }
            state=1;
            Redcondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
