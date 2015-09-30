package com.fengjr.crm.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.mockito.Mockito;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseTest extends AbstractTestCase {

    public BaseTest() {
        super();
    }

    protected Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    private HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
    private HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
    private Model model = new ExtendedModelMap();//Mockito.mock(Model.class);

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public Model getModel() {
        return model;
    }

    public final String USER_ID = "74C8ADFC-5DF1-4163-936D-4130484B583E";
}
