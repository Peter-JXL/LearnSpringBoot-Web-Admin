package com.peterjxl.learnspringbootwebadmin.controller;


import com.peterjxl.learnspringbootwebadmin.bean.User;
import com.peterjxl.learnspringbootwebadmin.exception.UserTooManyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {


    @GetMapping("/basic_table")
    public String basic_table(@RequestParam("a") int a){
        int i = 10 / 0;
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
        List<User> users = Arrays.asList(new User("zhangsan", "123456"),
                new User("lisi", "123444"),
                new User("haha", "aaaaa"),
                new User("hehe", "aaddd"));
        model.addAttribute("users", users);

        if (users.size() > 3){
            throw new UserTooManyException();
        }

        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
}
