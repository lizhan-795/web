package dom4j;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author lz
 * @data 2019-08-20
 * @comment 描述
 */
public class writeTest {
    public static void main(String[] args) {
        final String PATH = "F://food.xml";
        XmlUtil instance = XmlUtil.getInstance(PATH);
        try {
            List<Food> foods = instance.readXml(Food.class);
            //foods.stream().forEach(System.out::println);  //方法引用
            foods.add(new Food("test1", new BigDecimal(30), 1, new Date()));
            foods.add(new Food("test2", new BigDecimal(20), 1, new Date()));
            foods.add(new Food("test3", new BigDecimal(15), 1, new Date()));
            foods.add(new Food("test4", new BigDecimal(10), 1, new Date()));

            foods.stream().forEach(t-> System.out.println(t));
            instance.writeXml(foods);
            System.out.println("输出文件完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
