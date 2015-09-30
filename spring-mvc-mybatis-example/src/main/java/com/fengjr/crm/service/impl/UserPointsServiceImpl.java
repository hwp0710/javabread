package com.fengjr.crm.service.impl;

import com.fengjr.crm.model.db.UserPoints;
import com.fengjr.crm.service.IUserPointsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2015/8/27.
 */
@Service("userPointsService")
public class UserPointsServiceImpl extends BaseService implements IUserPointsService {
    private static final Logger logger = LoggerFactory.getLogger(UserPointsServiceImpl.class);

    @Override
    public UserPoints getUserPoints(String userid) {
        UserPoints userPoints = userPointsDao.getObject(userid);
        return userPoints;
    }
}
