package com.zale.admin.controller;

import com.zale.admin.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Slf4j
@Controller
public class IndexController {


    /**
     * come to Login Page
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){

        return "login";
    }


    /**
     * redirect to main page
     * @param
     * @param
     * @return
     */
    @PostMapping("/login")
    public String main(User user, HttpSession httpSession, Model model) {
        if (StringUtils.hasLength(user.getUserName()) && "123456".equals(user.getPassword())) {

            httpSession.setAttribute("loginUser", user);

            return "redirect:/main.html";
        }
        else {
            model.addAttribute("msg", "UserName or password incorrect");
            return "login";
        }

    }

    /**
     * main page, in case of form repeat submit
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {

        log.info("当前方法是：{}","mainPage");
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser != null) {
            return "main";
        }
        else {
            model.addAttribute("msg", "re-login");
            return "login";
        }

       // return "main";
    }

}
