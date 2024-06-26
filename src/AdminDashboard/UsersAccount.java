/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminDashboard;

import config.dbConnector;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Elmer Rapon
 */
public class UsersAccount extends javax.swing.JFrame {

    /**
     * Creates new form UsersAccount
     */
    public UsersAccount() {
        initComponents();
        displayData();
    }
    
    Color navcolor = new Color (102,102,102);
    Color headcolor = new Color (102,102,255);
    Color bodycolor =new Color (240,240,240);
    
public void table() {
    // Obtain the JTableHeader object for the Users JTable
    JTableHeader thead = Users.getTableHeader();
    thead.setForeground(Color.BLACK);
    thead.setBackground(new Color(0, 102, 51));
    thead.setFont(new Font("Microsoft YaHei", Font.BOLD, 16));

    //Row height for the table
    int rowHeight = 30; 
    Users.setRowHeight(rowHeight);
    Users.setShowGrid(true);
    Users.setGridColor(Color.WHITE);
}

    
 public void displayData(){
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT lmer_ID as 'ID', lmer_fname as 'First Name',"
                    + " lmer_lname as 'Last Name', lmer_email as 'Email',"
                    + " lmer_uname as 'Username', lmer_acc as 'Position', "
                    + " lmer_stat as 'Account Status' FROM lmer_table");
            Users.setModel(DbUtils.resultSetToTableModel(rs));
            table();
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

        mainpanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        refresh = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nnew = new javax.swing.JLabel();
        update = new javax.swing.JLabel();
        Search = new javax.swing.JLabel();
        delete = new javax.swing.JLabel();
        searchText = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Users = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        mainpanel.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 102, 0));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LIST OF ACCOUNTS");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(50, 10, 200, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-list-25.png"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 20, 30, 20);

        mainpanel.add(jPanel2);
        jPanel2.setBounds(0, 0, 1040, 60);

        refresh.setFont(new java.awt.Font("Microsoft YaHei", 0, 15)); // NOI18N
        refresh.setForeground(new java.awt.Color(0, 102, 51));
        refresh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        refresh.setText("Refresh");
        refresh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                refreshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                refreshMouseExited(evt);
            }
        });
        mainpanel.add(refresh);
        refresh.setBounds(10, 120, 90, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-back-40.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        mainpanel.add(jLabel3);
        jLabel3.setBounds(30, 710, 40, 50);

        nnew.setFont(new java.awt.Font("Microsoft YaHei", 0, 15)); // NOI18N
        nnew.setForeground(new java.awt.Color(0, 102, 51));
        nnew.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nnew.setText("New");
        nnew.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nnew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nnewMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nnewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nnewMouseExited(evt);
            }
        });
        mainpanel.add(nnew);
        nnew.setBounds(10, 80, 90, 30);

        update.setFont(new java.awt.Font("Microsoft YaHei", 0, 15)); // NOI18N
        update.setForeground(new java.awt.Color(0, 102, 51));
        update.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        update.setText("Update");
        update.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateMouseExited(evt);
            }
        });
        mainpanel.add(update);
        update.setBounds(10, 160, 90, 30);

        Search.setFont(new java.awt.Font("Microsoft YaHei", 0, 15)); // NOI18N
        Search.setForeground(new java.awt.Color(0, 102, 51));
        Search.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Search.setText("Search");
        Search.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SearchMouseExited(evt);
            }
        });
        mainpanel.add(Search);
        Search.setBounds(930, 110, 90, 30);

        delete.setFont(new java.awt.Font("Microsoft YaHei", 0, 15)); // NOI18N
        delete.setForeground(new java.awt.Color(0, 102, 51));
        delete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delete.setText("Delete");
        delete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
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
        mainpanel.add(delete);
        delete.setBounds(10, 200, 90, 30);

        searchText.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        searchText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextKeyReleased(evt);
            }
        });
        mainpanel.add(searchText);
        searchText.setBounds(570, 110, 340, 30);

        Users.setBackground(new java.awt.Color(0, 102, 0));
        Users.setFont(new java.awt.Font("Microsoft YaHei", 0, 15)); // NOI18N
        Users.setForeground(new java.awt.Color(255, 255, 255));
        Users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Users.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        Users.setSelectionBackground(new java.awt.Color(110, 170, 120));
        jScrollPane2.setViewportView(Users);

        mainpanel.add(jScrollPane2);
        jScrollPane2.setBounds(120, 150, 900, 590);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        admin ads = new admin();
        ads.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void nnewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nnewMouseClicked
        // TODO add your handling code here:
        newAcc na = new newAcc();
        na.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nnewMouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        // TODO add your handling code here:
        int rowindex = Users.getSelectedRow();
        
        if(rowindex < 0){
            JOptionPane.showMessageDialog(null, "Please select an Account");
        }else{
            TableModel model = Users.getModel();
            updateAcc ua = new updateAcc();
            ua.id.setText(""+model.getValueAt(rowindex, 0));
            ua.finame.setText(""+model.getValueAt(rowindex, 1));
            ua.laname.setText(""+model.getValueAt(rowindex, 2));
            ua.email1.setText(""+model.getValueAt(rowindex, 3));
            ua.username1.setText(""+model.getValueAt(rowindex, 4));
            ua.position1.setSelectedItem(model.getValueAt(rowindex, 5));
            ua.status.setSelectedItem(model.getValueAt(rowindex, 6));
            ua.setVisible(true);
            this.dispose();
        }


    }//GEN-LAST:event_updateMouseClicked

    private void nnewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nnewMouseEntered
        // TODO add your handling code here:
        nnew.setBackground(navcolor);
    }//GEN-LAST:event_nnewMouseEntered

    private void nnewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nnewMouseExited
        // TODO add your handling code here:
        nnew.setBackground(bodycolor);
    }//GEN-LAST:event_nnewMouseExited

    private void refreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseEntered
        // TODO add your handling code here:
        refresh.setBackground(navcolor);
    }//GEN-LAST:event_refreshMouseEntered

    private void refreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseExited
        // TODO add your handling code here:
        refresh.setBackground(bodycolor);
    }//GEN-LAST:event_refreshMouseExited

    private void updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseEntered
        // TODO add your handling code here:
        update.setBackground(navcolor);
    }//GEN-LAST:event_updateMouseEntered

    private void updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseExited
        // TODO add your handling code here:
        update.setBackground(bodycolor);
    }//GEN-LAST:event_updateMouseExited

    private void SearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseEntered
        // TODO add your handling code here:
        Search.setBackground(navcolor);
    }//GEN-LAST:event_SearchMouseEntered

    private void SearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseExited
        // TODO add your handling code here:
        Search.setBackground(bodycolor);
    }//GEN-LAST:event_SearchMouseExited

    private void deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseEntered
        // TODO add your handling code here:
        delete.setBackground(navcolor);
    }//GEN-LAST:event_deleteMouseEntered

    private void deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseExited
        // TODO add your handling code here:
        delete.setBackground(bodycolor);
    }//GEN-LAST:event_deleteMouseExited

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        // TODO add your handling code here:
        displayData();
    }//GEN-LAST:event_refreshMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        // TODO add your handling code here:
        int rowIndex = Users.getSelectedRow();
        if(rowIndex<0){
            JOptionPane.showMessageDialog(null, "Please Select an Account");
        }else{
            TableModel model = Users.getModel();
            Object ide = model.getValueAt(rowIndex, 0);
            Object finame = model.getValueAt(rowIndex, 1);
            Object laname = model.getValueAt(rowIndex, 2);
            
            String id = ide.toString();
            int a = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this account?"+finame+" "+laname);
            if(a == JOptionPane.YES_OPTION){
                dbConnector dbc = new dbConnector();
                int l_id = Integer.parseInt(id);
                dbc.deleteData(l_id, "lmer_table");
                displayData();
            }
        }
    }//GEN-LAST:event_deleteMouseClicked

    private void SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseClicked
        // TODO add your handling code here:
        TableModel search = Users.getModel();
        TableRowSorter<TableModel> srch = new TableRowSorter<>(search);
        Users.setRowSorter(srch);
        srch.setRowFilter(RowFilter.regexFilter("(?i)" +searchText.getText()));
    }//GEN-LAST:event_SearchMouseClicked

    private void searchTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextKeyReleased
        // TODO add your handling code here:
        TableModel search = Users.getModel();
        TableRowSorter<TableModel> srch = new TableRowSorter<>(search);
        Users.setRowSorter(srch);
        srch.setRowFilter(RowFilter.regexFilter("(?i)" +searchText.getText()));
    }//GEN-LAST:event_searchTextKeyReleased

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
            java.util.logging.Logger.getLogger(UsersAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsersAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsersAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsersAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsersAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Search;
    private javax.swing.JTable Users;
    private javax.swing.JLabel delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JLabel nnew;
    private javax.swing.JLabel refresh;
    private javax.swing.JTextField searchText;
    private javax.swing.JLabel update;
    // End of variables declaration//GEN-END:variables
}
