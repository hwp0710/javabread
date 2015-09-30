package com.fengjr.crm.dao;

        import org.apache.ibatis.session.SqlSessionFactory;

        import javax.annotation.Resource;

/**
 * Created by admin on 2015/9/1.
 */
public class BaseDao {

    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }


}
