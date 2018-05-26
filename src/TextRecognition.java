import java.awt.*;
import java.io.File;
import java.util.*;

public class TextRecognition {

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            String path = "C:\\Users\\Rav\\Desktop\\M";
            TextRecognizer textRecognizer = new TextRecognizer();
            for(File folder : new File(path).listFiles()) {
            System.out.println(folder.getName() + " " + textRecognizer.recognize(ImageLoader.loadImage(path + "\\"+folder.getName())));
            }
        });
    }

}
