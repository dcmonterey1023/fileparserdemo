package com.fileparser.demo.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @author d.monterey on 04/08/2020
 */
@Data
public class FileStatisticsDTO {

    String fileName;
    int numWords;
    int numOfDots;
    String mostUsedWord;


    @Override
    public String toString() {
        return "FileStatisticsDTO{" +
                "fileName='" + fileName + '\'' +
                ", numWords=" + numWords +
                ", numOfDots=" + numOfDots +
                ", mostUsedWord='" + mostUsedWord + '\'' +
                '}';
    }
}
