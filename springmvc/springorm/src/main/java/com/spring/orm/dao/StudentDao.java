package com.spring.orm.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {
  private HibernateTemplate hibernateTemplate;
private Serializable studentId;
  
	
	public HibernateTemplate getHibernateTemplate() {
	return hibernateTemplate;
}


public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
}

     @Transactional
	public int insert(Student student) 
	{
		//insert
		Integer i=(Integer) this.hibernateTemplate.save(student) ;
		return 1;
	}
     //get single data 
     public Student getStudent(int studentId) 
     {
        Student student = this.hibernateTemplate.get(Student.class, studentId);
        return student;
     }
     //get all students(all rows)
     public List<Student> getAllStudents()
     {
    	 List<Student> students = this.hibernateTemplate.loadAll(Student.class);
    	 return students;
     }
     //deleting
     @Transactional
     public void deleteStudent(int studentId) 
     {
    	 Student student = this.hibernateTemplate.get(Student.class, studentId );
    	 this.hibernateTemplate.delete(student);
     }
     //updating the data
     @Transactional
     public void updateStudent(Student student) 
     {
    	 this.hibernateTemplate.update(student);
     }
}
