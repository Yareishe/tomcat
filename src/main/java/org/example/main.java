/*
package org.example;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class main {
    public static void main(String[] args) throws IOException {
        HttpServletRequest req = null;
        HttpServletResponse resp = null;

        String timezone = req.getParameter("timezone");
        System.out.println(timezone + "1");
        String timezoneDecode = URLDecoder.decode(timezone,String.valueOf(StandardCharsets.UTF_8));
        System.out.println(timezoneDecode+ "2");
        ZoneId timezoneid = ZoneId.of(timezoneDecode);
        System.out.println(timezoneid +"3");
        LocalDateTime timezoneLocal = LocalDateTime.now(timezoneid);
        System.out.println(timezoneLocal+ "4");
        DateTimeFormatter timezoneformat = DateTimeFormatter.ISO_LOCAL_TIME;
        System.out.println(timezoneformat + "5");
        String timezoneformatTime = timezoneformat.format(timezoneLocal);
        System.out.println(timezoneformatTime + "6");
        resp.getWriter().write(timezoneformatTime);
        System.out.println(resp + "7");
        System.out.println(req+ "8");
    }
}
*/