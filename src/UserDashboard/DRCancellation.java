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
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Elmer Rapon
 */
public class DRCancellation extends javax.swing.JInternalFrame {

    /**
     * Creates new form CustomersOrder
     */
    public DRCancellation() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null); 
    }
    
    Color orig = new Color(255,255,255);
    Color newColor =new Color(204,204,204);
    Color origC = new Color(0,0,255);
  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        done = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        CustomerName = new javax.swing.JLabel();
        CustomerAddress = new javax.swing.JLabel();
        TotalAmounts = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        DRCode = new javax.swing.JTextField();
        ENTER = new javax.swing.JLabel();
        BACK = new javax.swing.JLabel();

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(50, 150, 122));
        jLabel2.setText("DR CANCELLATION");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 0, 750, 40);

        done.setBackground(new java.awt.Color(255, 255, 255));
        done.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        done.setForeground(new java.awt.Color(255, 0, 51));
        done.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        done.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-cancel-20 (1).png"))); // NOI18N
        done.setText("CANCEL");
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
        done.setBounds(340, 570, 130, 30);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0)));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        jLabel1.setText("DR STATUS:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(30, 270, 220, 30);

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DR NUMBER:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 10, 710, 30);

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel4);
        jLabel4.setBounds(250, 270, 450, 30);

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        jLabel5.setText("ADDRESS:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(30, 150, 220, 30);

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        jLabel6.setText("NET AMOUNT:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(30, 190, 220, 30);

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        jLabel7.setText("ORDERED DATE:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(30, 230, 220, 30);

        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 0, 0, new java.awt.Color(51, 153, 0)));
        jPanel2.add(jLabel8);
        jLabel8.setBounds(20, 30, 10, 410);

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        jLabel10.setText("CUSTOMER:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(30, 110, 220, 30);

        CustomerName.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        CustomerName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(CustomerName);
        CustomerName.setBounds(250, 110, 450, 30);

        CustomerAddress.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        CustomerAddress.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(CustomerAddress);
        CustomerAddress.setBounds(250, 150, 450, 30);

        TotalAmounts.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        TotalAmounts.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(TotalAmounts);
        TotalAmounts.setBounds(250, 190, 450, 30);

        jLabel14.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        jLabel14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel14);
        jLabel14.setBounds(250, 230, 450, 30);

        DRCode.setBackground(new java.awt.Color(240, 240, 240));
        DRCode.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(DRCode);
        DRCode.setBounds(250, 36, 240, 30);

        ENTER.setBackground(new java.awt.Color(255, 255, 255));
        ENTER.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        ENTER.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ENTER.setText("ENTER");
        ENTER.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ENTER.setOpaque(true);
        ENTER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ENTERMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ENTERMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ENTERMouseExited(evt);
            }
        });
        jPanel2.add(ENTER);
        ENTER.setBounds(500, 40, 80, 26);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 70, 730, 460);

        BACK.setBackground(new java.awt.Color(255, 255, 255));
        BACK.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
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
        BACK.setBounds(340, 610, 130, 30);

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

    private void ENTERMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ENTERMouseEntered
        // TODO add your handling code here:
        ENTER.setBackground(newColor);
    }//GEN-LAST:event_ENTERMouseEntered

    private void ENTERMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ENTERMouseExited
        // TODO add your handling code here:
        ENTER.setBackground(orig);
    }//GEN-LAST:event_ENTERMouseExited

    private void ENTERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ENTERMouseClicked
        OrderForm of = new OrderForm();
        dbConnector db = new dbConnector();
        String code = DRCode.getText();

               if (!of.checkDRCode(code)) {
                   JOptionPane.showMessageDialog(null, "NO PENDING DELIVERY RECEIPT!", "Warning", JOptionPane.WARNING_MESSAGE);
               } else {
                   try {
                       ResultSet rs = db.getData("SELECT " +
                               "drgenerator.DRNo AS 'DR', " +
                               "customerinfo.CustomerName AS CUSTOMER, " +
                               "CONCAT(customeradd.CustPurok, ', ', customeradd.CustBarangay, ', ', customeradd.CustMunicipal, ', ', customeradd.CustProvince, ', ',"
                               + "customeradd.CustCountry) AS ADDRESS, " +
                               "drgenerator.DeliveryDate AS 'DATE', " +
                               "SUM(orderform.O_TotalAmount) AS 'TOTAL', " +
                               "drgenerator.DRStatus AS 'STATUS', " +
                               "CONCAT(lmer_table.lmer_fname, ' ', lmer_table.lmer_lname) AS 'CASHIER' " +
                               "FROM drgenerator " +
                               "JOIN orderform ON drgenerator.DRNo = orderform.DRNumber " +
                               "JOIN product_information ON orderform.ProductID = product_information.P_Code " +
                               "JOIN lmer_table ON drgenerator.CashierID = lmer_table.lmer_ID " +
                               "JOIN customerinfo ON drgenerator.CustomerID = customerinfo.CustomerID " +
                               "JOIN customeradd ON customerinfo.CustomerAddress = customeradd.customAddNo " +
                               "WHERE drgenerator.DRNo = '" + code + "' " +
                               "GROUP BY drgenerator.DRNo, customerinfo.CustomerName, customeradd.CustPurok, "
                               + "customeradd.CustBarangay, customeradd.CustMunicipal, customeradd.CustProvince, "
                               + "customeradd.CustCountry, drgenerator.DeliveryDate, lmer_table.lmer_fname, lmer_table.lmer_lname");

                       if (rs.next()) { 
                           String name = rs.getString("CUSTOMER");
                           String add = rs.getString("ADDRESS");
                           String amount = rs.getString("TOTAL");
                           Date orDate = rs.getDate("DATE");
                           String date = orDate != null ? orDate.toString() : "";
                           String stat = rs.getString("STATUS");

                           CustomerName.setText(name);
                           CustomerAddress.setText(add);
                           TotalAmounts.setText(amount);
                           jLabel14.setText(date);
                           jLabel4.setText(stat);  
                       } else {
                           JOptionPane.showMessageDialog(null, "No records found!", "Info", JOptionPane.INFORMATION_MESSAGE);
                       }
                   } catch (SQLException ex) {
                       Logger.getLogger(DRCancellation.class.getName()).log(Level.SEVERE, null, ex);
                       JOptionPane.showMessageDialog(null, "Error fetching data!", "Error", JOptionPane.ERROR_MESSAGE);
                   }
               }
    }//GEN-LAST:event_ENTERMouseClicked

    private void doneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doneMouseClicked

        dbConnector connect = new dbConnector();
        String code = DRCode.getText(); 
        if(code.isEmpty()){
            JOptionPane.showMessageDialog(null, "INPUT DR NUMBER FIRST", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            
            int drcode;
            try {
                drcode = Integer.parseInt(code);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid DR Number", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
             
        String query = "SELECT * FROM orderform WHERE DRNumber = ?";
        try (Connection conn = connect.getConnection();
             PreparedStatement pstOrder = conn.prepareStatement(query)) {

            pstOrder.setString(1, code);
            ResultSet resultSetOrder = pstOrder.executeQuery();

            conn.setAutoCommit(false); // Start transaction

            while (resultSetOrder.next()) {
                String prodID = resultSetOrder.getString("ProductID");
                int orderQuan = resultSetOrder.getInt("OrderQuantity");
                Date manDate = resultSetOrder.getDate("ManufacturingDate");
                Date exDate = resultSetOrder.getDate("ExpiryDate");

                String selectOutputQuery = "SELECT * FROM output WHERE product_ID = ? AND O_ManufacturingDate = ? AND O_ExpiryDate = ?";
                try (PreparedStatement pstOutput = conn.prepareStatement(selectOutputQuery)) {
                    pstOutput.setString(1, prodID);
                    pstOutput.setDate(2, (java.sql.Date) manDate);
                    pstOutput.setDate(3, (java.sql.Date) exDate);
                    ResultSet resultSetOutput = pstOutput.executeQuery();

                    if (resultSetOutput.next()) {
                        // Entry exists, update the quantity
                        int outputId = resultSetOutput.getInt("output_ID");
                        int currentQuantity = resultSetOutput.getInt("O_Quantity");
                        int newQuantity = currentQuantity + orderQuan;

                        String updateOutputQuery = "UPDATE output SET O_Quantity = ? WHERE output_ID = ?";
                        try (PreparedStatement updateOutputPst = conn.prepareStatement(updateOutputQuery)) {
                            updateOutputPst.setInt(1, newQuantity);
                            updateOutputPst.setInt(2, outputId);
                            updateOutputPst.executeUpdate();
                        }
                    } else {
                        // Entry does not exist, insert a new row
                        String insertOutputQuery = "INSERT INTO output (product_ID, O_Quantity, O_ManufacturingDate, O_ExpiryDate, O_Status) VALUES (?, ?, ?, ?, ?)";
                        try (PreparedStatement insertOutputPst = conn.prepareStatement(insertOutputQuery)) {
                            insertOutputPst.setString(1, prodID);
                            insertOutputPst.setInt(2, orderQuan);
                            insertOutputPst.setDate(3, (java.sql.Date) manDate);
                            insertOutputPst.setDate(4, (java.sql.Date) exDate);
                            insertOutputPst.setString(5, "IN STOCK");                            
                            insertOutputPst.executeUpdate();
                        }
                    }
                }

                // Delete the entry from orderform
                String deleteOrderQuery = "DELETE FROM orderform WHERE DRNumber = ? AND ProductID = ? AND ManufacturingDate = ? AND ExpiryDate = ?";
                try (PreparedStatement deleteOrderPst = conn.prepareStatement(deleteOrderQuery)) {
                    deleteOrderPst.setString(1, code);
                    deleteOrderPst.setString(2, prodID);
                    deleteOrderPst.setDate(3, (java.sql.Date) manDate);
                    deleteOrderPst.setDate(4, (java.sql.Date) exDate);
                    deleteOrderPst.executeUpdate();
                }
            }
            
                String updateDRStatus = "UPDATE drgenerator SET DRStatus = ? WHERE DRNo = ?";
                        try (PreparedStatement updateDRStat = conn.prepareStatement(updateDRStatus)) {
                            updateDRStat.setString(1, "CANCELLED");
                            updateDRStat.setInt(2, drcode);
                            updateDRStat.executeUpdate();
                        }          

            conn.commit(); // Commit transaction
            JOptionPane.showMessageDialog(null, "Delivery Receipt Canceled Successfully!", "Message", JOptionPane.INFORMATION_MESSAGE);
            DRTransactions dr = new DRTransactions();
            JDesktopPane desktopPane = (JDesktopPane) getParent();
            desktopPane.add(dr);
            dr.setVisible(true);
            setVisible(false);

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
        }  
    }//GEN-LAST:event_doneMouseClicked

    private void doneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doneMouseEntered
        // TODO add your handling code here:
        done.setBackground(newColor);
    }//GEN-LAST:event_doneMouseEntered

    private void doneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doneMouseExited
        // TODO add your handling code here:
        done.setBackground(orig);
    }//GEN-LAST:event_doneMouseExited

    private void BACKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BACKMouseClicked
        // TODO add your handling code here:
        DRTransactions drT = new DRTransactions();
        JDesktopPane desktopPane = (JDesktopPane) getParent();
        desktopPane.add(drT);
        drT.setVisible(true);
        setVisible(false);

    }//GEN-LAST:event_BACKMouseClicked

    private void BACKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BACKMouseEntered
        // TODO add your handling code here:
        BACK.setBackground(newColor);
    }//GEN-LAST:event_BACKMouseEntered

    private void BACKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BACKMouseExited
        // TODO add your handling code here:
        BACK.setBackground(orig);
    }//GEN-LAST:event_BACKMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BACK;
    private javax.swing.JLabel CustomerAddress;
    private javax.swing.JLabel CustomerName;
    private javax.swing.JTextField DRCode;
    private javax.swing.JLabel ENTER;
    private javax.swing.JLabel TotalAmounts;
    private javax.swing.JLabel done;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
