package fii.jt.lab1;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static fii.jt.lab1.DictionaryPair.generateCounter;

/**
 * Class providing different static methods used for word processing.
 *
 * @author Amarandei Matei Alexandru
 */
public class WordUtils {
    /**
     * Generates subsets of a given size from the letters of the given word.
     * Saves the generated subsets in the subWords List passed as a parameter.
     * Method: Backtracking
     *
     * @param i        The character about which to decide whether to be included or not in the current set.
     * @param k        The available space left in the current set.
     * @param sol      Current solution (in the process of building).
     * @param word     The word from which to retrieve the sub words.
     * @param subWords Where to store the solution.
     */
    public static void transferSubWordsOfGivenSize(int i, int k, String sol, String word, List<String> subWords) {
        if (k == 0) {
            subWords.add(sol);
            return;
        }

        if (i == word.length()) {
            return;
        }

        sol += word.charAt(i);
        transferSubWordsOfGivenSize(i + 1, k - 1, sol, word, subWords);
        sol = sol.substring(0, sol.length() - 1);
        transferSubWordsOfGivenSize(i + 1, k, sol, word, subWords);
    }

    /**
     * Compares the Counter of the current word with the Counters of the words in the Dictionary.
     *
     * @param subWords   The list of words to filter.
     * @param dictionary The dictionary of valid words.
     * @return A set of valid words (anagrams of the words in the subWords list that are in the dictionary)
     */
    public static Set<String> filterWordsUsingDictionary(List<String> subWords, List<DictionaryPair> dictionary) {
        Set<String> words = new HashSet<>();

        for (String set : subWords) {
            Map<Character, Integer> counter = generateCounter(set);

            for (DictionaryPair dp : dictionary) {
                if (dp.counter.equals(counter)) {
                    words.add(dp.word);
                }
            }
        }

        return words;
    }
}
