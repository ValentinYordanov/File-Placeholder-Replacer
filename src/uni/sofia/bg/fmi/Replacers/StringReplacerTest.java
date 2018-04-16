package uni.sofia.bg.fmi.Replacers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;
import static uni.sofia.bg.fmi.Replacers.StringReplacer.*;

public class StringReplacerTest {

    @Test
    public void basicTests() {

        assertEquals("Basic test1: replacing a single word", "Hello, Valentin", replace("Hello, {name}", Map.of("name", "Valentin")));
        assertEquals("Basic test2: replacing a word not in the map", "Hello, {Name}", replace("Hello, {Name}", Map.of("name", "Valentin")));
        assertEquals("Basic test3: replacing 2 words", "Hello, Valentin Yordanov", replace("Hello, {name} {SecondName}", Map.of("name", "Valentin", "SecondName", "Yordanov")));
        assertEquals("Basic test4: replacing 2 words, 1 in the map & 1 not", "Hello, {Name} Yordanov", replace("Hello, {Name} {SecondName}", Map.of("name", "Valentin", "SecondName", "Yordanov")));

    }

}