package model;

import java.io.Serializable;
import java.util.List;
/**
 * Created by 123 on 2017/06/29.
 */
public class Person implements Serializable {
    private Integer id;
    private String userName;
    private Integer age;
    private String mobilePhone;
    private List<Son> sons;

    public List<Son> getSons() {
        return sons;
    }

    public void setSons(List<Son> sons) {
        this.sons = sons;
    }

    public Person() {
    }

    public Person(Integer id, String userName, Integer age, String mobilePhone) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.mobilePhone = mobilePhone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
