import java.io.File;
import java.util.Scanner;

/**
 * @author lz
 * @data 2019-08-16
 * @comment 描述
 */
public class delete {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.println("请输入要删除的文件夹地址：");
        String path =input.next();
        File file =new File(path);
        File[] files = file.listFiles();
        for (File file01 : files) {
            if(file01.isFile()){
                file01.delete();
            }else{
                delete(file01);
            }
        }
        file.delete();
        System.out.println("删除成功！");
    }

    public static void delete(File file){
        for (File file01 : file.listFiles()) {
            if(file01.isFile()) {
                file01.delete();
            } else{
                delete(file01);
            }
            }
            file.delete();
        }
}
