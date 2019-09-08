package test1;

/**
 * @author lz
 * @data 2019-08-24
 * @comment 描述
 */
public class subtract implements Runnable {
    private cilent cilent;

    public subtract(test1.cilent cilent) {
        this.cilent = cilent;
    }

    @Override
    public void run() {
        while (true){
            cilent.subtract();
        }
    }
}
