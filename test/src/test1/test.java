package test1;

/**
 * @author lz
 * @data 2019-08-24
 * @comment 描述
 */
public class test {
    public static void main(String[] args) {
       cilent cilent=new cilent();
        Thread t1=new Thread(new add(cilent));
        Thread t2=new Thread(new add(cilent));
        Thread t3=new Thread(new subtract(cilent));
        Thread t4=new Thread(new subtract(cilent));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
