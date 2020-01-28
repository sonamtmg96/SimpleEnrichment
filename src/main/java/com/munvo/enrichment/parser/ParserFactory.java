package com.munvo.enrichment.parser;

public class ParserFactory {

    public FileReaderParser getFileReaderParser(String fileName){
        if(fileName == null){
            return null;
        }
        if(fileName.equalsIgnoreCase("json")){
            return new JSONParser();
        }else{
            return new CSVParser();
        }
    }
}
