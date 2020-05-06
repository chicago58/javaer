package com.wolf.hibernate;

import com.wolf.domain.Customer;
import com.wolf.utils.HibernateUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @Description Hibernate的CRUD
 * @Author wangqikang
 * @CreatedAt 2020-04-12 21:47
 **/
public class CrudDemo {

    private static Session session = null;
    private static Transaction transaction = null;

    /**
     * 增
     */
    public static void save() {
        try {
            session = HibernateUtil.openSession();
            transaction = session.beginTransaction();

            Customer customer = new Customer();
            customer.setCustName("测试保存功能");

            session.save(customer);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    /**
     * 查
     */
    public static void findOne() {
        try {
            session = HibernateUtil.openSession();
            transaction = session.beginTransaction();

            Customer customer = (Customer) session.get(Customer.class, 2L);
            System.out.println(customer);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    /**
     * 改
     */
    public static void update() {

        try {
            session = HibernateUtil.openSession();
            transaction = session.beginTransaction();

            Customer customer = (Customer) session.get(Customer.class, 1L);
            customer.setCustAddress("上海市宝山区");
            // 执行更新
            session.update(customer);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    /**
     * 删
     */
    public static void delete() {

        try {
            session = HibernateUtil.openSession();
            transaction = session.beginTransaction();

            Customer customer = (Customer) session.get(Customer.class, 2L);
            session.delete(customer);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    /**
     * 查询所有
     */
    public static void findAll() {
        try {
            session = HibernateUtil.openSession();
            transaction = session.beginTransaction();

            // 使用Session对象获取查询对象Query
            SQLQuery sqlQuery = session.createSQLQuery("select * from cst_customer");
            // 使用SQLQuery对象获取结果集
            List<Object[]> list = sqlQuery.list();
            for (Object[] os : list) {
                System.out.println("数组中的内容：");
                for (Object o : os) {
                    System.out.println(o);
                }
            }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }

    }

    public static void main(String[] args) {
//        save();

//        findOne();

//        update();

//        delete();

//        findAll();
    }
}
