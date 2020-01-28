package com.munvo.enrichment.configuration;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configuration {

    private String studentName;
    private String type;
    private String fileName;
    private static Configuration instance;

    private Configuration() {
        Config config = ConfigFactory.load();
        this.studentName = config.getString("name");
        this.type = config.getString("type");
        this.fileName = config.getString("fileName");
    }

//    private static class ConfigurationInner{
//        private static final Configuration INSTANCE = new Configuration();
//    }

//    public static Configuration getInstance(){
//        return ConfigurationInner.INSTANCE;
//    }

    public static Configuration getInstance(){
        if (instance == null){
            return new Configuration();
        }
        return instance;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getType() {
        return type;
    }

    public String getFileName() {
        return fileName;
    }
}