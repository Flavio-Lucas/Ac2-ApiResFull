//#region imports

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

//#endregion

@Service
public class CourseServices {
  

  @Autowired
  private CourseRepository courseRepository;

  @Autowired
  private SchoolServices schoolServices;
  
  /**
   * Metodo que lista todos os cursos
   */
  public List<Course> getAllCourses(){
      return courseRepository.getAllCourses();
  }
  
  /**
   * MEtodo que Retorna um curso com base em seu identificador
   * 
   * @param IdCourse identificador do curso
   */
  public Course getCourseById(int IdCourse){
      Optional<Course> exist = courseRepository.getCourseById(IdCourse);
      return exist.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Código do curso inválido"));

  }

  /**
   * Metodo que trata a atualização para que não sejam atualizados todos os dados
   * 
   * @param courseDTO regras dto da atualização
   */
  public Course UpdateFromDTO(DTOUpdateCourse courseDTO){
    Course course = new Course();
    course.setHours(courseDTO.getHours());
    return course;
  }

  /**
   * Metodo que atualiza um curso
   * 
   * @param course curso que será atualizado
   */
  public Course updateCourse(Course course) {
    getCourseById(course.getIdCourse());
    return courseRepository.update(course);
  }

  /**
   * Metodo que salva um curso
   * 
   * @param course curso a ser salvo
   * @param IdSchool identificação da escola na qual o curso será salvo
   */
  public Course saveCourse(Course course, int IdSchool){
      School school = schoolServices.getSchoolById(IdSchool);
      
      course.setIdSchool(school.getIdSchool());
      school.addCourse(course);
      return courseRepository.saveCourse(course);
  }

  /**
   * Metodo que remove um curso a partir de seu identificado
   * 
   * @param IdCourse identificadoor do curso a ser removido
   */
  public void removeCourse(int IdCourse){
    courseRepository.removeCourse(getCourseById(IdCourse));
  }
}
