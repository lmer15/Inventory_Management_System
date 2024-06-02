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
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Elmer Rapon
 */
public class AccountsReceivable extends javax.swing.JInternalFrame {

    /**
     * Creates new form AccountsReceivable
     */
    public AccountsReceivable() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        displayData();
        CountProduct();
    }

        public void displayData(){
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT " +
                    "drgenerator.DRNo AS 'DR', " +
                    "customerinfo.CustomerName AS CUSTOMER, " +
                    "CONCAT(customeradd.CustPurok, ', ', customeradd.CustBarangay, ', ', customeradd.CustMunicipal, ', ', customeradd.CustProvince, ', ',"
                    +"customeradd.CustCountry) ADDRESS, " +
                    "drgenerator.DeliveryDate 'DATE', " +
                    "SUM(orderform.O_TotalAmount) AS 'TOTAL', " +
                    "drgenerator.DRStatus AS 'STATUS', " +
                    "CONCAT(lmer_table.lmer_fname, ' ', lmer_table.lmer_lname) AS 'CASHIER' " +
                    "FROM drgenerator " +
                    "JOIN orderform ON drgenerator.DRNo = orderform.DRNumber " +
                    "JOIN product_information ON orderform.ProductID = product_information.P_Code " +
                    "JOIN lmer_table ON drgenerator.CashierID = lmer_table.lmer_ID " +
                    "JOIN customerinfo ON drgenerator.CustomerID = customerinfo.CustomerID " +
                    "JOIN customeradd ON customerinfo.CustomerAddress = customeradd.customAddNo " +"" 
                    +"GROUP BY drgenerator.DRNo, customerinfo.CustomerName, customeradd.CustPurok,"
                    + " customeradd.CustBarangay, customeradd.CustMunicipal, customeradd.CustProvince,"
                    + " customeradd.CustCountry, drgenerator.DeliveryDate, lmer_table.lmer_fname, lmer_table.lmer_lname");
            
            DRTable.setModel(DbUtils.resultSetToTableModel(rs));
            JTableHeader header = DRTable.getTableHeader();
            header.setBackground(Color.GRAY);
            header.setForeground(Color.BLACK);
            header.setFont(new Font("Microsoft Gothic", Font.BOLD, 10));
            header.setPreferredSize(new Dimension(header.getPreferredSize().width, 30)); // Adjust header height

            // Customize row appearance
            DRTable.setRowHeight(30);
            DRTable.setShowGrid(true);
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    c.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : Color.LIGHT_GRAY); // Alternating row colors
                    return c;
                }
            };
            for (int i = 0; i < DRTable.getColumnCount(); i++) {
                DRTable.getColumnModel().getColumn(i).setCellRenderer(renderer);
            }
            
            
            rs.close();
        }catch(SQLException ex){ 
            System.out.println("Errors: "+ex.getMessage());
      }

    } 
        
    private void CountProduct() {
        try {
            dbConnector db = new dbConnector();
            String sql = "SELECT SUM(O_TotalAmount) AS count FROM orderform WHERE OrderStatus = 'DELIVERED'";
            ResultSet rs = db.getData(sql);

            if (rs.next()) {
                int count = rs.getInt("count");
                num.setText("₱" +Double.toString(count));
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DRTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        num = new javax.swing.JLabel();

        jPanel1.setLayout(null);

        DRTable.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        DRTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        DRTable.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(DRTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 190, 750, 402);

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(50, 150, 122));
        jLabel3.setText("ACCOUNT'S RECEIVABLE");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 10, 750, 40);

        jPanel2.setBackground(new java.awt.Color(50, 150, 122));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("<html>TOTAL ACCOUNT'S RECEIVABLE</html>");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(10, 10, 130, 70);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(120, 0, 10, 90);

        num.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        num.setForeground(new java.awt.Color(255, 0, 0));
        num.setText("jLabel2");
        jPanel2.add(num);
        num.setBounds(130, 30, 160, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 70, 320, 90);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DRTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel num;
    // End of variables declaration//GEN-END:variables
}