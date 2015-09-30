package com.fengjr.crm.dao;

import com.fengjr.crm.sys.model.TUser;
import com.fengjr.crm.sys.model.TUserExample;
import com.fengjr.crm.util.BaseTest;
import com.fengjr.crm.sys.mapper.TUserMapper;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;

@RunWith(PowerMockRunner.class)
public class UserDaoTest extends BaseTest {

    private TUserMapper dao;

    public UserDaoTest() {
        dao = (TUserMapper) ctx.getBean("TUserMapper");
    }


    @Test
    public void testGetObject() throws Exception {
        TUser user = dao.selectByPrimaryKey(1);
        Assert.assertNotNull(user);

    }

    @Test
    public void testGetAddDelete() throws Exception {
        TUser user = new TUser();
        user.setId(3);
        user.setPassword("123456");
        dao.insert(user);

        dao.deleteByPrimaryKey(3);
    }


    @Test
    public void testUpdate() throws Exception {
        TUser user = dao.selectByPrimaryKey(2);
        user.setUsername("jack123");

        dao.updateByPrimaryKey(user);
    }

    @Test
    public void testSelectExample() throws Exception {
        TUserExample example = new TUserExample();
        example.createCriteria().andUsernameLike("%123%");

        List<TUser> users = dao.selectByExample(example);
        Assert.assertEquals(true, users.size() == 1);

    }


}
