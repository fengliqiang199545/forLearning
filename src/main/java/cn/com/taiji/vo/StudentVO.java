package cn.com.taiji.vo;

import cn.com.taiji.pojo.Class;

/**
 * @author fengliqiang
 * @date 2019/03/13/3:10 PM
 **/
public class StudentVO {
    private Integer id;

    private String name;

    private String email;

    private String password;

    private Class aClass;

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "StudentVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", aClass=" + aClass +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }
}
