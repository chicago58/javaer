package com.wolf.hibernate;

import com.wolf.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Description TODO
 * @Author wangqikang
 * @CreatedAt 2020-04-15 22:55
 **/
public class C3P0Connection {

    /**
     * Hibernate中使用原生JDBC API
     * JDBC API包括：Connection、Statement、PreparedStatement、ResultSet
     *
     * @param args
     */
    public static void main(String[] args) {
        // 获取Session对象
        Session session = HibernateUtil.openSession();

        // 调用doWork()方法
        session.doWork(new Work() {
            public void execute(Connection connection) throws SQLException {
                System.out.println(connection.getClass().getName());
            }
        });
    }
}
