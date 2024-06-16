package com.spring.orm;

import java.util.List;
import java.util.Scanner;

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
        
		/*
		 * Student student = new Student(101, "Ravindra Kadam", "Pune");
		 * 
		 * int i = dao.insert(student); System.out.println("Record inserted : " + i);
		 */
        Scanner sc = new Scanner(System.in);
        int ch;
        do {
        	System.out.println("______________________________________________________________________");
	        System.out.println("\t\t\t| * Student Menu * |");
	        System.out.println("______________________________________________________________________");
	        System.out.println("\t1. Add New Student");
	        System.out.println("\t2. Update Student");
	        System.out.println("\t3. Delete Student Student");
	        System.out.println("\t4. Search Student");
	        System.out.println("\t5. Display All Student");
	        System.out.println("\t6. Exit");
	        System.out.println("______________________________________________________________________");
	        System.out.println("Enter your choice : ");
	        ch = sc.nextInt();
	        System.out.println("______________________________________________________________________");
	        switch (ch) {
			case 1:
				System.out.println("Enter Student id : ");
				int id = sc.nextInt();
				System.out.println("Enter Student Name : ");
				String name = sc.next();
				System.out.println("Enter Student City : ");
				String city = sc.next();
				Student student = new Student(id, name, city);
				int i = dao.insert(student);
				System.out.println("Record inserted : " + i);
				break;
			case 2:
				List<Student> students = dao.getAllStudents();
				for(Student student2 : students) {
					System.out.println(student2);
				}
				System.out.println("\nEnter Student id : ");
				id = sc.nextInt();
				System.out.println("Enter Student Name : ");
				name = sc.next();
				System.out.println("Enter Student City : ");
				city = sc.next();
				student = new Student(id, name, city);
				dao.update(student);
				students = dao.getAllStudents();
				for(Student student2 : students) {
					System.out.println(student2);
				}
				break;
			case 3:
				students = dao.getAllStudents();
				for(Student student2 : students) {
					System.out.println(student2);
				}
				System.out.println("\nEnter Student id to delete record : ");
				id = sc.nextInt();
				dao.delete(id);
				dao.getAllStudents();
				students = dao.getAllStudents();
				for(Student student2 : students) {
					System.out.println(student2);
				}
				break;
			case 4:
				System.out.println("Enter id to search record : ");
				id = sc.nextInt();
				student = dao.getStudent(id);
				if(student == null) {
					System.out.println("Record not found...!");
				}
				else {
					System.out.println(student);
				}
				break;
			case 5:
				students = dao.getAllStudents();
				for(Student student2 : students) {
					System.out.println(student2);
				}
				break;
			default:
				System.out.println();
				break;
			}
        }while(ch != 6); 
        System.out.println("Thank you for using this application...Visit Again...!");
    }
}
