package com.comb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Application {

    private String appName;

    private String appUrl;

    private String introduction;
}
