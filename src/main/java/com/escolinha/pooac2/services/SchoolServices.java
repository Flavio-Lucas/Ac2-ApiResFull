//#region Imports

package com.escolinha.pooac2.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.escolinha.pooac2.DTO.DTOUpdateSchool;
import com.escolinha.pooac2.models.Course;
import com.escolinha.pooac2.models.School;
import com.escolinha.pooac2.repository.SchoolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

//#endregion

/**
 * Classe responsavel por gerenciar os serviços
 */
@Service
public class SchoolServices {
  
  //#region private properties

  @Autowired
  private SchoolRepository repository;

  //#endregion

  /**
   * Metodo responsavel por retornar todas as escolas
   */
  public List<School> getAllSchools(){
      return repository.getAllSchools();
  }

  /**
   * Metodo responsavel por retornar uma escola com base em um identificador
   * 
   * @param IdSchool identificador da escola a ser alterada
   */
  public School getSchoolById(int IdSchool){
    Optional<School> exist = repository.getSchoolById(IdSchool);
    return exist.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao deletar a escola. Identificador incorreto")); 
  }
  
  /**
   * metodo responsavel por 
   * 
   * @param school Objeto a ser salvo
   */
  public School saveSchool(School school){
      return repository.saveSchool(school);
  }

  /**
   * Metodo responsavel por remover uma escola
   * 
   * @param IdSchool identificador da escola a ser removida
   */
  public void removeSchool(int IdSchool){
    
    School school = getSchoolById(IdSchool);
    if(school.haveCourses()){
      repository.removeSchool(school);
    }
  }

  /**
   * Metodo responsavel por Atualizar uma escola
   * 
   * @param school novas informações da escola
   */
  public School updateSchool(School school){
    getSchoolById(school.getIdSchool());
    return repository.updateSchool(school);
  }

  /**
   * Metodo responsavel por atualizar
   * 
   * @param dto Molde com as regras sobre a atualização
   */
  public School UpdateFromDTO(DTOUpdateSchool dto){
    School school = new School();
    school.setName(dto.getName());
    school.setAdress(dto.getAdress());
    return school;
  }

  /**
   * Metodo responsavel por pegar a lista de cursos de uma escola
   *  
   * @param IdSchool identificador de uma
   * @return
   */
  public ArrayList<Course> listSchoolCourses(int IdSchool){
    Optional<School> school = repository.getSchoolById(IdSchool);
    School a = school.get();
    return a.getCourseList();
  }
}
