package fii.jt.lab2.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Class modelling a dictionary pair, comprised of:
 * Key: a word
 * Value: its characters' frequencies (similar structure to Python's Counter)
 * Created to make the searching of valid words more efficient.
 *
 * @author Amarandei Matei Alexandru
 */
public class DictionaryPair {
    public String word;
    public Map<Character, Integer> counter;

    /**
     * Constructor for the dictionary pair.
     *
     * @param word The valid dictionary word. Used for computing the Counter object.
     */
    public DictionaryPair(String word) {
        this.word = word;
        this.counter = generateCounter(word);
    }

    /**
     * Static method for generating a Counter object.
     *
     * @param word The valid dictionary word. Used for computing the Counter object.
     * @return a (Key, Value) (Character, Frequency) Mapping
     */
    public static Map<Character, Integer> generateCounter(String word) {
        Map<Character, Integer> counter = new HashMap<>();
        word = word.toLowerCase();

        for (int i = 0; i < word.length(); i++) {
            if (!counter.containsKey(word.charAt(i))) {
                char ch = word.charAt(i);
                counter.put(ch, (int) word.chars().filter(c -> c == ch).count());
            }
        }

        return counter;
    }
}
