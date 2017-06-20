package com.project.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by JORGE-HP on 17/6/2017.
 */

@Controller
@RequestMapping("/home")
public class TestController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView handleRequestInternal() throws Exception {
        ModelAndView model = new ModelAndView("index");
        model.addObject("msg", "hello world");
        return model;
    }
}
