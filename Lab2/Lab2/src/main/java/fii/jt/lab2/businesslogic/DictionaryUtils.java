package fii.jt.lab2.businesslogic;

import fii.jt.lab2.model.DictionaryPair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible with creating the dictionary from the words in a file.
 *
 * @author Amarandei Matei Alexandru
 */
public class DictionaryUtils {
    /**
     * Generates a dictionary by pairing together words with their respective Counters.
     *
     * @return a list composed of all the pairs generated with the words in the file
     */
    public static List<DictionaryPair> generateDictionary() {
        List<DictionaryPair> dictionary = new ArrayList<>();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("/Users/alex-ama/Files/GitHub/Java-Technologies/Lab1/Lab1/src/main/java/fii/jt/lab1/dictionary.txt"));
            String word = reader.readLine();
            while (word != null) {
                dictionary.add(new DictionaryPair(word.toLowerCase()));
                word = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return dictionary;
    }
}
