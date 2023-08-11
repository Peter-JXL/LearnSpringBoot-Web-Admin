package com.peterjxl.learnspringbootwebadmin.controller;


import com.peterjxl.learnspringbootwebadmin.bean.City;
import com.peterjxl.learnspringbootwebadmin.bean.Student;
import com.peterjxl.learnspringbootwebadmin.bean.User;
import com.peterjxl.learnspringbootwebadmin.service.CityService;
import com.peterjxl.learnspringbootwebadmin.service.StudentService;
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

@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    StudentService studentService;

    @Autowired
    CityService cityService;

    @ResponseBody
    @GetMapping("/stu")
    public Student getStudentById(@RequestParam("id") Integer id) {
        return studentService.selectStudentById(id);
    }

    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id") Long id) {
        return cityService.getCityById(id);
    }

    @ResponseBody
    @PostMapping("/city")
    public City saveCity(City city) {
        cityService.saveCity(city);
        return city;
    }


    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from students", Long.class);
        return aLong.toString();
    }

    /**
     * 登录页面
     *
     * @return
     */
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if (StringUtils.hasLength(user.getUserName()) && StringUtils.hasLength(user.getPassword())) {
            session.setAttribute("loginUser", user);
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }
    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {
        return "main";
    }
}
