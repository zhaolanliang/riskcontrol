package com.zll.riskcontrol.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DruidUserConfig {
	@Value("${spring.datasource.user.password}")
	private String password;
	private static final Logger logger = LoggerFactory.getLogger(DruidUserConfig.class);
	
	@Primary
	@Bean(name = "userDataSource", initMethod = "init", destroyMethod = "close")
	@ConfigurationProperties(prefix  = "spring.datasource.user")
	public DruidDataSource dataSource() {
		logger.info("开始创建用户sqlSessionFactoryUser");
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setPassword(password);
		return dataSource;
	}
}
