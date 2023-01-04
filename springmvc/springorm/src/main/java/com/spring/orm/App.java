package com.spring.orm;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

//        Student student =new Student(124,"abid","rourekila");
//        
//        int r = studentDao.insert(student);
//        System.out.println("done"+r);
//		Student student = studentDao.getStudent(123);
//		System.out.println(student.getStudentId());
//		System.out.println(student.getStudentName());
//		System.out.println(student.getStudentCity());
		Scanner sc=new Scanner(System.in);
		boolean go=true;
		while(go) {
			System.out.println("press 1 to add a student");
			System.out.println("press 2 to display all student");
			System.out.println("press 3 to get details of a single student");
			System.out.println("press 4 to delete a student");
			System.out.println("press 5 to update a student");
			System.out.println("press 6 to exit");
			try {
				int input=sc.nextInt();
				
				switch (input) {
				case 1:
					//add a new student
					//taking input from the user
					System.out.println("enter the userid");
					int uId=sc.nextInt();
					
					System.out.println("enter username");
					String uName=sc.next();
					
					System.out.println("enter usercity");
					String uCity=sc.next();
					
					//creating the object
					Student s=new Student();
					s.setStudentId(uId);
					s.setStudentName(uName);
					s.setStudentCity(uCity);
					
					//saving the data into database
					int r = studentDao.insert(s);
					System.out.println("user added"+r);
					System.out.println("++++++++++++++++++++++++++++++++++++++");
					System.out.println();
					break;
				case 2:
					//display all student
					List<Student> allStudents = studentDao.getAllStudents();
					for (Student st : allStudents) {
						System.out.println("id"+st.getStudentId());
						System.out.println("Name"+st.getStudentName());
						System.out.println("city"+st.getStudentCity());
						System.out.println("___________________________________");
					}
					System.out.println("++++++++++++++++++++++++++++++++++++++++");
					break;
				case 3:
					//get single data
					System.out.println("enter user id");
					int uId1=sc.nextInt();
					Student student = studentDao.getStudent(uId1);
					System.out.println(student.getStudentId());
					System.out.println(student.getStudentName());
					System.out.println(student.getStudentCity());
					break;
					
				case 4:
					//deleting
					System.out.println("enter userid");
					int id=sc.nextInt();
					studentDao.deleteStudent(id);
					System.out.println("student deleted");
					break;
				case 5:
					//updating a student
					System.out.println("enter user id");
					int id1=sc.nextInt();
					System.out.println("enter username");
					String userName=sc.next();
					System.out.println("enter usercity");
					String userCity=sc.next();
					
					Student s1=new Student();
					s1.setStudentId(id1);
					s1.setStudentName(userName);;
					s1.setStudentCity(userCity);
					  studentDao.updateStudent(s1);
					break;
				case 6:
					go=false;
					break;
				default:
				    System.out.println("wrong input");
					break;
				}
			} catch (Exception e) {
				System.out.println("invalid input try with another one!");
				System.out.println(e.getMessage());
			}
		}
		System.out.println("thanks");
	}
}
