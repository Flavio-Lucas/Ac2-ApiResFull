//#region imports

package com.escolinha.pooac2.DTO;

//#endregion

/**
 * Classe DTO que controla as atualizações de uma escola
 */
public class DTOUpdateSchool {
  private String name;
  private String adress;

  //#region GETERS and SETERS

  /**
   * Metodo que retorna o nome
   */
  public String getName() {
      return name;
  }

  /**
   * Metodo que altera o nome
   * 
   * @param name Novo valor para nome
   */
  public void setNome(String name) {
      this.name = name;
  }

  /**
   * Metodo que retorna o endereço
   */
  public String getAdress() {
    return adress;
  }

  /**
   * Metodo que altera o valor do endereço
   * 
   * @param adress novo valor para endereço
   */
  public void setAdress(String adress) {
    this.adress = adress;
  }

  
}
