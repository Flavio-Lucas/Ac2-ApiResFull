package com.escolinha.pooac2.models;


public class Course{

  //#region private properties

  private int IdCourse;
  private String name;
  private String category;
  private double hours;
  private int IdSchool;

  //#endregion

  //#region GETERS and SETERS

  public int getIdCourse() {
    return IdCourse;
  }

  public void setIdCourse(int iD_Course) {
    IdCourse = iD_Course;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public double getHours() {
    return hours;
  }

  public void setHours(double hours) {
    this.hours = hours;
  }

  public int setIdSchool() {
    return IdSchool;
  }

  public void setIdSchool(int IdSchool) {
    this.IdSchool = IdSchool;
  }

  //#endregion  
  
  //#region toString

  @Override
  public String toString() {
    return "Course [ID_Course=" + IdCourse + ", category=" + category + ", hours=" + hours + ", name=" + name
        + ", school=" + IdSchool + "]";
  }


  //#endregion
}


  
