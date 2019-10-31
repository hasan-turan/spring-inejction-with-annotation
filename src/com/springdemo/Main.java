package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IocConfig.class);

		ICustomerDal customerDal = context.getBean("database", ICustomerDal.class);
//		CustomerManager customerManager = new CustomerManager(context.getBean("database", ICustomerDal.class));
//		customerManager.add();
		customerDal.add();
	}

}
