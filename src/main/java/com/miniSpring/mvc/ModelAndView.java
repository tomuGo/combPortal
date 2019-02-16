package com.miniSpring.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ModelAndView {

    private String view;

    private Object model;
}
