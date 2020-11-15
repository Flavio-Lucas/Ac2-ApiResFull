package com.escolinha.pooac2.services;

import java.util.List;
import java.util.Optional;

import com.escolinha.pooac2.DTO.DTOUpdateCourse;
import com.escolinha.pooac2.models.Course;
import com.escolinha.pooac2.models.School;
import com.escolinha.pooac2.repository.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CourseServices {
  

  @Autowired
  private CourseRepository courseRepository;

  @Autowired
  private SchoolServices schoolServices;
  
  public List<Course> getAllCourses(){
      return courseRepository.getAllCourses();
  }
  
  public Course getCourseById(int IdCourse){
      Optional<Course> exist = courseRepository.getCourseById(IdCourse);
      return exist.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Código do curso inválido"));

  }

  public Course UpdateFromDTO(DTOUpdateCourse courseDTO){
    Course course = new Course();
    course.setHours(courseDTO.getHours());
    return course;
  }

  public Course updateCourse(Course course) {
    getCourseById(course.getIdCourse());
    return courseRepository.update(course);
  }

  public Course saveCourse(Course course, int IdSchool){
      School school = schoolServices.getSchoolById(IdSchool);
      
      course.setIdSchool(school.getIdSchool());
      school.addCourse(course);
      return courseRepository.saveCourse(course);
  }

  public void removeCourse(int IdCourse){
    courseRepository.removeCourse(getCourseById(IdCourse));
  }
}
