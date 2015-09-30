package com.fengjr.crm.dao;

import com.fengjr.crm.model.db.UserPoints;
import com.fengjr.crm.util.BaseTest;
import com.fengjr.loan.utils.HelperUtils;
import com.fengjr.loan.utils.UUIDGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Date;

@RunWith(PowerMockRunner.class)
public class UserPointsDaoTest extends BaseTest {

    private UserPointsDao userPointsDao;

    public UserPointsDaoTest() {
        userPointsDao = (UserPointsDao) ctx.getBean("userPointsDao");
    }

    @Test
    public void testGetList() throws Exception {
        userPointsDao.getList("1");
    }

    @Test
    public void testGetObject() throws Exception {
        UserPoints userPoints = userPointsDao.getObject(USER_ID);
        if (null == userPoints) {
            UserPoints obj = new UserPoints();
            obj.setUserId(USER_ID);
            obj.setCreateTime(HelperUtils.getTimeStampformatter(new Date(), "yyyy-MM-dd HH:mm:ss"));
            obj.setComments("create my comments");
            obj.setAvailablePoints(Integer.parseInt("100"));
            obj.setExpiredTime(HelperUtils.getTimeStampformatter(new Date(), "yyyy-MM-dd HH:mm:ss"));
            obj.setLevel("1");
            obj.setLevelName("level name");
            obj.setStatus("1");
            obj.setTotalPoints(Integer.parseInt("100"));
            obj.setUpgradePoints(Integer.parseInt("100"));
            userPointsDao.add(obj);
        }
    }


    @Test
    public void testUpdate() throws Exception {
        userPointsDao.update(null);
    }

    @Test
    public void testAdd() throws Exception {
        UserPoints obj = new UserPoints();
        obj.setUserId(UUIDGenerator.generateUUID().toUpperCase());
        obj.setCreateTime(HelperUtils.getTimeStampformatter(new Date(), "yyyy-MM-dd HH:mm:ss"));
        obj.setComments("test comments");
        obj.setAvailablePoints(Integer.parseInt("100"));
        obj.setExpiredTime(HelperUtils.getTimeStampformatter(new Date(), "yyyy-MM-dd HH:mm:ss"));
        obj.setLevel("1");
        obj.setLevelName("level name");
        obj.setStatus("1");
        obj.setTotalPoints(Integer.parseInt("100"));
        obj.setUpgradePoints(Integer.parseInt("100"));
        userPointsDao.add(obj);

        obj.setComments("update comments...");
        userPointsDao.update(obj);
    }

}
