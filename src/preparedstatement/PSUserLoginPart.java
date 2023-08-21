package preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 * ClassName: PSUserLoginPart
 * Package: preparedstatement
 * Description:
 *
 *
 *
 * @Author 18797
 * @Create 2023/8/21 12:22
 * @Version 1.0
 */
public class PSUserLoginPart {
    static String url = "jdbc:mysql://localhost:3306/jdbctest?useSSL=false&serverTimezone=Asia/Shanghai&use";
    static String username = "root";
    static String password = "123456";

    public static void main(String[] args) throws Exception {
        // 获取账号和密码
        Scanner in = new Scanner(System.in);
        System.out.println("请输入账号");
        String account = in.nextLine();
        System.out.println("请输入密码");
        String password1 = in.nextLine();
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取连接
        Connection connection = DriverManager.getConnection(url, username, password);
        // 创建预编译语句
        PreparedStatement preparedStatement = connection.prepareStatement("select password from t_user where account = ?");
        // 设置参数
        preparedStatement.setString(1, account);
        ResultSet resultSet = preparedStatement.executeQuery();
        // 处理结果集
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
        // 关闭连接
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }


}
