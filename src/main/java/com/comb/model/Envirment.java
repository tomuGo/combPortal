package com.comb.model;

import lombok.Data;

import java.io.Serializable;
import java.util.LinkedList;

@Data
public class Envirment implements Serializable {

    private String envirName;

    private String introduction;

    private LinkedList<Application> applications;

}
