package com.wolf.hibernate;

import com.wolf.domain.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


/**
 * @Description 需求：保存一个客户到数据库
 * @Author wangqikang
 * @CreatedAt 2020-04-12 14:09
 **/
public class StartedDemo {
    private static SessionFactory factory;
    private static Session session;
    private static Transaction tx;

    public static void main(String[] args) {
        try {
            // 创建Configuration实例
            Configuration conf = new Configuration();
            // 加载默认位置、默认名称的主配置文件（默认位置是根路径、默认名称是hibernate.cfg.xml）
            conf.configure();

//        conf.addResource("com/wolf/domain/Customer.hbm.xml");// 添加映射文件的配置
//        conf.addClass(Customer.class);// 添加映射文件配置（配置名称与类名称一致）

            // 创建SessionFactory，并将Configuration对象的所有配置拷贝到SessionFactory内存
            factory = conf.buildSessionFactory();

            // SessionFactory创建Session
            session = factory.openSession();

            // 开启事务
            tx = session.beginTransaction();

            // 执行操作
            Customer c = new Customer();
            c.setCustName("商品名01");
            session.save(c);

            // 提交事务
            tx.commit();
        } catch (Exception e) {
            // 释放资源
            session.close();
            factory.close();
        }
    }
}
