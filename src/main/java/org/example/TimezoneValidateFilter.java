package org.example;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/time")
public class TimezoneValidateFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String timezone = request.getParameter("timezone");


        if (timezone != null && !timezone.isEmpty()) {
            if (isValidTimezone(timezone)) {
                chain.doFilter(request, response);
            } else {

                response.setContentType("text/html");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("Invalid timezone");
            }
        } else {
            chain.doFilter(request, response);
        }
    }


    private boolean isValidTimezone(String timezone) {
        return !timezone.toLowerCase().contains("maxim");
    }
}