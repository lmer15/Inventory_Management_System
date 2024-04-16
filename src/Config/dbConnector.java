/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Jean
 */
public class dbConnector {
  
    private Connection Connect;
    public dbConnector(){
            try{
                Connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/lmerdb", "root", "");
            }catch(SQLException ex){
                    System.out.println("Can't connect to database: "+ex.getMessage());
            }
        }
    
        //Function to retrieve data
       public ResultSet getData(String sql) throws SQLException{
           Statement stmt = (Statement) Connect.createStatement();
           ResultSet rst = stmt.executeQuery(sql);
           return rst;
       }
    //Function to save data
        public boolean insertData(String sql){
            try{
                PreparedStatement pst = Connect.prepareStatement(sql);
                pst.executeUpdate();
                System.out.println("Inserted Successfully!");
                pst.close();
               return true;
            }catch(SQLException ex){
                System.out.println("Connection Error: "+ex);
               return false;
            }
        }
        public void updateData(String sql){
            try{
            PreparedStatement pst = Connect.prepareStatement(sql);
            int rowsUpdated = pst.executeUpdate();
                if(rowsUpdated>0){
                    JOptionPane.showMessageDialog(null, "Data Updated Successfully!");
                }else{
                    System.out.println("Data Update Failed!");
                }
            }catch(SQLException ex){
                System.out.println("Connection Error!"+ex);
            }
        }

}
