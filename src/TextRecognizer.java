import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
//ImageLoader.loadImage("C:\\Users\\Rav\\Desktop\\M\\2.jpg"
public class TextRecognizer {
    HashMap<String, Pattern> patterns;

    public TextRecognizer() {
        PatternGenerator patternGenerator = new PatternGenerator();
        patterns = patternGenerator.generateAllPatterns();
    }

    String recognize(BufferedImage letter) {
        ArrayList<PercentageSimilarity> similarities = new ArrayList<>();

        for(Map.Entry it : patterns.entrySet()) {
            Pattern pattern = (Pattern) it.getValue();
            PercentageSimilarity percentageSimilarity = pattern.getLetterSimilarityToPattern(letter);
            percentageSimilarity.patternName = (String) it.getKey();
            similarities.add(percentageSimilarity);
        }

        Collections.sort(similarities,new PercentageSimilarityComparatorByTestedImage());

        int candidats = 3;
        similarities = new ArrayList<>(similarities.subList(0,candidats));

        Collections.sort(similarities,new PercentageSimilarityComparatorByPatternImage());

        return similarities.get(0).patternName;
    }
}
