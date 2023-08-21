package statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 * ClassName: statement.StatementUserLoginPart
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author 18797
 * @Create 2023/8/21 0:32
 * @Version 1.0
 */
public class StatementUserLoginPart {
    static String url = "jdbc:mysql://localhost:3306/jdbctest?useSSL=false&serverTimezone=Asia/Shanghai&use";
    static String username = "root";
    static String password = "123456";

    public static void main(String[] args) throws Exception {
        //获取账号和密码
        Scanner in = new Scanner(System.in);
        System.out.println("请输入账号");
        String account = in.nextLine();
        System.out.println("请输入密码");
        String password1 = in.nextLine();
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //连接
        Connection connection = DriverManager.getConnection(url, username, password);
        //sql语句
        String sql = "select password from t_user where account = " + "'" + account + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        //处理结果集
        if (resultSet.next()) {
            String password2 = resultSet.getString("password");
            if (password2.equals(password1)) {
                System.out.println("登录成功");
            } else {
                System.out.println("密码错误");

            }
        }else {
            System.out.println("账号不存在");
        }
        //关闭连接
        resultSet.close();
        statement.close();
        connection.close();


    }
}
