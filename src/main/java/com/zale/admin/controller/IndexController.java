package com.zale.admin.controller;

import com.zale.admin.bean.Account;
import com.zale.admin.bean.City;
import com.zale.admin.bean.User;
import com.zale.admin.service.AccountService;
import com.zale.admin.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
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

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountService accountService;

    @Autowired
    CityService cityService;


    /**
     * come to Login Page
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){

        return "login";
    }

    @ResponseBody
    @PostMapping("/city")
    public City saveCity(City city){

        cityService.saveCity(city);
        return city;
    }

    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id") Long id){
        return cityService.getById(id);
    }

    @ResponseBody
    @GetMapping("/acct")
    public Account getById(@RequestParam("id") Long id){

        return accountService.getAcctByid(id);
    }

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from account_tbl", Long.class);
        return aLong.toString();
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
