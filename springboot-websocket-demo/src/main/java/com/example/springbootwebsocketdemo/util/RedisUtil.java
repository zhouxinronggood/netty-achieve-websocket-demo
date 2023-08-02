package com.example.springbootwebsocketdemo.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * @Description Redis工具类
 * @Author zhouxinrong
 * @Date 2023/7/30
 * @Version 1.0
 */
//@Component
public class RedisUtil {

    private static Log log = LogFactory.getLog(RedisUtil.class);

    //@Autowired
    public RedisTemplate redisTemplate;

    //@Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 发布
     *
     * @param key
     */
    public void publish(String key, String value) {
        stringRedisTemplate.convertAndSend(key, value);
    }

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key   缓存的键值
     * @param value 缓存的值
     */
    public <T> void setCacheObject(final String key, final T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key      缓存的键值
     * @param value    缓存的值
     * @param timeout  时间
     * @param timeUnit 时间颗粒度
     */
    public <T> void setCacheObject(final String key, final T value, final Integer timeout, final TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    /**
     * 设置有效时间
     *
     * @param key     Redis键
     * @param timeout 超时时间
     * @return true=设置成功；false=设置失败
     */
    public boolean expire(final String key, final long timeout) {
        return expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 设置有效时间
     *
     * @param key     Redis键
     * @param timeout 超时时间
     * @param unit    时间单位
     * @return true=设置成功；false=设置失败
     */
    public boolean expire(final String key, final long timeout, final TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }

    /**
     * 获得缓存的基本对象。
     *
     * @param key 缓存键值
     * @return 缓存键值对应的数据
     */
    public <T> T getCacheObject(final String key) {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }

    /**
     * 生成自定义前缀编码
     *
     * @return str 标识符
     */
    public String generateSeq(String str) {
        LocalDateTime dateTime = LocalDateTime.now();
        String dateStr = dateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHH"));
        DecimalFormat df = new DecimalFormat("0000");
        RedisAtomicLong counter = new RedisAtomicLong(str, redisTemplate.getConnectionFactory());
        long count = counter.incrementAndGet();
        StringBuilder sb = new StringBuilder(str).append(dateStr).append(df.format(count));
        return sb.toString();
    }

    /**
     * 生成编码
     *
     * @return str 标识符
     */
    public String generateNoPrefixSeq(String strKey) {
        LocalDateTime dateTime = LocalDateTime.now();
        String dateStr = dateTime.format(DateTimeFormatter.ofPattern("yyyyMMddHH"));
        DecimalFormat df = new DecimalFormat("0000");
        RedisAtomicLong counter = new RedisAtomicLong(strKey, redisTemplate.getConnectionFactory());
        long count = counter.incrementAndGet();
        StringBuilder sb = new StringBuilder(dateStr).append(df.format(count));
        return sb.toString();
    }

    /**
     * 判断key是否存在
     *
     * @param key
     * @return
     */
    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 值+1
     */
    public void incr(String key) {
        redisTemplate.opsForValue().increment(key, 1);
    }

    /**
     * 值-1
     */
    public void decr(String key) {
        redisTemplate.opsForValue().decrement(key, 1);
    }

    /**
     * 判断key是否过期
     *
     * @param key
     * @return
     */
    public boolean isExpire(String key) {
        return expire(key) > 0 ? false : true;
    }


    /**
     * 从redis中获取key对应的过期时间;
     * 如果该值有过期时间，就返回相应的过期时间;
     * 如果该值没有设置过期时间，就返回-1;
     * 如果没有该值，就返回-2;
     *
     * @param key
     * @return
     */
    public long expire(String key) {
        return redisTemplate.opsForValue().getOperations().getExpire(key);
    }

    /**
     * 自定义参数加锁：自定义key，过期时间，
     * @param lockKey 自定义key
     * @param lockValue 自定义value
     * @param timeOut 过期时间数值，比如：10L，该方法中为10s
     * @return
     */
    public Boolean getCustomParamsLock(String lockKey, String lockValue, Long timeOut) {
        //如果该键已经存在，则不设置，并返回false，否则设置并返回true
        Boolean lockStatus = this.redisTemplate.opsForValue().setIfAbsent(lockKey, lockValue, Duration.ofSeconds(timeOut));
        //Redis异常情况时#.setIfAbsent() 会返回null的情况,则不进行加锁处理
        if(lockStatus.equals(null)){
            return true;
        }else{
            return lockStatus;
        }
    }

    /**
     * 自定义参数释放锁
     * @param lockKey 自定义key
     * @param lockValue 自定义value
     */
    public void releaseCustomParamsLock(String lockKey, String lockValue) {
        //setIfAbsent() 会返回null的情况，故释放之前先判断redis中是否存在该key：.hasKey()方法，当这个key存在，那么hasKey()方法返回true，否则返回false。
        if(redisTemplate.hasKey(lockKey)) {
            String luaScript = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            RedisScript<Long> redisScript = new DefaultRedisScript<>(luaScript, Long.class);
            //传递的Redis命令需要访问的key不存在，不会抛出异常，而是返回一个null值，兼容setIfAbsent() 会返回null的情况
            Long releaseStatus = (Long) this.redisTemplate.execute(redisScript, Collections.singletonList(lockKey), lockValue);
            //判断结果异常
            if (releaseStatus == null) {
                throw new IllegalMonitorStateException("当前锁不属于你, 解锁失败!");
            }
        }else{
            log.warn("releaseCustomParamsLock()方法需要释放锁的key在redis中不存在！");
        }
    }
}
