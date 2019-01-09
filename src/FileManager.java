import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
    ArrayList<String> read(String fileDirectory){
        ArrayList<String> stringsArray = new ArrayList<>();

        try (BufferedReader buffRead = new BufferedReader(new FileReader(fileDirectory))) {
            String tmp;
            while ((tmp = buffRead.readLine()) != null) {
                stringsArray.add(tmp);
            }
        } catch (IOException e) {
            System.err.println('\n' + "File not found in this Directory: " + fileDirectory);
            System.exit(404);
        }
        return stringsArray;
    }
}
