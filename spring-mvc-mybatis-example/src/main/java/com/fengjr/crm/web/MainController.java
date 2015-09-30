package com.fengjr.crm.web;

import com.fengjr.crm.model.db.UserPoints;
import com.fengjr.crm.service.IUserPointsService;
import com.fengjr.crm.web.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/avocado")
public class MainController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Resource(name = "userPointsService")
    private IUserPointsService userPointsService;

    @RequestMapping(value = "/profile/user/{userId}", method = RequestMethod.GET)
    public ModelAndView profile(@PathVariable(value = "userId") String userId,
                                final HttpServletRequest request, final HttpServletResponse response, final Model model) {
        UserPoints userPoints = userPointsService.getUserPoints(userId);
        model.addAttribute(userPoints);
        return viewNegotiating(request, response, model);
    }


}
