package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        boolean first = true;
        byte second = Byte.MAX_VALUE;
        short third = 32767;
        int fifth = Integer.MIN_VALUE;
        long sixth = 9223372036854775807L;
        float seventh = 1.0f;
        double eighth = 2.0;

        char j = 'j';
        char a = 'a';
        char v = 'v';
        char d = 'd';
        char e = 'e';
        char t = 't';
        char k = 'k';
        char o = 'o';

        LOG.debug("\nThis is a reeeeeal debug baby:\n{}\n{}\n{}\n{}\n{}\n{}\n{}\n",
                first, second, third, fifth, sixth, seventh, eighth);
        LOG.debug("Короче, {}{}{} {}{}{}{} {}{}{}{}{}",
                e, t, o, j, a, v, a, d, e, t, k, a);
    }
}