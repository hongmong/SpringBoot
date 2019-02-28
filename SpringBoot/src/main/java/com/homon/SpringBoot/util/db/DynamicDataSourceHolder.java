package com.homon.SpringBoot.util.db;


import com.homon.SpringBoot.bean.DataSourceType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HongMong on 2017/2/6.
 */
public class DynamicDataSourceHolder {

    public static List<DataSourceType> dataSourceIds = new ArrayList<DataSourceType>();

    private static final ThreadLocal<DataSourceType> dataSourceTypes = new ThreadLocal<DataSourceType>(){
        @Override
        protected DataSourceType initialValue(){
            return DataSourceType.master;
        }
    };

    public static DataSourceType get(){
        return dataSourceTypes.get();
    }

    public static void set(DataSourceType dataSourceType){
        dataSourceTypes.set(dataSourceType);
    }

    public static void reset(){
        dataSourceTypes.set(DataSourceType.master);
    }

    public static void clear(){dataSourceTypes.remove();}

    public static boolean containsDataSource(DataSourceType dataSourceId){
        return dataSourceIds.contains(dataSourceId);
    }
}
