package com.fileparser.demo.service;

import com.fileparser.demo.dto.FileStatisticsDTO;
import com.fileparser.demo.util.FileUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.fileparser.demo.botstrap.PathLoader.NEW_DIR_PATH;

/**
 * @author d.monterey on 04/08/2020
 */
@Service
public class FileParserServiceImpl implements FileParserService{

    private final FileProcessorService fileProcessorService;

    public FileParserServiceImpl(FileProcessorService fileProcessorService){
        this.fileProcessorService = fileProcessorService;
    }

    @Override
    public List<FileStatisticsDTO> getFileStatisticsList(String dirPath) {
        List<File> files = FileUtil.getAllFiles(dirPath);

        List<FileStatisticsDTO> fileStatisticsDTOList = new ArrayList<>();

        files.stream().forEach(file -> {
            try{
                    FileStatisticsDTO fileDto = fileProcessorService.getStatistics(file);
                    fileStatisticsDTOList.add(fileDto);
                    moveFile(NEW_DIR_PATH, file);
            }catch (IOException e){
                System.out.println("An error occured while parsing the file");
            }

        });

        return fileStatisticsDTOList;
    }

    @Override
    public void moveFile(String newDir, File file) {

        System.out.println("New Directory:   " + newDir + "/" + file.getName());

        if(file.renameTo(new File(newDir + "/" + file.getName()))) {
            file.delete();
            System.out.println("File moved successfully");
        }
        else
        {
            System.out.println("Failed to move the file");
        }
    }
}
