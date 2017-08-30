package com.farmfriend.SpringBoot.annotation;

import com.farmfriend.SpringBoot.bean.DataSourceType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by HongMong on 2017/8/23.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
/**
 * 此注解用来切换数据源
 * 使用注意:
 *      1:非事务环境下,可在DAO层方法使用此注解value为DataSourceType中的枚举值
 *      2:事务环境下只会使用一种数据源,Dao层中的注解切换无效,会使用默认的连接池,如需切换在Service层方法使用注解切换数据源
 */
public @interface DB {
    DataSourceType value() default DataSourceType.master;
}
