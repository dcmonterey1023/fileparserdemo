package com.fileparser.demo.service;

import com.fileparser.demo.dto.FileStatisticsDTO;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * @author d.monterey on 04/08/2020
 */
@Service
public class FileProcessorService {

    FileStatisticsInterface fileStatisticsInterface;

    public FileProcessorService(FileStatisticsInterface fileStatisticsInterface){
        this.fileStatisticsInterface = fileStatisticsInterface;
    }

    public FileStatisticsDTO getStatistics(File file) throws IOException {
        FileStatisticsDTO dto = new FileStatisticsDTO();

        dto.setFileName(file.getName());
        dto.setNumWords(fileStatisticsInterface.getNumberOfWords(file));
        dto.setNumOfDots(fileStatisticsInterface.getNumberOfDots(file));
        dto.setMostUsedWord(fileStatisticsInterface.getMostUserWord(file));

        return dto;
    }

}
