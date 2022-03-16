package com.mycommerce.project.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

@WebFilter("/*")
public class IncomingRequestsAuditFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        System.out.println("###### " + httpServletRequest.getProtocol() + " " + httpServletRequest.getRequestURI() + " ###### ###### \n");
        System.out.print("###### ###### Headers ");
        Map<String, String> headers = Collections.list(httpServletRequest.getHeaderNames())
                .stream()
                .collect(Collectors.toMap(h -> h, httpServletRequest::getHeader));
        headers.entrySet().forEach(h -> System.out.println(h));

        System.out.println("###### ###### Body ");
        Map<String, String[]> parameters = httpServletRequest.getParameterMap();
        if (parameters.isEmpty()) {
            System.out.println("\n");
        }
        parameters.entrySet()
                .stream()
                .forEach(p -> {
                    System.out.println(p.getKey() + " -> " + Arrays.toString(p.getValue()));
                });
        System.out.print("###### ###### ###### ###### ######\n");
        chain.doFilter(request, response);
    }
}
