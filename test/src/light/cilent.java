package light;

/**
 * @author lz
 * @data 2019-08-24
 * @comment 描述
 */
public class cilent {
    public static void main(String[] args) {
        light light=new light();
        Thread red=new Thread(new red(light));
        Thread yellow=new Thread(new yellow(light));
        Thread green=new Thread(new green(light));

        red.start();
        yellow.start();
        green.start();

    }
}
