package utils;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * ClassName: JdbcCurdPart
 * Package: utils
 * Description:
 *
 * @Author 18797
 * @Create 2023/8/21 22:28
 * @Version 1.0
 */
public class JdbcCurdPart {

    @Test
    public void testSelect() throws Exception{
        Connection connection = JdbcUtils.getConnection();
        ThreadLocal<Connection> local = new ThreadLocal<>();
        local.set(connection);
        connection.setAutoCommit(false);
        PreparedStatement statement = connection.prepareStatement("select * from t_user where id = ?");
        statement.setInt(1, 1);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
        connection.commit();
        resultSet.close();
        statement.close();
        JdbcUtils.freeConnection(connection);

    }
}
