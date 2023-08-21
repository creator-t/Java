package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ClassName: JdbcUtils2
 * Package: utils
 * Description: 实现事务
 *
 * @Author 18797
 * @Create 2023/8/21 22:43
 * @Version 2.0
 */
public class JdbcUtils2 {

    private static DataSource dataSource = null;

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    static {
        Properties properties = new Properties();
        InputStream inputStream = utils.JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {

        if (threadLocal.get() == null) {
            threadLocal.set(dataSource.getConnection());
        }
        return threadLocal.get();

    }

    public static void freeConnection(Connection connection) throws SQLException {
        if (threadLocal.get() != null) {
            threadLocal.remove();
        }
        connection.setAutoCommit(true);
        connection.close();

    }
}