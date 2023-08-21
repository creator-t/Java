package utils;

import java.util.Objects;

/**
 * ClassName: Person
 * Package: utils
 * Description:
 *
 * @Author 18797
 * @Create 2023/8/21 23:24
 * @Version 1.0
 */
public class Person {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String account;
    private String password;
    private String nickname;

    public Person() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(account, person.account) && Objects.equals(password, person.password) && Objects.equals(nickname, person.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, password, nickname);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
