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
  
    public Connection Connect;
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
    //function to update data
    public void updateData(String sql){
        try{
        PreparedStatement pst = Connect.prepareStatement(sql);
        int rowsUpdated = pst.executeUpdate();
            if(rowsUpdated>0){
                JOptionPane.showMessageDialog(null, "Data Updated Successfully!");
            }else{
                System.out.println("Data Update Failed!");
            }
            pst.close();
        }catch(SQLException ex){
            System.out.println("Connection Error!"+ex);
        }
    }
    //funtion to delete data
    public void deleteData(int id, String table){

        try{
            PreparedStatement pst = Connect.prepareStatement("DELETE FROM lmer_table WHERE lmer_ID=?");
            pst.setInt( 1, id );
            int rowsDeleted = pst.executeUpdate();
                if(rowsDeleted>0){
                    JOptionPane.showMessageDialog(null, "Successful Deletion!");
                }else{
                    System.out.println("Unsuccessful Deletion!");
                }
                pst.close();
        }catch(SQLException ex){
            System.out.println("Connection Error!"+ex);
        }
    }
        public boolean insertImageData(String sql, byte[] imageData) {
        try {
            PreparedStatement pst = Connect.prepareStatement(sql);
            // Set the image data as a byte array parameter
            pst.setBytes(1, imageData);
            pst.executeUpdate();
            System.out.println("Image inserted Successfully!");
            pst.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Connection Error: " + ex);
            return false;
        }
    }
        
    public boolean hasCompanyProfileData() {
        try {
            String query = "SELECT COUNT(*) AS count FROM companyprofile "
                         + "UNION ALL "
                         + "SELECT COUNT(*) AS count FROM business_address "
                         + "UNION ALL "
                         + "SELECT COUNT(*) AS count FROM ceo_profile";
            Statement statement = Connect.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            int totalCount = 0;
            while (resultSet.next()) {
                totalCount += resultSet.getInt("count");
            }

            // Close resources
            resultSet.close();
            statement.close();

            return totalCount > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
        public Connection getConnection() {
        return this.Connect;
        }

}
