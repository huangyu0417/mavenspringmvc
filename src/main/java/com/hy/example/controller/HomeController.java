package com.hy.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/index/{id}")
    public ModelAndView index(@PathVariable("id") int id, ModelAndView modelAndView){
        logger.info("home page => {},param => ID:{}","index.jsp",id);
        modelAndView.setViewName("welcome");
        modelAndView.addObject(id);
        //返回index.jsp视图
        return modelAndView;
    }

}
