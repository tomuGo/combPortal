package com.comb.web;

import com.miniSpring.annotations.RequestMapping;
import com.miniSpring.annotations.RequestMethed;

public class CombController {

    @RequestMapping(value = "/", methed = RequestMethed.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index", new Object());
        return modelAndView;
    }
}
