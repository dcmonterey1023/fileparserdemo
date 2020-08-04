package com.fileparser.demo.service;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author d.monterey on 04/08/2020
 */

@Component
public class FileStatisticsImpl implements FileStatisticsInterface {

    @Override
    public int getNumberOfWords(File file) throws IOException {

        int count = 0;

        try(Scanner sc = new Scanner(new FileInputStream(file))){
            while(sc.hasNext()){
                String word = sc.next();
                if(word.matches("^[a-zA-Z0-9]*$"))
                count++;
            }
        }

        return count;

    }

    @Override
    public int getNumberOfDots(File file) throws IOException{

        int count = 0;

        try(Scanner sc = new Scanner(new FileInputStream(file))){
            while(sc.hasNext()){
                String word = sc.next();
                if(word.contains("."))
                    count++;
            }
        }

        return count;

    }

    @Override
    public String getMostUserWord(File file) throws IOException {

        String freqWord = null;
        int currMax = 0;

        Map<String, Integer> wordMap = new HashMap<>();

        try(Scanner sc = new Scanner(new FileInputStream(file))){
            while(sc.hasNext()){
                String word = sc.next();
                Integer currVal = wordMap.get(word);
                wordMap.put(word, currVal == null ? 1 : ++currVal );
            }
        }

        for(Map.Entry<String, Integer> entry : wordMap.entrySet()){

            if(entry.getKey().matches("^[a-zA-Z0-9]*$") && entry.getValue() > currMax){
                freqWord = entry.getKey();
                currMax = entry.getValue();
            }

        }

        return freqWord;

    }
}
