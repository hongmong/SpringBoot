package com.homon.SpringBoot.aop;


import com.homon.SpringBoot.annotation.DB;
import com.homon.SpringBoot.bean.DataSourceType;
import com.homon.SpringBoot.util.db.DynamicDataSourceHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by HongMong on 2017/8/23.
 */
@Aspect
@Component
@Order(-1)
public class DBAop {

    protected static Logger logger = LoggerFactory.getLogger(DBAop.class);


    @Before("@annotation(db)")
    public void before(JoinPoint point, DB db){
        DataSourceType value = db.value();
        if(!DynamicDataSourceHolder.containsDataSource(value)){
            logger.error("DataSource[{}] not found，User Default DataSource > {}", db.value(), point.getSignature());
        }else {
            logger.debug("Use DataSource : {} > {}", db.value(), point.getSignature());
            DynamicDataSourceHolder.set(db.value());
        }
    }

    @After("@annotation(db)")
    public void after(JoinPoint point,DB db){
        logger.debug("Revert DataSource : {} > {}",db.value(),point.getSignature());
        DynamicDataSourceHolder.reset();
    }
}
