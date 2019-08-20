package dom4j;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lz
 * @data 2019-08-20
 * @comment 描述
 */
public class Food {
    private String name;
    private BigDecimal price;
    private Integer count;
    private Date date;

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", date=" + date +
                '}';
    }

    public Food() {
    }

    public Food(String name, BigDecimal price, Integer count, Date date) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
