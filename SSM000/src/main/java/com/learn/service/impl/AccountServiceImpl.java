package com.learn.service.impl;

import com.learn.dao.AccountDao;
import com.learn.domain.Account;
import com.learn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    /*
        service能成功调用dao对象就算整合成功
            ？dao是一个接口，代理对象也是执行时生成的，怎么放到容器中呢？
                ？代理对象 配置
                ？存到容器

            测试类中 我们可以 手动加载 SqlMapConfig，手动创建factory session 代理对象

     */

    @Autowired
    private AccountDao dao;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层：查询所有账户");
        return dao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层：保存账户");
        dao.saveAccount(account);
    }
}
