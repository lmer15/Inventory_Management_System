/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserDashboard;

import config.dbConnector;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
public class OrderForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form DRGenerator
     */
    public OrderForm() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
        drError.setVisible(false);
        itemError.setVisible(false);
        ErrorHandling();
    }
        
    Color orig = new Color(255,255,255);
    Color newColor =new Color(204,204,204);
    Color origC = new Color(0,0,255);
    
    private void ErrorHandling() {

        drCode.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                drCodes();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                drCodes();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                drCodes();
            }
        });
        
        itemCode.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                productCode();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                productCode();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                productCode();
            }
        });
    }
    
    
    private void drCodes() {
    String dr = drCode.getText();
    if (!checkDRCode(dr)) {
        drError.setVisible(true);
    } else {
        drError.setVisible(false);
    }
}
    private void productCode() {
    String prod = itemCode.getText();
    if (!checkProductCode(prod)) {
        itemError.setVisible(true);
    } else {
        itemError.setVisible(false);
    }
}
   
      
    public static boolean checkDRCode(String codes) {
        dbConnector connect = new dbConnector();

        try {
            String query = "SELECT DRNo FROM drgenerator WHERE DRNo = ? AND DRStatus = 'Pending' ";
            PreparedStatement statement = connect.getConnection().prepareStatement(query);
            statement.setString(1, codes);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return true; // Code exists in the database
            } else {
                return false; // Code not found in the database
            }
        } catch(SQLException ex) {
            System.out.println("Connection Error: " + ex);
            return false; // Exception occurred
        }
    }
    
        public static boolean checkProductCode(String codes) {
        dbConnector connect = new dbConnector();

        try {
            String query = "SELECT P_Code FROM product_information WHERE P_Code = ?";
            PreparedStatement statement = connect.getConnection().prepareStatement(query);
            statement.setString(1, codes);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return true; // Code exists in the database
            } else {
                return false; // Code not found in the database
            }
        } catch(SQLException ex) {
            System.out.println("Connection Error: " + ex);
            return false; // Exception occurred
        }
    }  
       
    public static double getProductPrice(String productCode) {
        double productPrice = 0.0;
        dbConnector connector = new dbConnector();
        try {
            String query = "SELECT P_Price FROM product_information WHERE P_Code = '" + productCode + "'";
            ResultSet resultSet = connector.getData(query);
            if (resultSet.next()) {
                productPrice = resultSet.getDouble("P_Price");
            } else {
                JOptionPane.showMessageDialog(null, "Invalid product code!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Connection Error!");
        }
        return productPrice;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        drCode = new javax.swing.JTextField();
        drError = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        itemCode = new javax.swing.JTextField();
        itemError = new javax.swing.JLabel();
        iOK = new javax.swing.JLabel();
        OName = new javax.swing.JLabel();
        OFlavor = new javax.swing.JLabel();
        Oquan = new javax.swing.JLabel();
        quantity = new javax.swing.JLabel();
        OPrice = new javax.swing.JLabel();
        quantit = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        done = new javax.swing.JLabel();

        jPanel1.setLayout(null);

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(50, 150, 122), 1, true));
        jPanel2.setLayout(null);

        jLabel2.setForeground(new java.awt.Color(50, 150, 122));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Enter DR Number:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 10, 170, 20);

        drCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 150, 122)));
        jPanel2.add(drCode);
        drCode.setBounds(20, 30, 150, 22);

        drError.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        drError.setForeground(new java.awt.Color(255, 0, 51));
        drError.setText("!DR Number doesn't Exist");
        jPanel2.add(drError);
        drError.setBounds(20, 50, 150, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(560, 10, 190, 80);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 150, 122)));
        jPanel3.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(50, 150, 122));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Item Description");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel1);
        jLabel1.setBounds(220, 10, 500, 40);

        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(50, 150, 122), 1, true));
        jPanel5.setLayout(null);

        jLabel5.setForeground(new java.awt.Color(50, 150, 122));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Enter Item Code:");
        jPanel5.add(jLabel5);
        jLabel5.setBounds(10, 10, 130, 20);

        itemCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 150, 122)));
        jPanel5.add(itemCode);
        itemCode.setBounds(10, 30, 130, 22);

        itemError.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        itemError.setForeground(new java.awt.Color(255, 0, 51));
        itemError.setText(" !Item not found");
        jPanel5.add(itemError);
        itemError.setBounds(10, 50, 130, 20);

        iOK.setBackground(new java.awt.Color(255, 255, 255));
        iOK.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        iOK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iOK.setText("OK");
        iOK.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        iOK.setOpaque(true);
        iOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iOKMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                iOKMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                iOKMouseExited(evt);
            }
        });
        jPanel5.add(iOK);
        iOK.setBounds(150, 30, 30, 21);

        jPanel3.add(jPanel5);
        jPanel5.setBounds(10, 10, 190, 80);

        OName.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        OName.setForeground(new java.awt.Color(50, 150, 122));
        OName.setText("Name:");
        OName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        OName.setOpaque(true);
        jPanel3.add(OName);
        OName.setBounds(230, 60, 470, 30);

        OFlavor.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        OFlavor.setForeground(new java.awt.Color(50, 150, 122));
        OFlavor.setText("Flavor");
        OFlavor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        OFlavor.setOpaque(true);
        jPanel3.add(OFlavor);
        OFlavor.setBounds(230, 100, 470, 30);

        Oquan.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        Oquan.setForeground(new java.awt.Color(50, 150, 122));
        Oquan.setText("No. of Item Ordered: ");
        Oquan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        Oquan.setOpaque(true);
        jPanel3.add(Oquan);
        Oquan.setBounds(230, 220, 190, 30);

        quantity.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        quantity.setForeground(new java.awt.Color(50, 150, 122));
        quantity.setText("Quantity:");
        quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        quantity.setOpaque(true);
        jPanel3.add(quantity);
        quantity.setBounds(230, 140, 470, 30);

        OPrice.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        OPrice.setForeground(new java.awt.Color(50, 150, 122));
        OPrice.setText("Price: ");
        OPrice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        OPrice.setOpaque(true);
        jPanel3.add(OPrice);
        OPrice.setBounds(230, 180, 470, 30);

        quantit.setBackground(new java.awt.Color(240, 240, 240));
        quantit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        quantit.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        quantit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantitActionPerformed(evt);
            }
        });
        jPanel3.add(quantit);
        quantit.setBounds(420, 220, 280, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(20, 180, 730, 260);

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(50, 150, 122));
        jLabel3.setText("ORDER FORM");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 10, 530, 40);

        back.setBackground(new java.awt.Color(255, 255, 255));
        back.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
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
        jPanel1.add(back);
        back.setBounds(350, 570, 80, 30);

        done.setBackground(new java.awt.Color(255, 255, 255));
        done.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        done.setForeground(new java.awt.Color(255, 0, 51));
        done.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        done.setText("DONE");
        done.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        done.setOpaque(true);
        done.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                doneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                doneMouseExited(evt);
            }
        });
        jPanel1.add(done);
        done.setBounds(350, 530, 80, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void doneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doneMouseExited
        // TODO add your handling code here:
        done.setBackground(orig);
    }//GEN-LAST:event_doneMouseExited

    private void doneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doneMouseEntered
        // TODO add your handling code here:
        done.setBackground(newColor);
    }//GEN-LAST:event_doneMouseEntered

    private void doneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doneMouseClicked

        String DrCode = drCode.getText();
        String ItemCode = itemCode.getText();
        String quan = quantit.getText();

        if (DrCode.isEmpty() || ItemCode.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fill in the Form First!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!checkDRCode(DrCode)) {
            JOptionPane.showMessageDialog(null, "DR Number Doesn't Exist, Create Delivery Receipt First", "Error", JOptionPane.ERROR_MESSAGE);
            drCode.setText(""); // Clear the text field
        } else {
            int quant;
            try {
                quant = Integer.parseInt(quan);
                if (quant <= 0) {
                    JOptionPane.showMessageDialog(null, "Quantity must be a positive number", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Quantity must be a valid counting number", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            dbConnector db = new dbConnector();
            Connection conn = db.getConnection();
            try {
                conn.setAutoCommit(false); // Start transaction

                String query = "SELECT * FROM output WHERE product_ID = ? ORDER BY O_ExpiryDate ASC";
                try (PreparedStatement pst = conn.prepareStatement(query)) {
                    pst.setString(1, ItemCode);
                    ResultSet resultSet = pst.executeQuery();

                    double totalAmount = 0.0;
                    double productPrice = getProductPrice(ItemCode);

                    while (resultSet.next() && quant > 0) {
                        int outputId = resultSet.getInt("output_ID");
                        int currentQuantity = resultSet.getInt("O_Quantity");
                        Date manDate = resultSet.getDate("O_ManufacturingDate");
                        Date exDate = resultSet.getDate("O_ExpiryDate");

                        int usedQuantity;
                        if (currentQuantity <= quant) {
                            // Order quantity exceeds or matches the current product quantity
                            usedQuantity = currentQuantity;
                            quant -= currentQuantity;
                            // Delete the record
                            String deleteQuery = "DELETE FROM output WHERE output_ID = ?";
                            try (PreparedStatement deletePst = conn.prepareStatement(deleteQuery)) {
                                deletePst.setInt(1, outputId);
                                deletePst.executeUpdate();
                            }
                        } else {
                            // Order quantity is less than the current product quantity
                            usedQuantity = quant;
                            int newQuantity = currentQuantity - quant;
                            quant = 0;
                            // Update the quantity
                            String updateQuery = "UPDATE output SET O_Quantity = ? WHERE output_ID = ?";
                            try (PreparedStatement updatePst = conn.prepareStatement(updateQuery)) {
                                updatePst.setInt(1, newQuantity);
                                updatePst.setInt(2, outputId);
                                updatePst.executeUpdate();
                            }
                        }

                        // Calculate the total amount for the used quantity
                        double batchTotalAmount = usedQuantity * productPrice;
                        totalAmount += batchTotalAmount;

                        // Insert the used product batch into the orderform table
                        String insertOrderQuery = "INSERT INTO orderform (DRNumber, ProductID, OrderQuantity, O_TotalAmount, ManufacturingDate, ExpiryDate, OrderStatus) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";
                        try (PreparedStatement insertPst = conn.prepareStatement(insertOrderQuery)) {
                            insertPst.setString(1, DrCode);
                            insertPst.setString(2, ItemCode);
                            insertPst.setInt(3, usedQuantity);
                            insertPst.setDouble(4, batchTotalAmount);
                            insertPst.setDate(5, (java.sql.Date) manDate);
                            insertPst.setDate(6, (java.sql.Date) exDate);
                            insertPst.setString(7, "PENDING");
                            insertPst.executeUpdate();
                        }
                    }

                    if (quant > 0) {
                        conn.rollback(); // Rollback transaction if there is insufficient stock
                        JOptionPane.showMessageDialog(null, "Insufficient stock to fulfill the order!.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        conn.commit(); // Commit transaction
                        JOptionPane.showMessageDialog(null, "Order Saved!");
                        OrderForm of = new OrderForm();
                        JDesktopPane desktopPane = (JDesktopPane) getParent();
                        desktopPane.add(of);
                        of.setVisible(true);
                        setVisible(false);
                    }
                }
            } catch (SQLException ex) {
                try {
                    conn.rollback(); // Rollback transaction in case of error
                } catch (SQLException ex1) {
                    Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex1);
                }
                JOptionPane.showMessageDialog(null, "Error processing the order: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                try {
                    conn.setAutoCommit(true); // Reset to default
                } catch (SQLException ex) {
                    Logger.getLogger(OrderForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }//GEN-LAST:event_doneMouseClicked

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
        // TODO add your handling code here:
        back.setBackground(orig);
    }//GEN-LAST:event_backMouseExited

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        // TODO add your handling code here:
        back.setBackground(newColor);

    }//GEN-LAST:event_backMouseEntered

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
        OrderTransactions ot = new OrderTransactions();
        JDesktopPane desktopPane = (JDesktopPane) getParent();
        desktopPane.add(ot);
        ot.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_backMouseClicked

    private void quantitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantitActionPerformed

    private void iOKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iOKMouseExited
        // TODO add your handling code here:
        iOK.setBackground(orig);
    }//GEN-LAST:event_iOKMouseExited

    private void iOKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iOKMouseEntered
        // TODO add your handling code here:
        iOK.setBackground(newColor);

    }//GEN-LAST:event_iOKMouseEntered

    private void iOKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iOKMouseClicked
        // TODO add your handling code here:

        dbConnector dbc = new dbConnector();
        newProduct np = new newProduct();
        Output op = new Output();

        try {
            String code = itemCode.getText();

            if (code.isEmpty()) {
                JOptionPane.showMessageDialog(null, "INPUT PRODUCT CODE FIRST", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                String sql = "SELECT * FROM product_information WHERE P_Code = '" + code + "'";
                ResultSet rs = dbc.getData(sql);

                if (rs.next()) {
                    int productCode = rs.getInt("P_Code");

                    if (code.equals(String.valueOf(productCode))) {
                        int productPrice = rs.getInt("P_Price");
                        int quan = op.checkQuantity(productCode); // get the quantity for the specific product

                        OName.setText("Name: " + rs.getString("P_Name"));
                        OFlavor.setText("Flavor: " + rs.getString("P_Flavor"));
                        OPrice.setText("Price: " + productPrice);
                        quantity.setText("Quantity: " + quan);
                    }
                } else {
                    // No rows found
                    JOptionPane.showMessageDialog(null, "NO PRODUCT FOUND", "Error", JOptionPane.ERROR_MESSAGE);
                    OName.setText("Name: ");
                    OFlavor.setText("Flavor: ");
                    OPrice.setText("Price: ");
                    quantity.setText("Quantity");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Invalid Connection: " + ex.getMessage());
        }
    }//GEN-LAST:event_iOKMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel OFlavor;
    private javax.swing.JLabel OName;
    private javax.swing.JLabel OPrice;
    private javax.swing.JLabel Oquan;
    private javax.swing.JLabel back;
    private javax.swing.JLabel done;
    private javax.swing.JTextField drCode;
    private javax.swing.JLabel drError;
    private javax.swing.JLabel iOK;
    private javax.swing.JTextField itemCode;
    private javax.swing.JLabel itemError;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField quantit;
    private javax.swing.JLabel quantity;
    // End of variables declaration//GEN-END:variables
}
