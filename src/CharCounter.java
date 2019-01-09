import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CharCounter {
    HashMap<Character, Double> create (ArrayList<String> textArray) {
        HashMap<Character, Double> countTable = new HashMap<>();
        long size = 0;
        for(String text : textArray) {
            for(int i=0; i<text.length(); i++){
                String chars = text.substring(i, i+1);
                Character letter = chars.charAt(0);
                Matcher matcher = Pattern.compile("^[а-я|А-я|Ё|ё]$").matcher(chars);              //^[а-я]$

                if(matcher.find()){
                    if(countTable.containsKey(letter)){
                        countTable.put(letter, countTable.get(letter) + 1);
                    }else {
                        countTable.put(letter, 1.0);
                    }

                }
                size++;
            }
        }
        for(Map.Entry<Character, Double> letter : countTable.entrySet()){
            countTable.put(letter.getKey(), 100 * letter.getValue() / size);
        }

        return  countTable;
    }
}
