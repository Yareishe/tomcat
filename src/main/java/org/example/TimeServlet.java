package org.example;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String timezone = request.getParameter("timezone");
        String currentTime;

        if (timezone != null && !timezone.isEmpty()) {
            currentTime = getCurrentTimeWithTimezone(timezone);
        } else {
            currentTime = getCurrentTimeInUTC();
        }

        response.getWriter().write( currentTime );
    }

    private String getCurrentTimeInUTC() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdf.format(new Date());
    }

    private String getCurrentTimeWithTimezone(String timezone) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        sdf.setTimeZone(TimeZone.getTimeZone(timezone));
        return sdf.format(new Date());
    }
}