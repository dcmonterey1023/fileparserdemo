package com.fileparser.demo.service;

import com.fileparser.demo.dto.FileStatisticsDTO;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.util.List;

/**
 * @author d.monterey on 04/08/2020
 */
public interface FileParserService {

    List<FileStatisticsDTO> getFileStatisticsList(String dirPath);
    void moveFile(String newDir, File file);

}
