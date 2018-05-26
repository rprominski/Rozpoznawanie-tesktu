import java.util.Comparator;

public class PercentageSimilarity {
    double testedImage;
    double patternImage;
    String patternName;

}

class PercentageSimilarityComparatorByTestedImage implements Comparator<PercentageSimilarity> {
    @Override
    public int compare(PercentageSimilarity a, PercentageSimilarity b) {
        if(a.testedImage < b.testedImage)
            return 1;
        return -1;
    }
}

class PercentageSimilarityComparatorByPatternImage implements Comparator<PercentageSimilarity> {
    @Override
    public int compare(PercentageSimilarity a, PercentageSimilarity b) {
        if(a.patternImage < b.patternImage)
            return 1;
        return -1;
    }
}