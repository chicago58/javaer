package com.wolf.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @Description Hibernate工具类
 * @Author wangqikang
 * @CreatedAt 2020-04-12 21:47
 **/
public class HibernateUtil {

    private static SessionFactory factory;

    // Hibernate把可预见的异常转成运行时异常
    static {
        try {
            Configuration cfg = new Configuration();
            cfg.configure();
            factory = cfg.buildSessionFactory();
        } catch (ExceptionInInitializerError e) {
            throw new ExceptionInInitializerError("初始化SessionFactory失败，请检查配置文件！");
        }
    }

    /**
     * 获取Session对象
     *
     * @return
     */
    public static Session openSession() {
        return factory.openSession();
    }
}
