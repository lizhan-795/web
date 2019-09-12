import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author lz
 * @data 2019-09-11
 * @comment 描述
 */
public class sqltest {
    private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123";

    public static void main(String[] args) {

        try {
            Class.forName(DRIVER);

            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            Statement statement = connection.createStatement();

            String insert_sql = "insert into teacher (tid,tname) value(4,'赵四')";

            int i = statement.executeUpdate(insert_sql);

            System.out.println(i>0 ?"成功":"失败");

            statement.close();
            connection.close();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
