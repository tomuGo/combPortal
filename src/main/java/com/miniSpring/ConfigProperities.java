package com.miniSpring;

import lombok.Data;

import java.util.Properties;

@Data
public class ConfigProperities extends Properties {

    private int port;

    private Boolean enableLog;

    private String logPath;

}
