package com.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.springdemo.enums.EnumDatabaseType;
import com.springdemo.exceptions.DatabaseTypeException;
import com.springdemo.helpers.PropertyFileHelper;

@Configuration
@ComponentScan("com.springdemo")
public class IocConfig {
	@Bean
	public ICustomerDal database() throws DatabaseTypeException {
		PropertyFileHelper fileHelper = new PropertyFileHelper("classpath:application.properties");
		String databaseType = fileHelper.getProperty("database.type");
		if (databaseType == EnumDatabaseType.MYSQL.getValue()) {
			return new MsSqlCustomerDal();
		} else if (databaseType == EnumDatabaseType.MYSQL.getValue()) {
			return new MySqlCustomerDal();
		} else if (databaseType == EnumDatabaseType.ORACLE.getValue()) {
			return new OracleCustomerDal();
		} else {
			throw new DatabaseTypeException("Please specify database type in application.properties");
		}

	}
}
