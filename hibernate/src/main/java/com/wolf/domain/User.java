package com.wolf.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description 联系人实体类
 * @Author wangqikang
 * @CreatedAt 2020-04-16 07:26
 **/
@Entity // 表明该类是实体类
@Table(name = "cst_user") // 建立当前类和数据库表的映射关系
public class User implements Serializable {
    /**
     * 使用注解都是JPA规范，所以导入javax.persistence包
     */

    @Id // 表明当前字段为主键
    @Column(name = "id") // 表明数据库主键字段
    // 指定主键生成策略。strategy：使用JPA提供的主键生成策略。generator：使用Hibernate的主键生成策略。
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    public User(Long id, String username, String password, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.address = address;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
