/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserDashboard;

import Config.insertImage;
import Config.session;
import config.dbConnector;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Elmer Rapon
 */
public class Output extends javax.swing.JInternalFrame {

    /**
     * Creates new form Output
     */
    public Output() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }

    Color orig = new Color(240,240,240);
    Color newColor =new Color(204,204,204);
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        OLogo = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        OPrice = new javax.swing.JLabel();
        OName = new javax.swing.JLabel();
        OFlavor = new javax.swing.JLabel();
        OQuantity = new javax.swing.JLabel();
        OStatus = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        OCode = new javax.swing.JTextField();
        back = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        ok = new javax.swing.JLabel();
        save = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setLayout(null);

        OLogo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0)));
        OLogo.setOpaque(true);
        jPanel2.add(OLogo);
        OLogo.setBounds(30, 20, 270, 270);

        jLabel13.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(50, 150, 122));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Expiry Date");
        jLabel13.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel13);
        jLabel13.setBounds(430, 490, 270, 30);

        jLabel14.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(50, 150, 122));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Basic Details");
        jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel14);
        jLabel14.setBounds(310, 20, 440, 30);

        OPrice.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        OPrice.setForeground(new java.awt.Color(50, 150, 122));
        OPrice.setText("Price: ");
        OPrice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        OPrice.setOpaque(true);
        jPanel2.add(OPrice);
        OPrice.setBounds(310, 140, 440, 30);

        OName.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        OName.setForeground(new java.awt.Color(50, 150, 122));
        OName.setText("Name:");
        OName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        OName.setOpaque(true);
        jPanel2.add(OName);
        OName.setBounds(310, 60, 440, 30);

        OFlavor.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        OFlavor.setForeground(new java.awt.Color(50, 150, 122));
        OFlavor.setText("Flavor");
        OFlavor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        OFlavor.setOpaque(true);
        jPanel2.add(OFlavor);
        OFlavor.setBounds(310, 100, 440, 30);

        OQuantity.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        OQuantity.setForeground(new java.awt.Color(50, 150, 122));
        OQuantity.setText("Quantity");
        OQuantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        OQuantity.setOpaque(true);
        jPanel2.add(OQuantity);
        OQuantity.setBounds(310, 180, 440, 30);

        OStatus.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        OStatus.setForeground(new java.awt.Color(50, 150, 122));
        OStatus.setText("Status:");
        OStatus.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        OStatus.setOpaque(true);
        jPanel2.add(OStatus);
        OStatus.setBounds(310, 220, 440, 30);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1);
        jTextField1.setBounds(430, 350, 270, 40);

        jLabel16.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(50, 150, 122));
        jLabel16.setText("Enter Product Code: ");
        jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel16);
        jLabel16.setBounds(30, 310, 270, 30);

        OCode.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        OCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OCodeActionPerformed(evt);
            }
        });
        jPanel2.add(OCode);
        OCode.setBounds(30, 350, 190, 40);

        back.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(50, 150, 122));
        back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back.setText("BACK");
        back.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        back.setOpaque(true);
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backMouseExited(evt);
            }
        });
        jPanel2.add(back);
        back.setBounds(30, 530, 270, 30);
        jPanel2.add(jDateChooser1);
        jDateChooser1.setBounds(430, 530, 270, 40);

        jLabel19.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(50, 150, 122));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Manufacturing Date");
        jLabel19.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel19);
        jLabel19.setBounds(430, 400, 270, 30);
        jPanel2.add(jDateChooser2);
        jDateChooser2.setBounds(430, 440, 270, 40);

        ok.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        ok.setForeground(new java.awt.Color(255, 0, 51));
        ok.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ok.setText("Ok");
        ok.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ok.setOpaque(true);
        ok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                okMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                okMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                okMouseExited(evt);
            }
        });
        jPanel2.add(ok);
        ok.setBounds(230, 350, 90, 40);

        save.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        save.setForeground(new java.awt.Color(255, 51, 51));
        save.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        save.setText("SAVE");
        save.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        save.setOpaque(true);
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saveMouseExited(evt);
            }
        });
        jPanel2.add(save);
        save.setBounds(30, 490, 270, 30);

        jLabel26.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(50, 150, 122));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Quantity");
        jLabel26.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel26);
        jLabel26.setBounds(430, 310, 270, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 770, 690);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void OCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OCodeActionPerformed

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_saveMouseClicked

    private void saveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseEntered
        // TODO add your handling code here:
        save.setBackground(newColor);
    }//GEN-LAST:event_saveMouseEntered

    private void saveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseExited
        // TODO add your handling code here:
        save.setBackground(orig);

    }//GEN-LAST:event_saveMouseExited

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        // TODO add your handling code here:
        back.setBackground(newColor);
    }//GEN-LAST:event_backMouseEntered

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
        // TODO add your handling code here:
        back.setBackground(orig);
    }//GEN-LAST:event_backMouseExited

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
    back.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            transaction trans = new transaction();
            JDesktopPane desktopPane = (JDesktopPane) getParent();
            desktopPane.add(trans);
            trans.setVisible(true);
            setVisible(false);
        }
        });
    }//GEN-LAST:event_backMouseClicked

    private void okMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okMouseEntered
        // TODO add your handling code here:
        ok.setBackground(newColor);
    }//GEN-LAST:event_okMouseEntered

    private void okMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okMouseExited
        // TODO add your handling code here:
        ok.setBackground(orig);
    }//GEN-LAST:event_okMouseExited

    private void okMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_okMouseClicked

    dbConnector dbc = new dbConnector();
    newProduct np = new newProduct();
    insertImage im = new insertImage();
    
      try {
          
          String code = OCode.getText();

          if (code.isEmpty()) {
              JOptionPane.showMessageDialog(null, "INPUT PRODUCT CODE FIRST", "Warning", JOptionPane.WARNING_MESSAGE);
          } else {
              String sql = "SELECT *, SUM(P_Quantity) AS totalQuantity FROM product_information WHERE P_Code = '" + code + "'";
              ResultSet rs = dbc.getData(sql);

                if (rs.next()) {
                  
                  int productCode = rs.getInt("P_Code");

                  if (code.equals(String.valueOf(productCode))) {
                      int productPrice = rs.getInt("P_Price");
                      int quantity = rs.getInt("totalQuantity");

                      OName.setText("Name: " + rs.getString("P_Name"));
                      OFlavor.setText("Flavor: " + rs.getString("P_Flavor"));
                      OPrice.setText("Price: " + productPrice);
                      OQuantity.setText("Quantity: " + quantity);

                      if (quantity > 0) {
                          OStatus.setText("Status: IN STOCK");
                      } else {
                          OStatus.setText("Status: NO STOCK");
                      }

                      String photoPath = rs.getString("P_Photo");
                      if (photoPath != null && !photoPath.isEmpty()) {
                          OLogo.setIcon(im.ResizeImage(photoPath, null, OLogo));
                          np.oldPath = photoPath;
                          np.path = photoPath;
                          np.destination = photoPath;
                      } else {
                          // If no photo is available, clear the icon and paths
                          OLogo.setIcon(null);
                          np.oldPath = "";
                          np.path = "";
                          np.destination = "";
                      }
                  } else {
                  JOptionPane.showMessageDialog(null, "NO PRODUCT FOUND", "Error", JOptionPane.ERROR_MESSAGE);
                  OName.setText("");
                  OFlavor.setText("");
                  OPrice.setText("");
                  OQuantity.setText("");
                  OStatus.setText("");
                  OLogo.setIcon(null); // Clear the icon
                  np.oldPath = "";
                  np.path = "";
                  np.destination = "";
              }
            }
          }
      } catch(SQLException ex) {
          System.out.println("Invalid Connection: " + ex.getMessage());
      }

          
    }//GEN-LAST:event_okMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField OCode;
    public javax.swing.JLabel OFlavor;
    public javax.swing.JLabel OLogo;
    public javax.swing.JLabel OName;
    public javax.swing.JLabel OPrice;
    public javax.swing.JLabel OQuantity;
    public javax.swing.JLabel OStatus;
    private javax.swing.JLabel back;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel ok;
    private javax.swing.JLabel save;
    // End of variables declaration//GEN-END:variables
}
