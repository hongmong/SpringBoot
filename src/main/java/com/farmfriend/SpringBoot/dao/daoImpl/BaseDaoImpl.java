package com.farmfriend.SpringBoot.dao.daoImpl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import javax.annotation.Resource;

/**
 * Created by HongMong on 2017/9/18.
 */
public class BaseDaoImpl extends SqlSessionDaoSupport {
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
