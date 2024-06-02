/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reports;

import config.dbConnector;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ReportDamage extends javax.swing.JInternalFrame {

    /**
     * Creates new form DamageProducts
     */
    public ReportDamage() {
        initComponents();
                
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
        displayData();
        CountProduct();
    }
    
    public void displayData() {
        try {
            dbConnector dbc = new dbConnector();
            String sql = "SELECT dp.product_ID AS 'PRODUCT ID', " +
                         "CONCAT(pi.P_Name, ', ', pi.P_Flavor, ', ', pi.P_Price, ', ', pi.P_Net, ', ', pi.P_Unit) AS 'PRODUCT NAME', " +
                         "SUM(dp.DamageQuantity) AS 'QUANTITY', " +
                         "dp.ManufacturingDate AS 'MANUFACTURING DATE', " +
                         "dp.ExpiryDate AS 'EXPIRY DATE' " +
                         "FROM damageproduct dp " +
                         "JOIN product_information pi ON dp.product_ID = pi.P_Code " +
                         "WHERE dp.Status = 'DAMAGED' " +
                         "GROUP BY dp.product_ID, pi.P_Name, pi.P_Flavor, pi.P_Price, pi.P_Net, "
                         + "pi.P_Unit, dp.ManufacturingDate, dp.ExpiryDate";

            ResultSet rs = dbc.getData(sql);
            DamageTable.setModel(DbUtils.resultSetToTableModel(rs));

            // Customize the table header
            JTableHeader header = DamageTable.getTableHeader();
            header.setBackground(Color.GRAY);
            header.setForeground(Color.BLACK);
            header.setFont(new Font("Microsoft Gothic", Font.BOLD, 10));
            header.setPreferredSize(new Dimension(header.getPreferredSize().width, 30));

            // Customize row appearance
            DamageTable.setRowHeight(30);
            DamageTable.setShowGrid(true);
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    c.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE);
                    return c;
                }
            };
            for (int i = 0; i < DamageTable.getColumnCount(); i++) {
                DamageTable.getColumnModel().getColumn(i).setCellRenderer(renderer);
            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());
        }
}

    
    private void CountProduct() {
        try {
            dbConnector db = new dbConnector();
            String sql = "SELECT SUM(DamageQuantity) AS count FROM damageproduct WHERE Status = 'DAMAGED'";
            ResultSet rs = db.getData(sql);

            if (rs.next()) {
                int count = rs.getInt("count");
                num.setText(Integer.toString(count));
            } else {
                num.setText("0");
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(ViewProducts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
            
    Color orig = new Color(255,255,255);
    Color newColor =new Color(204,204,204);
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DamageTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        textSearch3 = new javax.swing.JTextField();
        buttonSearch = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        num = new javax.swing.JLabel();

        jPanel1.setLayout(null);

        DamageTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(DamageTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 190, 740, 402);

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("DAMAGE PRODUCTS");
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
        textSearch3.setBounds(390, 140, 300, 30);

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
        buttonSearch.setBounds(700, 140, 40, 30);

        jPanel2.setBackground(new java.awt.Color(50, 150, 122));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("<html>TOTAL NUMBER OF DAMAGE PRODUCTS</html>");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 0, 130, 90);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(120, 0, 10, 90);

        num.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        num.setForeground(new java.awt.Color(255, 0, 0));
        num.setText("jLabel2");
        jPanel2.add(num);
        num.setBounds(130, 20, 170, 50);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 70, 320, 90);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textSearch3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearch3KeyReleased
        // TODO add your handling code here:'
        TableModel search = DamageTable.getModel();
        TableRowSorter<TableModel> srch = new TableRowSorter<>(search);
        DamageTable.setRowSorter(srch);
        srch.setRowFilter(RowFilter.regexFilter("(?i)" +textSearch3.getText()));
    }//GEN-LAST:event_textSearch3KeyReleased

    private void buttonSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSearchMouseClicked
        // TODO add your handling code here:
        TableModel search = DamageTable.getModel();
        TableRowSorter<TableModel> srch = new TableRowSorter<>(search);
        DamageTable.setRowSorter(srch);
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
    private javax.swing.JTable DamageTable;
    private javax.swing.JLabel buttonSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel num;
    private javax.swing.JTextField textSearch3;
    // End of variables declaration//GEN-END:variables
}