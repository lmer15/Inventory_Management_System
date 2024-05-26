/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminDashboard;

import Config.session;
import Reports.AccountsReceivable;
import SignUp_LogIn.LogIn;
import UserDashboard.OrderForm;
import Reports.CustomersAccount;
import Reports.ExpiredProducts;
import Reports.ReportDamage;
import Reports.ViewProducts;
import UserDashboard.DamageProducts;
import UserDashboard.user;
import UserDashboard.userProfileInfo;
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
public class admin extends javax.swing.JFrame {

    /**
     * Creates new form admin
     */
    public admin() {
        initComponents();
        date();
        time();
        displayProduct();
        getTotalSoldProducts();
        
    }
    
    private void date(){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        String dt = sdf.format(d);
        date.setText(dt);
        totalS.setText("As of " + dt);
        AccR.setText("As of " + dt);

        
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
            ProductsTable.setModel(tableModel);
            
            JTableHeader header = ProductsTable.getTableHeader();
            header.setBackground(Color.GRAY);
            header.setForeground(Color.BLACK);
            header.setFont(new Font("Microsoft Gothic", Font.BOLD, 10));
            header.setPreferredSize(new Dimension(header.getPreferredSize().width, 30)); // Adjust header height

            // Customize row appearance
            ProductsTable.setRowHeight(30);
            ProductsTable.setShowGrid(true);// Adjust row height
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    c.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : Color.LIGHT_GRAY); // Alternating row colors
                    return c;
                }
            };
            for (int i = 0; i < ProductsTable.getColumnCount(); i++) {
                ProductsTable.getColumnModel().getColumn(i).setCellRenderer(renderer);
            }
        }
    } catch (SQLException ex) {
        System.out.println("Errors: " + ex.getMessage());
    }
}

    public static void getTotalSoldProducts() {
        try {
            dbConnector db = new dbConnector();
            String sql = "SELECT SUM(OrderQuantity) as TOTALSOLD, SUM(O_TotalAmount) as TOTALAMOUNT FROM orderform WHERE OrderStatus = 'DELIVERED'";
            ResultSet resultSet = db.getData(sql);
            if (resultSet.next()) {
                int totalSoldQuantity = resultSet.getInt("TOTALSOLD");
                double AccReceive = resultSet.getDouble("TOTALAMOUNT");
                totalSold.setText("₱" +Integer.toString(totalSoldQuantity));
                sale.setText(Double.toString(AccReceive));
            } else {
                totalSold.setText("0"); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
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
        ListOfProducts = new javax.swing.JLabel();
        dr = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        da = new javax.swing.JLabel();
        vers = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        rbs = new javax.swing.JLabel();
        cd = new javax.swing.JLabel();
        dr1 = new javax.swing.JLabel();
        HOME = new javax.swing.JLabel();
        AdminDesktop = new javax.swing.JDesktopPane();
        mainPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductsTable = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        sale = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        AccR = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        totalSold = new javax.swing.JLabel();
        totalS = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setLayout(null);

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

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1060, 90);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));
        jPanel3.setLayout(null);

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
        pi.setBounds(0, 100, 290, 30);

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("About Us");
        jLabel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel7);
        jLabel7.setBounds(30, 590, 220, 30);

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
        jPanel3.add(lo);
        lo.setBounds(0, 190, 290, 30);

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Profile");
        jLabel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel9);
        jLabel9.setBounds(30, 20, 220, 30);

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
        jPanel3.add(manageAcc);
        manageAcc.setBounds(0, 130, 290, 30);

        ListOfProducts.setBackground(new java.awt.Color(102, 102, 102));
        ListOfProducts.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        ListOfProducts.setForeground(new java.awt.Color(255, 255, 255));
        ListOfProducts.setText("          List Of Products");
        ListOfProducts.setOpaque(true);
        ListOfProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListOfProductsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ListOfProductsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ListOfProductsMouseExited(evt);
            }
        });
        jPanel3.add(ListOfProducts);
        ListOfProducts.setBounds(0, 300, 290, 30);

        dr.setBackground(new java.awt.Color(102, 102, 102));
        dr.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        dr.setForeground(new java.awt.Color(255, 255, 255));
        dr.setText("          Accounts Receivable");
        dr.setOpaque(true);
        dr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                drMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                drMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                drMouseExited(evt);
            }
        });
        jPanel3.add(dr);
        dr.setBounds(0, 510, 290, 30);

        jLabel16.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Dashboard");
        jLabel16.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel16);
        jLabel16.setBounds(30, 260, 220, 30);

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
        da.setBounds(0, 330, 290, 30);

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
        jPanel3.add(vers);
        vers.setBounds(0, 630, 280, 30);

        jLabel21.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Reports");
        jLabel21.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel21);
        jLabel21.setBounds(30, 410, 220, 30);

        rbs.setBackground(new java.awt.Color(102, 102, 102));
        rbs.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        rbs.setForeground(new java.awt.Color(255, 255, 255));
        rbs.setText("          Expired Products");
        rbs.setOpaque(true);
        rbs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rbsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rbsMouseExited(evt);
            }
        });
        jPanel3.add(rbs);
        rbs.setBounds(0, 450, 290, 30);

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
        jPanel3.add(cd);
        cd.setBounds(0, 160, 290, 30);

        dr1.setBackground(new java.awt.Color(102, 102, 102));
        dr1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 16)); // NOI18N
        dr1.setForeground(new java.awt.Color(255, 255, 255));
        dr1.setText("          Damage Items");
        dr1.setOpaque(true);
        dr1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dr1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dr1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dr1MouseExited(evt);
            }
        });
        jPanel3.add(dr1);
        dr1.setBounds(0, 480, 290, 30);

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

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 90, 290, 670);

        mainPanel.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(98, 180, 98));
        jPanel6.setLayout(null);

        jLabel24.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("AVAILABLE STOCKS");
        jLabel24.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel6.add(jLabel24);
        jLabel24.setBounds(20, 10, 690, 25);

        ProductsTable.setBackground(new java.awt.Color(98, 180, 98));
        ProductsTable.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        ProductsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(ProductsTable);

        jPanel6.add(jScrollPane1);
        jScrollPane1.setBounds(20, 50, 690, 310);

        mainPanel.add(jPanel6);
        jPanel6.setBounds(20, 270, 730, 380);

        jPanel7.setBackground(new java.awt.Color(98, 180, 98));
        jPanel7.setLayout(null);

        sale.setFont(new java.awt.Font("Microsoft YaHei", 1, 50)); // NOI18N
        sale.setForeground(new java.awt.Color(0, 0, 255));
        sale.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sale.setText("+100,000");
        jPanel7.add(sale);
        sale.setBounds(10, 50, 330, 130);

        jLabel27.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Accounts Receivable");
        jLabel27.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel7.add(jLabel27);
        jLabel27.setBounds(10, 10, 280, 25);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-time-25.png"))); // NOI18N
        jPanel7.add(jLabel5);
        jLabel5.setBounds(10, 200, 25, 30);

        AccR.setText("As of December 16, 2024");
        jPanel7.add(AccR);
        AccR.setBounds(40, 200, 210, 30);

        mainPanel.add(jPanel7);
        jPanel7.setBounds(390, 10, 360, 240);

        jPanel5.setBackground(new java.awt.Color(98, 180, 98));
        jPanel5.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total Sold");
        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel5.add(jLabel10);
        jLabel10.setBounds(10, 10, 280, 25);

        totalSold.setFont(new java.awt.Font("Microsoft YaHei", 1, 50)); // NOI18N
        totalSold.setForeground(new java.awt.Color(255, 51, 51));
        totalSold.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalSold.setText("-234,567");
        totalSold.setPreferredSize(new java.awt.Dimension(350, 250));
        jPanel5.add(totalSold);
        totalSold.setBounds(10, 60, 320, 120);

        totalS.setText("As of December 16, 2024");
        jPanel5.add(totalS);
        totalS.setBounds(40, 200, 210, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-time-25.png"))); // NOI18N
        jPanel5.add(jLabel3);
        jLabel3.setBounds(10, 200, 25, 30);

        mainPanel.add(jPanel5);
        jPanel5.setBounds(20, 10, 360, 240);

        AdminDesktop.setLayer(mainPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout AdminDesktopLayout = new javax.swing.GroupLayout(AdminDesktop);
        AdminDesktop.setLayout(AdminDesktopLayout);
        AdminDesktopLayout.setHorizontalGroup(
            AdminDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminDesktopLayout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        AdminDesktopLayout.setVerticalGroup(
            AdminDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(AdminDesktop);
        AdminDesktop.setBounds(290, 90, 760, 670);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1054, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
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

    private void ListOfProductsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListOfProductsMouseEntered
        // TODO add your handling code here:\
        ListOfProducts.setBackground(navcolor);

    }//GEN-LAST:event_ListOfProductsMouseEntered

    private void ListOfProductsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListOfProductsMouseExited
        // TODO add your handling code here:
        ListOfProducts.setBackground(bodycolor);

    }//GEN-LAST:event_ListOfProductsMouseExited

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

    private void daMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daMouseEntered
        // TODO add your handling code here:
        da.setBackground(navcolor);      
    }//GEN-LAST:event_daMouseEntered

    private void daMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daMouseExited
        // TODO add your handling code here:
        da.setBackground(bodycolor);      
    }//GEN-LAST:event_daMouseExited

    private void rbsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbsMouseEntered
        // TODO add your handling code here:
       rbs.setBackground(navcolor);
    }//GEN-LAST:event_rbsMouseEntered

    private void rbsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbsMouseExited
        // TODO add your handling code here:\
        rbs.setBackground(bodycolor);
    }//GEN-LAST:event_rbsMouseExited

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
       dbConnector db = new dbConnector();   
       if (db.hasCompanyProfileData()) {
            UpdateCompanyProfile updateFrame = new UpdateCompanyProfile();
         updateFrame.setVisible(true);
            this.dispose();
       } else {
            // Show the registration frame
            Company_Profile profileFrame = new Company_Profile();
            profileFrame.setVisible(true);
            this.dispose();
       }

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
        dr1.setBackground(navcolor);
    }//GEN-LAST:event_dr1MouseEntered

    private void dr1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dr1MouseExited
        // TODO add your handling code here:
        dr1.setBackground(bodycolor);
    }//GEN-LAST:event_dr1MouseExited

    private void ListOfProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListOfProductsMouseClicked
        // TODO add your handling code here:
        ViewProducts view = new ViewProducts();
        OrderForm dr = new OrderForm();
        AdminDesktop.add(view).setVisible(true);
        AdminDesktop.add(dr);
    }//GEN-LAST:event_ListOfProductsMouseClicked

    private void drMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drMouseExited
        // TODO add your handling code here:
        dr.setBackground(bodycolor);
    }//GEN-LAST:event_drMouseExited

    private void drMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drMouseEntered
        // TODO add your handling code here:
        dr.setBackground(navcolor);
    }//GEN-LAST:event_drMouseEntered

    private void daMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daMouseClicked
        // TODO add your handling code here:
        CustomersAccount view = new CustomersAccount();
        AdminDesktop.add(view).setVisible(true);
    }//GEN-LAST:event_daMouseClicked

    private void dr1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dr1MouseClicked
        // TODO add your handling code here:
        ReportDamage damage = new ReportDamage();
        AdminDesktop.add(damage).setVisible(true); 
    }//GEN-LAST:event_dr1MouseClicked

    private void HOMEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HOMEMouseClicked
        
        admin ad = new admin();
        ad.setVisible(true);
        dispose();
    }//GEN-LAST:event_HOMEMouseClicked

    private void HOMEMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HOMEMouseEntered
        // TODO add your handling code here:
        HOME.setBackground(navcolor);
    }//GEN-LAST:event_HOMEMouseEntered

    private void HOMEMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HOMEMouseExited
        // TODO add your handling code here:
        HOME.setBackground(bodycolor);
    }//GEN-LAST:event_HOMEMouseExited

    private void rbsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbsMouseClicked
        // TODO add your handling code here:
        ExpiredProducts damage = new ExpiredProducts();
        AdminDesktop.add(damage).setVisible(true); 
    }//GEN-LAST:event_rbsMouseClicked

    private void drMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_drMouseClicked
        // TODO add your handling code here:
        AccountsReceivable acc = new AccountsReceivable();
        AdminDesktop.add(acc).setVisible(true); 
    }//GEN-LAST:event_drMouseClicked

    private void piMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_piMouseClicked
        // TODO add your handling code here:
        
        AdminProfile adp = new AdminProfile();
        session ss = session.getInstance();
        String firstname = ss.getFname();
        String lastname = ss.getLname();
        String fullname = firstname + " " +lastname;
        adp.u_username.setText("@" + ss.getUsername());
        adp.u_position.setText(ss.getPosition());
        adp.u_fullname.setText(fullname);
        adp.u_email.setText(ss.getEmail());
        adp.u_accountstat.setText(ss.getStatus());
        adp.dispose();
        AdminDesktop.add(adp).setVisible(true);
        
    }//GEN-LAST:event_piMouseClicked

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
    private javax.swing.JLabel AccR;
    public javax.swing.JDesktopPane AdminDesktop;
    private javax.swing.JLabel HOME;
    private javax.swing.JLabel ListOfProducts;
    private javax.swing.JTable ProductsTable;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lo;
    public javax.swing.JPanel mainPanel;
    private javax.swing.JLabel manageAcc;
    private javax.swing.JLabel pi;
    private javax.swing.JLabel rbs;
    private static javax.swing.JLabel sale;
    private javax.swing.JLabel time;
    private javax.swing.JLabel totalS;
    private static javax.swing.JLabel totalSold;
    private javax.swing.JLabel vers;
    // End of variables declaration//GEN-END:variables
}
