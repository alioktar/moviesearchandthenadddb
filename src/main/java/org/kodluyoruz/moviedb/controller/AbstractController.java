package org.kodluyoruz.moviedb.controller;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractController {

    protected final ServletRequestAttributes getServletRequestAttributes() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return attributes instanceof ServletRequestAttributes ? (ServletRequestAttributes) attributes : null;
    }

    protected final HttpServletRequest getCurrentRequest(){
        ServletRequestAttributes attributes = getServletRequestAttributes();
        return attributes == null ? null : attributes.getRequest();
    }

    protected final HttpServletResponse getCurrentResponse(){
        ServletRequestAttributes attributes = getServletRequestAttributes();
        return attributes == null ? null : attributes.getResponse();
    }

}
