/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminDashboard;

import Config.session;
import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author SCC
 */
public class updateAcc extends javax.swing.JFrame {

    /**
     * Creates new form updateAcc
     */
    public updateAcc() {
        initComponents();
    }
    
    public static boolean checkEmail(String email, int ID){
        dbConnector dbc = new dbConnector();
        try{
            String sql = "SELECT * FROM lmer_table WHERE lmer_email = '"+email+"' AND lmer_ID != '"+ID+"'";
            ResultSet rst = dbc.getData(sql);
            return rst.next();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static boolean checkUserName(String username, int ID){
        dbConnector dbc = new dbConnector();
        try{
            String sql = "SELECT * FROM lmer_table WHERE lmer_uname = '"+username+"' AND lmer_ID != '"+ID+"'";
            ResultSet rst = dbc.getData(sql);
            return rst.next();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public void getdata(int id){
          dbConnector dbc = new dbConnector();

          try{
              String sql = "SELECT * FROM lmer_table WHERE lmer_ID = '"+id+"'";
                ResultSet rs = dbc.getData(sql);
             if(rs.next()){
                session ss = session.getInstance();
                ss.setId(rs.getInt("lmer_ID"));
                ss.setFname(rs.getString("lmer_fname"));
                ss.setLname(rs.getString("lmer_lname"));
                ss.setEmail(rs.getString("lmer_email"));
                ss.setUsername(rs.getString("lmer_uname")); 
                ss.setPosition(rs.getString("lmer_acc"));
                ss.setStatus(rs.getString("lmer_stat"));
             }

          }catch(SQLException ex){
              System.out.println("Inavalid Connection"+ex.getMessage());
          }
         }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        update = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        status = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        position1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        username1 = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        finame = new javax.swing.JTextField();
        laname = new javax.swing.JTextField();
        email1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 51));
        jPanel1.setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-back-40.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 560, 40, 40);

        update.setBackground(new java.awt.Color(255, 255, 255));
        update.setFont(new java.awt.Font("Microsoft YaHei", 1, 15)); // NOI18N
        update.setForeground(new java.awt.Color(255, 255, 255));
        update.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        update.setText("Update");
        update.setToolTipText("");
        update.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });
        jPanel1.add(update);
        update.setBounds(250, 500, 80, 32);

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Status:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 420, 120, 20);

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(60, 120, 130, 20);

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Last Name:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(60, 210, 120, 20);

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Email: ");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(60, 270, 120, 20);

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Username: ");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(60, 320, 120, 20);

        status.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending" }));
        jPanel1.add(status);
        status.setBounds(230, 410, 280, 40);

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei", 1, 25)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Update Account");
        jLabel9.setToolTipText("");
        jLabel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 10, 560, 40);

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Position: ");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(60, 370, 120, 20);

        position1.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        position1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Inventory-In-Charge" }));
        jPanel1.add(position1);
        position1.setBounds(230, 360, 280, 40);

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("First Name:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(60, 160, 130, 20);

        username1.setBackground(new java.awt.Color(0, 102, 51));
        username1.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        username1.setForeground(new java.awt.Color(255, 255, 255));
        username1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(username1);
        username1.setBounds(230, 306, 280, 30);

        id.setEditable(false);
        id.setBackground(new java.awt.Color(0, 102, 51));
        id.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(id);
        id.setBounds(230, 112, 280, 30);

        finame.setBackground(new java.awt.Color(0, 102, 51));
        finame.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        finame.setForeground(new java.awt.Color(255, 255, 255));
        finame.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(finame);
        finame.setBounds(230, 156, 280, 30);

        laname.setBackground(new java.awt.Color(0, 102, 51));
        laname.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        laname.setForeground(new java.awt.Color(255, 255, 255));
        laname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(laname);
        laname.setBounds(230, 206, 280, 30);

        email1.setBackground(new java.awt.Color(0, 102, 51));
        email1.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        email1.setForeground(new java.awt.Color(255, 255, 255));
        email1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(email1);
        email1.setBounds(230, 250, 280, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        UsersAccount ua = new UsersAccount();
        ua.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked

        dbConnector dbc = new dbConnector();
        
        try{
            if (checkEmail(email1.getText(),Integer.valueOf(id.getText()))){
                JOptionPane.showMessageDialog(null, "Email Already existed");
                return;
            }
            if (checkUserName(username1.getText(),Integer.valueOf(id.getText()))){
                JOptionPane.showMessageDialog(null, "Username Already existed");
                return;
            }
            if(dbc.insertData("UPDATE lmer_table SET lmer_fname = '" + finame.getText() + "', "
                            + "lmer_lname = '" + laname.getText() + "', "
                            + "lmer_email = '" + email1.getText() + "', "
                            + "lmer_uname = '" + username1.getText() + "',"
                            + "lmer_acc = '" + position1.getSelectedItem() + "',"
                            + "lmer_stat = '" + status.getSelectedItem() + "' "
                            + "WHERE lmer_ID = '" +Integer.valueOf(id.getText())+"'")){
                JOptionPane.showMessageDialog(null, "Changes Saved!");
                UsersAccount ua = new UsersAccount();
                ua.setVisible(true);
                this.dispose();
                getdata(Integer.valueOf(id.getText()));
        }
        }catch(Exception ex){
            System.out.println(""+ex);    
            
        }

    }//GEN-LAST:event_updateMouseClicked

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
            java.util.logging.Logger.getLogger(updateAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateAcc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateAcc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField email1;
    public javax.swing.JTextField finame;
    public javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField laname;
    public javax.swing.JComboBox<String> position1;
    public javax.swing.JComboBox<String> status;
    private javax.swing.JLabel update;
    public javax.swing.JTextField username1;
    // End of variables declaration//GEN-END:variables
}
