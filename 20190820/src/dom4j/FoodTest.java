package dom4j;

import java.util.List;

/**
 * @author lz
 * @data 2019-08-20
 * @comment 描述
 */
public class FoodTest {
    public static void main(String[] args) {
        XmlUtil instance=XmlUtil.getInstance("F://food.xml");
        List<Food> foods = null;
        try {
            foods = instance.readXml(Food.class);
            for (Food food : foods) {
                System.out.println(food);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(foods.size());
    }
}
