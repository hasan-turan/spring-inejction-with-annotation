package com.springdemo;

import java.io.File;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.springdemo.enums.EnumDatabaseType;
import com.springdemo.exceptions.DatabaseTypeException;
import com.springdemo.helpers.PropertyFileHelper;

@Configuration
@ComponentScan("com.springdemo")
@PropertySource("classpath:application.properties")
public class IocConfig {
	@Bean
	public ICustomerDal database() throws DatabaseTypeException {

		PropertyFileHelper fileHelper = new PropertyFileHelper(
				new File("src/application.properties").getAbsolutePath());
		String databaseType = fileHelper.getProperty("database.type");

		if (databaseType.equals(EnumDatabaseType.MSSQL.getValue())) {
			return new MsSqlCustomerDal();
		} else if (databaseType.equals(EnumDatabaseType.MYSQL.getValue())) {
			return new MySqlCustomerDal();
		} else if (databaseType.equals(EnumDatabaseType.ORACLE.getValue())) {
			return new OracleCustomerDal();
		} else {
			throw new DatabaseTypeException("Please specify database type in application.properties");
		}

	}

	@Bean
	public ICustomerService customerService() throws DatabaseTypeException {
		return new CustomerManager(database());
	}

}
