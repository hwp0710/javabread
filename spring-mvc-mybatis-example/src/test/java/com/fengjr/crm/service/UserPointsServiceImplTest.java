package com.fengjr.crm.service;

import com.fengjr.crm.model.db.UserPoints;
import com.fengjr.crm.util.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
public class UserPointsServiceImplTest extends BaseTest {

    private IUserPointsService userPointsService;

    public UserPointsServiceImplTest() {
        userPointsService = (IUserPointsService) ctx.getBean("userPointsService");
    }

    @Test
    public void testGetUserPoint() {
        UserPoints userPoints = userPointsService.getUserPoints(USER_ID);
        Assert.assertEquals(true, userPoints.getAvailablePoints() > 0);
    }

}
