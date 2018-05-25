package com.stumanage.common;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by 15295 on 2018/2/25.
 */
public class TokenCache {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(TokenCache.class);

    public static final String TOKEN_PREFIX = "token_";

    //LRU算法
    // 给定时间内没有被读/写访问，则回收。

    //CacheBuilder的构造函数是私有的，只能通过其静态方法newBuilder()来获得CacheBuilder的实例
    //.initialCapacity(1000) 设置缓存容器的初始容量为1000;.maximumSize(10000)设置缓存最大容量为10000，超过10000之后就会按照LRU最近虽少使用算法来移除缓存项;设置写缓存后12h过期
    //build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
    private static LoadingCache<String, String> localCache = CacheBuilder.newBuilder().initialCapacity(1000).maximumSize(10000).expireAfterAccess(12, TimeUnit.HOURS)
            .build(new CacheLoader<String, String>() {
                //默认的数据加载实现，当调用get取值的时候，如果key没有对应的值，就调用这个方法进行加载
                @Override
                //当本地缓存命没有中时，调用load方法获取结果并将结果缓存
                public String load(String s) throws Exception {
                    return "null";
                }
            });
    public static void setKey(String key, String value) {
        localCache.put(key, value);
    }
    public static String getKey(String key) {
        String value = null;
        try {
            value = localCache.get(key);
            if ("null".equals(value)) {
                return null;
            }
            return value;
        }catch (Exception e) {
            logger.error("localCache get error",e);
        }
        return null;
    }
}
