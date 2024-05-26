/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import UserDashboard.user;
import config.dbConnector;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Elmer Rapon
 */
public final class CustomersAccount extends javax.swing.JInternalFrame {

    /**
     * Creates new form CustomersAccount
     */
    public CustomersAccount() {
        initComponents();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
        displayData();
    }
    
        
    Color orig = new Color(255,255,255);
    Color newColor =new Color(204,204,204);

    public void displayData() {
        try {
            dbConnector dbc = new dbConnector();
            try (ResultSet rs = dbc.getData("SELECT " +
                    "customerinfo.CustomerID AS 'CUSTOMER ID', " +
                    "customerinfo.CustomerName AS 'NAME', " +
                    "CONCAT(customeradd.CustPurok, ', ', customeradd.CustBarangay, ', ', customeradd.CustMunicipal, ', ', customeradd.CustProvince, ', ', " +
                    "customeradd.CustCountry) AS 'ADDRESS', " +
                    "customerinfo.CustomerContactNo AS 'CONTACT NUMBER' " +
                    "FROM customerinfo " +
                    "JOIN customeradd ON customerinfo.CustomerAddress = customeradd.customAddNo " +
                    "GROUP BY customerinfo.CustomerID, customerinfo.CustomerName, customeradd.CustPurok, " +
                    "customeradd.CustBarangay, customeradd.CustMunicipal, customeradd.CustProvince, " +
                    "customeradd.CustCountry, customerinfo.CustomerContactNo")) {
                CustomerTable.setModel(DbUtils.resultSetToTableModel(rs));
                JTableHeader header = CustomerTable.getTableHeader();
                header.setBackground(Color.GRAY);
                header.setForeground(Color.BLACK);
                header.setFont(new Font("Microsoft Gothic", Font.BOLD, 10));
                header.setPreferredSize(new Dimension(header.getPreferredSize().width, 30));
                
                // Customize row appearance
                CustomerTable.setRowHeight(30);
                CustomerTable.setShowGrid(true);
                DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
                    @Override
                    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                        c.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE);
                        return c;
                    }
                };
                for (int i = 0; i < CustomerTable.getColumnCount(); i++) {
                    CustomerTable.getColumnModel().getColumn(i).setCellRenderer(renderer);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CustomerTable = new javax.swing.JTable();
        delete = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textSearch3 = new javax.swing.JTextField();
        buttonSearch = new javax.swing.JLabel();

        jPanel1.setLayout(null);

        CustomerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(CustomerTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 130, 740, 402);

        delete.setBackground(new java.awt.Color(255, 255, 255));
        delete.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 0, 0));
        delete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-delete-25.png"))); // NOI18N
        delete.setText("DELETE");
        delete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        delete.setOpaque(true);
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteMouseExited(evt);
            }
        });
        jPanel1.add(delete);
        delete.setBounds(340, 570, 100, 30);

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(50, 150, 122));
        jLabel3.setText("CUSTOMER'S ACCOUNTS");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 10, 750, 40);

        textSearch3.setBackground(new java.awt.Color(240, 240, 240));
        textSearch3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51)));
        textSearch3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textSearch3KeyReleased(evt);
            }
        });
        jPanel1.add(textSearch3);
        textSearch3.setBounds(390, 80, 300, 30);

        buttonSearch.setBackground(new java.awt.Color(255, 255, 255));
        buttonSearch.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        buttonSearch.setForeground(new java.awt.Color(255, 255, 255));
        buttonSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-search-20.png"))); // NOI18N
        buttonSearch.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonSearch.setOpaque(true);
        buttonSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSearchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buttonSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buttonSearchMouseExited(evt);
            }
        });
        jPanel1.add(buttonSearch);
        buttonSearch.setBounds(700, 80, 40, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        // TODO add your handling code here:
    int rowIndex = CustomerTable.getSelectedRow();
    if (rowIndex < 0) {
        JOptionPane.showMessageDialog(null, "Please Select an Account");
    } else {
        TableModel model = CustomerTable.getModel();
        Object ide = model.getValueAt(rowIndex, 0);
        Object name = model.getValueAt(rowIndex, 1);

        String id = ide.toString();
        int a = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this account? " + name);
        if (a == JOptionPane.YES_OPTION) {
            dbConnector dbc = new dbConnector();
            int l_id = Integer.parseInt(id);
            try {
                dbc.getConnection().setAutoCommit(false);

                // Check if the customer is active in the drgenerator table
                String checkDrGeneratorSQL = "SELECT COUNT(*) FROM drgenerator WHERE customerID = ?";
                PreparedStatement psCheck = dbc.getConnection().prepareStatement(checkDrGeneratorSQL);
                psCheck.setInt(1, l_id);
                ResultSet rsCheck = psCheck.executeQuery();
                if (rsCheck.next() && rsCheck.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(null, "THIS CUSTOMER IS ACTIVE!");
                    dbc.getConnection().rollback();
                    return;
                }

                // Delete customer record
                String deleteCustomerSQL = "DELETE FROM customerinfo WHERE CustomerID = ?";
                PreparedStatement psCustomer = dbc.getConnection().prepareStatement(deleteCustomerSQL);
                psCustomer.setInt(1, l_id);
                psCustomer.executeUpdate();

                // Delete address record
                String deleteAddressSQL = "DELETE FROM customeradd WHERE customAddNo = (SELECT CustomerAddress FROM customerinfo WHERE CustomerID = ?)";
                PreparedStatement psAddress = dbc.getConnection().prepareStatement(deleteAddressSQL);
                psAddress.setInt(1, l_id);
                psAddress.executeUpdate();
                dbc.getConnection().commit();
                displayData();
                
            } catch (SQLException ex) {
                try {
                    dbc.getConnection().rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
                ex.printStackTrace();
            } finally {
                try {
                    dbc.getConnection().setAutoCommit(true);
                } catch (SQLException finalEx) {
                    finalEx.printStackTrace();
                }
            }
        }
    }


    }//GEN-LAST:event_deleteMouseClicked

    private void deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseEntered
        // TODO add your handling code here:
        delete.setBackground(newColor);
    }//GEN-LAST:event_deleteMouseEntered

    private void deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseExited
        // TODO add your handling code here:
        delete.setBackground(orig);
    }//GEN-LAST:event_deleteMouseExited

    private void textSearch3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearch3KeyReleased
        // TODO add your handling code here:'
        TableModel search = CustomerTable.getModel();
        TableRowSorter<TableModel> srch = new TableRowSorter<>(search);
        CustomerTable.setRowSorter(srch);
        srch.setRowFilter(RowFilter.regexFilter("(?i)" +textSearch3.getText()));

    }//GEN-LAST:event_textSearch3KeyReleased

    private void buttonSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSearchMouseClicked
        // TODO add your handling code here:
        TableModel search = CustomerTable.getModel();
        TableRowSorter<TableModel> srch = new TableRowSorter<>(search);
        CustomerTable.setRowSorter(srch);
        srch.setRowFilter(RowFilter.regexFilter("(?i)" +textSearch3.getText()));
    }//GEN-LAST:event_buttonSearchMouseClicked

    private void buttonSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSearchMouseEntered
        // TODO add your handling code here:
        buttonSearch.setBackground(newColor);
    }//GEN-LAST:event_buttonSearchMouseEntered

    private void buttonSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSearchMouseExited
        // TODO add your handling code here:
        buttonSearch.setBackground(orig);
    }//GEN-LAST:event_buttonSearchMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CustomerTable;
    private javax.swing.JLabel buttonSearch;
    private javax.swing.JLabel delete;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textSearch3;
    // End of variables declaration//GEN-END:variables
}
