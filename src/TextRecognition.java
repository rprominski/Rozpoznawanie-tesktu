import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class TextRecognition {

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            PatternCreator patternCreator = new PatternCreator();
        });
    }

}