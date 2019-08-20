import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lz
 * @data 2019-08-16
 * @comment 描述
 */
public class cut {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.println("请输入要剪切的文件地址：");
        String origin=input.next();
        System.out.println("请输入要剪切到的地址：");
        String dest=input.next();
        System.out.println(cut(origin,dest)?"剪切成功":"剪切失败！文件不存在!");
    }

    public static boolean cut(String origin,String dest){
        try {
            File file = new File(origin);
            if(file.exists()) {
                Reader reader = new FileReader(file);
                List<Character> list = new ArrayList<Character>();
                int i = -1;
                while ((i = reader.read()) != -1) {
                    char c = (char) i;
                    list.add(c);
                }
                reader.close();
                Writer writer = new FileWriter(dest);
                for (Character character : list) {
                    writer.write(character);
                }
                writer.close();
                file.delete();
                return true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
