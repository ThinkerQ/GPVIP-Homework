package com.gupao.common.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 基于LinkedHashMap实现LRU内存淘汰机制
 * @Author: GengGhuQiang
 * @Date: 2020/9/8
 */
@Slf4j
public class LRUCache extends LinkedHashMap {
    private Integer initialCapacity;

    public LRUCache(Integer size){
        super(8,0.75f,true);
        this.initialCapacity = size;
    }

    /**
     * 移除老元素
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return super.size() > this.initialCapacity;
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put("1",1);
        cache.put("2",2);
        cache.put("3",3);
        log.info("cache=={}", cache.toString());
        cache.get("1");
        cache.get("2");
        cache.put("5",5);
        log.info("cache=={}", cache.toString());


    }
}
