package com.learn.test;

import com.learn.dao.AccountDao;
import com.learn.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    /**
     * 测试查询
     * @throws Exception
     */
    @Test
    public void testFindAll() throws Exception {
        //1.加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.创建session
        SqlSession session = factory.openSession();

        //4.获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //5.查询
        List<Account> accounts = dao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }

        //释放资源
        session.close();
        in.close();
    }

    @Test
    public void testSaveAccount() throws Exception {
        //1.加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //3.创建session
        SqlSession session = factory.openSession();

        //4.获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);

        Account account = new Account();
        account.setName("史睿生");
        account.setMoney(3000d);

        dao.saveAccount(account);
        session.commit();

        //释放资源
        session.close();
        in.close();

    }

}
