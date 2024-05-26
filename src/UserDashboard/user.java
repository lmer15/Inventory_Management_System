/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserDashboard;

import Config.session;
import Reports.AccountsReceivable;
import SignUp_LogIn.LogIn;
import Reports.CustomersAccount;
import Reports.ExpiredProducts;
import Reports.ReportDamage;
import Reports.ViewProducts;
import config.dbConnector;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Elmer Rapon
 */
public final class user extends javax.swing.JFrame {

    /**
     * Creates new form user
     */
    public user() {
        initComponents();
        displayProduct();
        date();
        time();
    }
    
    private void date(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        String dt = sdf.format(d);
        date.setText(dt);
        
    }
    Timer t;
    SimpleDateFormat st;
    
    private void time(){
        t = new Timer(0, (ActionEvent ae) ->{
            Date dt = new Date();
            st = new SimpleDateFormat("hh:mm:ss a");
            String tm = st.format(dt);
            time.setText(tm);
        });
        t.start();
    }
    
    Color navcolor = new Color (153,153,153);
    Color headcolor = new Color (153,153,153);
    Color bodycolor =new Color (102,102,102);;
    Color transColor = new Color (240,240,240);
    Color newTrans =new Color(255,255,255);
    
    
public void displayProduct() {
    try {
        dbConnector dbc = new dbConnector();
        try (ResultSet rs = dbc.getData("SELECT product_information.P_Code AS 'CODE', "
                + "product_information.P_Name AS 'NAME', "
                + "product_information.P_Flavor AS 'FLAVOR', "
                + "product_information.P_Price AS 'PRICE', "
                + "product_information.P_Net AS 'NET WEIGHT', "
                + "product_information.P_Unit AS 'UNIT', "
                + "COALESCE(SUM(output.O_Quantity), 0) AS 'QUANTITY' "
                + "FROM product_information "
                + "LEFT JOIN output ON product_information.P_Code = output.product_ID "
                + "GROUP BY product_information.P_Code, "
                + "product_information.P_Name, "
                + "product_information.P_Flavor, "
                + "product_information.P_Price, "
                + "product_information.P_Net, "
                + "product_information.P_Unit;")) {
           
            DefaultTableModel tableModel = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
            String[] columnNames = {"CODE", "NAME", "FLAVOR", "PRICE", "NET WEIGHT", "UNIT", "QUANTITY"};
            tableModel.setColumnIdentifiers(columnNames);
            TableStocks.setModel(tableModel);
            
            JTableHeader header = TableStocks.getTableHeader();
            header.setBackground(Color.GRAY);
            header.setForeground(Color.BLACK);
            header.setFont(new Font("Microsoft Gothic", Font.BOLD, 10));
            header.setPreferredSize(new Dimension(header.getPreferredSize().width, 30)); // Adjust header height

            // Customize row appearance
            TableStocks.setRowHeight(30);
            TableStocks.setShowGrid(true);// Adjust row height
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    c.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : Color.LIGHT_GRAY); // Alternating row colors
                    return c;
                }
            };
            for (int i = 0; i < TableStocks.getColumnCount(); i++) {
                TableStocks.getColumnModel().getColumn(i).setCellRenderer(renderer);
            }
        }
    } catch (SQLException ex) {
        System.out.println("Errors: " + ex.getMessage());
    }
}



    
    static String user;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        userName = new javax.swing.JLabel();
        userPosition = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        logOut = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        pi = new javax.swing.JLabel();
        da = new javax.swing.JLabel();
        drp = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        HOME = new javax.swing.JLabel();
        tl = new javax.swing.JLabel();
        to = new javax.swing.JLabel();
        vers = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        list1 = new javax.swing.JLabel();
        to1 = new javax.swing.JLabel();
        userDesktop = new javax.swing.JDesktopPane();
        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableStocks = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        trans = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 102, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userName.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        userName.setForeground(new java.awt.Color(255, 255, 255));
        userName.setText("User Name");
        jPanel2.add(userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 340, 30));

        userPosition.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 17)); // NOI18N
        userPosition.setForeground(new java.awt.Color(255, 255, 255));
        userPosition.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        userPosition.setText("Position");
        jPanel2.add(userPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 290, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-user-70.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 80));

        time.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 50, 120, 20));

        date.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 120, 20));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, -3, 1040, 90);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setForeground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("About Us");
        jLabel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel9);
        jLabel9.setBounds(30, 600, 220, 30);

        logOut.setBackground(new java.awt.Color(102, 102, 102));
        logOut.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        logOut.setForeground(new java.awt.Color(255, 0, 0));
        logOut.setText("          Log Out");
        logOut.setOpaque(true);
        logOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logOutMouseExited(evt);
            }
        });
        jPanel3.add(logOut);
        logOut.setBounds(0, 130, 280, 30);

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Profile");
        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel10);
        jLabel10.setBounds(30, 30, 220, 30);

        pi.setBackground(new java.awt.Color(102, 102, 102));
        pi.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        pi.setForeground(new java.awt.Color(255, 255, 255));
        pi.setText("          Profile Info");
        pi.setOpaque(true);
        pi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                piMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                piMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                piMouseExited(evt);
            }
        });
        jPanel3.add(pi);
        pi.setBounds(0, 100, 280, 30);

        da.setBackground(new java.awt.Color(102, 102, 102));
        da.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        da.setForeground(new java.awt.Color(255, 255, 255));
        da.setText("          Customer's Accounts");
        da.setOpaque(true);
        da.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                daMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                daMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                daMouseExited(evt);
            }
        });
        jPanel3.add(da);
        da.setBounds(0, 260, 280, 30);

        drp.setBackground(new java.awt.Color(102, 102, 102));
        drp.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        drp.setForeground(new java.awt.Color(255, 255, 255));
        drp.setText("          Damage/Reject Products");
        drp.setOpaque(true);
        drp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                drpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                drpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                drpMouseExited(evt);
            }
        });
        jPanel3.add(drp);
        drp.setBounds(0, 290, 280, 30);

        jLabel15.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Dashboard");
        jLabel15.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel15);
        jLabel15.setBounds(30, 190, 220, 30);

        HOME.setBackground(new java.awt.Color(102, 102, 102));
        HOME.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        HOME.setForeground(new java.awt.Color(255, 255, 255));
        HOME.setText("          HOME");
        HOME.setOpaque(true);
        HOME.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HOMEMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HOMEMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HOMEMouseExited(evt);
            }
        });
        jPanel3.add(HOME);
        HOME.setBounds(0, 70, 280, 30);

        tl.setBackground(new java.awt.Color(102, 102, 102));
        tl.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        tl.setForeground(new java.awt.Color(255, 255, 255));
        tl.setText("          Damage Products");
        tl.setOpaque(true);
        tl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tlMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tlMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tlMouseExited(evt);
            }
        });
        jPanel3.add(tl);
        tl.setBounds(0, 410, 280, 30);

        to.setBackground(new java.awt.Color(102, 102, 102));
        to.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        to.setForeground(new java.awt.Color(255, 255, 255));
        to.setText("          Account's Receivable");
        to.setOpaque(true);
        to.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                toMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                toMouseExited(evt);
            }
        });
        jPanel3.add(to);
        to.setBounds(0, 470, 280, 30);

        vers.setBackground(new java.awt.Color(102, 102, 102));
        vers.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        vers.setForeground(new java.awt.Color(255, 255, 255));
        vers.setText("         version 1.0.00.0");
        vers.setOpaque(true);
        vers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                versMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                versMouseExited(evt);
            }
        });
        jPanel3.add(vers);
        vers.setBounds(0, 640, 280, 30);

        jLabel23.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Reports");
        jLabel23.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel23);
        jLabel23.setBounds(30, 370, 220, 30);

        list1.setBackground(new java.awt.Color(102, 102, 102));
        list1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        list1.setForeground(new java.awt.Color(255, 255, 255));
        list1.setText("          View Products");
        list1.setOpaque(true);
        list1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                list1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                list1MouseExited(evt);
            }
        });
        jPanel3.add(list1);
        list1.setBounds(0, 230, 280, 30);

        to1.setBackground(new java.awt.Color(102, 102, 102));
        to1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        to1.setForeground(new java.awt.Color(255, 255, 255));
        to1.setText("          Expired Products");
        to1.setOpaque(true);
        to1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                to1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                to1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                to1MouseExited(evt);
            }
        });
        jPanel3.add(to1);
        to1.setBounds(0, 440, 280, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 80, 280, 690);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 51));
        jLabel1.setText("<html>TrackIn is your go-to inventory management system, offering real-time tracking and automated reordering to streamline your operations and boost efficiency. Experience seamless multi-location management and customizable reporting with TrackIn, elevating your business and simplifying your inventory control.</html>");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        mainPanel.add(jLabel1);
        jLabel1.setBounds(20, 70, 730, 60);

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 51));
        jLabel3.setText("Welcome to TrackIn!");
        mainPanel.add(jLabel3);
        jLabel3.setBounds(20, 20, 270, 40);

        jPanel5.setBackground(new java.awt.Color(98, 180, 98));
        jPanel5.setLayout(null);

        TableStocks.setBackground(new java.awt.Color(98, 180, 98));
        TableStocks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TableStocks.setEnabled(false);
        jScrollPane1.setViewportView(TableStocks);

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(10, 40, 690, 410);

        jLabel24.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("AVAILABLE STOCKS");
        jLabel24.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel5.add(jLabel24);
        jLabel24.setBounds(0, 5, 710, 30);

        mainPanel.add(jPanel5);
        jPanel5.setBounds(20, 150, 710, 460);

        trans.setBackground(new java.awt.Color(255, 255, 255));
        trans.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        trans.setForeground(new java.awt.Color(0, 153, 51));
        trans.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trans.setText("CLICK FOR TRANSACTION!");
        trans.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 153, 51)));
        trans.setOpaque(true);
        trans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                transMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                transMouseExited(evt);
            }
        });
        mainPanel.add(trans);
        trans.setBounds(10, 620, 740, 30);

        userDesktop.add(mainPanel);
        mainPanel.setBounds(0, 0, 760, 670);

        jPanel1.add(userDesktop);
        userDesktop.setBounds(280, 90, 760, 670);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutMouseClicked
        // TODO add your handling code here:
        LogIn li = new LogIn();
        li.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_logOutMouseClicked

    private void piMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piMouseClicked
         
        userProfileInfo usi = new userProfileInfo();
        session ss = session.getInstance();
        String firstname = ss.getFname();
        String lastname = ss.getLname();
        String fullname = firstname + " " +lastname;
        usi.u_username.setText("@" + ss.getUsername());
        usi.u_position.setText(ss.getPosition());
        usi.u_fullname.setText(fullname);
        usi.u_email.setText(ss.getEmail());
        usi.u_accountstat.setText(ss.getStatus());
        usi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_piMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        session ss = session.getInstance();
        String firstname = ss.getFname();
        String lastname = ss.getLname();
        String fullname = firstname + " " +lastname;
        if(ss.getId() == 0){
            JOptionPane.showMessageDialog(null, "No account, Log In First");
            LogIn li = new LogIn();
            li.setVisible(true);
            this.dispose();    
        }else{
            userName.setText(""+fullname);
            userPosition.setText(""+ss.getPosition());  
        }       
    }//GEN-LAST:event_formWindowActivated

    private void piMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piMouseEntered
        // TODO add your handling code here:
        pi.setBackground(navcolor);
    }//GEN-LAST:event_piMouseEntered

    private void piMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piMouseExited
        // TODO add your handling code here:
        pi.setBackground(bodycolor);
    }//GEN-LAST:event_piMouseExited

    private void logOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutMouseEntered
        // TODO add your handling code here:
        logOut.setBackground(navcolor);
    }//GEN-LAST:event_logOutMouseEntered

    private void logOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutMouseExited
        // TODO add your handling code here:
        logOut.setBackground(bodycolor);
    }//GEN-LAST:event_logOutMouseExited

    private void HOMEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HOMEMouseEntered
        // TODO add your handling code here:
        HOME.setBackground(navcolor);
    }//GEN-LAST:event_HOMEMouseEntered

    private void HOMEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HOMEMouseExited
        // TODO add your handling code here:
        HOME.setBackground(bodycolor);
    }//GEN-LAST:event_HOMEMouseExited

    private void daMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daMouseEntered
        // TODO add your handling code here:
        da.setBackground(navcolor);
    }//GEN-LAST:event_daMouseEntered

    private void daMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daMouseExited
        // TODO add your handling code here:
        da.setBackground(bodycolor);
    }//GEN-LAST:event_daMouseExited

    private void drpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drpMouseEntered
        // TODO add your handling code here:
        drp.setBackground(navcolor);
    }//GEN-LAST:event_drpMouseEntered

    private void drpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drpMouseExited
        // TODO add your handling code here:
        drp.setBackground(bodycolor);
    }//GEN-LAST:event_drpMouseExited

    private void tlMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tlMouseEntered
        // TODO add your handling code here:
        tl.setBackground(navcolor);
    }//GEN-LAST:event_tlMouseEntered

    private void tlMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tlMouseExited
        // TODO add your handling code here:
        tl.setBackground(bodycolor); 
    }//GEN-LAST:event_tlMouseExited

    private void versMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_versMouseEntered
        // TODO add your handling code here:
        vers.setBackground(navcolor); 
    }//GEN-LAST:event_versMouseEntered

    private void versMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_versMouseExited
        // TODO add your handling code here:
        vers.setBackground(bodycolor);
    }//GEN-LAST:event_versMouseExited

    private void transMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transMouseClicked
        try {
            // TODO add your handling code here:
            transaction tran = new transaction();
            OrderForm dr = new OrderForm();
            userDesktop.add(tran).setVisible(true);    
            userDesktop.add(dr);
        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_transMouseClicked

    private void transMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transMouseEntered
        // TODO add your handling code here:
        trans.setBackground(transColor);
    }//GEN-LAST:event_transMouseEntered

    private void transMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transMouseExited
        // TODO add your handling code here:
        trans.setBackground(newTrans);
    }//GEN-LAST:event_transMouseExited

    private void list1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list1MouseEntered
        // TODO add your handling code here:
        list1.setBackground(navcolor); 
    }//GEN-LAST:event_list1MouseEntered

    private void list1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list1MouseExited
        // TODO add your handling code here:
        list1.setBackground(bodycolor);
    }//GEN-LAST:event_list1MouseExited

    private void HOMEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HOMEMouseClicked
        user us = new user();
        us.setVisible(true);
        dispose(); 
    }//GEN-LAST:event_HOMEMouseClicked

    private void list1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list1MouseClicked
        // TODO add your handling code here:
        ViewProducts view = new ViewProducts();
        userDesktop.add(view).setVisible(true);
    }//GEN-LAST:event_list1MouseClicked

    private void toMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toMouseExited
        // TODO add your handling code here:
        to.setBackground(bodycolor);
    }//GEN-LAST:event_toMouseExited

    private void toMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toMouseEntered
        // TODO add your handling code here:
        to.setBackground(navcolor);
    }//GEN-LAST:event_toMouseEntered

    private void daMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daMouseClicked
        // TODO add your handling code here:
        CustomersAccount view = new CustomersAccount();
        userDesktop.add(view).setVisible(true);
    }//GEN-LAST:event_daMouseClicked

    private void drpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drpMouseClicked
        // TODO add your handling code here:
        DamageProducts damage = new DamageProducts();
        userDesktop.add(damage).setVisible(true);    
    }//GEN-LAST:event_drpMouseClicked

    private void to1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_to1MouseEntered
        // TODO add your handling code here:
        to1.setBackground(navcolor);
    }//GEN-LAST:event_to1MouseEntered

    private void to1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_to1MouseExited
        // TODO add your handling code here:
        to1.setBackground(bodycolor);
    }//GEN-LAST:event_to1MouseExited

    private void tlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tlMouseClicked
        // TODO add your handling code here:
        ReportDamage damage = new ReportDamage();
        userDesktop.add(damage).setVisible(true);    
        
    }//GEN-LAST:event_tlMouseClicked

    private void to1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_to1MouseClicked
        // TODO add your handling code here:
        ExpiredProducts damage = new ExpiredProducts();
        userDesktop.add(damage).setVisible(true); 
    }//GEN-LAST:event_to1MouseClicked

    private void toMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toMouseClicked
        // TODO add your handling code here:
        AccountsReceivable acc = new AccountsReceivable();
        userDesktop.add(acc).setVisible(true);  
    }//GEN-LAST:event_toMouseClicked

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
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user().setVisible(true);
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HOME;
    private javax.swing.JTable TableStocks;
    private javax.swing.JLabel da;
    private javax.swing.JLabel date;
    private javax.swing.JLabel drp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel list1;
    private javax.swing.JLabel logOut;
    public javax.swing.JPanel mainPanel;
    private javax.swing.JLabel pi;
    private javax.swing.JLabel time;
    private javax.swing.JLabel tl;
    private javax.swing.JLabel to;
    private javax.swing.JLabel to1;
    private javax.swing.JLabel trans;
    public javax.swing.JDesktopPane userDesktop;
    public javax.swing.JLabel userName;
    public javax.swing.JLabel userPosition;
    private javax.swing.JLabel vers;
    // End of variables declaration//GEN-END:variables
}
