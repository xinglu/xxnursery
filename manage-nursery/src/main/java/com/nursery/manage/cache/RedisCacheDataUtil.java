package com.nursery.manage.cache;

import org.junit.platform.commons.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.Protocol;

import java.util.Map;
import java.util.Set;

/**
 * 缓存工具类
 */
@Component
public class RedisCacheDataUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisCacheDataUtil.class);
    //集群名称
    private String clusterName = null;
    private boolean localCache = false;
    private JedisCluster jedisCluster;


    public RedisCacheDataUtil() {

    }

    public RedisCacheDataUtil(String clusterName, JedisCluster jedisCluster) {
        this.clusterName = clusterName;
        this.jedisCluster = jedisCluster;
    }

    public RedisCacheDataUtil(String clusterName, boolean localCache, JedisCluster jedisCluster) {
        this.clusterName = clusterName;
        this.localCache = localCache;
        this.jedisCluster = jedisCluster;
    }

    public JedisCluster getJedisCluster() {
        return jedisCluster;
    }

    public void setJedisCluster(String clusterName, JedisCluster jedisCluster) {
        this.clusterName = clusterName;
        this.jedisCluster = jedisCluster;
    }

    private String IS_OK = Protocol.Keyword.OK.name();

    /**
     * 判断key是否存在
     *
     * @param key
     * @return
     */
    public boolean isExist(String key) {
        return jedisCluster.exists(key.getBytes());
    }

    public boolean isExist(byte[] key) {
        return jedisCluster.exists(key);
    }


    /**
     * 根据key从缓存中删除
     *
     * @param key
     * @return
     */
    public Long del(String key) {
        return jedisCluster.del(key.getBytes());
    }

    public Long del(byte[] key) {
        return jedisCluster.del(key);
    }

    public Long del(String... keys) {
        return jedisCluster.del(keys);
    }

    public Long del(byte[]... keys) {
        return jedisCluster.del(keys);
    }

    //将string 放入缓存
    public boolean put2Cache(String cacheKey, String value) {
        boolean flag = false;
        byte[] keyBytes = cacheKey.getBytes();
        byte[] valueBytes = value.getBytes();
        String result = jedisCluster.set(keyBytes, valueBytes);
        if ("OK".equals(result)) {
            flag = true;
        }
        return flag;
    }

    //将string 放入缓存
    public boolean put2Cache(String cacheKey, String value, int seconds) {
        boolean flag = false;
        if (seconds>0){
            byte[] keyBytes = cacheKey.getBytes();
            byte[] valueBytes = value.getBytes();
            String result = jedisCluster.setex(keyBytes, seconds, valueBytes);
            if ("OK".equals(result)) {
                flag = true;
            }
        }
        return flag;
    }

    public String getString(String key){
        String value = "";
        byte[] result = jedisCluster.get(key.getBytes());
        if (result != null && result.length!=0){
            value = new String(result);
        }
        return value;
    }

    public Long incr(String key){
        return jedisCluster.incr(key.getBytes());
    }

    public Long decr(String key){
        return jedisCluster.decr(key.getBytes());
    }

    //从缓存中获取map集合
    public Map<String,String> getMap(String key){
        return jedisCluster.hgetAll(key);
    }

    public Map<byte[],byte[]> getMap(byte[] key){
        return jedisCluster.hgetAll(key);
    }

    //将无序集合存进缓存
    public Long putAdd(String key,String... value){
        return jedisCluster.sadd(key,value);
    }

    //将无序集合存进缓存
    public Set<String> getSet(String key){
        return jedisCluster.smembers(key);
    }

    //将value插入到列表表头
    public Long lpush(String key,String... values){
        return jedisCluster.lpush(key,values);
    }

    public Long rpush(String key,String... values){
        return jedisCluster.rpush(key,values);
    }

    //删除 list value
    public String lpop(String key,String... values){
        return jedisCluster.lpop(key);
    }

    public String rpop(String key,String... values){
        return jedisCluster.rpop(key);
    }


    //将有序集合存入缓存
    public long zadd(String key,double score,String member){
        return jedisCluster.zadd(key.getBytes(),score,member.getBytes());
    }

    //返回缓存的key的生命周期
    public long ttl(String cachekey){
        return jedisCluster.ttl(cachekey.getBytes());
    }

    //缓存追加值
    public boolean append(String key,String appendValue,int seconds){
        boolean flag = false;
        if (seconds>0){
            String result = "";
            String value = getString(key);
            if (StringUtils.isNotBlank(value)){
                result = jedisCluster.setex(key.getBytes(), seconds, (value + appendValue).getBytes());
            }else {
                result = jedisCluster.setex(key.getBytes(), seconds, appendValue.getBytes());
            }
            if ("OK".equals(result)){
                flag = true;
            }
        }
        return flag;
    }


    //删除一个或多个缓存 不存在缓存key会被忽略
    public void delCache(String... cacheKey){
        for (String key : cacheKey) {
            jedisCluster.del(key.getBytes());
        }
    }

    //获取缓存集合长度
    public long llen(String key){
        return jedisCluster.llen(key.getBytes());
    }


    //获取指定位置的缓存值
    public String lindex(String key,long index){
        return jedisCluster.lindex(key,index);
    }

}