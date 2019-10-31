package com.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class MySqlCustomerDal implements ICustomerDal {

	@Value("${database.connection.string}")
	private String connectionString;

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	@Override
	public void add() {
		System.out.println("Connection String: " + this.connectionString);
		System.out.println("Mysql veritabanýna kaydedildi");
	}

}
