package com.fengjr.crm.service;

import com.fengjr.crm.model.db.UserPoints;

public interface IUserPointsService {

    //    5).查询用户level，points等
    UserPoints getUserPoints(String userid);

}
