/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminDashboard;

import SignUp_LogIn.LogIn;
import static SignUp_LogIn.LogIn.loginAcc;
import config.dbConnector;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Elmer Rapon
 */
public class admin extends javax.swing.JFrame {

    /**
     * Creates new form admin
     */
    public admin() {
        initComponents();
        datetime();
    }
    
    public void datetime(){
        DateTimeFormatter d = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        DateTimeFormatter t = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        date.setText(d.format(now));
        time.setText(t.format(now));  
    }
    
    
    Color navcolor = new Color (0,0,0,0);
    Color headcolor = new Color (153,153,153);
    Color bodycolor =new Color (240,240,240);;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        adminPosition = new javax.swing.JLabel();
        adminName = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pi = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        vua = new javax.swing.JLabel();
        si = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 102, 0));
        jPanel2.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-admin-70.png"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 10, 80, 70);

        adminPosition.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 17)); // NOI18N
        adminPosition.setForeground(new java.awt.Color(255, 255, 255));
        adminPosition.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        adminPosition.setText("Position");
        jPanel2.add(adminPosition);
        adminPosition.setBounds(110, 50, 380, 30);

        adminName.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        adminName.setForeground(new java.awt.Color(255, 255, 255));
        adminName.setText("Admin Name");
        jPanel2.add(adminName);
        adminName.setBounds(110, 20, 410, 30);

        time.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(time);
        time.setBounds(900, 50, 130, 20);

        date.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(date);
        date.setBounds(900, 20, 130, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1050, 90);

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setLayout(null);
        jPanel3.add(jLabel1);
        jLabel1.setBounds(40, 40, 0, 0);

        pi.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        pi.setForeground(new java.awt.Color(255, 255, 255));
        pi.setText("Profile Info");
        pi.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                piMouseMoved(evt);
            }
        });
        pi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                piMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                piMouseExited(evt);
            }
        });
        jPanel3.add(pi);
        pi.setBounds(50, 80, 220, 30);

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("About Us");
        jLabel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel7);
        jLabel7.setBounds(30, 600, 220, 30);

        lo.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        lo.setForeground(new java.awt.Color(255, 51, 51));
        lo.setText("Log Out");
        lo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loMouseExited(evt);
            }
        });
        jPanel3.add(lo);
        lo.setBounds(50, 140, 220, 30);

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Profile");
        jLabel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel9);
        jLabel9.setBounds(30, 50, 220, 30);

        vua.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        vua.setForeground(new java.awt.Color(255, 255, 255));
        vua.setText("Manage Account");
        vua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vuaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                vuaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                vuaMouseExited(evt);
            }
        });
        jPanel3.add(vua);
        vua.setBounds(50, 110, 220, 30);

        si.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        si.setForeground(new java.awt.Color(255, 255, 255));
        si.setText("Sales Inventory");
        si.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                siMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                siMouseExited(evt);
            }
        });
        jPanel3.add(si);
        si.setBounds(50, 240, 220, 30);

        jLabel13.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Output Inventory");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(50, 270, 220, 30);

        jLabel14.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Walk-In Accounts");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(50, 300, 220, 30);

        jLabel15.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Damage/Reject");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(50, 540, 220, 30);

        jLabel16.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Dashboard");
        jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel16);
        jLabel16.setBounds(30, 200, 220, 30);

        jLabel17.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Distributor Accounts");
        jPanel3.add(jLabel17);
        jLabel17.setBounds(50, 330, 220, 30);

        jLabel18.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Total Sales");
        jPanel3.add(jLabel18);
        jLabel18.setBounds(50, 450, 220, 30);

        jLabel19.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Accounts Receivable");
        jPanel3.add(jLabel19);
        jLabel19.setBounds(50, 480, 220, 30);

        jLabel20.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Version 1.0.00.0");
        jPanel3.add(jLabel20);
        jLabel20.setBounds(50, 640, 200, 30);

        jLabel21.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Reports");
        jLabel21.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel21);
        jLabel21.setBounds(30, 400, 220, 30);

        jLabel22.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Returned/BO Stocks");
        jPanel3.add(jLabel22);
        jLabel22.setBounds(50, 510, 220, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 90, 280, 680);

        jPanel4.setBackground(new java.awt.Color(98, 180, 98));
        jPanel4.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Pulled Out Stocks");
        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel10);
        jLabel10.setBounds(20, 30, 280, 25);

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei", 1, 50)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setText("-234,567");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(70, 70, 240, 120);

        jLabel23.setText("from July 26 to December 16");
        jPanel4.add(jLabel23);
        jLabel23.setBounds(30, 200, 210, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-time-25.png"))); // NOI18N
        jPanel4.add(jLabel3);
        jLabel3.setBounds(0, 200, 25, 30);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(300, 120, 340, 240);

        jPanel6.setBackground(new java.awt.Color(98, 180, 98));
        jPanel6.setLayout(null);

        jLabel24.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("AVAILABLE STOCKS");
        jLabel24.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel6.add(jLabel24);
        jLabel24.setBounds(20, 20, 690, 25);

        jTable1.setBackground(new java.awt.Color(98, 180, 98));
        jTable1.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel6.add(jScrollPane1);
        jScrollPane1.setBounds(20, 50, 690, 310);

        jPanel1.add(jPanel6);
        jPanel6.setBounds(300, 390, 730, 370);

        jPanel7.setBackground(new java.awt.Color(98, 180, 98));
        jPanel7.setLayout(null);

        jLabel25.setFont(new java.awt.Font("Microsoft YaHei", 1, 50)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 255));
        jLabel25.setText("+100,000");
        jPanel7.add(jLabel25);
        jLabel25.setBounds(40, 70, 250, 120);

        jLabel26.setText("from July 26 to December 16");
        jPanel7.add(jLabel26);
        jLabel26.setBounds(40, 200, 210, 30);

        jLabel27.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Pulled In Stocks");
        jLabel27.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel7.add(jLabel27);
        jLabel27.setBounds(20, 30, 280, 25);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-time-25.png"))); // NOI18N
        jPanel7.add(jLabel5);
        jLabel5.setBounds(10, 200, 25, 30);

        jPanel1.add(jPanel7);
        jPanel7.setBounds(679, 119, 350, 240);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1042, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void vuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vuaMouseClicked
        // TODO add your handling code here:
        UsersAccount ua = new UsersAccount();
        ua.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_vuaMouseClicked

    private void loMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loMouseClicked
        // TODO add your handling code here:
        LogIn li = new LogIn();
        li.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_loMouseClicked

    private void piMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piMouseEntered
        // TODO add your handling code here:
        pi.setBackground(navcolor);       
    }//GEN-LAST:event_piMouseEntered

    private void piMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piMouseExited
        // TODO add your handling code here:
        pi.setBackground(bodycolor);       
    
    }//GEN-LAST:event_piMouseExited

    private void vuaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vuaMouseEntered
        // TODO add your handling code here:
        vua.setBackground(navcolor);       
    }//GEN-LAST:event_vuaMouseEntered

    private void vuaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vuaMouseExited
        // TODO add your handling code here:
        vua.setBackground(bodycolor);       

    }//GEN-LAST:event_vuaMouseExited

    private void loMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loMouseEntered
        // TODO add your handling code here:
        lo.setBackground(navcolor);
    }//GEN-LAST:event_loMouseEntered

    private void loMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loMouseExited
        // TODO add your handling code here:
        lo.setBackground(bodycolor);

    }//GEN-LAST:event_loMouseExited

    private void siMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siMouseEntered
        // TODO add your handling code here:\
        si.setBackground(navcolor);

    }//GEN-LAST:event_siMouseEntered

    private void siMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siMouseExited
        // TODO add your handling code here:
        si.setBackground(bodycolor);

    }//GEN-LAST:event_siMouseExited

    private void piMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piMouseMoved

    }//GEN-LAST:event_piMouseMoved

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
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel adminName;
    public javax.swing.JLabel adminPosition;
    private javax.swing.JLabel date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lo;
    private javax.swing.JLabel pi;
    private javax.swing.JLabel si;
    private javax.swing.JLabel time;
    private javax.swing.JLabel vua;
    // End of variables declaration//GEN-END:variables
}
