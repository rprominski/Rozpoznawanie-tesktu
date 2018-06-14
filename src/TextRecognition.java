import java.awt.*;
import java.io.File;
import java.util.*;

public class TextRecognition {

    public static void main(String args[]) {
        if(args.length == 0) {
            EventQueue.invokeLater(() -> {
                RecognizeWindow recognizeWindow = new RecognizeWindow();
            });
            return;
        }
        if(args[0].equals("create")) {
            EventQueue.invokeLater(() -> {
                    String patternsFolderPath = (args.length>1 ? args[1] : "patterns");
                    PatternCreator patternCreator = new PatternCreator(patternsFolderPath);
            });
        }
        if(args[0].equals("test")) {
            String testedImagesPath = (args.length>1 ? args[1] : "testImages");
            String patternsFolderPath = (args.length>2 ? args[2] : "patterns");
            TextRecognizer textRecognizer = new TextRecognizer(patternsFolderPath);

            for (File folder : new File(testedImagesPath).listFiles()) {
                System.out.println(folder.getName() + " " + textRecognizer.recognize(ImageLoader.loadImage(testedImagesPath + "\\" + folder.getName())));
            }
        }
    }
}
