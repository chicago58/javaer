package com.wolf.hibernate;

import com.wolf.domain.Customer;
import com.wolf.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @Description TODO
 * @Author wangqikang
 * @CreatedAt 2020-04-16 07:58
 **/
public class QueryCompareDemo {

    /**
     * Hibernate查询一个记录的方法
     * get(Class clazz, Serializable id);
     * load(Class clazz, Serializable id);
     * <p>
     * 两者比较
     * 共同点：都是根据id查询一个实体
     * 区别：
     * 1、查询时机不同
     * get()：调用时发起查询（立即加载）
     * load()：使用时发起查询（延迟加载、懒加载、惰性加载）
     * <p>
     * 2、返回结果不同
     * get()返回对象实体类
     * load()返回对象实体类的代理对象
     *
     * load()默认情况下延迟加载，可以通过配置的方式改为立即加载。
     *
     * @param args
     */
    public static void main(String[] args) {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();

        Customer customer1;
        Customer customer2;

//        customer1 = session.get(Customer.class, 1L);
        customer2 = session.load(Customer.class, 1L);

//        System.out.println(customer1);
        System.out.println(customer2);

        transaction.commit();
        session.close();
    }
}

/**
 * 搭建hibernate开发环境 写映射配置文件、主配置文件
 * CRUD 查询一个  查询所有
 *
 */
