package com.fileparser.demo.service;

import java.io.File;
import java.io.IOException;

/**
 * @author d.monterey on 04/08/2020
 */
public interface FileStatisticsInterface {

    int getNumberOfWords(File file) throws IOException;
    int getNumberOfDots(File file) throws IOException;
    String getMostUserWord(File file) throws IOException;

}
