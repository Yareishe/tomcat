package org.example;




import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class TimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

            resp.getWriter()
                    .write(DateTimeFormatter.ISO_LOCAL_TIME
                            .format(LocalDateTime.now(ZoneId.of(
                                            URLEncoder.encode(
                                                    req.getParameter("timezone"), String.valueOf(StandardCharsets.UTF_8)
                                            )
                                    ))
                            )
                    );

        resp.getWriter().close();
    }
}
