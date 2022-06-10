package com.zensar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zensar.*;
import com.zensar.beans.Student;
import com.zensar.config.JavaConfiguration;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
        //System.out.println( "Hello World!" );
    //ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    
    //System.out.println(context);
    /*
    Product p =(Product)context.getBean("product");
    System.out.println(p);
    Product p1 =(Product)context.getBean("pro2");
    System.out.println(p1);
    Product p2 = context.getBean("pro2", Product.class);
    System.out.println(p2);
    Product p3 = context.getBean( Product.class,"pro2");
    System.out.println(p3);
    */
    	AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(JavaConfiguration.class);
    Student st=context.getBean(Student.class,"stud");
    Student st1=context.getBean(Student.class,"stud");
    System.out.println(st.hashCode());
    System.out.println(st1.hashCode());
    System.out.println(st);
    System.out.println(st1);
    //((AbstractApplicationContext)context).close();
    }
}
