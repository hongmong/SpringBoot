package com.homon.SpringBoot.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ES查询构建实例
 */
public class ESQueryBuild {

    /**
     * 起止查询
     */
    private int from;
    /**
     * 查询大小
     */
    private int size;
    /**
     * 全文查询条件
     */
    private Map<Object,Object> fuzzyQuery;
    /**
     * 精确查询
     */
    private Map<Object,Object> equalsQuery;
    /**
     * 不等于查询
     */
    private Map<Object,Object> notEqualsQuery;
    /**
     * 大于查询条件
     */
    private Map<Object,Object> gteQuery;
    /**
     * 小于等于查询
     */
    private Map<Object,Object> lteQuery;
    /**
     * in(查询)
     */
    private Map<Object,List<Object>> inQuery;
    /**
     * 排序
     */
    private Map<Object,Object> sort;

    /**
     * 分组/计数
     */
    private List<String> countGroupList;

    public ESQueryBuild(){
        this.from = 0;
        this.size = 10;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Map<Object, Object> getFuzzyQuery() {
        return fuzzyQuery;
    }

    public void setFuzzyQuery(Map<Object, Object> fuzzyQuery) {
        this.fuzzyQuery = fuzzyQuery;
    }

    public Map<Object, Object> getEqualsQuery() {
        return equalsQuery;
    }

    public void setEqualsQuery(Map<Object, Object> equalsQuery) {
        this.equalsQuery = equalsQuery;
    }

    public Map<Object, Object> getNotEqualsQuery() {
        return notEqualsQuery;
    }

    public void setNotEqualsQuery(Map<Object, Object> notEqualsQuery) {
        this.notEqualsQuery = notEqualsQuery;
    }

    public Map<Object, Object> getSort() {
        return sort;
    }

    public void setSort(Map<Object, Object> sort) {
        this.sort = sort;
    }

    public List<String> getCountGroupList() {
        return countGroupList;
    }

    public void setCountGroupList(List<String> countGroupList) {
        this.countGroupList = countGroupList;
    }

    public Map<Object, Object> getGteQuery() {
        return gteQuery;
    }

    public void setGteQuery(Map<Object, Object> gteQuery) {
        this.gteQuery = gteQuery;
    }

    public Map<Object, Object> getLteQuery() {
        return lteQuery;
    }

    public void setLteQuery(Map<Object, Object> lteQuery) {
        this.lteQuery = lteQuery;
    }

    public Map<Object, List<Object>> getInQuery() {
        return inQuery;
    }

    public void setInQuery(Map<Object, List<Object>> inQuery) {
        this.inQuery = inQuery;
    }

    public Map<Object,Object> addFuzzyQuery(Object key, Object value){
        if(this.fuzzyQuery == null){
            this.fuzzyQuery = new HashMap<>();
        }
        this.fuzzyQuery.put(key,value);
        return this.fuzzyQuery;
    }

    public Map<Object,Object> addEqualsQuery(Object key, Object value){
        if(this.equalsQuery == null){
            this.equalsQuery = new HashMap<>();
        }
        this.equalsQuery.put(key,value);
        return this.equalsQuery;
    }

    public Map<Object,Object> addNotEqualsQuery(Object key, Object value){
        if(this.notEqualsQuery == null){
            this.notEqualsQuery = new HashMap<>();
        }
        this.notEqualsQuery.put(key,value);
        return this.notEqualsQuery;
    }

    public Map<Object,Object> addSort(Object key,Object value){
        if(this.sort == null){
            this.sort = new HashMap<>();
        }
        this.sort.put(key,value);
        return this.sort;
    }

    public Map<Object,Object> addGteQuery(Object key,Object value){
        if(this.gteQuery == null){
            this.gteQuery = new HashMap<>();
        }
        this.gteQuery.put(key,value);
        return this.gteQuery;
    }

    public Map<Object,Object> addLteQuery(Object key,Object value){
        if(this.lteQuery == null){
            this.lteQuery = new HashMap<>();
        }
        this.lteQuery.put(key,value);
        return this.lteQuery;
    }

    public Map<Object,List<Object>> addInQuery(Object key,Object... value){
            if(this.inQuery == null){
                this.inQuery = new HashMap<>();
            }
            List<Object> list = new ArrayList<>();
            for (Object o :value){
                list.add(o);
            }
            this.inQuery.put(key,list);
            return this.inQuery;
        }

    public List<String> addCountGroupList(String value){
        if(this.countGroupList == null){
            this.countGroupList = new ArrayList<>();
        }
        this.countGroupList.add(value);
        return this.countGroupList;
    }
}
