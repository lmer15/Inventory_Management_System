/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserDashboard;


import Config.session;
import SignUp_LogIn.LogIn;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.AncestorListener;

/**
 *
 * @author Elmer Rapon
 */
public class user extends javax.swing.JFrame {

    /**
     * Creates new form user
     */
    public user() {
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
    Color transColor = new Color (240,240,240);
    Color newTrans =new Color(255,255,255);
    
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
        list = new javax.swing.JLabel();
        ts = new javax.swing.JLabel();
        tep = new javax.swing.JLabel();
        rbp = new javax.swing.JLabel();
        tl = new javax.swing.JLabel();
        to = new javax.swing.JLabel();
        vers = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        ra = new javax.swing.JLabel();
        userDesktop = new javax.swing.JDesktopPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
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
        logOut.setBounds(0, 110, 280, 30);

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Profile");
        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel10);
        jLabel10.setBounds(30, 40, 220, 30);

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
        pi.setBounds(0, 80, 280, 30);

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
        jPanel3.add(da);
        da.setBounds(0, 230, 280, 30);

        drp.setBackground(new java.awt.Color(102, 102, 102));
        drp.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        drp.setForeground(new java.awt.Color(255, 255, 255));
        drp.setText("          Damage/Reject Products");
        drp.setOpaque(true);
        drp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                drpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                drpMouseExited(evt);
            }
        });
        jPanel3.add(drp);
        drp.setBounds(0, 260, 280, 30);

        jLabel15.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Dashboard");
        jLabel15.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel15);
        jLabel15.setBounds(30, 160, 220, 30);

        list.setBackground(new java.awt.Color(102, 102, 102));
        list.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        list.setForeground(new java.awt.Color(255, 255, 255));
        list.setText("          List of Products");
        list.setOpaque(true);
        list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                listMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                listMouseExited(evt);
            }
        });
        jPanel3.add(list);
        list.setBounds(0, 200, 280, 30);

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
        jPanel3.add(ts);
        ts.setBounds(0, 420, 280, 30);

        tep.setBackground(new java.awt.Color(102, 102, 102));
        tep.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        tep.setForeground(new java.awt.Color(255, 255, 255));
        tep.setText("          Total Expected Profit");
        tep.setOpaque(true);
        tep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tepMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tepMouseExited(evt);
            }
        });
        jPanel3.add(tep);
        tep.setBounds(0, 450, 280, 30);

        rbp.setBackground(new java.awt.Color(102, 102, 102));
        rbp.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        rbp.setForeground(new java.awt.Color(255, 255, 255));
        rbp.setText("          Returned/BO Products");
        rbp.setOpaque(true);
        rbp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rbpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rbpMouseExited(evt);
            }
        });
        jPanel3.add(rbp);
        rbp.setBounds(0, 290, 280, 30);

        tl.setBackground(new java.awt.Color(102, 102, 102));
        tl.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        tl.setForeground(new java.awt.Color(255, 255, 255));
        tl.setText("          Total Lost");
        tl.setOpaque(true);
        tl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tlMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tlMouseExited(evt);
            }
        });
        jPanel3.add(tl);
        tl.setBounds(0, 480, 280, 30);

        to.setBackground(new java.awt.Color(102, 102, 102));
        to.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        to.setForeground(new java.awt.Color(255, 255, 255));
        to.setText("          Total Outputs");
        to.setOpaque(true);
        to.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                toMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                toMouseExited(evt);
            }
        });
        jPanel3.add(to);
        to.setBounds(0, 510, 280, 30);

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
        jLabel23.setBounds(30, 380, 220, 30);

        ra.setBackground(new java.awt.Color(102, 102, 102));
        ra.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        ra.setForeground(new java.awt.Color(255, 255, 255));
        ra.setText("          Receivable Accounts");
        ra.setOpaque(true);
        ra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                raMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                raMouseExited(evt);
            }
        });
        jPanel3.add(ra);
        ra.setBounds(0, 540, 280, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 80, 280, 690);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 51));
        jLabel1.setText("<html>TrackIn is your go-to inventory management system, offering real-time tracking and automated reordering to streamline your operations and boost efficiency. Experience seamless multi-location management and customizable reporting with TrackIn, elevating your business and simplifying your inventory control.</html>");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel4.add(jLabel1);
        jLabel1.setBounds(20, 70, 730, 60);

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 51));
        jLabel3.setText("Welcome to TrackIn!");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(20, 20, 270, 40);

        jPanel5.setBackground(new java.awt.Color(98, 180, 98));
        jPanel5.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel5.add(jScrollPane1);
        jScrollPane1.setBounds(10, 40, 690, 410);

        jLabel24.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("AVAILABLE STOCKS");
        jLabel24.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel5.add(jLabel24);
        jLabel24.setBounds(0, 5, 710, 30);

        jPanel4.add(jPanel5);
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
        jPanel4.add(trans);
        trans.setBounds(10, 620, 740, 30);

        userDesktop.add(jPanel4);
        jPanel4.setBounds(0, 0, 760, 670);

        jPanel1.add(userDesktop);
        userDesktop.setBounds(280, 90, 760, 690);

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

    private void listMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseEntered
        // TODO add your handling code here:
        list.setBackground(navcolor);
    }//GEN-LAST:event_listMouseEntered

    private void listMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseExited
        // TODO add your handling code here:
        list.setBackground(bodycolor);
    }//GEN-LAST:event_listMouseExited

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

    private void rbpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbpMouseEntered
        // TODO add your handling code here:
        rbp.setBackground(navcolor);
    }//GEN-LAST:event_rbpMouseEntered

    private void rbpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbpMouseExited
        // TODO add your handling code here:
        rbp.setBackground(bodycolor); 
    }//GEN-LAST:event_rbpMouseExited

    private void tsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tsMouseEntered
        // TODO add your handling code here:
        ts.setBackground(navcolor); 
    }//GEN-LAST:event_tsMouseEntered

    private void tsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tsMouseExited
        // TODO add your handling code here:
        ts.setBackground(bodycolor); 
    }//GEN-LAST:event_tsMouseExited

    private void tepMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tepMouseEntered
        // TODO add your handling code here:
        tep.setBackground(navcolor); 
    }//GEN-LAST:event_tepMouseEntered

    private void tepMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tepMouseExited
        // TODO add your handling code here:
        tep.setBackground(bodycolor); 
    }//GEN-LAST:event_tepMouseExited

    private void tlMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tlMouseEntered
        // TODO add your handling code here:
        tl.setBackground(navcolor);
    }//GEN-LAST:event_tlMouseEntered

    private void tlMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tlMouseExited
        // TODO add your handling code here:
        tl.setBackground(bodycolor); 
    }//GEN-LAST:event_tlMouseExited

    private void toMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toMouseEntered
        // TODO add your handling code here:
        to.setBackground(navcolor); 
    }//GEN-LAST:event_toMouseEntered

    private void toMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toMouseExited
        // TODO add your handling code here:
        to.setBackground(bodycolor); 
    }//GEN-LAST:event_toMouseExited

    private void raMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_raMouseEntered
        // TODO add your handling code here:
        ra.setBackground(navcolor); 
    }//GEN-LAST:event_raMouseEntered

    private void raMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_raMouseExited
        // TODO add your handling code here:
        ra.setBackground(bodycolor); 
    }//GEN-LAST:event_raMouseExited

    private void versMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_versMouseEntered
        // TODO add your handling code here:
        vers.setBackground(navcolor); 
    }//GEN-LAST:event_versMouseEntered

    private void versMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_versMouseExited
        // TODO add your handling code here:
        vers.setBackground(bodycolor);
    }//GEN-LAST:event_versMouseExited

    private void transMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transMouseClicked
        // TODO add your handling code here:
        transaction tran = new transaction();
        newProduct prod = new newProduct();
        Output op = new Output();
        userDesktop.add(tran).setVisible(true);
        userDesktop.add(prod);
        userDesktop.add(op);
        
    }//GEN-LAST:event_transMouseClicked

    private void transMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transMouseEntered
        // TODO add your handling code here:
        trans.setBackground(transColor);
    }//GEN-LAST:event_transMouseEntered

    private void transMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transMouseExited
        // TODO add your handling code here:
        trans.setBackground(newTrans);
    }//GEN-LAST:event_transMouseExited

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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel list;
    private javax.swing.JLabel logOut;
    private javax.swing.JLabel pi;
    private javax.swing.JLabel ra;
    private javax.swing.JLabel rbp;
    private javax.swing.JLabel tep;
    private javax.swing.JLabel time;
    private javax.swing.JLabel tl;
    private javax.swing.JLabel to;
    private javax.swing.JLabel trans;
    private javax.swing.JLabel ts;
    public javax.swing.JDesktopPane userDesktop;
    public javax.swing.JLabel userName;
    public javax.swing.JLabel userPosition;
    private javax.swing.JLabel vers;
    // End of variables declaration//GEN-END:variables
}
