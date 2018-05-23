import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {
    public static BufferedImage loadImage(String path){
        BufferedImage image=null;
        try {
            image = ImageIO.read(new File(path));
        } catch(IOException ex){

        }
        return image;
    }

    public static Boolean saveImage(String path, Image image){
        try{
            BufferedImage bufferedImage = (BufferedImage) image;
            File outputfile = new File(path);
            ImageIO.write(bufferedImage,"jpg",outputfile);
            return true;
        } catch(IOException ex) {
            return false;
        }
    }
}
