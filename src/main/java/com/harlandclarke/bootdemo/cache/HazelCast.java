package com.harlandclarke.bootdemo.cache;

import com.hazelcast.core.HazelcastInstance;

import java.util.concurrent.ConcurrentMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HazelCast {
    @Autowired
    private HazelcastInstance h;
    ConcurrentMap<String, String> map;

    public HazelCast() {
        System.out.println("-------------------> Initializing Cache");
    }


    public void put(String key, String value) {
        map = h.getMap("servicecache");
        map.put(key, value);

    }

    public String get(String key) {
        map = h.getMap("servicecache");
        return  map.get(key);
    }
}
