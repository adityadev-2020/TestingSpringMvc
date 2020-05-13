package com.transvision.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.transvision.app.controller.Controller;

public class Tester {

	public static void main(String[] args) {

		ApplicationContext container=new ClassPathXmlApplicationContext("DispathcherServlet-servlet.xml");
		Controller c=container.getBean(Controller.class);
		System.out.println(c);
	}
}
