package in.ashokit.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ashokit.config.Appconfig;
import in.ashokit.service.Userservice;

public class Myapp {
		public static void main(String[] args) {

			// Starting IOC Container
			ApplicationContext ctxt = new AnnotationConfigApplicationContext(Appconfig.class);

			// Getting Spring Bean obj from IoC
			Userservice us = ctxt.getBean(Userservice.class);

			// calling user service bean method
			us.getName();

		}
	}


