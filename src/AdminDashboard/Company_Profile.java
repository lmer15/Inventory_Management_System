package AdminDashboard;
import Config.insertImage;
import config.dbConnector;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Elmer Rapon
 */
public class Company_Profile extends javax.swing.JFrame {
    private String selectedGender;
 
    public Company_Profile() {
        initComponents();
        ErrorHandling();
    }
    
    public String destination = "";
    File selectedFile;
    public String oldPath;
    public String path;
    
    Color navcolor = new Color (204,204,204);
    Color headcolor = new Color (153,153,153);
    Color bodycolor =new Color (240,240,240);;
    
      private void ErrorHandling() {
        emError.setVisible(false);
        numError.setVisible(false);
        webError.setVisible(false);
        tinError.setVisible(false);
        birError.setVisible(false);
        permitError.setVisible(false);
        brnError.setVisible(false);
        binError.setVisible(false);

        email.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateEmail();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateEmail();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateEmail();
            }
        });
        web.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateWebsite();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateWebsite();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateWebsite();
            }
        });
        number.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateNumber();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateNumber();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateNumber();
            }
        });
        noTIN.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateTIN();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateTIN();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateTIN();
            }
        });
        noBIR.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                validateBIR();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                validateBIR();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                validateBIR();
            }
        });       
        noMayor.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
               validatePermit();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
               validatePermit();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               validatePermit();
            }
        }); 
        noBRN.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
               validateBRN();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
               validateBRN();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               validateBRN();
            }
        });
        noBIN.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
               validateBIN();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
               validateBIN();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               validateBIN();
            }
        }); 
    }

    // Validate Email
    private void validateEmail() {
        String emailText = email.getText();
        if (!validateEmail(emailText)) {
            emError.setVisible(true);
        } else {
            emError.setVisible(false);
        }
    }

    // Validate Website
    private void validateWebsite() {
        String websiteText = web.getText();
        if (!validateWebsite(websiteText)) {
            webError.setVisible(true);
        } else {
            webError.setVisible(false);
        }
    }
    
    //Validate Number
    private void validateNumber() {
    String numberText = number.getText();
    if (!validatePhoneNumber(numberText)) {
        numError.setVisible(true);
    } else {
        numError.setVisible(false);
    }
}
    
    //Validate TIN
    private void validateTIN() {
    String TINN = noTIN.getText();
    if (!validation(TINN, "TIN")) {
        tinError.setVisible(true);
    } else {
        tinError.setVisible(false);
    }
}

    //Validate BIR
    private void validateBIR() {
    String BIRR = noBIR.getText();
    if (!validation(BIRR, "BIR")) {
        birError.setVisible(true);
    } else {
        birError.setVisible(false);
    }
}

    //Validate Mayor's Permit
    private void validatePermit() {
    String permit = noMayor.getText();
    if (!validation(permit, "MAYORS_PERMIT")) {
        permitError.setVisible(true);
    } else {
        permitError.setVisible(false);
    }
}
    
    //Validate BRN
    private void validateBRN() {
    String BRNN = noBRN.getText();
    if (!validation(BRNN, "BRN")) {
        brnError.setVisible(true);
    } else {
        brnError.setVisible(false);
    }
}
    
//Validate BRN
    private void validateBIN() {
    String BINN = noBIN.getText();
    if (!validation(BINN, "BIN")) {
        binError.setVisible(true);
    } else {
        binError.setVisible(false);
    }
}

    
    public static boolean validateEmail(String email) {
        String pattern = "^[\\w.-]+@[a-zA-Z0-9-]+\\.[a-zA-Z]{2,6}$";
        return email.matches(pattern);
    }

    public static boolean validateWebsite(String website) {
        String pattern = "^(http(s)?://)?(www\\.)?[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}(/[a-zA-Z0-9.-]*)*$";
        return website.matches(pattern);
    }
    
    public static boolean validation(String number, String type) {
        String pattern = "";
        
        switch(type) {
            case "TIN":
                pattern = "^\\d{2}-\\d{9}-\\d$";
                break;
            case "BIR":
                pattern = "^[a-zA-Z0-9-]{12}$";
                break;
            case "MAYORS_PERMIT":
                pattern = "^[a-zA-Z0-9-]{11}$";
                break;
            case "BRN":
                pattern = "^\\d{3}-\\d{7}$";
                break;
            case "BIN":
                pattern = "^\\d{3}-\\d{3}-\\d{3}-\\d{3}$";
                break;
            default:
                return false;
        }
        return number.matches(pattern);
    }
    public static boolean validatePhoneNumber(String phoneNumber) {
        String pattern = "^\\d{3}-\\d{3}-\\d{4}$";
        return phoneNumber.matches(pattern);
    }

    
     public boolean FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/images", fileName);
        return Files.exists(filePath);
    }

    
    public int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);

            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();

            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found: " + ex.getMessage());
        }
        return -1;
    }
    public ImageIcon ResizeImage(String imagePath, JLabel label) {
        ImageIcon myImage = new ImageIcon(imagePath);
        int newHeight = getHeightFromWidth(imagePath, label.getWidth());

        if (newHeight == -1) {
            return null;
        }

        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }
    public boolean isImage(String filename) {
        String[] imageExtensions = {".jpg", ".jpeg", ".png", ".gif", ".bmp"};
        for (String extension : imageExtensions) {
            if (filename.toLowerCase().endsWith(extension)) {
                return true;
            }
        }  
        return false;
        }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        ceoLname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ceoFname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        c_Brgy = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        c_Country = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        c_Purok = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        c_Mun = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        c_Zip = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        c_Prov = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cLogo = new javax.swing.JLabel();
        busType = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        fb = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        number = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        web = new javax.swing.JTextField();
        webError = new javax.swing.JLabel();
        numError = new javax.swing.JLabel();
        emError = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tag = new javax.swing.JTextArea();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        noBIN = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        noTIN = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        noBIR = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        noMayor = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        noBRN = new javax.swing.JTextField();
        binError = new javax.swing.JLabel();
        tinError = new javax.swing.JLabel();
        birError = new javax.swing.JLabel();
        permitError = new javax.swing.JLabel();
        brnError = new javax.swing.JLabel();
        register = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        female = new javax.swing.JCheckBox();
        male = new javax.swing.JCheckBox();
        jLabel28 = new javax.swing.JLabel();
        comName = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 102, 0));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("UPDATE COMPANY'S PROFILE");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(50, 10, 430, 40);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-list-25.png"))); // NOI18N
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 20, 30, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1050, 60);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 51), 2));
        jPanel3.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 0));
        jLabel3.setText("Last Name: ");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(470, 80, 100, 30);

        ceoLname.setBackground(new java.awt.Color(240, 240, 240));
        ceoLname.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        ceoLname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 0)));
        jPanel3.add(ceoLname);
        ceoLname.setBounds(570, 90, 160, 20);

        jLabel5.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 0));
        jLabel5.setText("Company Name:");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(20, 18, 130, 22);

        jLabel7.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 0));
        jLabel7.setText("Gender:");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(760, 40, 60, 30);

        ceoFname.setBackground(new java.awt.Color(240, 240, 240));
        ceoFname.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        ceoFname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 0)));
        jPanel3.add(ceoFname);
        ceoFname.setBounds(570, 49, 160, 22);

        jLabel8.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 0));
        jLabel8.setText("Business Type:");
        jPanel3.add(jLabel8);
        jLabel8.setBounds(20, 50, 130, 20);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0)));
        jPanel4.setLayout(null);

        c_Brgy.setBackground(new java.awt.Color(240, 240, 240));
        c_Brgy.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        c_Brgy.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 0)));
        jPanel4.add(c_Brgy);
        c_Brgy.setBounds(340, 50, 200, 20);

        jLabel12.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 0));
        jLabel12.setText("Country:");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(300, 150, 80, 20);

        c_Country.setBackground(new java.awt.Color(240, 240, 240));
        c_Country.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        c_Country.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 0)));
        jPanel4.add(c_Country);
        c_Country.setBounds(370, 150, 170, 20);

        jLabel13.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 0));
        jLabel13.setText("Purok:");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(10, 50, 60, 20);

        c_Purok.setBackground(new java.awt.Color(240, 240, 240));
        c_Purok.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        c_Purok.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 0)));
        jPanel4.add(c_Purok);
        c_Purok.setBounds(70, 50, 210, 20);

        jLabel14.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 0));
        jLabel14.setText("Municipality:");
        jPanel4.add(jLabel14);
        jLabel14.setBounds(10, 100, 100, 20);

        jLabel15.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 0));
        jLabel15.setText("Brgy.:");
        jPanel4.add(jLabel15);
        jLabel15.setBounds(290, 50, 50, 20);

        c_Mun.setBackground(new java.awt.Color(240, 240, 240));
        c_Mun.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        c_Mun.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 0)));
        jPanel4.add(c_Mun);
        c_Mun.setBounds(110, 100, 240, 20);

        jLabel16.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 0));
        jLabel16.setText("ZIP Code:");
        jPanel4.add(jLabel16);
        jLabel16.setBounds(350, 100, 80, 20);

        c_Zip.setBackground(new java.awt.Color(240, 240, 240));
        c_Zip.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        c_Zip.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 0)));
        jPanel4.add(c_Zip);
        c_Zip.setBounds(440, 100, 100, 20);

        jLabel20.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 0));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("ADDRESS INFROMATION");
        jLabel20.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel20);
        jLabel20.setBounds(10, 10, 530, 20);

        jLabel23.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 0));
        jLabel23.setText("Province:");
        jPanel4.add(jLabel23);
        jLabel23.setBounds(10, 140, 80, 40);

        c_Prov.setBackground(new java.awt.Color(240, 240, 240));
        c_Prov.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        c_Prov.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 0)));
        jPanel4.add(c_Prov);
        c_Prov.setBounds(90, 150, 210, 20);

        jPanel3.add(jPanel4);
        jPanel4.setBounds(450, 120, 550, 200);

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 0));
        jLabel6.setText("CHIEF EXECUTIVE OFFICER:");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(460, 20, 220, 22);

        cLogo.setBackground(new java.awt.Color(255, 255, 255));
        cLogo.setFont(new java.awt.Font("Microsoft YaHei", 2, 16)); // NOI18N
        cLogo.setForeground(new java.awt.Color(102, 102, 102));
        cLogo.setText(" Upload File Here!");
        cLogo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        cLogo.setOpaque(true);
        cLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cLogoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cLogoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cLogoMouseExited(evt);
            }
        });
        jPanel3.add(cLogo);
        cLogo.setBounds(160, 78, 260, 30);

        busType.setBackground(new java.awt.Color(240, 240, 240));
        busType.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        busType.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 0)));
        jPanel3.add(busType);
        busType.setBounds(160, 50, 260, 20);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0)));
        jPanel5.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CONTACT DETAILS");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel5.add(jLabel4);
        jLabel4.setBounds(10, 10, 390, 20);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-facebook-20.png"))); // NOI18N
        jPanel5.add(jLabel17);
        jLabel17.setBounds(20, 150, 20, 30);

        fb.setBackground(new java.awt.Color(240, 240, 240));
        fb.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        fb.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 0)));
        jPanel5.add(fb);
        fb.setBounds(50, 160, 340, 20);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-phone-number-20.png"))); // NOI18N
        jPanel5.add(jLabel19);
        jLabel19.setBounds(20, 40, 20, 20);

        number.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        number.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 0)));
        jPanel5.add(number);
        number.setBounds(50, 40, 340, 20);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-email-20.png"))); // NOI18N
        jPanel5.add(jLabel21);
        jLabel21.setBounds(20, 80, 30, 20);

        email.setBackground(new java.awt.Color(240, 240, 240));
        email.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 0)));
        jPanel5.add(email);
        email.setBounds(50, 80, 340, 20);

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PICTURE/icons8-website-20.png"))); // NOI18N
        jPanel5.add(jLabel22);
        jLabel22.setBounds(20, 110, 20, 30);

        web.setBackground(new java.awt.Color(240, 240, 240));
        web.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        web.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 0)));
        jPanel5.add(web);
        web.setBounds(50, 120, 340, 20);

        webError.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        webError.setForeground(new java.awt.Color(255, 0, 0));
        webError.setText("!Invalid Format (www.example.org or https://www.example.com)");
        jPanel5.add(webError);
        webError.setBounds(50, 140, 310, 13);

        numError.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        numError.setForeground(new java.awt.Color(255, 0, 0));
        numError.setText("!Invalid Format (123-456-7890 or (123) 456-7890)");
        jPanel5.add(numError);
        numError.setBounds(50, 60, 220, 13);

        emError.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        emError.setForeground(new java.awt.Color(255, 0, 0));
        emError.setText("!Invalid Format (example@email.com)");
        jPanel5.add(emError);
        emError.setBounds(50, 100, 180, 13);

        jPanel3.add(jPanel5);
        jPanel5.setBounds(20, 120, 410, 200);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0)));
        jPanel6.setLayout(null);

        jLabel18.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("COMPANY'S TAGLINE");
        jLabel18.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel6.add(jLabel18);
        jLabel18.setBounds(10, 10, 390, 20);

        tag.setColumns(20);
        tag.setRows(5);
        jScrollPane1.setViewportView(tag);

        jPanel6.add(jScrollPane1);
        jScrollPane1.setBounds(10, 40, 390, 210);

        jPanel3.add(jPanel6);
        jPanel6.setBounds(20, 340, 410, 260);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 0)));
        jPanel7.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("TAX AND BUSINESS REGISTRATION DETAILS");
        jLabel9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel7.add(jLabel9);
        jLabel9.setBounds(10, 10, 530, 20);

        jLabel11.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 0));
        jLabel11.setText("BIN NO.:");
        jPanel7.add(jLabel11);
        jLabel11.setBounds(20, 220, 90, 20);

        noBIN.setBackground(new java.awt.Color(240, 240, 240));
        noBIN.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        noBIN.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 0)));
        jPanel7.add(noBIN);
        noBIN.setBounds(110, 220, 420, 20);

        jLabel24.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 102, 0));
        jLabel24.setText("TIN NO.:");
        jPanel7.add(jLabel24);
        jLabel24.setBounds(20, 60, 80, 20);

        noTIN.setBackground(new java.awt.Color(240, 240, 240));
        noTIN.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        noTIN.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 0)));
        jPanel7.add(noTIN);
        noTIN.setBounds(100, 60, 430, 20);

        jLabel25.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 102, 0));
        jLabel25.setText("BIR CERT.:");
        jPanel7.add(jLabel25);
        jLabel25.setBounds(20, 100, 80, 20);

        noBIR.setBackground(new java.awt.Color(240, 240, 240));
        noBIR.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        noBIR.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 0)));
        jPanel7.add(noBIR);
        noBIR.setBounds(100, 99, 430, 22);

        jLabel26.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 102, 0));
        jLabel26.setText("MAYOR'S PERMIT: ");
        jPanel7.add(jLabel26);
        jLabel26.setBounds(20, 140, 150, 20);

        noMayor.setBackground(new java.awt.Color(240, 240, 240));
        noMayor.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        noMayor.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 0)));
        jPanel7.add(noMayor);
        noMayor.setBounds(170, 140, 360, 20);

        jLabel27.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 102, 0));
        jLabel27.setText("BRN NO.:");
        jPanel7.add(jLabel27);
        jLabel27.setBounds(20, 180, 90, 20);

        noBRN.setBackground(new java.awt.Color(240, 240, 240));
        noBRN.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        noBRN.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 0)));
        jPanel7.add(noBRN);
        noBRN.setBounds(110, 180, 420, 20);

        binError.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        binError.setForeground(new java.awt.Color(255, 0, 0));
        binError.setText("!Invalid Format (123-456-789-012 )");
        jPanel7.add(binError);
        binError.setBounds(110, 240, 200, 13);

        tinError.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tinError.setForeground(new java.awt.Color(255, 0, 0));
        tinError.setText("!Invalid Format (xx-xxxxxxxxxx-x)");
        jPanel7.add(tinError);
        tinError.setBounds(100, 80, 210, 13);

        birError.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        birError.setForeground(new java.awt.Color(255, 0, 0));
        birError.setText("!Invalid Format (ABCD12345678)");
        jPanel7.add(birError);
        birError.setBounds(100, 120, 200, 13);

        permitError.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        permitError.setForeground(new java.awt.Color(255, 0, 0));
        permitError.setText("!Invalid Format (ABCD1234567)");
        jPanel7.add(permitError);
        permitError.setBounds(170, 160, 180, 13);

        brnError.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        brnError.setForeground(new java.awt.Color(255, 0, 0));
        brnError.setText("!Invalid Format (123-4567890)");
        jPanel7.add(brnError);
        brnError.setBounds(110, 200, 180, 13);

        jPanel3.add(jPanel7);
        jPanel7.setBounds(450, 340, 550, 260);

        register.setBackground(new java.awt.Color(255, 255, 255));
        register.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        register.setForeground(new java.awt.Color(0, 102, 0));
        register.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        register.setText("UPDATE");
        register.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        register.setOpaque(true);
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerMouseExited(evt);
            }
        });
        jPanel3.add(register);
        register.setBounds(410, 620, 140, 30);

        jLabel30.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 102, 0));
        jLabel30.setText("First Name: ");
        jPanel3.add(jLabel30);
        jLabel30.setBounds(470, 50, 100, 20);

        female.setForeground(new java.awt.Color(0, 102, 0));
        female.setText("Female");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });
        jPanel3.add(female);
        female.setBounds(830, 40, 115, 30);

        male.setForeground(new java.awt.Color(0, 102, 0));
        male.setText("Male");
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });
        jPanel3.add(male);
        male.setBounds(830, 70, 65, 30);

        jLabel28.setFont(new java.awt.Font("Microsoft YaHei", 0, 16)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 102, 0));
        jLabel28.setText("Company Logo:");
        jPanel3.add(jLabel28);
        jLabel28.setBounds(20, 80, 130, 30);

        comName.setBackground(new java.awt.Color(240, 240, 240));
        comName.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        comName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel3.add(comName);
        comName.setBounds(160, 10, 260, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 80, 1020, 670);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseClicked
        // TODO add your handling code here:   
        if(comName.getText().isEmpty()
            || busType.getText().isEmpty()
            || cLogo.getText().isEmpty()
            || number.getText().isEmpty()
            || email.getText().isEmpty()
            || web.getText().isEmpty()
            || fb.getText().isEmpty()
            || tag.getText().isEmpty()
            || ceoFname.getText().isEmpty()
            || ceoLname.getText().isEmpty()
            || c_Purok.getText().isEmpty()
            || c_Brgy.getText().isEmpty()
            || c_Mun.getText().isEmpty()
            || c_Zip.getText().isEmpty()
            || c_Prov.getText().isEmpty()
            || c_Country.getText().isEmpty()
            || noTIN.getText().isEmpty()
            || noBIR.getText().isEmpty()
            || noMayor.getText().isEmpty()
            || noBRN.getText().isEmpty()
            || noBIN.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "All Fields should be Filled");
        }else if(!validateEmail(email.getText())){
            JOptionPane.showMessageDialog(null, "Input Email Correctly!");
            email.setText("");
        }else if(!validateWebsite(web.getText())){
            JOptionPane.showMessageDialog(null, "Input Website Correctly!");
            web.setText("");
        }else if(!validatePhoneNumber(number.getText()) ){
            JOptionPane.showMessageDialog(null, "Input Number Correctly!");
            number.setText("");
        }else if(!validation(noTIN.getText(), "TIN")){
            JOptionPane.showMessageDialog(null, "Input TIN Number Correctly!");
            noTIN.setText("");
        }else if(!validation(noBIR.getText(), "BIR")){
            JOptionPane.showMessageDialog(null, "Input BIR Number Correctly!");
            noBIR.setText("");
        }else if(!validation(noMayor.getText(), "MAYORS_PERMIT")){
            JOptionPane.showMessageDialog(null, "Input Mayor's Permit Number Correctly!");
            noMayor.setText("");
        }else if(!validation(noBRN.getText(), "BRN")){
            JOptionPane.showMessageDialog(null, "Input BRN Number Correctly!");
            noBRN.setText("");
        }else if(!validation(noBIN.getText(), "BIN")){
            JOptionPane.showMessageDialog(null, "Input BIN Number Correctly!");
            noBIN.setText("");
        }else{
            if (male.isSelected()) {
                selectedGender = "Male";
            } else if (female.isSelected()) {
                selectedGender = "Female";
            }
    dbConnector db = new dbConnector();

    String tagText = tag.getText();

    // Insert company profile data with the image data
    if (db.insertData("INSERT INTO companyprofile (Company_Name, Business_Type, Company_Logo, Contact_Number, Email_Address,"
            + "Website, Facebook, Tagline, TIN_Number, BIR_Number, Mayors_Permit, BRN_Number, BIN_Number) "
            + "VALUES "
            + "('" + comName.getText() + "',"
            + " '" + busType.getText() + "',"
            + " '" + destination+ "',"
            + " '" + number.getText() + "',"
            + " '" + email.getText() + "',"
            + " '" + web.getText() + "',"
            + " '" + fb.getText() + "',"
            + " '" + tagText+ "',"
            + " '" + noTIN.getText() + "',"
            + " '" + noBIR.getText() + "',"
            + " '" + noMayor.getText() + "',"
            + " '" + noBRN.getText() + "',"
            + " '" + noBIN.getText() + "')")) {
        // Insert business address data
        if (db.insertData("INSERT INTO business_address (Purok, Baranggay, Municipality, ZIP_Code, Province, Country)"
                + " VALUES "
                + "('" + c_Purok.getText() + "',"
                + " '" + c_Brgy.getText() + "',"
                + " '" + c_Mun.getText() + "',"
                + " '" + c_Zip.getText() + "',"
                + " '" + c_Prov.getText() + "',"
                + " '" + c_Country.getText() + "')")) {
            // Insert CEO profile data
            if (db.insertData("INSERT INTO ceo_profile (CEO_FirstName, CEO_LastName, CEO_Gender)"
                    + " VALUES "
                    + "('" + ceoFname.getText() + "',"
                    + " '" + ceoLname.getText() + "',"
                    + " '" + selectedGender + "')")) {
            } else {
                JOptionPane.showMessageDialog(null, "Error inserting CEO profile data");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error inserting business address data");
        }
                try {
                    Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException ex) {
                    Logger.getLogger(Company_Profile.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "SAVE!", "Information", JOptionPane.INFORMATION_MESSAGE);
                admin ads = new admin();
                ads.setVisible(true);
                this.dispose();
    } else {
        JOptionPane.showMessageDialog(null, "Error inserting company profile data");
    }
        }
    }//GEN-LAST:event_registerMouseClicked

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed
        // TODO add your handling code here:
        if(female.isSelected()){
            selectedGender = "Female";
            male.setSelected(false);
        }
    }//GEN-LAST:event_femaleActionPerformed

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if(male.isSelected()){
            selectedGender = "Male";
            female.setSelected(false);
        }
    }//GEN-LAST:event_maleActionPerformed

    private void registerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseEntered
        // TODO add your handling code here:
        register.setBackground(navcolor);
    }//GEN-LAST:event_registerMouseEntered

    private void registerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseExited
        // TODO add your handling code here:
        register.setBackground(bodycolor);
    }//GEN-LAST:event_registerMouseExited

    private void cLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cLogoMouseClicked
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
                            cLogo.setText(path);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "File is not an Image", "Error", JOptionPane.ERROR_MESSAGE);
                        System.out.println("File Error!");
                    }
                }

    }//GEN-LAST:event_cLogoMouseClicked

    private void cLogoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cLogoMouseEntered
        // TODO add your handling code here:
        cLogo.setBackground(navcolor);
    }//GEN-LAST:event_cLogoMouseEntered

    private void cLogoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cLogoMouseExited
        // TODO add your handling code here:
        cLogo.setBackground(bodycolor);  
    }//GEN-LAST:event_cLogoMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> {
            new Company_Profile().setVisible(true);
        });
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Company_Profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel binError;
    private javax.swing.JLabel birError;
    private javax.swing.JLabel brnError;
    private javax.swing.JTextField busType;
    public javax.swing.JLabel cLogo;
    private javax.swing.JTextField c_Brgy;
    private javax.swing.JTextField c_Country;
    private javax.swing.JTextField c_Mun;
    private javax.swing.JTextField c_Prov;
    private javax.swing.JTextField c_Purok;
    private javax.swing.JTextField c_Zip;
    private javax.swing.JTextField ceoFname;
    private javax.swing.JTextField ceoLname;
    private javax.swing.JTextField comName;
    private javax.swing.JLabel emError;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fb;
    private javax.swing.JCheckBox female;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox male;
    private javax.swing.JTextField noBIN;
    private javax.swing.JTextField noBIR;
    private javax.swing.JTextField noBRN;
    private javax.swing.JTextField noMayor;
    private javax.swing.JTextField noTIN;
    private javax.swing.JLabel numError;
    private javax.swing.JTextField number;
    private javax.swing.JLabel permitError;
    private javax.swing.JLabel register;
    private javax.swing.JTextArea tag;
    private javax.swing.JLabel tinError;
    private javax.swing.JTextField web;
    private javax.swing.JLabel webError;
    // End of variables declaration//GEN-END:variables
}

