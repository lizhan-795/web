package test1;

/**
 * @author lz
 * @data 2019-08-24
 * @comment 描述
 */
public class cilent {
    private static int sum;

    public synchronized void add(){
            sum++;
            System.out.println(Thread.currentThread().getName()+"已加1："+sum);
        try {
            notifyAll();
            wait();
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized  void subtract(){
        sum--;
        System.out.println(Thread.currentThread().getName()+"已减1："+sum);
        try {
            notifyAll();
            wait();
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
