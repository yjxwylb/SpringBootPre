package com.xyj.learn.springmvc4;

import com.xyj.learn.springmvc4.service.ServiceTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author: xiayuejie
 * @date: 2019/1/28 10:18
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("/src/main/resources/")//显示指定加载web资源路径，默认为/src/main/webapp/
@ContextConfiguration(classes = MyMvcConfig.class)
public class ControllerInterceptionTests {

    private MockMvc mockMvc;//模拟MVC对象
    MockHttpSession mockHttpSession;//可注入模拟的http session,本例未使用
    MockHttpServletRequest request;//可注入模拟的http request,本例未使用
    @Autowired
    private ServiceTest serviceTest;
    @Autowired
    private WebApplicationContext webApplicationContext;//可注入webApplicationContext

    @Before //测试开始前的初始化
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void testNormalController()throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/normal"))//模拟向/normal 执行get请求
                .andExpect(MockMvcResultMatchers.status().isOk())//预期控制器返回状态为200
                .andExpect(MockMvcResultMatchers.view().name("page"))//预期view名称为page
                .andExpect(MockMvcResultMatchers.forwardedUrl("WEB-INF/classes/views/page.jsp"))//预期页面的真正转向路径
                .andExpect(MockMvcResultMatchers.model().attribute("msg", serviceTest.saySomething()));//预期model的值为serviceTest.saySomething()
    }

    @Test
    public void testRestController()throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/testrest"))//模拟向/normal 执行get请求
                .andExpect(MockMvcResultMatchers.status().isOk())//预期控制器返回状态为200
                //.andExpect(MockMvcResultMatchers.content().contentType("text/plain; charset=ISO-8859-1"))//预期文本格式
                .andExpect(MockMvcResultMatchers.content().string(serviceTest.saySomething()));//预期文本内容
    }

}
