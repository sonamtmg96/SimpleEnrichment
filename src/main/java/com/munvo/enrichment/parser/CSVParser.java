package com.munvo.enrichment.parser;

import com.munvo.enrichment.model.Subscriber;


public class CSVParser implements FileReaderParser {

    private int id;
    private String name;
    private String phoneNumber;

    @Override
    public Subscriber parseSubscriber(String subLine) {
        String[] a = subLine.split(",");

        id= Integer.parseInt(a[0]);
        name = a[1];
        phoneNumber = a[2];

        return new Subscriber(id,name,phoneNumber);
    }


}
