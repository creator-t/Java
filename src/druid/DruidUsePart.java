package druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import javax.sql.PooledConnection;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ClassName: DruidUsePart
 * Package: druid
 * Description:
 *
 * @Author 18797
 * @Create 2023/8/21 20:16
 * @Version 1.0
 */
public class DruidUsePart {

    @Test
    public void testHard() {
        //实例化一个druid数据源
        DruidDataSource dataSource = new DruidDataSource();

        //设置参数
        //必须 连接数据库的jdbc的全类名 url user password
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///jdbctest");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //非必须 初始化连接池 最大连接数
        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);


    }

    @Test
    public void testSoft() throws Exception {
        Properties properties = new Properties();
        InputStream inputStream = DruidUsePart.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(inputStream);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);


    }


}
