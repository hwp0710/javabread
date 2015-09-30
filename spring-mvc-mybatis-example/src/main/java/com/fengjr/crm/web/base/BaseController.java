package com.fengjr.crm.web.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by bingquan.an@fengjr.com on 2015/4/23.
 */
public class BaseController {

    protected final static Gson gson = new GsonBuilder().
            setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    protected final static String DATA_FORMAT_JSON = "json";

    /**
     * @param model
     * @param statusText
     */
    protected void failedView(Model model, String statusText) {
        model.addAttribute(ResponseObject.STATUS, ResponseObject.FAIL);
        if (StringUtils.isNotBlank(statusText))
            model.addAttribute(ResponseObject.STATUS_TEXT, statusText);
    }


    /**
     * @param model
     */
    protected void successView(Model model) {
        this.successView(model, null);
    }

    protected void successView(Model model, String statusText) {
        model.addAttribute(ResponseObject.STATUS, ResponseObject.SUCCESS);
        if (StringUtils.isNotBlank(statusText))
            model.addAttribute(ResponseObject.STATUS_TEXT, statusText);
    }

    /**
     * @param request
     * @param response
     * @param model
     * @return
     */
    protected ModelAndView viewNegotiating(final HttpServletRequest request,
                                           final HttpServletResponse response, final Model model) {

        ModelAndView modelAndView = jsonView(request, response, model);
        return modelAndView;
    }

    /**
     * @param request
     * @param response
     * @param model
     * @return
     */
    protected ModelAndView jsonView(final HttpServletRequest request,
                                    final HttpServletResponse response, final Model model) {
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        ModelAndView modelAndView = new ModelAndView(view, model.asMap());
        return modelAndView;
    }

    protected String getExceptionString(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw, true));
        return sw.toString();
    }

    protected void processException(Model model, Exception e, String msg, Logger logger) {
        e.printStackTrace();
        logger.info(msg + " {} " + getExceptionString(e));
        failedView(model, msg + " " + e.toString());
    }

}
