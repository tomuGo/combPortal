package com.miniSpring.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ModelAndView {

    private String view;

    private Object model;
}
