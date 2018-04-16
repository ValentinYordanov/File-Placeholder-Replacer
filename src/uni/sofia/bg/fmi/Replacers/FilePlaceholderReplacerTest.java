package uni.sofia.bg.fmi.Replacers;

import org.junit.Test;

import java.io.*;
import java.util.Map;

import static org.junit.Assert.*;

public class FilePlaceholderReplacerTest {

    @Test
    public void fileplaceholderTest() throws IOException {

        File file1 = new File("test.txt");
        File file2 = new File("result.txt");

        PrintWriter pw = new PrintWriter(file1);
        pw.println("Hello, {name}! How are you {date}");

        pw.close();

        FilePlaceholderReplacer.replace("test.txt", "result.txt", Map.of("name", "Valentin", "date", "today"));

        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String line;
            while((line = br.readLine()) != null) {
                assertEquals("something is not translating right (true translating test)", "Hello, Valentin! How are you today", line);
            }

        }

        file1.delete();
        file2.delete();
    }

    @Test
    public void fileplaceholderTest2() throws IOException {

        File file1 = new File("test.txt");
        File file2 = new File("result.txt");

        PrintWriter pw = new PrintWriter(file1);
        pw.println("Hello, {name}! How are you {date}");

        pw.close();

        FilePlaceholderReplacer.replace("test.txt", "result.txt", Map.of("name", "Valentin", "Date", "today"));

        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String line;
            while((line = br.readLine()) != null) {
                assertEquals("something is not translating right(false translating)", "Hello, Valentin! How are you {date}", line);
            }

        }

        file1.delete();
        file2.delete();
    }
}