package fii.jt.lab1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static fii.jt.lab1.InputValidation.tryParseInt;
import static fii.jt.lab1.InputValidation.validateSizeGivenWord;
import static fii.jt.lab1.WordUtils.filterWordsUsingDictionary;
import static fii.jt.lab1.WordUtils.transferSubWordsOfGivenSize;

/**
 * Represents the servlet responsible with handling both the Compulsory and the Homework tasks.
 *
 * @author Amarandei Matei Alexandru
 */
@WebServlet(name = "handleWord", urlPatterns = "/handleWord")
public class HandleWordServlet extends HttpServlet {
    public List<DictionaryPair> dictionary;

    /**
     * Called only once when the servlet is created.
     * Also, responsible with initialising the dictionary of words from the file.
     * Source: aspell
     */
    public void init() throws ServletException {
        super.init();

        this.dictionary = new ArrayList<>();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("/Users/alex-ama/Files/GitHub/Java-Technologies/Lab1/Lab1/src/main/java/fii/jt/lab1/dictionary.txt"));
            String word = reader.readLine();
            while (word != null) {
                this.dictionary.add(new DictionaryPair(word.toLowerCase()));
                word = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Prints an ordered list composed of the letters of a word received through a POST request.
     *
     * @param request The HTTP POST request.
     * @param out     The output to which to write the HTML code for the response page.
     */
    private void solveTask1(HttpServletRequest request, PrintWriter out) {
        String word = request.getParameter("word");

        out.println("<ol>");
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != ' ') {
                out.println("<li>" + word.charAt(i) + "</li>");
            }
        }
        out.println("</ol><br>");
    }

    /**
     * Prints all the anagrams of a given size (or all possible, if size = 0) from the letters of the provided word.
     *
     * @param request The HTTP POST request.
     * @param out     The output to which to write the HTML code for the response page.
     */
    private void solveTask2(HttpServletRequest request, PrintWriter out) {
        String word = request.getParameter("word");
        Integer size = validateSizeGivenWord(tryParseInt(request.getParameter("size")), word);

        out.println("<p><i>");
        List<String> subWords = new ArrayList<>();

        if (size == 0) {
            for (int j = 1; j <= word.length(); j++) {
                transferSubWordsOfGivenSize(0, j, "", word, subWords);
            }
        } else {
            transferSubWordsOfGivenSize(0, size, "", word, subWords);
        }

        Set<String> words = filterWordsUsingDictionary(subWords, this.dictionary);

        for (String s : words) {
            out.println(s + " ");
        }
        out.println("</i></p><br>");
    }

    /**
     * Handles the POST request by generating the beginning and end of the HTML document.
     * Also, calls the appropriate functions for handling the two tasks.
     *
     * @param request  The HTTP POST request.
     * @param response The HTML page returned as a response to the request.
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        out.println("<h2> Word: ");
        out.println(request.getParameter("word"));
        out.println("| Size: ");
        out.println(request.getParameter("size"));
        out.println("</h2>");

        solveTask1(request, out);
        solveTask2(request, out);

        out.println("<br><hr><h1>See? Just as promised.</h1></body></html>");
    }

    /**
     * Called by the Servlet Container to indicate that the Servlet is being taken out of service.
     */
    public void destroy() {
    }
}