import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TextRecognizer {
    HashMap<String, Pattern> patterns;

    public TextRecognizer(String patternsFolderPath) {
        PatternGenerator patternGenerator = new PatternGenerator(patternsFolderPath);
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

        int candidats = 5;
        similarities = new ArrayList<>(similarities.subList(0,candidats));

        Collections.sort(similarities,new PercentageSimilarityComparatorByPatternImage());

        return similarities.get(0).patternName+" "+similarities.get(1).patternName+" "+similarities.get(2).patternName+" "+similarities.get(3).patternName+" "+similarities.get(4).patternName;
    }
}
