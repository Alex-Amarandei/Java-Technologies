package fii.jt.lab2.listeners;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Listener that listens for category modifications and context state changes.
 *
 * @author Amarandei Matei Alexandru
 */
@WebListener
public class CategoryWebListener implements ServletContextListener {
    public static String category;

    /**
     * Called when the context is initialized.
     * @param sce Servlet Context Event that triggered the method.
     */
    public void contextInitialized(ServletContextEvent sce) {
        category = sce.getServletContext().getInitParameter("category");
        System.out.println("Context Initialized! Category is: " + category);
    }

    /**
     * Called when the context is destroyed.
     * @param sce Servlet Context Event that triggered the method.
     */
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context Destroyed! Category is: " + category);
    }
}
