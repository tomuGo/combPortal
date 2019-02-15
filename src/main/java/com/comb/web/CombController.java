package com.comb.web;

import com.miniSpring.annotations.RequestMethed;
import com.miniSpring.annotations.RequestPath;
import com.miniSpring.model.ModelAndView;

public class CombController {

    @RequestPath(value = "/",methed = RequestMethed.GET)
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView("index",new Object());
        return modelAndView;
    }
}
