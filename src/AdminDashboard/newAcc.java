/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminDashboard;

import static SignUp_LogIn.SignUp.hashPass;
import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author SCC
 */
public class newAcc extends javax.swing.JFrame {

    /**
     * Creates new form newAcc
     */
    public newAcc() {
        initComponents();
    }
    
    public static String usernam, emal;
        
    public boolean duplicateCheck(){     
    dbConnector dbc = new dbConnector();
    try{
            String query = "SELECT * FROM lmer_table  WHERE lmer_uname = '" + user.getText() + "' OR lmer_email = '" + emailadd.getText() + "'";
            ResultSet resultSet = dbc.getData(query);
           
            if(resultSet.next()){                
              emal = resultSet.getString("lmer_email");      
              if(emal.equals(emailadd.getText())){
               JOptionPane.showMessageDialog(null, "Email is Already Used!");
               emailadd.setText("");
              }
              usernam = resultSet.getString("lmer_uname");
              if(usernam.equals(user.getText())){
               JOptionPane.showMessageDialog(null, "Username is Already Used!");
               user.setText("");
              }
              return true;
            }else{
                return false;
            }
          
        }catch(SQLException ex) {
            System.out.println("" +ex);
            return false;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newAccPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        user = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        firstname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        emailadd = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        passwo = new javax.swing.JPasswordField();
        jLabel13 = new javax.swing.JLabel();
        posit = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        hide = new javax.swing.JLabel();
        show = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        newAccPanel.setBackground(new java.awt.Color(0, 102, 51));
        newAccPanel.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Create New Account");
        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        newAccPanel.add(jLabel8);
        jLabel8.setBounds(10, 0, 620, 50);

        user.setBackground(new java.awt.Color(0, 102, 51));
        user.setFont(new java.awt.Font("Microsoft YaHei Light", 0, 16)); // NOI18N
        user.setForeground(new java.awt.Color(255, 255, 255));
        newAccPanel.add(user);
        user.setBounds(250, 280, 250, 40);

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei", 0, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("First Name:");
        newAccPanel.add(jLabel9);
        jLabel9.setBounds(120, 130, 90, 30);

        firstname.setBackground(new java.awt.Color(0, 102, 51));
        firstname.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        firstname.setForeground(new java.awt.Color(255, 255, 255));
        newAccPanel.add(firstname);
        firstname.setBounds(250, 130, 250, 40);

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei", 0, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Last Name:");
        newAccPanel.add(jLabel10);
        jLabel10.setBounds(120, 180, 90, 30);

        lastname.setBackground(new java.awt.Color(0, 102, 51));
        lastname.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        lastname.setForeground(new java.awt.Color(255, 255, 255));
        newAccPanel.add(lastname);
        lastname.setBounds(250, 180, 250, 40);

        jLabel11.setFont(new java.awt.Font("Microsoft YaHei", 0, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Email Address:");
        newAccPanel.add(jLabel11);
        jLabel11.setBounds(120, 230, 120, 30);

        emailadd.setBackground(new java.awt.Color(0, 102, 51));
        emailadd.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        emailadd.setForeground(new java.awt.Color(255, 255, 255));
        newAccPanel.add(emailadd);
        emailadd.setBounds(250, 230, 250, 40);

        jLabel12.setFont(new java.awt.Font("Microsoft YaHei", 0, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Username:");
        newAccPanel.add(jLabel12);
        jLabel12.setBounds(120, 280, 120, 30);

        passwo.setBackground(new java.awt.Color(0, 102, 51));
        passwo.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        passwo.setForeground(new java.awt.Color(255, 255, 255));
        newAccPanel.add(passwo);
        passwo.setBounds(250, 330, 250, 40);

        jLabel13.setFont(new java.awt.Font("Microsoft YaHei", 0, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Password:");
        newAccPanel.add(jLabel13);
        jLabel13.setBounds(120, 330, 120, 30);

        posit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Inventory-In-Charge" }));
        newAccPanel.add(posit);
        posit.setBounds(250, 380, 250, 40);

        jLabel14.setFont(new java.awt.Font("Microsoft YaHei", 0, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Position:");
        newAccPanel.add(jLabel14);
        jLabel14.setBounds(120, 380, 120, 30);

        jLabel15.setFont(new java.awt.Font("Microsoft YaHei", 1, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Log In");
        jLabel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        newAccPanel.add(jLabel15);
        jLabel15.setBounds(280, 480, 120, 30);

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cancel");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        newAccPanel.add(jLabel1);
        jLabel1.setBounds(280, 520, 120, 30);

        hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-invisible-30.png"))); // NOI18N
        hide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hideMouseClicked(evt);
            }
        });
        newAccPanel.add(hide);
        hide.setBounds(510, 330, 30, 40);

        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-eye-30.png"))); // NOI18N
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMouseClicked(evt);
            }
        });
        newAccPanel.add(show);
        show.setBounds(510, 330, 30, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(newAccPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(newAccPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:
        
                String pass = hashPass(passwo.getText());
                if(firstname.getText().isEmpty()
                || lastname.getText().isEmpty()
                || emailadd.getText().isEmpty()
                || user.getText().isEmpty()
                || passwo.getText().isEmpty())
            {
            JOptionPane.showMessageDialog(null, "All Fields should be Filled");
            }else if(passwo.getText().length() < 8){
            JOptionPane.showMessageDialog(null, "Minimum password should be above 8 character");
            passwo.setText("");  
            
            }else if(duplicateCheck()){
                System.out.println("Duplicate");
            }else{
            dbConnector db = new dbConnector();

                if(db.insertData("INSERT INTO lmer_table (lmer_fname, lmer_lname, lmer_email, lmer_uname, lmer_pass, lmer_acc, lmer_stat) "
                    + "VALUES ('"+firstname.getText()+"',"
                    + " '"+lastname.getText()+"',"
                    + " '"+emailadd.getText()+"', "
                    + " '"+user.getText()+"', "
                    + "'"+pass+"', "
                    + "'"+posit.getSelectedItem()+"', 'Pending' ) ")){

                    JOptionPane.showMessageDialog(null, "Inserted Successfully!");
                }else{
                    JOptionPane.showMessageDialog(null, "Connection Error!");
                }
                    UsersAccount ua = new UsersAccount();
                    ua.setVisible(true);
                    this.dispose(); 
            }
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        UsersAccount ua = new UsersAccount();
        ua.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseClicked
        // TODO add your handling code here:
        show.setVisible(false);
        hide.setVisible(true);
        passwo.setEchoChar('*');
    }//GEN-LAST:event_showMouseClicked

    private void hideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMouseClicked
        // TODO add your handling code here:
        show.setVisible(true);
        hide.setVisible(false);
        passwo.setEchoChar((char)0);
    }//GEN-LAST:event_hideMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(newAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new newAcc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailadd;
    private javax.swing.JTextField firstname;
    private javax.swing.JLabel hide;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lastname;
    public javax.swing.JPanel newAccPanel;
    private javax.swing.JPasswordField passwo;
    private javax.swing.JComboBox<String> posit;
    private javax.swing.JLabel show;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
