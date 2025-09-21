/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.entity;

/**
 *
 * @author ntoam
 */
public class StudentEntity {
  private Integer studNumber;
    private String name;
    private String surname;

    public StudentEntity() {
    }

    public StudentEntity(Integer studNumer, String name, String surname) {
        this.studNumber = studNumer;
        this.name = name;
        this.surname = surname;
    }

    public Integer getStudNumber() {
        return studNumber;
    }

    public void setStudNumber(Integer studNumer) {
        this.studNumber = studNumer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    @Override
    public String toString(){
        return studNumber + "." + name + surname ;
    }
}
