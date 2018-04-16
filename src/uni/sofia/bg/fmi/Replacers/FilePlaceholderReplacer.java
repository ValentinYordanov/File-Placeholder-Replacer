package uni.sofia.bg.fmi.Replacers;

import java.io.*;
import java.util.Map;

public class FilePlaceholderReplacer {

    public static void replace(String fromFile, String toFile, Map<String, String> mapOfWords) {

        File fileFrom = new File(fromFile);
        File fileTo = new File(toFile);
        try (BufferedReader br = new BufferedReader(new FileReader(fileFrom))) {
            String line;
            PrintWriter pw = new PrintWriter(fileTo);
            while ((line = br.readLine()) != null) {

                System.out.println(StringReplacer.replace(line, mapOfWords));
                pw.println(StringReplacer.replace(line, mapOfWords));
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        FilePlaceholderReplacer.replace("a.txt", "asd.txt", Map.of("name", "Valentin", "second", "Yuliana"));

    }

}
