package light;

/**
 * @author lz
 * @data 2019-08-19
 * @comment 描述
 */
public class test {
    public static void main(String[] args) {
        Light light =new Light();
        Thread t1=new Thread(new Red(light));
        Thread t2=new Thread(new Yellow(light));
        Thread t3=new Thread(new Green(light));

        t1.start();
        t2.start();
        t3.start();
    }
}
