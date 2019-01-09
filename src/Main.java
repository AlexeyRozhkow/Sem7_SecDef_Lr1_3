import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String Source = "C:\\SecDef\\Source1.txt";

        FileManager fileManager = new FileManager();
        CharCounter CC = new CharCounter();
        DigramsCounter DC = new DigramsCounter();
        LinkedHashMap<Character, Double> sourceI;
        LinkedHashMap<String, Double> sourceII;

        ArrayList<String> source = fileManager.read(Source);

        sourceI = valueSort(CC.create(source),false);
        System.out.println(printMapC(sourceI));
        System.out.println('\n' + "Всего  " + sourceI.size() + " cимвола");
        for ( int i = 0; i < 6; ++i ) {System.out.println();}

        sourceII = valueSort(DC.create(source), false);
        System.out.println(printMapS(sourceII));
        System.out.println('\n' + "Всего  " + sourceII.size() + " биграммы");
        for ( int i = 0; i < 6; ++i ) {System.out.println();}

    }

    //////////////////////////////////////
    private static  <K, V extends Comparable<? super V>>LinkedHashMap<K,V> valueSort(Map<K, V> Map , boolean ASC){
        List<Map.Entry<K,V>> list = new LinkedList<>(Map.entrySet());
        LinkedHashMap<K,V> result = new LinkedHashMap<>();

        list.sort(new Comparator<java.util.Map.Entry<K, V>>() {
            @Override
            public int compare(java.util.Map.Entry<K, V> o1, java.util.Map.Entry<K, V> o2) {
                if(ASC){
                    return o1.getValue().compareTo(o2.getValue());
                }
                else {
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });

        for (Map.Entry<K,V>entry : list){
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    private static String printMapC(HashMap<Character, Double> map) {
        int size = 0;
        StringBuilder sb = new StringBuilder();

        sb.append("{");
        for (Character ch : map.keySet()) {

            sb.append(ch);
            sb.append(" ↦ ");
            sb.append(map.get(ch));
            sb.append("%");
            if (size != map.size() - 1) {
                sb.append(",");
                sb.append('\n');
            }
            size++;
        }
        sb.append(" }");
        return sb.toString();
    }

    private static String printMapS(HashMap<String, Double> map) {
        int size = 0;
        StringBuilder sb = new StringBuilder();

        sb.append("{");
        for (String st : map.keySet()) {
            sb.append(st);
            sb.append(" ↦ ");
            sb.append(map.get(st));
            sb.append("%");
            if (size != map.size() - 1) {
                sb.append(",");
                sb.append('\n');
            }
            size++;
        }
        sb.append(" }");
        return sb.toString();
    }
}