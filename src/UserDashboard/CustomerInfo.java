/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserDashboard;

import config.dbConnector;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Elmer Rapon
 */
public class CustomerInfo extends javax.swing.JInternalFrame {

    /**
     * Creates new form CustomerInfo
     */
    public CustomerInfo() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
        errorContact.setVisible(false);
        ErrorHandling();
    }
    
    
     private void ErrorHandling() {
        CustomerNumber.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateNumber();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateNumber();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateNumber();
            }
        });
     }
     
    private void validateNumber() {
    String numberText = CustomerNumber.getText();
    if (!validatePhoneNumber(numberText)) {
        errorContact.setVisible(true);
    } else {
        errorContact.setVisible(false);
    }
}

    Color orig = new Color(255,255,255);
    Color newColor =new Color(204,204,204);
    Color origC = new Color(0,0,255);
    
    
    public static boolean validatePhoneNumber(String phoneNumber) {
        String pattern = "^\\d{3}-\\d{3}-\\d{4}$";
        return phoneNumber.matches(pattern);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cProvince = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cPurok = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cCountry = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cBrgy = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cMunicipal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CustomerName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        CustomerNumber = new javax.swing.JTextField();
        errorContact = new javax.swing.JLabel();
        BACK = new javax.swing.JLabel();
        DONE = new javax.swing.JLabel();

        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(50, 150, 122));
        jLabel3.setText("CUSTOMER INFORMATION");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 10, 750, 40);

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 51)));
        jPanel2.setLayout(null);

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 51)));
        jPanel3.setLayout(null);

        jLabel4.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Country");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(190, 160, 120, 30);

        cProvince.setBackground(new java.awt.Color(240, 240, 240));
        cProvince.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cProvince.setText(" ");
        cProvince.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 51)));
        cProvince.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cProvinceActionPerformed(evt);
            }
        });
        jPanel3.add(cProvince);
        cProvince.setBounds(480, 100, 180, 40);

        jLabel7.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 51));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("COMPLETE ADDRESS");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(10, 10, 670, 40);

        jLabel8.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Brgy.");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(280, 60, 100, 40);

        cPurok.setBackground(new java.awt.Color(240, 240, 240));
        cPurok.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cPurok.setText(" ");
        cPurok.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 51)));
        jPanel3.add(cPurok);
        cPurok.setBounds(110, 50, 170, 40);

        jLabel9.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 51));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Purok");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(10, 60, 100, 40);

        cCountry.setBackground(new java.awt.Color(240, 240, 240));
        cCountry.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cCountry.setText(" ");
        cCountry.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 51)));
        cCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cCountryActionPerformed(evt);
            }
        });
        jPanel3.add(cCountry);
        cCountry.setBounds(320, 150, 170, 40);

        jLabel10.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Municipal");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(10, 110, 150, 40);

        cBrgy.setBackground(new java.awt.Color(240, 240, 240));
        cBrgy.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cBrgy.setText(" ");
        cBrgy.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 51)));
        cBrgy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBrgyActionPerformed(evt);
            }
        });
        jPanel3.add(cBrgy);
        cBrgy.setBounds(390, 50, 270, 40);

        jLabel11.setFont(new java.awt.Font("OCR A Extended", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 51));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Province");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(330, 110, 150, 40);

        cMunicipal.setBackground(new java.awt.Color(240, 240, 240));
        cMunicipal.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        cMunicipal.setText(" ");
        cMunicipal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 51)));
        cMunicipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cMunicipalActionPerformed(evt);
            }
        });
        jPanel3.add(cMunicipal);
        cMunicipal.setBounds(160, 100, 170, 40);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(20, 240, 690, 220);

        jLabel5.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 51));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Customer Name");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 20, 710, 40);

        CustomerName.setBackground(new java.awt.Color(240, 240, 240));
        CustomerName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CustomerName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CustomerName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 51)));
        jPanel2.add(CustomerName);
        CustomerName.setBounds(190, 56, 340, 40);

        jLabel6.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Contact Number");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(10, 110, 710, 40);

        CustomerNumber.setBackground(new java.awt.Color(240, 240, 240));
        CustomerNumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CustomerNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CustomerNumber.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 51)));
        jPanel2.add(CustomerNumber);
        CustomerNumber.setBounds(190, 150, 340, 40);

        errorContact.setForeground(new java.awt.Color(255, 0, 51));
        errorContact.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorContact.setText("!Invalid Format (000-000-0000)");
        jPanel2.add(errorContact);
        errorContact.setBounds(190, 200, 340, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 70, 730, 480);

        BACK.setBackground(new java.awt.Color(255, 255, 255));
        BACK.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        BACK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BACK.setText("BACK");
        BACK.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BACK.setOpaque(true);
        BACK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BACKMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BACKMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BACKMouseExited(evt);
            }
        });
        jPanel1.add(BACK);
        BACK.setBounds(350, 600, 80, 30);

        DONE.setBackground(new java.awt.Color(255, 255, 255));
        DONE.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        DONE.setForeground(new java.awt.Color(255, 0, 51));
        DONE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DONE.setText("DONE");
        DONE.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DONE.setOpaque(true);
        DONE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DONEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DONEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DONEMouseExited(evt);
            }
        });
        jPanel1.add(DONE);
        DONE.setBounds(350, 560, 80, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cProvinceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cProvinceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cProvinceActionPerformed

    private void cCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cCountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cCountryActionPerformed

    private void cBrgyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBrgyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cBrgyActionPerformed

    private void cMunicipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cMunicipalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cMunicipalActionPerformed

    private void BACKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BACKMouseEntered
        // TODO add your handling code here:
        BACK.setBackground(newColor);
    }//GEN-LAST:event_BACKMouseEntered

    private void BACKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BACKMouseExited
        // TODO add your handling code here:
        BACK.setBackground(orig);
    }//GEN-LAST:event_BACKMouseExited

    private void DONEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DONEMouseEntered
        // TODO add your handling code here:
        DONE.setBackground(newColor);
    }//GEN-LAST:event_DONEMouseEntered

    private void DONEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DONEMouseExited
        // TODO add your handling code here:
        DONE.setBackground(orig);
    }//GEN-LAST:event_DONEMouseExited

    private void DONEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DONEMouseClicked
        // TODO add your handling code here:
        String number = CustomerNumber.getText();

        if (CustomerName.getText().isEmpty()
                || CustomerNumber.getText().isEmpty()
                || cPurok.getText().isEmpty()
                || cBrgy.getText().isEmpty()
                || cMunicipal.getText().isEmpty()
                || cProvince.getText().isEmpty()
                || cCountry.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields should be filled", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!validatePhoneNumber(number)) {
            JOptionPane.showMessageDialog(null, "Invalid format for Phone Number", "Error", JOptionPane.ERROR_MESSAGE);
            CustomerNumber.setText("");
        } else {
            dbConnector db = new dbConnector();
            try {
                
                db.getConnection().setAutoCommit(false);

                if (db.insertData("INSERT INTO customeradd (custPurok, custBarangay, custMunicipal, custProvince, custCountry) "
                        + "VALUES ('" + cPurok.getText() + "', '"
                        + cBrgy.getText() + "', '"
                        + cMunicipal.getText() + "', '"
                        + cProvince.getText() + "', '"
                        + cCountry.getText() + "')")) {

                    ResultSet rs = db.getData("SELECT LAST_INSERT_ID() ");
                    int addressID = -1;
                    if (rs.next()) {
                        addressID = rs.getInt(1);
                    }

                    if (db.insertData("INSERT INTO customerinfo (CustomerAddress, CustomerName, CustomerContactNo) "
                            + "VALUES ('" + addressID + "', '"
                            + CustomerName.getText() + "', '"
                            + CustomerNumber.getText() + "')")) {
                        
                        db.getConnection().commit();
                        JOptionPane.showMessageDialog(null, "Data Saved!", "Message", JOptionPane.INFORMATION_MESSAGE);

                        OrderForm dr = new OrderForm();
                        JDesktopPane desktopPane = (JDesktopPane) getParent();
                        desktopPane.add(dr);
                        dr.setVisible(true);
                        setVisible(false);
                    } else {
                        db.getConnection().rollback();
                        JOptionPane.showMessageDialog(null, "FAILED TO INSERT", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "FAILED TO INSERT.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                try {
                    db.getConnection().rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
                Logger.getLogger(CustomerInfo.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    db.getConnection().setAutoCommit(true);
                } catch (SQLException finalEx) {
                    finalEx.printStackTrace();
                }
            }
        }

    }//GEN-LAST:event_DONEMouseClicked

    private void BACKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BACKMouseClicked
        // TODO add your handling code here:
        drGenerator dr = new drGenerator();
        JDesktopPane desktopPane = (JDesktopPane) getParent();
        desktopPane.add(dr);
        dr.setVisible(true);
        setVisible(false);
        
    }//GEN-LAST:event_BACKMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BACK;
    private javax.swing.JTextField CustomerName;
    private javax.swing.JTextField CustomerNumber;
    private javax.swing.JLabel DONE;
    private javax.swing.JTextField cBrgy;
    private javax.swing.JTextField cCountry;
    private javax.swing.JTextField cMunicipal;
    private javax.swing.JTextField cProvince;
    private javax.swing.JTextField cPurok;
    private javax.swing.JLabel errorContact;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
