package com.fengjr.crm.dao;

import com.fengjr.crm.dao.mapper.UserPointsMapper;
import com.fengjr.crm.model.db.UserPoints;
import com.fengjr.loan.utils.SqlHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("userPointsDao")
public class UserPointsDao extends BaseDao {

    @Resource(name = "userPointsMapper")
    private UserPointsMapper userPointsMapper;

    public List<UserPoints> getList(@Param("id") String id) {
        return userPointsMapper.select(id);
    }

    public UserPoints getObject(@Param("userId") String userId) {
        return userPointsMapper.selectObject(userId);
    }

    public int add(UserPoints obj) {
        String sql = SqlHelper.getNamespaceSql(getSqlSessionFactory().openSession(), "com.fengjr.crm.dao.mapper.UserPointsMapper.add", obj);
//        System.out.println(sql);
        return userPointsMapper.add(obj);
    }

    public int update(UserPoints obj) {
        String sql = SqlHelper.getNamespaceSql(getSqlSessionFactory().openSession(), "com.fengjr.crm.dao.mapper.UserPointsMapper.update", obj);
//        System.out.println(sql);
        return userPointsMapper.update(obj);
    }
}
