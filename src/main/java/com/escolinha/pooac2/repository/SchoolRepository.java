package com.escolinha.pooac2.repository;

import java.util.ArrayList;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.escolinha.pooac2.models.Course;
import com.escolinha.pooac2.models.School;

import org.springframework.stereotype.Component;

@Component
public class SchoolRepository {

  //#region private properties

  private ArrayList<School> schools = new ArrayList<School>();
  private int nextId = 1;

  //#endregion

  @PostConstruct
  public void registerSchool() {

    School sc1 = new School();
    School sc2 = new School();
    School sc3 = new School();
    Course co1 = new Course();

    co1.setCategory("Programação");
    co1.setHours(40);
    co1.setIdCourse(1);
    co1.setName("Curso de spring");

    sc1.setIdSchool(1);
    sc1.setName("colegio adventista");
    sc1.setAdress("Rua antonio carlos lombarde jd guadalajara");
    sc1.setState("SP");
    sc1.addCourse(co1);
    
    schools.add(sc1);

    sc2.setIdSchool(2);
    sc2.setName("E.E. Cirilo");
    sc2.setAdress("Rua dos jaboticabais numero 12 jardim bairro");
    sc2.setState("PR");

    schools.add(sc2);

    sc3.setIdSchool(3);
    sc3.setName("E.E. prof Ezequiel Machado Nascimento");
    sc3.setAdress("mareachal deodoro da fonceca");
    sc3.setState("MT");
    
    schools.add(sc3);

    this.nextId = 3;
    
  }

  /**
   * Metodo que retorna todas as escolas
   */
  public ArrayList<School> getAllSchools(){
    return schools;
  }

  /**
   * Metodo que retorna uma escola a partir do seu identificador
   * 
   * @param IdSchool identificador de uma escola
   */
  public Optional<School> getSchoolById(int IdSchool){
    for(School item: schools){
        if(item.getIdSchool() == IdSchool){
            return Optional.of(item);
        }
    }
    return Optional.empty();//Funciona como um else
  }

  /**
   * Metodo que salva uma nova escola
   * 
   * @param school escola que será salva
   */
  public School saveSchool(School school){
    school.setIdSchool(++nextId);
    schools.add(school);
    return school;
  }

  /**
   * Metodo que remove uma escola
   * 
   * @param school escola a ser removida
   */
  public void removeSchool(School school){
    schools.remove(school);
  }
  
  /**
   * Metodo que atualiza uma escola existente
   * 
   * @param school escola a ser sobreposta
   */
  public School updateSchool(School school) {
    School sch = getSchoolById(school.getIdSchool()).get();
    if(sch != null){
      if(school.getName() != null){
        sch.setName(school.getName());
      }
      if(school.getAdress() != null ){
        sch.setAdress(school.getAdress());
      }
    }
    return sch;
  }
  


}
