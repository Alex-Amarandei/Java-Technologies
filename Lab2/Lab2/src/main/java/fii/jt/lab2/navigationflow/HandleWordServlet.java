package fii.jt.lab2.navigationflow;

import fii.jt.lab2.listeners.CategoryWebListener;
import fii.jt.lab2.model.DictionaryPair;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static fii.jt.lab2.businesslogic.DictionaryUtils.generateDictionary;
import static fii.jt.lab2.businesslogic.InputValidation.tryParseInt;
import static fii.jt.lab2.businesslogic.InputValidation.validateSizeGivenWord;
import static fii.jt.lab2.businesslogic.WordUtils.filterWordsUsingDictionary;
import static fii.jt.lab2.businesslogic.WordUtils.transferSubWordsOfGivenSize;

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

        this.dictionary = generateDictionary();
    }

    /**
     * Prints an ordered list composed of the letters of a word received through a POST request.
     *
     * @param request The HTTP POST request.
     */
    private void solveTask1(HttpServletRequest request) {
        String word = request.getParameter("word");
        List<Character> content = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != ' ') {
                content.add(word.charAt(i));
            }
        }

        request.setAttribute("task1Result", content);
    }

    /**
     * Prints all the anagrams of a given size (or all possible, if size = 0) from the letters of the provided word.
     *
     * @param request The HTTP POST request.
     */
    private void solveTask2(HttpServletRequest request) {
        String word = request.getParameter("word");
        Integer size = validateSizeGivenWord(tryParseInt(request.getParameter("size")), word);

        List<String> subWords = new ArrayList<>();

        if (size == 0) {
            for (int j = 1; j <= word.length(); j++) {
                transferSubWordsOfGivenSize(0, j, "", word, subWords);
            }
        } else {
            transferSubWordsOfGivenSize(0, size, "", word, subWords);
        }

        Set<String> words = filterWordsUsingDictionary(subWords, this.dictionary);

        List<String> content = new ArrayList<>(words);

        request.setAttribute("task2Result", content);
    }

    /**
     * Handles the POST request by generating the beginning and end of the HTML document.
     * Also, calls the appropriate functions for handling the two tasks.
     *
     * @param request  The HTTP POST request.
     * @param response The HTML page returned as a response to the request.
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("captchaSecurity");

        if (!request.getParameter("captchaCode").equals(code)) {
            request.setAttribute("error", "Invalid Captcha!");
            request.getRequestDispatcher("input.jsp").forward(request, response);
        }

        response.setContentType("text/html");
        String selectedTask = request.getParameter("task");
        CategoryWebListener.category = request.getParameter("task");

        if (CategoryWebListener.category.equals(""))
            CategoryWebListener.category = getServletContext().getInitParameter("category");

        Cookie cookie = new Cookie("category", request.getParameter("task"));

        request.setAttribute("word", request.getParameter("word"));
        request.setAttribute("size", request.getParameter("size"));
        request.setAttribute("task1Result", "");
        request.setAttribute("task2Result", "");

        if (selectedTask.equals("task1")) {
            solveTask1(request);
        } else {
            solveTask2(request);
        }

        response.addCookie(cookie);
        request.getRequestDispatcher("result.jsp").forward(request, response);
    }

    /**
     * Called by the Servlet Container to indicate that the Servlet is being taken out of service.
     */
    public void destroy() {
    }
}