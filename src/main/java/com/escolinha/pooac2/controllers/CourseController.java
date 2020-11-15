//#region imports

package com.escolinha.pooac2.controllers;

import java.util.List;

import com.escolinha.pooac2.DTO.DTOUpdateCourse;
import com.escolinha.pooac2.models.Course;
import com.escolinha.pooac2.services.CourseServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//#endregion

/**
 * Classe controller da entidade de cursos
 */
@RestController
@RequestMapping("/courses")
public class CourseController {
  
  @Autowired
  private CourseServices courseServices;

  /**
   * Metodo responsavel pela rota que retona uma lista de cursos
   */
  @GetMapping
  public List<Course> getAllCourses() {
    return courseServices.getAllCourses();
  }

  /**
   * Metodo responsavel pela rota que retorna um curso a partir de um identificador
   * 
   * @param IdCourse identificador do curso
   */
  @GetMapping("/{IdCourse}")
  public ResponseEntity<Course> getCourseById(@PathVariable int IdCourse) {
    Course course = courseServices.getCourseById(IdCourse);
    return ResponseEntity.ok(course);
  }

  /**
   * Metodo responsavel pela rota que atualiza uma escola
   * 
   * @param updateDTO Dto que controla as alterações a serem feitas
   * @param IdCourse Identificador da escola a ser alterada
   */
  @PutMapping("/{IdCourse}")
  public ResponseEntity<Course> atualizar(@RequestBody DTOUpdateCourse updateDTO, @PathVariable int IdCourse){
    Course course = courseServices.UpdateFromDTO(updateDTO);
    course.setIdCourse(IdCourse);
    course = courseServices.updateCourse(course);
    return ResponseEntity.ok(course);
  }

  /**
   * Metodo responsavel pela rota que exclui um curso
   * 
   * @param IdCourse identificador do curso
   */
  @DeleteMapping("/{IdCourse}")
  public ResponseEntity<Void> removeCourse(@PathVariable int IdCourse){ 
    courseServices.removeCourse(IdCourse);
    return ResponseEntity.noContent().build();
  }

}
