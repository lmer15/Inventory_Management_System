/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminDashboard;

import Config.session;
import SignUp_LogIn.LogIn;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Elmer Rapon
 */
public class admin extends javax.swing.JFrame {

    /**
     * Creates new form admin
     */
    public admin() {
        initComponents();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        adminPosition = new javax.swing.JLabel();
        adminName = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        pi = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        manageAcc = new javax.swing.JLabel();
        si = new javax.swing.JLabel();
        oi = new javax.swing.JLabel();
        dr = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        da = new javax.swing.JLabel();
        ts = new javax.swing.JLabel();
        vers = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        rbs = new javax.swing.JLabel();
        cd = new javax.swing.JLabel();
        dr1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 102, 0));
        jPanel2.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-admin-70.png"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 10, 80, 70);

        adminPosition.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 17)); // NOI18N
        adminPosition.setForeground(new java.awt.Color(255, 255, 255));
        adminPosition.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        adminPosition.setText("Position");
        jPanel2.add(adminPosition);
        adminPosition.setBounds(110, 50, 380, 30);

        adminName.setBackground(new java.awt.Color(51, 255, 255));
        adminName.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        adminName.setForeground(new java.awt.Color(255, 255, 255));
        adminName.setText("Admin Name");
        jPanel2.add(adminName);
        adminName.setBounds(110, 20, 410, 30);

        time.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        time.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(time);
        time.setBounds(900, 50, 130, 20);

        date.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(date);
        date.setBounds(900, 20, 130, 20);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pi.setBackground(new java.awt.Color(102, 102, 102));
        pi.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        pi.setForeground(new java.awt.Color(255, 255, 255));
        pi.setText("          Profile Info");
        pi.setOpaque(true);
        pi.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                piMouseMoved(evt);
            }
        });
        pi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                piMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                piMouseExited(evt);
            }
        });
        jPanel3.add(pi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 280, 30));

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("About Us");
        jLabel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, 220, 30));

        lo.setBackground(new java.awt.Color(102, 102, 102));
        lo.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        lo.setForeground(new java.awt.Color(255, 51, 51));
        lo.setText("          Log Out");
        lo.setOpaque(true);
        lo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loMouseExited(evt);
            }
        });
        jPanel3.add(lo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 280, 30));

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Profile");
        jLabel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 220, 30));

        manageAcc.setBackground(new java.awt.Color(102, 102, 102));
        manageAcc.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        manageAcc.setForeground(new java.awt.Color(255, 255, 255));
        manageAcc.setText("          Manage Account");
        manageAcc.setOpaque(true);
        manageAcc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageAccMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                manageAccMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                manageAccMouseExited(evt);
            }
        });
        jPanel3.add(manageAcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 280, 30));

        si.setBackground(new java.awt.Color(102, 102, 102));
        si.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        si.setForeground(new java.awt.Color(255, 255, 255));
        si.setText("          Sales Inventory");
        si.setOpaque(true);
        si.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                siMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                siMouseExited(evt);
            }
        });
        jPanel3.add(si, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 280, 30));

        oi.setBackground(new java.awt.Color(102, 102, 102));
        oi.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        oi.setForeground(new java.awt.Color(255, 255, 255));
        oi.setText("          Output Inventory");
        oi.setOpaque(true);
        oi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                oiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                oiMouseExited(evt);
            }
        });
        jPanel3.add(oi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 280, 30));

        dr.setBackground(new java.awt.Color(102, 102, 102));
        dr.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        dr.setForeground(new java.awt.Color(255, 255, 255));
        dr.setText("          Expired Items");
        dr.setOpaque(true);
        dr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                drMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                drMouseExited(evt);
            }
        });
        jPanel3.add(dr, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 280, 30));

        jLabel16.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Dashboard");
        jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 220, 30));

        da.setBackground(new java.awt.Color(102, 102, 102));
        da.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        da.setForeground(new java.awt.Color(255, 255, 255));
        da.setText("          Distributor Accounts");
        da.setOpaque(true);
        da.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                daMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                daMouseExited(evt);
            }
        });
        jPanel3.add(da, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 280, 30));

        ts.setBackground(new java.awt.Color(102, 102, 102));
        ts.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        ts.setForeground(new java.awt.Color(255, 255, 255));
        ts.setText("          Total Sales");
        ts.setOpaque(true);
        ts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tsMouseExited(evt);
            }
        });
        jPanel3.add(ts, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 280, 30));

        vers.setBackground(new java.awt.Color(102, 102, 102));
        vers.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        vers.setForeground(new java.awt.Color(255, 255, 255));
        vers.setText("         Version 1.0.00.0");
        vers.setOpaque(true);
        vers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                versMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                versMouseExited(evt);
            }
        });
        jPanel3.add(vers, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 280, 30));

        jLabel21.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Reports");
        jLabel21.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 220, 30));

        rbs.setBackground(new java.awt.Color(102, 102, 102));
        rbs.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        rbs.setForeground(new java.awt.Color(255, 255, 255));
        rbs.setText("          Returned/BO Stocks");
        rbs.setOpaque(true);
        rbs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rbsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rbsMouseExited(evt);
            }
        });
        jPanel3.add(rbs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 280, 30));

        cd.setBackground(new java.awt.Color(102, 102, 102));
        cd.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        cd.setForeground(new java.awt.Color(255, 255, 255));
        cd.setText("          Company's Details");
        cd.setOpaque(true);
        cd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cdMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cdMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cdMouseExited(evt);
            }
        });
        jPanel3.add(cd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 280, 30));

        dr1.setBackground(new java.awt.Color(102, 102, 102));
        dr1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        dr1.setForeground(new java.awt.Color(255, 255, 255));
        dr1.setText("          Damage/Reject");
        dr1.setOpaque(true);
        dr1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dr1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dr1MouseExited(evt);
            }
        });
        jPanel3.add(dr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 280, 30));

        jPanel4.setBackground(new java.awt.Color(98, 180, 98));
        jPanel4.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total Sold");
        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel10);
        jLabel10.setBounds(20, 30, 280, 25);

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei", 1, 50)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 51, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("-234,567");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(10, 70, 320, 120);

        jLabel23.setText("As of December 16, 2024");
        jPanel4.add(jLabel23);
        jLabel23.setBounds(30, 200, 210, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-time-25.png"))); // NOI18N
        jPanel4.add(jLabel3);
        jLabel3.setBounds(0, 200, 25, 30);

        jPanel6.setBackground(new java.awt.Color(98, 180, 98));
        jPanel6.setLayout(null);

        jLabel24.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("AVAILABLE STOCKS");
        jLabel24.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel6.add(jLabel24);
        jLabel24.setBounds(20, 20, 690, 25);

        jTable1.setBackground(new java.awt.Color(98, 180, 98));
        jTable1.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel6.add(jScrollPane1);
        jScrollPane1.setBounds(20, 50, 690, 310);

        jPanel7.setBackground(new java.awt.Color(98, 180, 98));
        jPanel7.setLayout(null);

        jLabel25.setFont(new java.awt.Font("Microsoft YaHei", 1, 50)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("+100,000");
        jPanel7.add(jLabel25);
        jLabel25.setBounds(10, 70, 330, 130);

        jLabel27.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Total Outputs");
        jLabel27.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel7.add(jLabel27);
        jLabel27.setBounds(20, 30, 280, 25);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-time-25.png"))); // NOI18N
        jPanel7.add(jLabel5);
        jLabel5.setBounds(10, 200, 25, 30);

        jLabel28.setText("As of December 16, 2024");
        jPanel7.add(jLabel28);
        jLabel28.setBounds(40, 200, 210, 30);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1042, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void manageAccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageAccMouseClicked
        // TODO add your handling code here:
        UsersAccount ua = new UsersAccount();
        ua.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_manageAccMouseClicked

    private void loMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loMouseClicked
        // TODO add your handling code here:
        LogIn li = new LogIn();
        li.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_loMouseClicked

    private void piMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piMouseEntered
        // TODO add your handling code here:
        pi.setOpaque(true);
        pi.setBackground(navcolor);       
    }//GEN-LAST:event_piMouseEntered

    private void piMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piMouseExited
        // TODO add your handling code here:
        pi.setOpaque(true);
        pi.setBackground(bodycolor);       
    
    }//GEN-LAST:event_piMouseExited

    private void manageAccMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageAccMouseEntered
        // TODO add your handling code here:
        manageAcc.setBackground(navcolor);       
    }//GEN-LAST:event_manageAccMouseEntered

    private void manageAccMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageAccMouseExited
        // TODO add your handling code here:
        manageAcc.setBackground(bodycolor);       

    }//GEN-LAST:event_manageAccMouseExited

    private void loMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loMouseEntered
        // TODO add your handling code here:
        lo.setBackground(navcolor);
    }//GEN-LAST:event_loMouseEntered

    private void loMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loMouseExited
        // TODO add your handling code here:
        lo.setBackground(bodycolor);

    }//GEN-LAST:event_loMouseExited

    private void siMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siMouseEntered
        // TODO add your handling code here:\
        si.setBackground(navcolor);

    }//GEN-LAST:event_siMouseEntered

    private void siMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siMouseExited
        // TODO add your handling code here:
        si.setBackground(bodycolor);

    }//GEN-LAST:event_siMouseExited

    private void piMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piMouseMoved

    }//GEN-LAST:event_piMouseMoved

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
            adminName.setText(""+fullname);
            adminPosition.setText(""+ss.getPosition());  
        }     
    }//GEN-LAST:event_formWindowActivated

    private void oiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oiMouseEntered
        // TODO add your handling code here:
        oi.setBackground(navcolor);
    }//GEN-LAST:event_oiMouseEntered

    private void oiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oiMouseExited
        // TODO add your handling code here:
        oi.setBackground(bodycolor);
    }//GEN-LAST:event_oiMouseExited

    private void daMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daMouseEntered
        // TODO add your handling code here:
        da.setBackground(navcolor);      
    }//GEN-LAST:event_daMouseEntered

    private void daMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daMouseExited
        // TODO add your handling code here:
        da.setBackground(bodycolor);      
    }//GEN-LAST:event_daMouseExited

    private void tsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tsMouseEntered
        // TODO add your handling code here:
        ts.setBackground(navcolor);
    }//GEN-LAST:event_tsMouseEntered

    private void tsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tsMouseExited
        // TODO add your handling code here:
        ts.setBackground(bodycolor);
    }//GEN-LAST:event_tsMouseExited

    private void rbsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbsMouseEntered
        // TODO add your handling code here:
       rbs.setBackground(navcolor);
    }//GEN-LAST:event_rbsMouseEntered

    private void rbsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbsMouseExited
        // TODO add your handling code here:\
        rbs.setBackground(bodycolor);
    }//GEN-LAST:event_rbsMouseExited

    private void drMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drMouseEntered
        // TODO add your handling code here:
        dr.setBackground(navcolor);
    }//GEN-LAST:event_drMouseEntered

    private void drMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drMouseExited
        // TODO add your handling code here:
        dr.setBackground(bodycolor);
    }//GEN-LAST:event_drMouseExited

    private void versMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_versMouseEntered
        // TODO add your handling code here:
        vers.setBackground(navcolor);
    }//GEN-LAST:event_versMouseEntered

    private void versMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_versMouseExited
        // TODO add your handling code here:
       vers.setBackground(bodycolor);
    }//GEN-LAST:event_versMouseExited

    private void cdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cdMouseClicked
        // TODO add your handling code here:
 //       dbConnector db = new dbConnector();   
 //       if (db.hasCompanyProfileData()) {
 //           UpdateCompanyProfile updateFrame = new UpdateCompanyProfile();
//           updateFrame.setVisible(true);
//            this.dispose();
 //       } else {
            // Show the registration frame
            Company_Profile profileFrame = new Company_Profile();
            profileFrame.setVisible(true);
            this.dispose();
//        }

    }//GEN-LAST:event_cdMouseClicked

    private void cdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cdMouseEntered
        // TODO add your handling code here:
        cd.setBackground(navcolor);
    }//GEN-LAST:event_cdMouseEntered

    private void cdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cdMouseExited
        // TODO add your handling code here:
        cd.setBackground(bodycolor);
    }//GEN-LAST:event_cdMouseExited

    private void dr1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dr1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_dr1MouseEntered

    private void dr1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dr1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_dr1MouseExited

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
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel adminName;
    public javax.swing.JLabel adminPosition;
    private javax.swing.JLabel cd;
    private javax.swing.JLabel da;
    private javax.swing.JLabel date;
    private javax.swing.JLabel dr;
    private javax.swing.JLabel dr1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lo;
    private javax.swing.JLabel manageAcc;
    private javax.swing.JLabel oi;
    private javax.swing.JLabel pi;
    private javax.swing.JLabel rbs;
    private javax.swing.JLabel si;
    private javax.swing.JLabel time;
    private javax.swing.JLabel ts;
    private javax.swing.JLabel vers;
    // End of variables declaration//GEN-END:variables
}
