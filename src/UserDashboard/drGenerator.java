package UserDashboard;
import SignUp_LogIn.LogIn;
import config.dbConnector;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Elmer Rapon
 */
public class drGenerator extends javax.swing.JInternalFrame {

    /**
     * Creates new form OrderForm
     */
    public drGenerator() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        customerError.setVisible(false);
        drError.setVisible(false);
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
        
        
        customerCode.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                customerCodes();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                customerCodes();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                customerCodes();
            }
        });
        
    }    
  
    private void drCodes() {
    String dr = drCode.getText();
    if (checkDRCode(dr)) {
        drError.setVisible(true);
    } else {
        drError.setVisible(false);
    }
}    
        
    private void customerCodes() {
    String cust = customerCode.getText();
    if (!checkCustomerCode(cust)) {
        customerError.setVisible(true);
    } else {
        customerError.setVisible(false);
    }
}
 
    public static boolean checkCustomerCode(String codes) {
    dbConnector connect = new dbConnector();

    try {
        String query = "SELECT CustomerID FROM customerinfo WHERE CustomerID = ?";
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
      
    public static boolean checkDRCode(String codes) {
        dbConnector connect = new dbConnector();

        try {
            String query = "SELECT DRNo FROM drgenerator WHERE DRNo = ?";
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
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        customerCode = new javax.swing.JTextField();
        customerError = new javax.swing.JLabel();
        cOK = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        CustomerContactNumber = new javax.swing.JLabel();
        CustomerAddress = new javax.swing.JLabel();
        CustomerName = new javax.swing.JLabel();
        newCust = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        drCode = new javax.swing.JTextField();
        drError = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        add = new javax.swing.JLabel();

        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(50, 150, 122));
        jLabel3.setText("DR GENERATOR");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 10, 530, 40);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 150, 122)));
        jPanel4.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(50, 150, 122));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Customer Profile");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel4);
        jLabel4.setBounds(220, 10, 500, 40);

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(50, 150, 122), 1, true));
        jPanel6.setLayout(null);

        customerCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 150, 122)));
        jPanel6.add(customerCode);
        customerCode.setBounds(10, 30, 140, 22);

        customerError.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        customerError.setForeground(new java.awt.Color(255, 0, 51));
        customerError.setText(" !No customer record");
        jPanel6.add(customerError);
        customerError.setBounds(10, 50, 130, 20);

        cOK.setBackground(new java.awt.Color(255, 255, 255));
        cOK.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cOK.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cOK.setText("OK");
        cOK.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cOK.setOpaque(true);
        cOK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cOKMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cOKMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cOKMouseExited(evt);
            }
        });
        jPanel6.add(cOK);
        cOK.setBounds(160, 30, 30, 21);

        jLabel8.setForeground(new java.awt.Color(50, 150, 122));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Enter Customer ID");
        jPanel6.add(jLabel8);
        jLabel8.setBounds(10, 10, 140, 20);

        jPanel4.add(jPanel6);
        jPanel6.setBounds(10, 10, 200, 80);

        CustomerContactNumber.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        CustomerContactNumber.setForeground(new java.awt.Color(50, 150, 122));
        CustomerContactNumber.setText("Contact Number:");
        CustomerContactNumber.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        CustomerContactNumber.setOpaque(true);
        jPanel4.add(CustomerContactNumber);
        CustomerContactNumber.setBounds(230, 170, 500, 30);

        CustomerAddress.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        CustomerAddress.setForeground(new java.awt.Color(50, 150, 122));
        CustomerAddress.setText("Address:");
        CustomerAddress.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        CustomerAddress.setOpaque(true);
        jPanel4.add(CustomerAddress);
        CustomerAddress.setBounds(230, 130, 500, 30);

        CustomerName.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        CustomerName.setForeground(new java.awt.Color(50, 150, 122));
        CustomerName.setText("Customer Name: ");
        CustomerName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        CustomerName.setOpaque(true);
        jPanel4.add(CustomerName);
        CustomerName.setBounds(230, 90, 500, 30);

        newCust.setForeground(new java.awt.Color(0, 0, 255));
        newCust.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newCust.setText("New Customer?");
        newCust.setOpaque(true);
        newCust.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newCustMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newCustMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newCustMouseExited(evt);
            }
        });
        jPanel4.add(newCust);
        newCust.setBounds(10, 100, 200, 20);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(10, 150, 760, 250);

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
        drError.setText(" !Number already exist");
        jPanel2.add(drError);
        drError.setBounds(20, 50, 130, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(560, 10, 190, 80);

        back.setBackground(new java.awt.Color(255, 255, 255));
        back.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
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
        back.setBounds(330, 480, 100, 30);

        add.setBackground(new java.awt.Color(255, 255, 255));
        add.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        add.setForeground(new java.awt.Color(255, 51, 51));
        add.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add.setText("ADD");
        add.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add.setOpaque(true);
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addMouseExited(evt);
            }
        });
        jPanel1.add(add);
        add.setBounds(330, 440, 100, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cOKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cOKMouseClicked
        // TODO add your handling code here:
        dbConnector dbc = new dbConnector();
        try {
            String code = customerCode.getText();

            if (code.isEmpty()) {
                JOptionPane.showMessageDialog(null, "INPUT CODE FIRST", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                String sql = "SELECT ci.CustomerID, ci.CustomerName, ci.CustomerContactNo, ca.custPurok, ca.custBarangay,"
                + " ca.custMunicipal, ca.custProvince, ca.custCountry"
                + " FROM customerinfo ci "
                + "INNER JOIN customeradd ca ON ci.CustomerAddress = ca.customAddNo WHERE ci.CustomerID = '" + code + "'";
                ResultSet rs = dbc.getData(sql);

                if (rs.next()) {

                    int custCode = rs.getInt("ci.CustomerID");
                    if (code.equals(String.valueOf(custCode))) {
                        String purok = rs.getString("ca.custPurok");
                        String brgy = rs.getString("ca.custBarangay");
                        String municipal = rs.getString("ca.custMunicipal");
                        String province = rs.getString("ca.custProvince");
                        String country = rs.getString("ca.custCountry");

                        CustomerName.setText("Customer Name: " + rs.getString("ci.CustomerName"));
                        CustomerAddress.setText("Address: " + purok + ", " + brgy + ", " + municipal + ", " + province + ", " + country);
                        CustomerContactNumber.setText("Contact Number: " +rs.getString("ci.CustomerContactNo"));
                    }
                } else {
                    // No rows found
                    JOptionPane.showMessageDialog(null, "NO CUSTOMER FOUND", "Error", JOptionPane.ERROR_MESSAGE);
                    CustomerName.setText("Customer Name: ");
                    CustomerAddress.setText("Customer Address: ");
                    CustomerContactNumber.setText("Contact Number: ");
                }
            }
        } catch (SQLException ex) {
            System.out.println("Invalid Connection: " + ex.getMessage());
        }
    }//GEN-LAST:event_cOKMouseClicked

    private void cOKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cOKMouseEntered
        // TODO add your handling code here:
        cOK.setBackground(newColor);
    }//GEN-LAST:event_cOKMouseEntered

    private void cOKMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cOKMouseExited
        // TODO add your handling code here:
        cOK.setBackground(orig);
    }//GEN-LAST:event_cOKMouseExited

    private void newCustMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newCustMouseClicked
        // TODO add your handling code here:
        CustomerInfo cust = new CustomerInfo();
        JDesktopPane desktopPane = (JDesktopPane) getParent();
        desktopPane.add(cust);
        cust.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_newCustMouseClicked

    private void newCustMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newCustMouseEntered
        // TODO add your handling code here:
        newCust.setForeground(orig);
    }//GEN-LAST:event_newCustMouseEntered

    private void newCustMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newCustMouseExited
        // TODO add your handling code here:
        newCust.setForeground(origC);
    }//GEN-LAST:event_newCustMouseExited

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
        // TODO add your handling code here:
        add.setBackground(newColor);
    }//GEN-LAST:event_addMouseEntered

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        // TODO add your handling code here:
        back.setBackground(newColor);
    }//GEN-LAST:event_backMouseEntered

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
        // TODO add your handling code here:
        add.setBackground(orig);
    }//GEN-LAST:event_addMouseExited

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
        // TODO add your handling code here:
        back.setBackground(orig);        
    }//GEN-LAST:event_backMouseExited

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
        DRTransactions drT = new DRTransactions();
        JDesktopPane desktopPane = (JDesktopPane) getParent();
        desktopPane.add(drT);
        drT.setVisible(true);
        setVisible(false);        
    }//GEN-LAST:event_backMouseClicked

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String deliveryDate = currentDate.format(dateFormatter);

    String DrCode = drCode.getText();
    String custCode = customerCode.getText();

    if (DrCode.isEmpty() || custCode.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Fill in the Form First!", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        dbConnector db = new dbConnector();
        String Cashier = LogIn.getCashierID();

        // Check if CashierID is not null
        if (Cashier != null) {
            // Check if the DR number already exists
            if (checkDRCode(DrCode)) {
                JOptionPane.showMessageDialog(null, "DR Number Already Exist", "Error", JOptionPane.ERROR_MESSAGE);
                drCode.setText(""); 
            } else {
                // Attempt to insert the new DR number
                if (db.insertData("INSERT INTO drgenerator (DRNo, CustomerID, CashierID, DeliveryDate, DRStatus) " +
                        "VALUES"
                        + " ('" + DrCode + "',"
                        + " '" + custCode + "',"
                        + " '" + Cashier + "',"
                        + " '" + deliveryDate + "', "
                        + " 'PENDING' ) ")) {
                    JOptionPane.showMessageDialog(null, "Delivery Receipt Saved!");

                    // If successful, proceed with other operations (e.g., opening OrderForm)
                    OrderForm of = new OrderForm();
                    JDesktopPane desktopPane = (JDesktopPane) getParent();
                    desktopPane.add(of);
                    of.setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Connection Error!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Failed to retrieve Cashier ID", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

      

    }//GEN-LAST:event_addMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel CustomerAddress;
    public javax.swing.JLabel CustomerContactNumber;
    public javax.swing.JLabel CustomerName;
    private javax.swing.JLabel add;
    private javax.swing.JLabel back;
    private javax.swing.JLabel cOK;
    public javax.swing.JTextField customerCode;
    private javax.swing.JLabel customerError;
    private javax.swing.JTextField drCode;
    private javax.swing.JLabel drError;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel newCust;
    // End of variables declaration//GEN-END:variables
}
