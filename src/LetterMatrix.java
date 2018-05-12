import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LetterMatrix {
    private String pathToPatternsFolder;
    final int height=100;
    final int weight=100;
    public double[][] matrix;
    File[] patterns;

    public LetterMatrix() {
    }

    public LetterMatrix(String pathToPatternsFolder) {
        this.pathToPatternsFolder = pathToPatternsFolder;
        patterns = new File(pathToPatternsFolder).listFiles();
        matrix = new double[height][weight];
    }

    public void generatePattern() {
        System.out.println(patterns.length);
        for(File pattern : patterns){
            ImageLoader imageLoader = new ImageLoader();
            BufferedImage patternImage = imageLoader.loadImage(pattern.getAbsolutePath());
            addPaternPixelValuesToMatrix(patternImage);
        }
    }

    public void addPaternPixelValuesToMatrix(BufferedImage patternImage){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < weight; j++){
                Color color = new Color(patternImage.getRGB(j,i));
                matrix[j][i] += color.getPercantageSimilarityToBlack()/(double)patterns.length;
            }
        }
    }

    public double getLetterSimilarityToPattern(BufferedImage letter) {
        int similarity = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight; j++) {
                Color color = new Color(letter.getRGB(j, i));
                similarity += color.getPercantageSimilarityToBlack()*matrix[j][i];
            }
        }
        return similarity;
    }

    public void setPathToPatternsFolder(String pathToPatternsFolder) {
        this.pathToPatternsFolder = pathToPatternsFolder;
    }
}
