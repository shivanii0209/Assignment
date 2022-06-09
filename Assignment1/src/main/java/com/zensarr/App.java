package com.zensarr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensarr.beans.Employee;

/**
 * Hello world!
 *
 */
public class App{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    	Employee st=context.getBean(Employee.class,"em");
    	System.out.println(st);
    }
}
