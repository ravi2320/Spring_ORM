package com.spring.orm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.model.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao dao = context.getBean("studentDao", StudentDao.class);
        
        Student student = new Student(103, "Ramesh Kumar", "Goa");
        
        int i = dao.insert(student);
        System.out.println("Record inserted : " + i);
    }
}
