import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class PatternGenerator {
    private static final String patternsFolderPath = "C:\\Users\\Rav\\Pictures\\patterns" ;

    public HashMap<String, Pattern> generateAllPatterns(){
        HashMap<String, Pattern> alfabet=new HashMap<String, Pattern>();
        final File patternsFolder = new File(patternsFolderPath);
        File[] letterMatrixFolders = patternsFolder.listFiles();

        for(File folder : letterMatrixFolders){
            if(folder.isDirectory()){
                alfabet.put(folder.getName(),new Pattern(patternsFolder+"\\"+folder.getName()));
            }
        }

        for(Map.Entry it : alfabet.entrySet()){
           // System.out.println(it.getKey()+" "+it.getValue());
        }
        return alfabet;
    }
}
