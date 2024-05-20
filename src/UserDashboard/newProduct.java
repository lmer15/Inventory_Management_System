
package UserDashboard;

import Config.insertImage;
import config.dbConnector;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Elmer Rapon
 */
public class newProduct extends javax.swing.JInternalFrame {

    public newProduct() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
        unitError.setVisible(false);
        codeError.setVisible(false);
        ErrorHandling(); 

        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                transaction transi = new transaction();
                JDesktopPane desktopPane = (JDesktopPane) getParent();
                desktopPane.add(transi);
                transi.setVisible(true);
                setVisible(false);
            }
            });
    
    } 
    
    public String destination = "";
    File selectedFile;
    public String oldPath;
    public String path;
    
    private static final Set<String> validUnits = new HashSet<>();

    static {
        validUnits.add("kg");
        validUnits.add("g");
        validUnits.add("mg");
        validUnits.add("lb");
        validUnits.add("oz");
        validUnits.add("L");
        validUnits.add("mL");
        validUnits.add("cm");
        validUnits.add("m");
        validUnits.add("km");
    }
    
    public static boolean isValidUnit(String unit) {
        String unitLower = unit.toLowerCase();
        for (String validUnit : validUnits) {
            if (validUnit.equalsIgnoreCase(unitLower)) {
                return true;
            }
        }
        return false;
    }
    
    Color orig = new Color(255,255,255);
    Color newColor =new Color(204,204,204);
    
    
    private void ErrorHandling() {

        PUnit.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateUnit();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateUnit();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateUnit();
            }
        });
        
        code.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateCode();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateCode();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateCode();
            }
        });
        
    }
    
    private void validateUnit() {
    String units = PUnit.getText();
    if (!isValidUnit(units)) {
        unitError.setVisible(true);
    } else {
        unitError.setVisible(false);
    }
}
    private void validateCode() {
    String codee = code.getText();
    if (checkCode(codee)) {
        codeError.setVisible(true);
    } else {
        codeError.setVisible(false);
    }
    }

    public boolean isNumber(String input) {
    try {
        Double.parseDouble(input);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}
    
    public static boolean checkCode(String codes) {
        dbConnector connect = new dbConnector();

        try {
            String query = "SELECT P_Code FROM product_information WHERE P_Code = ?";
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

   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        PFlavor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        PUnit = new javax.swing.JTextField();
        code = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        PNetWeight = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        PPrice = new javax.swing.JTextField();
        save = new javax.swing.JLabel();
        photo = new javax.swing.JLabel();
        unitError = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        remove = new javax.swing.JLabel();
        PName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        codeError = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        upload = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51), 2));
        jPanel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jPanel2.setLayout(null);

        PFlavor.setBackground(new java.awt.Color(240, 240, 240));
        PFlavor.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        PFlavor.setForeground(new java.awt.Color(0, 102, 51));
        PFlavor.setText(" ");
        PFlavor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 0)));
        PFlavor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PFlavorActionPerformed(evt);
            }
        });
        jPanel2.add(PFlavor);
        PFlavor.setBounds(400, 140, 280, 30);

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 51));
        jLabel3.setText("Flavor:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(290, 150, 110, 20);

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 51));
        jLabel4.setText("Net Weight:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(290, 230, 110, 20);

        PUnit.setBackground(new java.awt.Color(240, 240, 240));
        PUnit.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        PUnit.setForeground(new java.awt.Color(0, 102, 51));
        PUnit.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 0)));
        PUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PUnitActionPerformed(evt);
            }
        });
        jPanel2.add(PUnit);
        PUnit.setBounds(400, 260, 280, 30);

        code.setBackground(new java.awt.Color(240, 240, 240));
        code.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        code.setForeground(new java.awt.Color(0, 102, 51));
        code.setText(" ");
        code.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 0)));
        code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeActionPerformed(evt);
            }
        });
        jPanel2.add(code);
        code.setBounds(20, 260, 230, 30);

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 51));
        jLabel6.setText("Enter Product Code:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(20, 240, 170, 20);

        PNetWeight.setBackground(new java.awt.Color(240, 240, 240));
        PNetWeight.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        PNetWeight.setForeground(new java.awt.Color(0, 102, 51));
        PNetWeight.setText(" ");
        PNetWeight.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 0)));
        PNetWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PNetWeightActionPerformed(evt);
            }
        });
        jPanel2.add(PNetWeight);
        PNetWeight.setBounds(400, 220, 280, 30);

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 51));
        jLabel7.setText("Unit:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(290, 270, 110, 20);

        PPrice.setBackground(new java.awt.Color(240, 240, 240));
        PPrice.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        PPrice.setForeground(new java.awt.Color(0, 102, 51));
        PPrice.setText(" ");
        PPrice.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 0)));
        PPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PPriceActionPerformed(evt);
            }
        });
        jPanel2.add(PPrice);
        PPrice.setBounds(400, 180, 280, 30);

        save.setBackground(new java.awt.Color(255, 255, 255));
        save.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        save.setForeground(new java.awt.Color(204, 0, 0));
        save.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        save.setText("SAVE");
        save.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        save.setOpaque(true);
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saveMouseExited(evt);
            }
        });
        jPanel2.add(save);
        save.setBounds(320, 390, 100, 30);

        photo.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        photo.setForeground(new java.awt.Color(204, 204, 204));
        photo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photo.setAlignmentY(0.0F);
        photo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        photo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                photoMouseClicked(evt);
            }
        });
        jPanel2.add(photo);
        photo.setBounds(20, 20, 230, 170);

        unitError.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        unitError.setForeground(new java.awt.Color(255, 0, 0));
        unitError.setText("!Invalid Format");
        jPanel2.add(unitError);
        unitError.setBounds(400, 290, 180, 20);

        jLabel12.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 51));
        jLabel12.setText("Name: ");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(290, 100, 110, 30);

        remove.setBackground(new java.awt.Color(255, 255, 255));
        remove.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        remove.setForeground(new java.awt.Color(50, 150, 122));
        remove.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        remove.setText("Remove");
        remove.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        remove.setOpaque(true);
        remove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                removeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                removeMouseExited(evt);
            }
        });
        jPanel2.add(remove);
        remove.setBounds(130, 200, 90, 26);

        PName.setBackground(new java.awt.Color(240, 240, 240));
        PName.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        PName.setForeground(new java.awt.Color(0, 102, 51));
        PName.setText(" ");
        PName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 0)));
        PName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PNameActionPerformed(evt);
            }
        });
        jPanel2.add(PName);
        PName.setBounds(400, 100, 280, 30);

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 51));
        jLabel8.setText("Price:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(290, 190, 110, 20);

        back.setBackground(new java.awt.Color(255, 255, 255));
        back.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
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
        jPanel2.add(back);
        back.setBounds(320, 430, 100, 30);

        codeError.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        codeError.setForeground(new java.awt.Color(255, 0, 0));
        codeError.setText("Code already Exist!");
        jPanel2.add(codeError);
        codeError.setBounds(20, 290, 150, 13);

        jLabel15.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(50, 150, 122));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Basic Details");
        jLabel15.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel15);
        jLabel15.setBounds(260, 20, 470, 40);

        upload.setBackground(new java.awt.Color(255, 255, 255));
        upload.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        upload.setForeground(new java.awt.Color(50, 150, 122));
        upload.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        upload.setText("Upload");
        upload.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        upload.setOpaque(true);
        upload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uploadMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                uploadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                uploadMouseExited(evt);
            }
        });
        jPanel2.add(upload);
        upload.setBounds(40, 200, 70, 26);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 80, 740, 540);

        jLabel10.setFont(new java.awt.Font("Microsoft YaHei", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(50, 150, 122));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Product Information");
        jLabel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel10);
        jLabel10.setBounds(10, 10, 740, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PFlavorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PFlavorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PFlavorActionPerformed

    private void PUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PUnitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PUnitActionPerformed

    private void codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeActionPerformed

    private void PNetWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PNetWeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PNetWeightActionPerformed

    private void PPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PPriceActionPerformed

    private void saveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseEntered
        // TODO add your handling code here:
        save.setBackground(newColor);
    }//GEN-LAST:event_saveMouseEntered

    private void saveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseExited
        // TODO add your handling code here:
        save.setBackground(orig);
 
    }//GEN-LAST:event_saveMouseExited

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked

        String Unit = PUnit.getText();
        String codd = code.getText();
  
        if(photo.getIcon() == null
                ||PName.getText().isEmpty()
                ||code.getText().isEmpty()
                ||PFlavor.getText().isEmpty()
                ||PPrice.getText().isEmpty()
                ||PNetWeight.getText().isEmpty()
                ||Unit.isEmpty()){
            JOptionPane.showMessageDialog(null, "All fields should be filled", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }else if(!isValidUnit(Unit)){
            PUnit.setText("");
        }else if (!isNumber(PPrice.getText())){
            JOptionPane.showMessageDialog(null, "Price must be a valid number", "Error", JOptionPane.ERROR_MESSAGE);
            PPrice.setText(" ");
        }else if (!isNumber(PNetWeight.getText())){
            JOptionPane.showMessageDialog(null, "Net Weight must be a valid measurement", "Error", JOptionPane.ERROR_MESSAGE);
            PNetWeight.setText(" ");
        }else if(checkCode(codd)){
            code.setText(" ");
        }else{
            dbConnector db = new dbConnector();
        try{
            if(db.insertData("INSERT INTO product_information (P_Code, P_Photo, P_Name, P_Flavor,"
                    + "P_Price, P_Net, P_Unit) "
                    + "VALUES ('"+code.getText()+"',"
                    + " '"+destination+"',"
                    + " '"+PName.getText()+"', "
                    + " '"+PFlavor.getText()+"', "
                    + " '"+PPrice.getText()+"', "
                    + " '"+PNetWeight.getText()+"', "
                    + " '"+PUnit.getText()+ "')")){
                    
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
                JOptionPane.showMessageDialog(null, "SAVE!", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Connection Error!");
                }
                    transaction trans = new transaction();
                    JDesktopPane desktopPane = (JDesktopPane) getParent();
                    desktopPane.add(trans);
                    trans.setVisible(true);
                    setVisible(false); 
        }catch(IOException ex){
            System.out.println("Insert Image Error: " +ex);
        }
    

        }
    }//GEN-LAST:event_saveMouseClicked

    private void PNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PNameActionPerformed

    private void photoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_photoMouseClicked
   
    }//GEN-LAST:event_photoMouseClicked

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        // TODO add your handling code here:
        back.setBackground(newColor);
        
    }//GEN-LAST:event_backMouseEntered

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
        // TODO add your handling code here:
        back.setBackground(orig);
    }//GEN-LAST:event_backMouseExited

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:    
    }//GEN-LAST:event_backMouseClicked

    private void uploadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadMouseEntered
        // TODO add your handling code here:
        upload.setBackground(newColor);
        
    }//GEN-LAST:event_uploadMouseEntered

    private void removeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseEntered
        // TODO add your handling code here:
        remove.setBackground(newColor);
    }//GEN-LAST:event_removeMouseEntered

    private void uploadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadMouseExited
        // TODO add your handling code here:
        upload.setBackground(orig);
    }//GEN-LAST:event_uploadMouseExited

    private void removeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseExited
        // TODO add your handling code here:
        remove.setBackground(orig);
    }//GEN-LAST:event_removeMouseExited

    private void removeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeMouseClicked
        // TODO add your handling code here:
        remove.setEnabled(false);
        upload.setEnabled(true);
        photo.setIcon(null);
        destination = " ";
        path = " ";
        
        
    }//GEN-LAST:event_removeMouseClicked

    private void uploadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadMouseClicked
        // TODO add your handling code here:
    insertImage im = new insertImage();
    JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    try {
                        selectedFile = fileChooser.getSelectedFile();
                        destination = "src/ProductImages/" + selectedFile.getName();
                        path  = selectedFile.getAbsolutePath();
                        
                        
                        if(im.FileExistenceChecker(path) == 1){
                          JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                            destination = "";
                            path="";
                        }else{
                            photo.setIcon(im.ResizeImage(path, null, photo));
                            upload.setEnabled(false);
                            remove.setEnabled(true);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "File is not an Image", "Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println("File Error!");
                    }
                }



    }//GEN-LAST:event_uploadMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PFlavor;
    private javax.swing.JTextField PName;
    private javax.swing.JTextField PNetWeight;
    private javax.swing.JTextField PPrice;
    private javax.swing.JTextField PUnit;
    private javax.swing.JLabel back;
    private static javax.swing.JTextField code;
    private javax.swing.JLabel codeError;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel photo;
    public javax.swing.JLabel remove;
    private javax.swing.JLabel save;
    private javax.swing.JLabel unitError;
    public javax.swing.JLabel upload;
    // End of variables declaration//GEN-END:variables

}
