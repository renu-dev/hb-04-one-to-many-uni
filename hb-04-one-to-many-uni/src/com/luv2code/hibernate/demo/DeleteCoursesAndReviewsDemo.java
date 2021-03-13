package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class DeleteCoursesAndReviewsDemo {

	public static void main(String[] args) {

		//create session factory
		SessionFactory factory = new Configuration()
				                 .configure()
				                 .addAnnotatedClass(Instructor.class)
				                 .addAnnotatedClass(InstructorDetail.class)
				                 .addAnnotatedClass(Course.class)
				                 .addAnnotatedClass(Review.class)
				                 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//begin or start transaction
			session.beginTransaction();
			
			//get course by id
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			
			//print the course
			System.out.println("Course is: "+tempCourse);
			
			//print reviews
			System.out.println("Review is: "+tempCourse.getReviews());
			
			//delete the course
			session.delete(tempCourse);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
