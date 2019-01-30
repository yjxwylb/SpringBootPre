package com.xyj.learn.springmvc4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: xiayuejie
 * @date: 2019/1/24 11:15
 * @description:
 */
@Controller
public class AdviceController {

    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg) {
        throw new IllegalArgumentException("参数有误:" + msg);
    }
}
