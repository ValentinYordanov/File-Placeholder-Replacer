package uni.sofia.bg.fmi.Replacers;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;
import static uni.sofia.bg.fmi.Replacers.StringReplacer.*;

public class StringReplacerTest {

    @Test
    public void basicTests() {

        assertEquals("Basic tests not working", "Hello, Valentin", replace("Hello, {name}", Map.of("name", "Valentin")));
        assertEquals("Basic tests not working2", "Hello, {Name}", replace("Hello, {Name}", Map.of("name", "Valentin")));
        assertEquals("Basic tests not working3", "Hello, Valentin Yordanov", replace("Hello, {name} {SecondName}", Map.of("name", "Valentin", "SecondName", "Yordanov")));
        assertEquals("Basic tests not working3", "Hello, {Name} Yordanov", replace("Hello, {Name} {SecondName}", Map.of("name", "Valentin", "SecondName", "Yordanov")));

    }

}