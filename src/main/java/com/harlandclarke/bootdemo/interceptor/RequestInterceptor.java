package com.harlandclarke.bootdemo.interceptor;

import com.harlandclarke.bootdemo.controllers.MainController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        logger.info("In preHandle we are Intercepting the Request");
        String requestURI = request.getRequestURI();
        Integer personId = ServletRequestUtils.getIntParameter(request, "personId", 0);
        logger.info("RequestURI::" + requestURI +" || Search for Person with personId ::" + personId);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,Object object, ModelAndView model) throws Exception {
        logger.info("In postHandle request processing completed by @RestController");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg3) throws Exception {
        logger.info("In afterCompletion Request Completed");
    }
}