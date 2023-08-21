package utils;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * ClassName: Dao
 * Package: utils
 * Description:
 *
 * @Author 18797
 * @Create 2023/8/21 23:27
 * @Version 1.0
 */
public class Dao extends BaseDao{
    @Test
    public void update(){
        int i = executeUpdate("update t_user set account = '小黄' where account = ?", "admin");
        System.out.println(i);
    }
    @Test
    public void query() {
        List<Person> people = executeQuery("select * from t_user where account = ?", Person.class, "root");
        System.out.println(people);
    }




}
