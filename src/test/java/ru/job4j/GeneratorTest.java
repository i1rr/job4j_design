package ru.job4j;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GeneratorTest {

    @Test
    public void whenNameAndSubjThenPetrAndYou() {
        HashMap<String, String> args = new HashMap<>(Map.of(
                "name", "Petr",
                "subject", "you"));

        Generator gen = new ChatGenerator();
        String template = "I am a ${name}, Who are ${subject}? ";
        String expected = "I am a Petr Arsentev, Who are you? ";
        assertThat(gen.produce(template, args), is(expected));
    }

    @Test(expected = WrongKeyException.class)
    public void whenTemplateHasWrongKey() {
        HashMap<String, String> args = new HashMap<>(Map.of(
                "name", "Petr",
                "subject", "you"));

        Generator gen = new ChatGenerator();
        String template = "I am a ${nickName}, Who are ${subject}? ";
        String rsl = gen.produce(template, args);
    }

    @Test(expected = UnusedMapKeyException.class)
    public void whenMapHasUnusedKey() {
        HashMap<String, String> args = new HashMap<>(Map.of(
                "name", "Petr",
                "subject", "you",
                "address", "planetEarth"));

        Generator gen = new ChatGenerator();
        String template = "I am a ${name}, Who are ${subject}? ";
        String rsl = gen.produce(template, args);
    }
}