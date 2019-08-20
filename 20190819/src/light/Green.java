package light;

/**
 * @author lz
 * @data 2019-08-19
 * @comment 描述
 */
public class Green implements Runnable {
    private Light light;

    public Green(Light light) {
        this.light = light;
    }

    @Override
    public void run() {
        while (true){
            light.green();
        }
    }
}
