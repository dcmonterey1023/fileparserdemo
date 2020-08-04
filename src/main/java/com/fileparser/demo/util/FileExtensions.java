package com.fileparser.demo.util;

import java.util.Arrays;

/**
 * @author d.monterey on 04/08/2020
 */
public enum FileExtensions {

    TXT("TXT"), PDF("PDF"), DOCS("DOCS");
    private String value;

    FileExtensions(String value){
        this.value = value;
    }


    public String getValue(){
        return value;
    }

    public static FileExtensions fromValue(String value) {
        return Arrays.stream(FileExtensions.values())
                .filter(source -> source.getValue().equalsIgnoreCase(value))
                .findFirst()
                .orElse(null);
    }

}
