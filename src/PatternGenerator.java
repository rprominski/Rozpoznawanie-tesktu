import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class PatternGenerator {
    private static final String patternsFolderPath = "C:\\Users\\Rav\\Pictures\\patterns" ;

    public HashMap<String, LetterMatrix> generateAllPatterns(){
        HashMap<String,LetterMatrix> alfabet=new HashMap<String,LetterMatrix>();
        final File patternsFolder = new File(patternsFolderPath);
        File[] letterMatrixFolders = patternsFolder.listFiles();

        for(File folder : letterMatrixFolders){
            if(folder.isDirectory()){
                alfabet.put(folder.getName(),new LetterMatrix(patternsFolder+"\\"+folder.getName()));
            }
        }

        for(Map.Entry it : alfabet.entrySet()){
            System.out.println(it.getKey()+" "+it.getValue());
        }
        return alfabet;
    }
}
