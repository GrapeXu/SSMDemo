package com.learn.controller;

import com.learn.domain.Account;
import com.learn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * web层
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    /*
        这里能调用 service 就算 springmvc 和 spring整合成功了
        这里启动方式是 tomcat，web.xml只配置了加载springmvc.xml，别的不扫描

        加载springConfig.xml
     */

    @Autowired
    private AccountService accountService;


    @RequestMapping("/findAll")
    public String findAll(Model model) {
        System.out.println("表现层：查询所有账户信息");
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);//存到域对象里
        return "list";//跳到list.jsp
    }

    @RequestMapping("/saveAccount")
    public void saveAccount(Model model, Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("表现层：保存账户");
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");//保存完就去查
        return;
    }

}













