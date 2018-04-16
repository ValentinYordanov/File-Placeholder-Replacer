package uni.sofia.bg.fmi.Replacers;

import java.util.Map;

public class StringReplacer {

    public static String replace(String text, Map<String, String> mapOfWords) {

        StringBuilder result = new StringBuilder(text);

        for (int i = 0; i < result.length(); i++) {

            if (result.charAt(i) == '{') {

                int tempBegin = i;
                i++;

                String word = "";

                while (result.charAt(i) != '}' && i < result.length()) {

                    word += result.charAt(i);
                    i++;
                }

                if (result.charAt(i) == '}') {
                    i++;
                   try {
                       result.replace(tempBegin, i, mapOfWords.get(word));
                   } catch (NullPointerException ex) {

                   }
                }

            }

        }

        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(StringReplacer.replace("Hello, {namE}", Map.of("name", "valentin")));
        StringBuilder a = new StringBuilder("Hello");
       // System.out.println(a.replace(1, 4, "zdr"));

    }

}
