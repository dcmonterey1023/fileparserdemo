package com.fileparser.demo.controller;

import com.fileparser.demo.dto.FileStatisticsDTO;
import com.fileparser.demo.util.FileUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

/**
 * @author d.monterey on 04/08/2020
 */
@RestController
@RequestMapping("/files")
public class FileParserController {

    @RequestMapping("/statistics/{dirPath}")
    public ResponseEntity<List<FileStatisticsDTO>> getFileStatistics(@PathVariable String dirPath){
        List<File> files = FileUtil.getAllFiles(dirPath);

        return null;
    }


}
