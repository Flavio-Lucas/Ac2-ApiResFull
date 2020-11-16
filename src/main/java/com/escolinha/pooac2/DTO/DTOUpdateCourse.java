package com.escolinha.pooac2.DTO;

/**
 * Classe que gerencia as alterações feitas em um curso
 */
public class DTOUpdateCourse {
    private double hours;

    /**
     * Metodo que retorna as horas de determinado curso
     */
    public double getHours() {
      return hours;
    }

    /**
     * Metodo que seta as horas
     */
    public void setHours(double hours) {
      this.hours = hours;
    }

    
}
