/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.b1;

import java.util.List;
import za.ac.tut.entity.StudentEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author ntoam
 */
public class StudentDB implements DAOInterface<StudentEntity> {

    private Connection connection;
    public StudentDB(String dbURL,String username,String password) throws SQLException{
       connection  =getConnection(dbURL,username,password) ;
   }
    
    @Override
    public StudentEntity get(Integer code) {
      String sql="SELECT StudentNumber,Name,Surname" + "FROM StudentTBL" + "WHERE  StudentNumber=?";
      try{
          
        PreparedStatement ps=connection.prepareStatement(sql);
        ResultSet rs =ps.executeQuery();
        if(rs.next()){
            Integer studNum=rs.getInt("StudentNumber");
            String name=rs.getString("Name");
            String surname=rs.getString("Surname");
            StudentEntity student=new  StudentEntity(studNum,name,surname);
            rs.close();
            return student;
        }else{
            rs.close();
            return null;
        }
          
      }catch(SQLException ex){
          System.err.println(ex);
          return null;
      }
    }

    @Override
    public List<StudentEntity> getAll() {
        String sql="SELECT * FROM StudentTBL" + "ORDER BY StudentNumber ASC";
        List<StudentEntity> students=new ArrayList<>();
        try{
            PreparedStatement ps=connection.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Integer studNum=rs.getInt("StudentNumber");
                String name=rs.getString("Name");
                String surname=rs.getString("Surname");
                StudentEntity student =new  StudentEntity(studNum,name,surname);
                students.add(student);
            }
            return students;
            }catch(SQLException ex){
              System.err.println(ex);  
              return null;
            }
        
    }

    @Override
    public boolean add(StudentEntity t) {
        String sql="INSERT INTO StudentTBL(StudentNumber,Name,Surname)" +"VALUES(?,?,?)";
        try{
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1,t.getStudNumber());
            ps.setString(2, t.getName());
            ps.setString(3, t.getSurname());
            return true;
        }catch(SQLException ex){
            System.err.println(ex);
            return false;
        }
    }

    @Override
    public boolean update(StudentEntity t) {
        String sql="UPDATE StudentTBL SET" + "Name =? " + "Surname =?" + "WHERE StudentNumber=?";
        try{
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1,t.getName());
            ps.setString(2, t.getSurname());
            ps.setInt(3, t.getStudNumber());
            ps.executeUpdate();
            return true;
            
        }catch(SQLException ex){
        System.err.println(ex);
        return false;
    }
    }
    @Override
    public boolean delete(StudentEntity t) {
        String sql= "DELETE FROM StudentTBL" + "WHERE StudentNumber =?";
        try{
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setInt(1, t.getStudNumber());
            ps.executeUpdate();
            return true;
        }catch(SQLException ex){
           System.err.println(ex);
           return false;
        }
    }

    private Connection getConnection(String dbURL, String username, String password) throws SQLException {
        Connection theConnection=DriverManager.getConnection(dbURL, username, password);
        return theConnection;
    }
    
}
