
package org.example;




import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String timezone = req.getParameter("timezone");
        if (timezone == null || timezone.isEmpty()) {
            resp.getWriter().write(getDate("UTC"));
        } else {
            resp.getWriter().write(getDate(timezone));
        }
        resp.getWriter().close();
    }

    public static String getDate(String param) {Date actualDate = new Date();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z").withZone(ZoneId.of(param));
        return dateFormat.format(actualDate.toInstant());
    }

}
/*
 if (req.getParameter("timezone") == null || req.getParameter("timezone").isEmpty()) {
            resp.getWriter().write(getDate("UTC"));

        } else {
            String timezone = req.getParameter("timezone");
            String date = getDate(timezone);
            resp.getWriter().write(date);
        }

        resp.getWriter().close();
    }
    public static String getDate(String param) {
        Date actualDate = new Date();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss z")
                .withZone(ZoneId.of(param));
        return dateFormat.format(actualDate.toInstant());


        resp.getWriter()
                .write(DateTimeFormatter.ISO_LOCAL_TIME
                        .format(LocalDateTime
                                .now(ZoneId.of
                                        (URLDecoder.decode(req.getParameter("timezone"), String.valueOf(StandardCharsets.UTF_8)
                                        )))));

        String timezone = req.getParameter("timezone");
        String timezoneDecode = URLDecoder.decode(timezone,String.valueOf(StandardCharsets.UTF_8));
        ZoneId timezoneid = ZoneId.of(timezoneDecode);
        LocalDateTime timezoneLocal = LocalDateTime.now(timezoneid);
        DateTimeFormatter timezoneformat = DateTimeFormatter.ISO_LOCAL_TIME;
        String timezoneformatTime = timezoneformat.format(timezoneLocal);
        resp.getWriter().write(timezoneformatTime);
        System.out.println(timezoneid);

         */