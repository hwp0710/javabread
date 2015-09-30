package com.fengjr.crm.web;

import com.fengjr.crm.util.BaseTest;
import com.fengjr.loan.utils.HelperUtils;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;

public class ControllerTest extends BaseTest {

    private MainController controller;
    private CompletionService service = new ExecutorCompletionService(HelperUtils.getExecutorService());

    public ControllerTest() {
        controller = (MainController) ctx.getBean("mainController");
    }

    @Test
    public void testProducePointsUseJson() throws Exception {
        try {
            ModelAndView mv = controller.profile(USER_ID, getRequest(), getResponse(), getModel());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
