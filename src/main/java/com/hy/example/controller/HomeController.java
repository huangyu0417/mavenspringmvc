package com.hy.example.controller;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * desc:
 * 根目录Controller
 * @author hy
 * @version 1.0
 * @Created on 2017/5/8 16:07
 */

@Controller
@RequestMapping("/home")
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(value = "/index/{id}",method = RequestMethod.GET)
    public @ResponseBody String index(@PathVariable("id") int id, Model model){
        logger.info("home page => {},param => ID:{}","index.jsp",id);
        model.addAttribute("id",id);
        model.addAttribute("name","黄宇");
        Person person = new Person();
        person.setId(id);
        person.setName("黄宇");
        List<Person> p = new ArrayList<Person>();
        p.add(person);
        String r = JSON.toJSONString(p);
        logger.info("result JSON=> {}",r);
        //返回index.jsp视图
        return r;
    }

    class Person{
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
