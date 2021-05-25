package com.ruban.utils;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.lettuce.core.RedisURI;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.async.RedisAdvancedClusterAsyncCommands;
import io.lettuce.core.cluster.api.sync.RedisAdvancedClusterCommands;

@Configuration
public class LettuceClusterConfig {
	private static final Logger logger = LoggerFactory.getLogger(LettuceClusterConfig.class);
	@Value("${spring.profiles.active}")
	private String profiles;
	@Value("${redis.cluster.maxTotal}")
	private Integer maxTotal;
	@Value("${redis.cluster.maxIdle}")
	private Integer maxIdle;
	@Value("${redis.cluster.maxWaitMillis}")
	private Integer maxWaitMillis;
	
	@Value("${resis.cluster.password}")
	private String password;
	@Value("${redis.hostPorts}")
	private String hostPortsStr;
	
	@Bean
	public RedisClusterClient lettuceClient() {
		logger.info("Redis密码："+password);
		List<RedisURI> redisURIList = new ArrayList<>();
		String[] hostPortList=hostPortsStr.split(",");
		for (String hostPortStr : hostPortList) {
			String[] hostPortArr = hostPortStr.split(":");
			RedisURI  redisURI=RedisURI.create(hostPortArr[0],Integer.parseInt(hostPortArr[1]));
			redisURI.setPassword(password);
			redisURIList.add(redisURI);
			
		}
		 return RedisClusterClient.create(redisURIList);
	}
	
	/**
	 * lettuce同步连接
	 * @return lettuce同步连接对象
	 */
	@Bean
	public RedisAdvancedClusterCommands<String, String> lettuceCommands(){
		return this.lettuceClient().connect().sync();
	}
	
	/**
	 * lettuce异步连接
	 * @return lettuce异步连接对象
	 */
	@Bean
	public RedisAdvancedClusterAsyncCommands<String, String> lettuceAsyncCommands(){
		return this.lettuceClient().connect().async();
	}
}
