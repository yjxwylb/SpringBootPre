package com.xyj.learn.springmvc4;

import com.xyj.learn.springmvc4.service.ServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author: xiayuejie
 * @date: 2019/1/28 11:09
 * @description: 测试使用的控制器
 */
@Controller
public class NormalController {

    @Autowired
    private ServiceTest serviceTest;

    @GetMapping("/normal")
    public String testPage(Model model) {
        model.addAttribute("msg", serviceTest.saySomething());
        return "page";
    }
}
