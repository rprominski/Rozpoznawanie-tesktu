import java.awt.image.BufferedImage;
import java.io.File;

public class Pattern {
    String pathToPatternsFolder;
    final int height=100;
    final int weight=100;
    public double[][] pixelAppearances;
    File[] patterns;

    public Pattern(String pathToPatternsFolder) {
        this.pathToPatternsFolder = pathToPatternsFolder;
        patterns = new File(pathToPatternsFolder).listFiles();
        pixelAppearances = new double[height][weight];
        generatePattern();
    }

    public void generatePattern() {
        for(File pattern : patterns){
            ImageLoader imageLoader = new ImageLoader();
            BufferedImage patternImage = imageLoader.loadImage(pattern.getAbsolutePath());
            addPaternPixelAppearances(patternImage);
        }

        double minimalPercentageAppearance=5;
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                if(pixelAppearances[j][i]>minimalPercentageAppearance) {
                    pixelAppearances[j][i] = 100;
                }
                else {
                    pixelAppearances[j][i] = 0;
                }
            }
        }
    }

    public void addPaternPixelAppearances(BufferedImage patternImage){
        for(int i = 0; i < height; i++) {
            for(int j = 0; j < weight; j++) {
                Color color = new Color(patternImage.getRGB(j,i));
                pixelAppearances[j][i] += color.getPercantageSimilarityToBlack()/(double)patterns.length;
            }
        }
    }

    public PercentageSimilarity getLetterSimilarityToPattern(BufferedImage letter) {
        double testedLetterPixelsHits = 0;
        double testedLetterAllPixels = 0;
        double patternPixelsHits = 0;
        double patternAllPixels = 0;
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight; j++) {
                Color color = new Color(letter.getRGB(j, i));
                
                if((color.getPercantageSimilarityToBlack()>0)) {
                    testedLetterAllPixels++;
                    if(pixelAppearances[j][i]==100){
                        testedLetterPixelsHits++;
                    }
                }
                if(pixelAppearances[j][i]==100) {
                    patternAllPixels++;
                    if ((color.getPercantageSimilarityToBlack() > 0)) {
                        patternPixelsHits++;
                    }
                }
            }
        }
 
        PercentageSimilarity percentageSimilarity = new PercentageSimilarity();
        percentageSimilarity.testedImage = testedLetterPixelsHits/testedLetterAllPixels;
        percentageSimilarity.patternImage = patternPixelsHits/patternAllPixels;
        return percentageSimilarity;
    }

    public void setPathToPatternsFolder(String pathToPatternsFolder) {
        this.pathToPatternsFolder = pathToPatternsFolder;
    }
}
