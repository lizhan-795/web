package light;

/**
 * @author lz
 * @data 2019-08-24
 * @comment 描述
 */
public class red implements Runnable {
    private light light;

    public red(light light) {
        this.light = light;
    }

    @Override
    public void run() {
        while(true){
            light.red();
        }
    }
}
