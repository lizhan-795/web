import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author lz
 * @data 2019-09-11
 * @comment 描述
 */
public class log4j {
    private static Logger logger = LoggerFactory.getLogger(log4j.class);

    public int add(int num1,int num2){
        logger.debug("执行求和的方法：{} + {}",num1,num2);
        return num1 + num2;
    }
}
