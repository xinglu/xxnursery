package com.nursery.nurserymanage2.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * JVM 缓存工具类
 *
 */
@Component
public class JVMCacheDataUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JVMCacheDataUtil.class);
    public static final Map map = new ConcurrentHashMap();

    public static String getStringCache(String key) {
        String value = (String) map.get(key);
        return value;
    }

    public static Map getMapCache(String key) {
        Map value = (Map) map.get(key);
        return value;
    }

    public static List getListCache(String key) {
        List value = (List) map.get(key);
        return value;
    }

    public static Object getObjectCache(String key) {
        Object value = map.get(key);
        return value;
    }

    public static boolean delCache(String Key) {
        boolean result = false;
        try {
            map.remove(Key);
            result = true;
        } catch (Exception e) {
            LOGGER.error("删除缓存异常",e);
            result = false;
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public static boolean putStringCache(Map<String, String> dataMap) {
        boolean result = false;
        for (Iterator iterator = dataMap.entrySet().iterator(); iterator.hasNext(); ) {
            Map.Entry entry = (Map.Entry) iterator.next();
            try {
                map.put(entry.getKey(), entry.getValue());
                result = true;
            } catch (Exception e) {
                LOGGER.error("加载缓存异常-Map_string ",e);
                result = false;
                break;
            }
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public static boolean putMapCache(Map<String, Map<String, String>> dataMap) {
        boolean result = false;
        for (Iterator iterator = dataMap.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry entry = (Map.Entry) iterator.next();
            try {
                map.put(entry.getKey(), entry.getValue());
                result = true;
            } catch (Exception e) {
                LOGGER.error("加载缓存异常-Map_Map ",e);
                result = false;
                break;
            }
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public static boolean putListCache(Map<String,List> dataMap){
        boolean result = false;
        for (Iterator iterator = dataMap.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry entry = (Map.Entry) iterator.next();
            try {
                map.put(entry.getKey(), entry.getValue());
                result = true;
            } catch (Exception e) {
                LOGGER.error("加载缓存异常-Map_List ",e);
                result = false;
                break;
            }
        }
        return result;
    }



}
