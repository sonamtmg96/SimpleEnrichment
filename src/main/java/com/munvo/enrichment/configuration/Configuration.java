package com.munvo.enrichment.configuration;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configuration {

    private String studentName;
    private String type;
    private String fileName;

    public Configuration() {
        Config config = ConfigFactory.load();
        this.studentName = config.getString("name");
        this.studentName = config.getString("type");
        this.studentName = config.getString("fileName");
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