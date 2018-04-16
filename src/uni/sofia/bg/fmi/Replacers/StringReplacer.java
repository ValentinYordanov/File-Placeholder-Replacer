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
                        i--;
                        continue;
                    }
                    i = result.indexOf(mapOfWords.get(word)) + mapOfWords.get(word).length() - 1;
                }

            }

        }

        return result.toString();
    }

}
