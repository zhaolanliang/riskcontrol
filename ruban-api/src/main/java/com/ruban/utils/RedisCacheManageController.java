package com.ruban.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.util.StringUtils;
 
import io.lettuce.core.Range;
import io.lettuce.core.cluster.api.sync.RedisAdvancedClusterCommands;
/**
 * 
 * @author zhaolanliang
 * Reids通用方法
 */
@RestController
public class RedisCacheManageController {
	private static final Logger logger = LoggerFactory.getLogger(RedisCacheManageController.class);
	@Autowired
	private RedisAdvancedClusterCommands<String,String> lettuceCommands;
	
	/**
	 * Redis缓存数据
	 * @param key
	 * @param value
	 * @return value
	 */
	@RequestMapping("setKey")
	public String setRedisKey(String key,String value) {
		lettuceCommands.set(key,value);
		String result = lettuceCommands.get(key);
		logger.info("设置成功");
		return result;
	}
	
	/**
	 * 获取Redis值
	 * @param key
	 * @return value
	 */
	@RequestMapping("getKey")
	public String getRedisKey(String key) {
		String value = lettuceCommands.get(key);
		return value;
	}
	
	/**
	 * 删除Redis缓存
	 * @param keys
	 * @return 
	 */
	@RequestMapping("delKey")
	public String delRedisKey(String... keys) {
		logger.info("删除Redis数据："+keys);
		if(keys==null || keys.length==0) {
			return "未接收到key";
		}
		Long delNum = lettuceCommands.del(keys);
		String result=null;
		if(delNum==keys.length) {
			result = "删除成功";
		}else {
			result = "删除失败"+keys;
		}
		return result;
	}
	
	/** 
	 * 获取Redis值
	 * @param key
	 * @return value
	 */
	@RequestMapping("pfdd")
	public Long pfdd(String key,String... values) {
		lettuceCommands.pfadd(key, values);
		Long pfcount = lettuceCommands.pfcount(key);
		return pfcount;
	}	
	 
	/**
	 * 时间窗口限制流量工具类（redis 实现）
     *
     * @param key 键值Key
     * @param obj 此对象在set中不能重复，如有重复会更新score
     * @param timeWin 时间窗口
     * @param maxCount 每次时间窗口容忍的最大请求数量
     * @return
     */
	@SuppressWarnings("null")
	@RequestMapping("isActionAllow")
    public boolean isActionAllow(String key, int timeWin, int maxCount) {
        if (StringUtils.isEmpty(key) || timeWin == 0 || maxCount == 0) {
            return false;
        }
        long curTime = System.currentTimeMillis();
        //将数据插入进Redis
        lettuceCommands.zadd(key, curTime);
        Range<Long> range = null;
        range.gte(0l);
        range.lte(curTime-timeWin);
        //移除当前时间减去滑动窗口内的时间之前的数据
		lettuceCommands.zremrangebyscore(key, range);
		//统计去重后的数量
        Long zcard = lettuceCommands.zcard(key);
        //设置过期时间
        lettuceCommands.expire(key, timeWin);
        if(zcard>=maxCount) {
        	return true;
        	
        }
        return true;
    }
}
