package fii.jt.lab1;

/**
 * Class providing different static methods used for input validation.
 */
public class InputValidation {
    /**
     * Extracted this try-catch block for aesthetic reasons.
     *
     * @param text The text to parse to an integer.
     * @return The number (if valid)) or 0 otherwise.
     */
    public static Integer tryParseInt(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * Check the validity of the given size.
     *
     * @param size The size to verify.
     * @param word The word used to check the validity of the given size.
     * @return If the size is out of the bounds given the length of the word, return 0, otherwise, the size.
     */
    public static Integer validateSizeGivenWord(Integer size, String word) {
        if (size > word.length() || size < 0) {
            return 0;
        }
        return size;
    }
}
