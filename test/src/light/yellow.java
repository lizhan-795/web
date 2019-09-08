package light;

import java.net.HttpRetryException;

/**
 * @author lz
 * @data 2019-08-24
 * @comment 描述
 */
public class yellow implements Runnable {
    private light light;

    public yellow(light light) {
        this.light = light;
    }

    @Override
    public void run() {
        while(true){
            light.yellow();
        }
    }
}
