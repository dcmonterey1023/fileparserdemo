package com.fileparser.demo.botstrap;

import com.fileparser.demo.dto.FileStatisticsDTO;
import com.fileparser.demo.service.FileParserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * @author d.monterey on 04/08/2020
 */
@Component
public class PathLoader implements CommandLineRunner {

    public static final String DIR_PATH = "C:\\Users\\d.monterey\\IdeaProjects\\demo\\src\\main\\resources\\samplefiles";
    public static final String NEW_DIR_PATH = "C:\\Users\\d.monterey\\IdeaProjects\\demo\\src\\main\\resources\\samplefiles\\processed";

    private final FileParserService fileParserService;

    public PathLoader(FileParserService fileParserService){
        this.fileParserService = fileParserService;
    }

    @Override
    public void run(String... args) throws Exception {

        List<FileStatisticsDTO> list = fileParserService.getFileStatisticsList(DIR_PATH);

        list.forEach(System.out::println);


    }
}
