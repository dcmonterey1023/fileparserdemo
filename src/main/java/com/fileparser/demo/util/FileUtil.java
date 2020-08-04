package com.fileparser.demo.util;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.io.FilenameUtils;

/**
 * @author d.monterey on 04/08/2020
 */
public class FileUtil {

    public static List<File> getAllFiles(String dirPath){

        System.out.println("Dir Path:: " + dirPath);

        File folder = new File(dirPath);
        File[] files = folder.listFiles();

        System.out.println("File length: " + files.length);

        List<File> validFiles =  Arrays.stream(files).filter(FileUtil::validateFileExtensions).collect(Collectors.toList());

        return validFiles;
    }

    public static boolean validateFileExtensions(File file){

        String fileExtension = FilenameUtils.getExtension(file.getName()).toUpperCase();

        FileExtensions extension = FileExtensions.fromValue(fileExtension);

        return extension != null;
    }

}
