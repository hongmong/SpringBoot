package com.homon.SpringBoot.util.db;

import com.homon.SpringBoot.aop.DBAop;
import com.homon.SpringBoot.bean.DataSourceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by HongMong on 2017/8/23.
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    protected static Logger logger = LoggerFactory.getLogger(DBAop.class);

    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceType dataSourceType = DynamicDataSourceHolder.get();
        logger.debug("switch to [{}]",dataSourceType.toString());
        return dataSourceType;
    }
}
