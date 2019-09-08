package test3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.Executors.*;

/**
 * @author lz
 * @data 2019-08-24
 * @comment 描述
 */
public class cilent {
    public static void main(String[] args) {
        repo repo=new repo();
//        ScheduledExecutorService pool= newScheduledThreadPool(4);
        Thread t1=new Thread(new Customer(repo),"顾客1");
        Thread t2=new Thread(new Customer(repo),"顾客2");
        Thread t3=new Thread(new Productor(repo),"厨师1");
        Thread t4=new Thread(new Productor(repo),"厨师2");
//        pool.execute(t1);
//        pool.execute(t2);
//        pool.execute(t3);
//        pool.execute(t4);
//        pool.shutdown();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
