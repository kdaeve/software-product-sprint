package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Sanitize user input to remove HTML tags and JavaScript.
    String nameValue = Jsoup.clean(request.getParameter("name"), Safelist.basic());
    String emailValue = Jsoup.clean(request.getParameter("email"), Safelist.basic());
    String messageValue = Jsoup.clean(request.getParameter("messageInput"), Safelist.basic());
    String phoneValue = Jsoup.clean(request.getParameter("phone"), Safelist.basic());
    long timestamp = System.currentTimeMillis();


    /** Datastore init */
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Contact");
    FullEntity contactEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("name", nameValue)
            .set("email", emailValue)
            .set("phone", phoneValue)
            .set("message", messageValue)
            .set("timestamp", timestamp)
            .build();
    datastore.put(contactEntity);


    // Print the value so you can see it in the server logs.
    System.out.println("Success! Here is your submitted information: ");
    System.out.println("You submitted name: " + nameValue);
    System.out.println("You submitted email: " + emailValue);
    System.out.println("You submitted phone number: " + phoneValue);
    System.out.println("You submitted message: " + messageValue);

    // Write the value to the response so the user can see it.
    response.getWriter().println("Success! Here is your submitted information: ");
    response.getWriter().println("You submitted name: " + nameValue);
    response.getWriter().println("You submitted email: " + emailValue);
    response.getWriter().println("You submitted phone number: " + phoneValue);
    response.getWriter().println("You submitted message: " + messageValue);
  }
}