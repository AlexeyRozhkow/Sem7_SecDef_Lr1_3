import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DigramsCounter {
    HashMap<String, Double> create (ArrayList<String> textArray) {
        HashMap<String, Double> digramsTable = new HashMap<>();
        long size = 0;
        for(String text : textArray) {
            for(int i=0; i<text.length()-1; i++){
                String digram = text.substring(i, i+2);
                Matcher matcher = Pattern.compile("^[а-я|А-Я|Ё|ё]{2}$").matcher(digram);              //^[а-я]$

                if(matcher.find()){
                    if(digramsTable.containsKey(digram)){
                        digramsTable.put(digram, digramsTable.get(digram) + 1);
                    }else {
                        digramsTable.put(digram, 1.0);
                    }

                }
                size++;
            }
        }
        for(Map.Entry<String, Double> digram : digramsTable.entrySet()){
            digramsTable.put(digram.getKey(), 100 * digram.getValue() / size);
        }

        return  digramsTable;
    }
}
