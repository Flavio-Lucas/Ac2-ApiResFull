package com.escolinha.pooac2.models;
import java.util.ArrayList;

public class School{

  //#region Private Properties

  private int ID_School;
  private String name;
  private String state;
  private String adress;
  
  private ArrayList<Course> courseList = new ArrayList<Course>();

  //#endregion

  //#region GETERS and SETERS

  public int getIdSchool() {
    return ID_School;
  }

  public void setIdSchool(int IdSchool) {
    ID_School = IdSchool;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getAdress() {
    return adress;
  }

  public void setAdress(String adress) {
    this.adress = adress;
  }

  public ArrayList<Course> getCourseList() {
    return courseList;
  }

  public Boolean haveCourses(){
    return courseList.size() == 0;
  }

  public void setCourseList(ArrayList<Course> courseList) {
    this.courseList = courseList;
  }

  public boolean addCourse(Course course) {
    return this.courseList.add(course);
  }

  //#endregion

}
