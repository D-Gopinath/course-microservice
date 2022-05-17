package com.ecommerceapp.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerceapp.model.Course;
import com.ecommerceapp.model.CourseMenu;
import com.ecommerceapp.model.UserCourse;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
	@Query("select new com.ecommerceapp.model.Course(c.id,c.category,c.cName,c.tutor,c.duration,c.imageurl,c.description) from com.ecommerceapp.model.Course c where c.id=:cid")
	Course viewCourse(Integer cid);
	
	@Query("select new com.ecommerceapp.model.Course(c.id,c.category,c.cName,c.tutor,c.duration,c.imageurl,c.description) from com.ecommerceapp.model.Course c where c.cName=:cname")
	Course findByCourseName(@Param("cname") String cname);
	 
	 @Query("select new com.ecommerceapp.model.Course(c.id,c.category,c.cName,c.tutor,c.duration,c.imageurl,c.description) from com.ecommerceapp.model.Course c")
	 List<Course> viewAllCourse();
	 
	 @Query("select new com.ecommerceapp.model.CourseMenu(cm.id,cm.category,cm.image) from com.ecommerceapp.model.CourseMenu cm")
	 List<CourseMenu> courseCategory();
	 
	 @Query("select new com.ecommerceapp.model.Course(c.id,c.category,c.cName,c.tutor,c.duration,c.imageurl,c.description) from com.ecommerceapp.model.Course c where c.cId =:cId")
	 List<Course> viewCourseByType(Integer cId);
	 
	 Course save(Course course);
	 
	 @Modifying
	 @Query("delete from com.ecommerceapp.model.Course c where c.id=:id")
	 void deleteById(@Param("id") Integer id);
	 
	 UserCourse save(UserCourse userCourse);
}
