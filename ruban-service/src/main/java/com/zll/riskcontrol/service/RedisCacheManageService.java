package com.zll.riskcontrol.service;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import io.lettuce.core.cluster.api.sync.RedisAdvancedClusterCommands;
import net.agkn.hll.HLL;
/**
 * 
 * @author zhaolanliang
 * Reids通用方法
 */
@Service
public class RedisCacheManageService {
	private static final Logger logger = LoggerFactory.getLogger(RedisCacheManageService.class);
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
	public String getRedisKey(String key) {
		String value = lettuceCommands.get(key);
		return value;
	}
	
	/**
	 * 删除Redis缓存
	 * @param keys
	 * @return 
	 */
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
	
	 @Test
	    public void testSimpleUse(){
	        final int seed = 123456;
	        HashFunction hash = Hashing.murmur3_128(seed);
	        // data on which to calculate distinct count
	        final Integer[] data = new Integer[]{1, 1, 2, 3, 4, 5, 6, 6,
	                6, 7, 7, 7, 7, 8, 10};
	        final HLL hll = new HLL(13, 5); //number of bucket and bits per bucket
	        for (int item : data) {
	            final long value = hash.newHasher().putInt(item).hash().asLong();
	            hll.addRaw(value);
	        }
	        System.out.println("Distinct count="+ hll.cardinality());
	    }
}
