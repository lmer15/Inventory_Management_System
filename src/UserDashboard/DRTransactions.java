/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserDashboard;

import config.dbConnector;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Elmer Rapon
 */
public class DRTransactions extends javax.swing.JInternalFrame {

    /**
     * Creates new form DRTransactions
     */
    public DRTransactions() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        

        newDR.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                drGenerator dr = new drGenerator();
                JDesktopPane desktopPane = (JDesktopPane) getParent();
                desktopPane.add(dr);
                dr.setVisible(true);
                setVisible(false);
            }
        });
        
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    transaction trans = new transaction();
                    JDesktopPane desktopPane = (JDesktopPane) getParent();
                    desktopPane.add(trans);
                    trans.setVisible(true);
                    setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(DRTransactions.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        displayData(); 
    }
    
    Color orig = new Color(255,255,255);
    Color newColor =new Color(204,204,204);
    Color origC = new Color(0,102,51);
    
    
    
    
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
        back = new javax.swing.JLabel();
        newDR = new javax.swing.JLabel();
        updateDR = new javax.swing.JLabel();
        cancelDR = new javax.swing.JLabel();
        viewAR = new javax.swing.JLabel();
        print = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

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
        jScrollPane1.setBounds(10, 150, 750, 402);

        back.setBackground(new java.awt.Color(255, 255, 255));
        back.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
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
        back.setBounds(330, 620, 100, 40);

        newDR.setBackground(new java.awt.Color(0, 102, 51));
        newDR.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        newDR.setForeground(new java.awt.Color(255, 255, 255));
        newDR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newDR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-new-ticket-20.png"))); // NOI18N
        newDR.setText("NEW");
        newDR.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        newDR.setOpaque(true);
        newDR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newDRMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newDRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newDRMouseExited(evt);
            }
        });
        jPanel1.add(newDR);
        newDR.setBounds(20, 80, 110, 40);

        updateDR.setBackground(new java.awt.Color(0, 102, 51));
        updateDR.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        updateDR.setForeground(new java.awt.Color(255, 255, 255));
        updateDR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        updateDR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-update-20.png"))); // NOI18N
        updateDR.setText("ORDER");
        updateDR.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateDR.setOpaque(true);
        updateDR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateDRMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateDRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateDRMouseExited(evt);
            }
        });
        jPanel1.add(updateDR);
        updateDR.setBounds(220, 80, 120, 40);

        cancelDR.setBackground(new java.awt.Color(0, 102, 51));
        cancelDR.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        cancelDR.setForeground(new java.awt.Color(255, 255, 255));
        cancelDR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cancelDR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-cancel-20.png"))); // NOI18N
        cancelDR.setText("CANCEL");
        cancelDR.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cancelDR.setOpaque(true);
        cancelDR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelDRMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelDRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelDRMouseExited(evt);
            }
        });
        jPanel1.add(cancelDR);
        cancelDR.setBounds(440, 80, 110, 40);

        viewAR.setBackground(new java.awt.Color(0, 102, 51));
        viewAR.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        viewAR.setForeground(new java.awt.Color(255, 255, 255));
        viewAR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        viewAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-view-22.png"))); // NOI18N
        viewAR.setText("UPDATE");
        viewAR.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        viewAR.setOpaque(true);
        viewAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewARMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewARMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewARMouseExited(evt);
            }
        });
        jPanel1.add(viewAR);
        viewAR.setBounds(630, 80, 120, 40);

        print.setBackground(new java.awt.Color(255, 255, 255));
        print.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        print.setForeground(new java.awt.Color(255, 0, 0));
        print.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-print-25.png"))); // NOI18N
        print.setText("PRINT");
        print.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        print.setOpaque(true);
        print.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                printMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                printMouseExited(evt);
            }
        });
        jPanel1.add(print);
        print.setBounds(330, 570, 100, 40);

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(50, 150, 122));
        jLabel1.setText("DELIVERY RECEIPT");
        jLabel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 0, 710, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newDRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newDRMouseEntered
        // TODO add your handling code here:
        newDR.setBackground(newColor);
    }//GEN-LAST:event_newDRMouseEntered

    private void newDRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newDRMouseExited
        // TODO add your handling code here:
        newDR.setBackground(origC);
    }//GEN-LAST:event_newDRMouseExited

    private void updateDRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateDRMouseEntered
        // TODO add your handling code here:
        updateDR.setBackground(newColor);
    }//GEN-LAST:event_updateDRMouseEntered

    private void updateDRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateDRMouseExited
        // TODO add your handling code here:
        updateDR.setBackground(origC);
    }//GEN-LAST:event_updateDRMouseExited

    private void cancelDRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelDRMouseEntered
        // TODO add your handling code here:
        cancelDR.setBackground(newColor);
    }//GEN-LAST:event_cancelDRMouseEntered

    private void cancelDRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelDRMouseExited
        // TODO add your handling code here:
        cancelDR.setBackground(origC);
    }//GEN-LAST:event_cancelDRMouseExited

    private void viewARMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewARMouseEntered
        // TODO add your handling code here:
        viewAR.setBackground(newColor);
    }//GEN-LAST:event_viewARMouseEntered

    private void viewARMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewARMouseExited
        // TODO add your handling code here:
        viewAR.setBackground(origC);
    }//GEN-LAST:event_viewARMouseExited

    private void printMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseEntered
        // TODO add your handling code here:
        print.setBackground(newColor);
    }//GEN-LAST:event_printMouseEntered

    private void printMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseExited
        // TODO add your handling code here:
        print.setBackground(orig);
    }//GEN-LAST:event_printMouseExited

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        // TODO add your handling code here:
        back.setBackground(newColor);
    }//GEN-LAST:event_backMouseEntered

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
        // TODO add your handling code here:
        back.setBackground(orig);
    }//GEN-LAST:event_backMouseExited

    private void newDRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newDRMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_newDRMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_backMouseClicked

    private void updateDRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateDRMouseClicked
        // TODO add your handling code here:
        OrderTransactions ot = new OrderTransactions();
        JDesktopPane desktopPane = (JDesktopPane) getParent();
        desktopPane.add(ot);
        ot.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_updateDRMouseClicked

    private void cancelDRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelDRMouseClicked
        // TODO add your handling code here:
        DRCancellation co = new DRCancellation();
        JDesktopPane desktopPane = (JDesktopPane) getParent();
        desktopPane.add(co);
        co.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_cancelDRMouseClicked

    private void viewARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewARMouseClicked
        // TODO add your handling code here:
        UpdateDR uDR = new UpdateDR();
        JDesktopPane desktopPane = (JDesktopPane) getParent();
        desktopPane.add(uDR);
        uDR.setVisible(true);
        setVisible(false);
        
    }//GEN-LAST:event_viewARMouseClicked

    private void printMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printMouseClicked
        // TODO add your handling code here:
        PrintingDR dr = new PrintingDR();
        dr.setVisible(true);
        user us = new user();
        us.dispose();
        this.dispose();
        
    }//GEN-LAST:event_printMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DRTable;
    private javax.swing.JLabel back;
    private javax.swing.JLabel cancelDR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel newDR;
    private javax.swing.JLabel print;
    private javax.swing.JLabel updateDR;
    private javax.swing.JLabel viewAR;
    // End of variables declaration//GEN-END:variables
}
