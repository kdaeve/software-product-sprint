package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /quotes URL. Try running a server and navigating to /quotes! */
@WebServlet("/quotes")
public class MyQuotesServlet extends HttpServlet {
    private String[] quotes = {"A wise man can learn more from his enemies than a fool from his friends.",
                     "Don’t let anyone ever make you feel like you don’t deserve what you want.",
                     "Great men are not born great, they grow great.",
                     "Life is not the amount of breaths you take. It’s the moments that take your breath away.",
                     "Life moves pretty fast. If you don’t stop and look around once in a while, you could miss it.",
                     "Sometimes it is the people who no one imagines anything of who do the things that no one can imagine.",
                     "To see the world, things dangerous to come to, to see behind walls, to draw closer, to find each other and to feel. That is the purpose of life.",
                     "The very things that hold you down are going to lift you up.",
                     "Everything is possible, even the impossible.",
                     "There’s just no telling how far I’ll go.",
                     "Carpe diem. Seize the day, boys. Make your lives extraordinary."};

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(quotes);

        // Send the JSON as the response
        response.setContentType("application/json;");
        response.getWriter().println(json);
    }
}