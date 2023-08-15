package com.peterjxl.learnspringbootwebadmin.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.peterjxl.learnspringbootwebadmin.bean.User;
import com.peterjxl.learnspringbootwebadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table(@RequestParam("a") int a){
        // int i = 10 / 0;
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                                Model model){
        List<User> list = userService.list();
        //model.addAttribute("users", list);
        Page<User> userPage = new Page<>(pn, 2); // 参数：第几页，每页显示的条数
        Page<User> page = userService.page(userPage, null);
        model.addAttribute("page", page);

        System.out.println("当前页码：" + page.getCurrent());
        System.out.println("总页码：" + page.getPages());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("每页显示的记录数：" + page.getSize());
        System.out.println("是否有下一页：" + page.hasNext());
        System.out.println("是否有上一页：" + page.hasPrevious());

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


    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                             RedirectAttributes ra){
        userService.removeById(id);
        ra.addAttribute("pn", pn);
        return "redirect:/dynamic_table";  // 删除后回到当前页
    }
}
