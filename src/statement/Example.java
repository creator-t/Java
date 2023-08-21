package statement;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * ClassName: statement.Example
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 18797
 * @Create 2023/8/21 0:04
 * @Version 1.0
 */
public class Example {

    static String url = "jdbc:mysql://localhost:3306/jdbctest?useSSL=false&serverTimezone=Asia/Shanghai&use";
    static String username = "root";
    static String password = "123456";

    public static void main(String[] args) throws Exception {
        //1.注册驱动程序
        DriverManager.registerDriver(new Driver());
        //2.获取Connection连接
        Connection connection = DriverManager.getConnection(url, username, password);
        //3.创建statement
        Statement statement = connection.createStatement();
        //4.发送sql语句，并且获取返回结果
        String sqlQuery = "SELECT * FROM t_user";
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        //5.进行结果集解析
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String account = resultSet.getString("account");
            String password1 = resultSet.getString("password");
            String nickname = resultSet.getString("nickname");
            System.out.println("id:" + id + ", account:" + account + ", password1:" + password1 + ", nickname " + nickname);
        }
        ;

        //6.关闭连接
        resultSet.close();
        statement.close();
        connection.close();

    }

}
