/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.b1;

import java.util.List;

/**
 *
 * @author ntoam
 */
public interface DAOInterface<T> {
    T get(Integer code);
List<T> getAll();
boolean add(T t);
boolean update(T t);
boolean delete(T t);
}
