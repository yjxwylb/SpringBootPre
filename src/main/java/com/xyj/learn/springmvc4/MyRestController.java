package com.xyj.learn.springmvc4;

import com.xyj.learn.springmvc4.service.ServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xiayuejie
 * @date: 2019/1/28 13:32
 * @description:
 */
@RestController
public class MyRestController {

    @Autowired
    private ServiceTest serviceTest;

    @GetMapping("/testrest")
    public String testRest() {
        return serviceTest.saySomething();
    }
}
