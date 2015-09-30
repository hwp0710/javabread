package com.fengjr.crm.service.impl;

import com.fengjr.crm.dao.*;

import javax.annotation.Resource;

/**
 * Created by admin on 2015/8/27.
 */
public abstract class BaseService {

    @Resource(name = "userPointsDao")
    UserPointsDao userPointsDao;

}
