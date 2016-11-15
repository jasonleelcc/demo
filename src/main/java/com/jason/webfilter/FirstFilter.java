package com.jason.webfilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Enumeration;

/**
 * Created by innofin-04 on 2016/11/4.
 */
@Component
@Order(1)
public class FirstFilter implements javax.servlet.Filter {
    private FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("into First Filter.........");
//        String token = Jwts.builder().setSubject("A123471811").claim("id", "jasonleelcc")
//                .setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact();
//        System.out.println(token);
//        System.out.println(Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody());
//        System.out.println(Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody().get("id"));
        HttpServletRequest req = (HttpServletRequest)request;
        System.out.println(req.getRequestURL());
        System.out.println(req.getMethod());
        if ("POST".equalsIgnoreCase(req.getMethod())) {
            System.out.println(req.getParameter("data"));
//            String posted_data = "";
//            BufferedReader in = new BufferedReader(new InputStreamReader(
//                    req.getInputStream()));
//            String line = in.readLine();
//            while (line != null) {
//                posted_data += line;
//                line = in.readLine();
//       }
//            System.out.println(posted_data);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        filterConfig =  null;
    }
}
