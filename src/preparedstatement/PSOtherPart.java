package preparedstatement;

import com.mysql.cj.protocol.Resultset;
import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * ClassName: PSOtherPart
 * Package: preparedstatement
 * Description: 主键回显和主键值获取，
 * 批量插入数据优化
 * 事务回顾和设计转账类
 *
 * @Author 18797
 * @Create 2023/8/21 17:31
 * @Version 1.0
 */
public class PSOtherPart {
    static {


    }

    @Test
    public void test1() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useSSL=false&user=root&password=123456");
            String sql = "insert into t_user(account,password,nickname) values (?,?,?) ";
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setObject(1, "test");
            statement.setObject(2, "123456");
            statement.setObject(3, "张三");
            int i = statement.executeUpdate();
            if (i > 0) {
                rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    System.out.println(rs.getInt(1));
                }
            } else {
                System.out.println("插入失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            assert rs != null;
            rs.close();
            statement.close();
            connection.close();
        }


    }

    @Test
    public void testInsert10000() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useSSL=false&user=root&password=123456");
            String sql = "insert into t_user(account,password,nickname) values (?,?,?) ";
            statement = connection.prepareStatement(sql);
            long l = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {

                statement.setObject(1, "test" + i);
                statement.setObject(2, "123456" + i);
                statement.setObject(3, "张三" + i);
                statement.executeUpdate();
            }
            long l1 = System.currentTimeMillis();
            System.out.println(l1-l);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            statement.close();
            connection.close();
        }


    }

    @Test
    public void batchInsert() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useSSL=false&user=root&password=123456&rewriteBatchedStatements=true");
            String sql = "insert into t_user(account,password,nickname) values (?,?,?) ";
            statement = connection.prepareStatement(sql);
            long l = System.currentTimeMillis();
            for (int i = 10001; i < 20000; i++) {

                statement.setObject(1, "test" + i);
                statement.setObject(2, "123456" + i);
                statement.setObject(3, "张三" + i);
                statement.addBatch();
            }
            statement.executeBatch();
            long l1 = System.currentTimeMillis();
            System.out.println(l1-l);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            statement.close();
            connection.close();
        }

    }

    @Test
    public void transformed ()throws Exception{
         Class.forName("com.mysql.cj.jdbc.Driver");
         Connection connection= null;
         PreparedStatement statement = null;
         try {
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest?useSSL=false&user=root&password=123456");
             connection.setAutoCommit(false);
             String sql = "select * from t_user where account=? and password=?";
             statement = connection.prepareStatement(sql);
             statement.setObject(1,"admin");
             statement.setObject(2,"123456");
             ResultSet resultSet = statement.executeQuery();
             if (resultSet.next()) {
                 String userName = resultSet.getString("nickname");
                 System.out.println(userName);
             }
             connection.commit();
             resultSet.close();
         }catch (SQLException e) {
             e.printStackTrace();
             connection.rollback();
         }finally {
             statement.close();
             connection.close();
         }
    }
}
