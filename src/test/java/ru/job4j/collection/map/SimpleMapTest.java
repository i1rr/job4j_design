package ru.job4j.collection.map;

import org.junit.Test;
import java.util.Calendar;
import java.util.ConcurrentModificationException;
import java.util.GregorianCalendar;
import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void whenPutSameKey() {
        SimpleMap<User, String> sMap = new SimpleMap<>();
        Calendar dob = new GregorianCalendar(1922, Calendar.JANUARY, 31);
        User petja = new User("Petja", 2, dob);
        User vasja = new User("Vasja", 1, dob);
        sMap.put(petja, "Petja1");
        sMap.put(vasja, "Vasja");
        assertTrue(sMap.put(petja, "Petja2"));
        assertThat(sMap.get(petja), is("Petja2"));
    }

    @Test
    public void whenPut100Times() {
        SimpleMap<User, String> sMap = new SimpleMap<>();
        for (int i = 0; i < 100; i++) {
            sMap.put(new User(i), "test: " + i);
        }
        System.out.println("When put 100 times test: " + System.lineSeparator()
                + "There are " + sMap.size() + " items in table.");
    }

    @Test
    public void whenGet3TimesAndOverridePetja() {
        SimpleMap<User, String> sMap = new SimpleMap<>();
        Calendar dob = new GregorianCalendar(1922, Calendar.JANUARY, 31);
        User petja = new User("Petja", 2, dob);
        User vasja = new User("Vasja", 1, dob);
        User epifan = new User("Epifan", 18, dob);
        sMap.put(petja, "Petja1");
        sMap.put(vasja, "Vasja");
        sMap.put(petja, "Petja2");
        sMap.put(epifan, "Epifan");
        assertThat(sMap.get(petja), is("Petja2"));
        assertThat(sMap.get(epifan), is("Epifan"));
        assertThat(sMap.get(vasja), is("Vasja"));
    }

    @Test
    public void whenGetNull() {
        SimpleMap<User, String> sMap = new SimpleMap<>();
        assertNull(sMap.get(new User(44)));
    }

    @Test
    public void whenRemovePetjaIsTrueAndNull() {
        SimpleMap<User, String> sMap = new SimpleMap<>();
        Calendar dob = new GregorianCalendar(1922, Calendar.JANUARY, 31);
        User petja = new User("Petja", 2, dob);
        User vasja = new User("Vasja", 1, dob);
        User epifan = new User("Epifan", 18, dob);
        sMap.put(petja, "Petja1");
        sMap.put(vasja, "Vasja");
        sMap.put(petja, "Petja2");
        sMap.put(epifan, "Epifan");
        assertTrue(sMap.remove(petja));
        assertNull(sMap.get(petja));
    }

    @Test
    public void whenRemoveFalse() {
        SimpleMap<User, String> sMap = new SimpleMap<>();
        assertFalse(sMap.remove(new User(1)));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIterToConcurrentException() {
        SimpleMap<User, String> sMap = new SimpleMap<>();
        Calendar dob = new GregorianCalendar(1922, Calendar.JANUARY, 31);
        User petja = new User("Petja", 2, dob);
        User vasja = new User("Vasja", 1, dob);
        User epifan = new User("Epifan", 18, dob);
        sMap.put(petja, "Petja1");
        sMap.put(vasja, "Vasja");
        sMap.put(petja, "Petja2");
        sMap.put(epifan, "Epifan");
        Iterator<SimpleMap.MapEntry<User, String>> it = sMap.iterator();
        it.next();
        it.next();
        sMap.put(vasja, "Vasja2");
        it.next();
    }

    @Test
    public void whenIterate() {
        SimpleMap<User, String> sMap2 = new SimpleMap<>();
        Calendar dob = new GregorianCalendar(1922, Calendar.JANUARY, 31);
        User petja = new User("Petja", 2, dob);
        User vasja = new User("Vasja", 1, dob);
        User epifan = new User("Epifan", 18, dob);
        sMap2.put(petja, "Petja");
        sMap2.put(vasja, "Vasja");
        sMap2.put(epifan, "Epifan");
        Iterator<SimpleMap.MapEntry<User, String>> it = sMap2.iterator();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        assertFalse(it.hasNext());
    }
}