package utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: BaseDao
 * Package: utils
 * Description: 封装了update和query
 *
 * @Author 18797
 * @Create 2023/8/21 23:14
 * @Version 1.0
 */
public class BaseDao {

    public static int executeUpdate(String sql, Object... params) {
        int i = 0;
        try {
            Connection connection = JdbcUtils2.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            for (; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            i = statement.executeUpdate();

            statement.close();
            if (connection.getAutoCommit()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return i;

    }

    public static <T> List<T> executeQuery(String sql, Class<T> clazz, Object... params) {
        List<T> list = null;
        try {
            Connection connection = JdbcUtils2.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            ResultSet resultSet = statement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            list = new ArrayList<>();
            while (resultSet.next()) {
                T t = clazz.getConstructor().newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Field field = clazz.getDeclaredField(metaData.getColumnName(i + 1));
                    Object object = resultSet.getObject(metaData.getColumnName(i + 1));
                    field.setAccessible(true);
                    field.set(t, object);
                }
                list.add(t);
            }
            statement.close();
            if (connection.getAutoCommit()) {
                connection.close();
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
        return list;

    }
}
