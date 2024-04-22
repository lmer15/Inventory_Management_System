/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserDashboard;

import SignUp_LogIn.LogIn;
import static SignUp_LogIn.SignUp.hashPass;
import config.dbConnector;
import javax.swing.JOptionPane;

/**
 *
 * @author Elmer Rapon
 */
public class changePass extends javax.swing.JFrame {

    
    private String origPass;
    public changePass() {
        initComponents();
        origPass = LogIn.passw;
    }
    
    
    private void updatePassword(String newPassword) {
        
        dbConnector connector = new dbConnector();
        String username = LogIn.l_username;
        String query = "UPDATE lmer_table SET lmer_pass = '" + newPassword + "' WHERE lmer_uname = '" + username + "'";
        connector.updateData(query);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        newPass = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        orgPasswo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 102, 0));
        jPanel2.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-list-25.png"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 10, 40, 20);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Change Password");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(50, 10, 220, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 660, 40);

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CANCEL");
        jLabel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(jLabel3);
        jLabel3.setBounds(260, 300, 80, 30);

        newPass.setBackground(new java.awt.Color(153, 153, 153));
        newPass.setForeground(new java.awt.Color(255, 255, 255));
        newPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPassActionPerformed(evt);
            }
        });
        jPanel1.add(newPass);
        newPass.setBounds(150, 200, 370, 40);

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Enter your original password:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 80, 250, 22);

        orgPasswo.setBackground(new java.awt.Color(153, 153, 153));
        orgPasswo.setForeground(new java.awt.Color(255, 255, 255));
        orgPasswo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orgPasswoActionPerformed(evt);
            }
        });
        jPanel1.add(orgPasswo);
        orgPasswo.setBounds(150, 116, 370, 40);

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Enter your new password:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(50, 170, 250, 22);

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("CHANGE");
        jLabel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6);
        jLabel6.setBounds(260, 260, 80, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void newPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPassActionPerformed

    private void orgPasswoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orgPasswoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orgPasswoActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        
        
        String pass = hashPass(newPass.getText());
        String orgPassw = orgPasswo.getText();
        String newPassw = pass;
        if (!orgPassw.equals(origPass)) {
            JOptionPane.showMessageDialog(null, "Original password is incorrect.");
            return;
        }
        updatePassword(newPassw);
        JOptionPane.showMessageDialog(null, "Password updated successfully!.");
        user u = new user();
        u.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

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
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changePass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField newPass;
    private javax.swing.JTextField orgPasswo;
    // End of variables declaration//GEN-END:variables
}
