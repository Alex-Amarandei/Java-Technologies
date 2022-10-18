package fii.jt.lab2.navigationflow;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Represents the servlet responsible with generating the security captcha.
 *
 * @author Amarandei Matei Alexandru
 */
@WebServlet("/captcha")
public class CaptchaServlet extends HttpServlet {
    /**
     * Generates a random Captcha using letters of different colors, positions and sizes.
     *
     * @param request The HTTP GET request.
     * @param response The HTTP response to send (the image).
     * @throws IOException If there are problems with the output stream.
     */
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("image/jpg");

        int numberOfCharacters = 6;
        int height = 40;
        int width = 150;

        Font font1 = new Font("Arial", Font.BOLD, 30);
        Font font2 = new Font("Verdana", Font.BOLD, 20);

        Random rand = new Random();
        String code = (Long.toString(Math.abs(rand.nextLong()), 36)).substring(0, numberOfCharacters);

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2dImage = (Graphics2D) bufferedImage.getGraphics();

        int circle = 15;
        for (int i = 0; i < circle; i++) {
            g2dImage.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));

            int radius = (int) (Math.random() * height / 2.0);
            int x = (int) (Math.random() * width - radius);
            int y = (int) (Math.random() * height - radius);
        }
        g2dImage.setFont(font1);
        for (int i = 0; i < numberOfCharacters; i++) {
            g2dImage.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));

            if (i % 2 == 0) {
                g2dImage.drawString(code.substring(i, i + 1), 25 * i, 24);
            } else {
                g2dImage.drawString(code.substring(i, i + 1), 25 * i, 35);
            }
        }

        OutputStream out = response.getOutputStream();
        ImageIO.write(bufferedImage, "jpeg", out);

        g2dImage.dispose();

        HttpSession session = request.getSession();
        session.setAttribute("captchaSecurity", code);
    }

    /**
     * The function responsible with handling the GET request, it calls the handleRequest method.
     *
     * @param request The HTTP GET request.
     * @param response The HTTP response to send (the image).
     * @throws IOException If there are problems with the output stream, coming from the handleRequest method.
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        handleRequest(request, response);
    }
}
