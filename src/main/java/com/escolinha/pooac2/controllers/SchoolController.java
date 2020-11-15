//#region Imports

package com.escolinha.pooac2.controllers;

import com.escolinha.pooac2.DTO.DTOUpdateSchool;
import com.escolinha.pooac2.models.Course;
import com.escolinha.pooac2.models.School;

import com.escolinha.pooac2.services.CourseServices;
import com.escolinha.pooac2.services.SchoolServices;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

//#endregion

/**
 * Classe controller da entidade de escolas
 */
@RestController
@RequestMapping("/school")
public class SchoolController {
  
  //#region private properties

  /**
   * Referencia para arquivo de serviços da escola
   */
  @Autowired
  private SchoolServices schoolServices;

  /**
   * Referencia para arquivo de serviços do curso
   */
  @Autowired
  private CourseServices courseServices;

  //#endregion
  
  /**
   * Metodo responsavel pela rota que retorna uma lista com todas as escolas
   */
  @GetMapping
  public List<School> getAllSchools(){
    return schoolServices.getAllSchools();
  }
  
  /**
   * Metodo responsavel pela rota que Retorna uma escola a partir de se identificador
   * 
   * @param IdSchool Identificador de uma escola
   */
  @GetMapping("/{IdSchool}")
  public ResponseEntity<School> getOneSchool(@PathVariable int IdSchool){
    School school = schoolServices.getSchoolById(IdSchool);
    
    return ResponseEntity.ok(school);
  }

  /**
   * Metodo responsavel pela rota que cria uma escola
   * 
   * @param saveDTO Dto que controla o salvamento a ser feito
   * @param request Variavel que controla o dominio (URL)
   * @param builder Constrói o dominio
   */
  @PostMapping
  public ResponseEntity<Void> saveSchool(@RequestBody School school, HttpServletRequest request, UriComponentsBuilder builder ) {
    school = schoolServices.saveSchool(school);
    UriComponents path = builder.path(request.getRequestURI() + "/" + school.getIdSchool()).build();
    return ResponseEntity.created(path.toUri()).build();
  }

  /**
   * Metodo responsavel pela rota que atualiza uma escola
   * 
   * @param updateDTO Dto que controla as alterações a serem feitas
   * @param IdSchool Identificador da escola a ser alterada
   */
  @PutMapping("/{IdSchool}")
  public ResponseEntity<School> atualizar(@RequestBody DTOUpdateSchool updateDTO, @PathVariable int IdSchool){
    School school = schoolServices.UpdateFromDTO(updateDTO);
    school.setIdSchool(IdSchool);
    school = schoolServices.updateSchool(school);
    return ResponseEntity.ok(school);
  }

  /**
   * Metodo responsavel pela rota que cria um curso
   * 
   * @param IdSchool Identificador da escola
   * @param course Curso a ser criado
   * @param request Responsavel pela URL
   * @param builder Construtor da URL
   */
  @PostMapping("/courses/{IdSchool}")
  public ResponseEntity<Void> saveCourse(@PathVariable int IdSchool, @RequestBody Course course, HttpServletRequest request, UriComponentsBuilder builder){
    course = courseServices.saveCourse(course, IdSchool);
    UriComponents path = builder.path(request.getRequestURI() + "/" + course.getIdCourse()).build();
    return ResponseEntity.created(path.toUri()).build();
  }

  /**
   * Metodo responsavel por deletar uma escola
   * 
   * @param IdSchool identificador de uma escola
   * @return
   */
  @DeleteMapping("/{IdSchool}")
  public ResponseEntity<Void> removeSchool(@PathVariable int IdSchool){
    schoolServices.removeSchool(IdSchool);
    return ResponseEntity.noContent().build();
  }

  /**
   * Metodo responsavel por listar Os cursos de uma escola
   * 
   * @param IdSchool identificador de uma escola
   * @return
   */
  @GetMapping("/{IdSchool}/courses")
  public ResponseEntity<List<Course>> listSchoolCourses(@PathVariable int IdSchool) {
    ArrayList<Course> school = schoolServices.listSchoolCourses(IdSchool);

    return ResponseEntity.ok(school);
  }

}
