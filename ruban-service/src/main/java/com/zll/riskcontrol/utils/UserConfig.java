package com.zll.riskcontrol.utils;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages  = "com.zll.riskcontrol.usermapper",sqlSessionFactoryRef = "sqlSessionFactoryUser")
public class UserConfig {
	@Autowired
	@Qualifier("userDataSource")
	private  DataSource dataSource;
	
	@Bean
	public SqlSessionFactory sqlSessionFactoryUser() {
		TransactionFactory transactionFactory = new SpringManagedTransactionFactory();
		Environment environment = new Environment("user",transactionFactory,dataSource);
		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration(environment);
		configuration.setMapUnderscoreToCamelCase(true);
		SqlSessionFactoryBuilder builder =new SqlSessionFactoryBuilder();
		return builder.build(configuration);
		
	}

}
