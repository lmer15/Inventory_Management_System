
package Config;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class insertImage {

    public int FileExistenceChecker(String path){
            File file = new File(path);
            String fileName = file.getName();

            Path filePath = Paths.get("src/ProductImages", fileName);
            boolean fileExists = Files.exists(filePath);

            if (fileExists) {
                return 1;
            } else {
                return 0;
            }

    }


        public static int getHeightFromWidth(String imagePath, int desiredWidth) {
                try {
                    // Read the image file
                    File imageFile = new File(imagePath);
                    BufferedImage image = ImageIO.read(imageFile);

                    // Get the original width and height of the image
                    int originalWidth = image.getWidth();
                    int originalHeight = image.getHeight();

                    // Calculate the new height based on the desired width and the aspect ratio
                    int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);

                    return newHeight;
                } catch (IOException ex) {
                    System.out.println("No image found!");
                }

                return -1;
            }

        //--------------------------------------------------------------------------------------

        public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
            ImageIcon MyImage = null;
                if(ImagePath !=null){
                    MyImage = new ImageIcon(ImagePath);
                }else{
                    MyImage = new ImageIcon(pic);
                }

            int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

            Image img = MyImage.getImage();
            Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
            ImageIcon image = new ImageIcon(newImg);
            return image;
        }




}
