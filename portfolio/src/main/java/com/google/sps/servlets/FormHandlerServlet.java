package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String nameValue = request.getParameter("name");
    String textValue = request.getParameter("text-input");
    String emailValue = request.getParameter("email");
    String phoneValue = request.getParameter("phone");

    // Print the value so you can see it in the server logs.
    System.out.println("Success! Here is your submitted information: ");
    System.out.println("You submitted name: " + nameValue);
    System.out.println("You submitted email: " + emailValue);
    System.out.println("You submitted phone number: " + phoneValue);
    System.out.println("You submitted message: " + textValue);

    // Write the value to the response so the user can see it.
    response.getWriter().println("Success! Here is your submitted information: ");
    response.getWriter().println("You submitted name: " + nameValue);
    response.getWriter().println("You submitted email: " + emailValue);
    response.getWriter().println("You submitted phone number: " + phoneValue);
    response.getWriter().println("You submitted message: " + textValue);
  }
}