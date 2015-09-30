package com.fengjr.crm.exception;

import com.fengjr.crm.web.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionHandler extends BaseController implements HandlerExceptionResolver {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        final Model model = new ExtendedModelMap();
        if (ex instanceof MessageQueueException) {
            processException(model, ex, "Insert data to db success, but send data to MQ throw exception :", logger);
        } else if (ex instanceof DataAccessException) {
            processException(model, ex, "Process data to db throw exception :", logger);
        } else {
            processException(model, ex, "Program process data throw exception :", logger);
        }
        return viewNegotiating(request, response, model);
    }
}