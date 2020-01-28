package com.munvo.enrichment.parser;

import com.munvo.enrichment.model.Subscriber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSONParser implements FileReaderParser {

    private int id;
    private String name;
    private String phoneNumber;

    @Override
    public Subscriber parseSubscriber(String subLine) {

        //use regex to split sublines at commas, to seperate id, name and phone number into groups
        String[] a = subLine.split(",");

        //match digits, which only occurs at the begginning. No need to worry about telephone number since it is a string and not an integer
        Pattern pattern = Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(a[0]);
        if (matcher.find())
        {
            System.out.println(matcher.group(1));
            id = Integer.parseInt(matcher.group(1));
        }

        //match name, which is the second group of all quoted words
        pattern = Pattern.compile(":\\s(\"\\w+\")");
        matcher = pattern.matcher(a[1]);
        if (matcher.find())
        {
            System.out.println(matcher.group(1));
            name = matcher.group(1).replace("\"", "");
        }

        //match the telephone number
        pattern = Pattern.compile("((\\d{3})-(\\d{3})-(\\d{4}))");
        matcher = pattern.matcher(a[2]);
        if (matcher.find())
        {
            System.out.println(matcher.group(0));
            phoneNumber = matcher.group(1);
        }

        return new Subscriber(id,name,phoneNumber);
    }
}
