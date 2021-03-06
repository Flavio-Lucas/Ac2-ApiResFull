//#region imports

package com.escolinha.pooac2.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.escolinha.pooac2.models.Course;

import org.springframework.stereotype.Component;

//#endregion

@Component
public class CourseRepository {

  /**
   * Lista de cursos
   */
  private ArrayList<Course> courses = new ArrayList<Course>(); 
  private static int nextId = 0;

  /**
   * Metodo que inicializa cursos genericos para efeito de testes
   */
  @PostConstruct
  public void registerCourse() {
    
    Course co1 = new Course();
    Course co2 = new Course();

    co1.setCategory("programação");
    co1.setHours(40);
    co1.setIdCourse(1);
    co1.setName("TypeScript");
    co1.setIdSchool(1);

    courses.add(co1);

    co2.setCategory("programação");
    co2.setHours(40);
    co2.setIdCourse(2);
    co2.setName("Java/ Spring boot");
    co2.setIdSchool(2);

    courses.add(co2);

    nextId = 2;
    
  }

  /**
   * Metodo que lista os cursos
   */
  public List<Course> getAllCourses(){
    return courses;
  }

  /**
   * Metodo que retorna um curso através de seu identificador
   * @param IdCourse identificador do curso
   * @return
   */
  public Optional<Course> getCourseById(int IdCourse){
    for(Course item: courses){
      if(item.getIdCourse() == IdCourse){
        return Optional.of(item);
      }
    }
    return Optional.empty();
  }

  /**
   * Metodo que atualiza um curso
   * 
   * @param course
   */
  public Course update(Course course) {
    Course item = getCourseById(course.getIdCourse()).get();

    if(item != null){
      item.setHours(course.getHours());
    }
    return item;
  }

  /**
   * Metodo que salva um curso e adiciona ele a lista
   * 
   * @param course curso a ser adicionado
   */
  public Course saveCourse(Course course){
    course.setIdCourse(++nextId);
    courses.add(course);
    return course;
  }

  /**
   * Metodo que remove um curso da lista
   * 
   * @param course curso a ser removido
   */
  public void removeCourse(Course course){
    courses.remove(course);
  }
}
