package test3;

/**
 * @author lz
 * @data 2019-08-24
 * @comment 描述
 */
public class Productor implements Runnable{
    private repo repo;

    public Productor(repo repo) {
        this.repo = repo;
    }

    @Override
    public void run() {
        while(true){
            repo.product();
        }
    }
}
