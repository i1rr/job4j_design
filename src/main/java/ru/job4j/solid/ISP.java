package ru.job4j.solid;

/**
 * Examples of breaking ISP (Interface Segregation Principle)
 */
public class ISP {

    /**
     * Этот интерфейс очень специфичен и скорей всего избыточен для других классов.
     */
    public interface Wash {
        void withSoap();

        void withoutSoap();

        void dry();

        void rinse();

        void restart();
    }

    /**
     * Методы этого интерфейса в 99.9% случаев не имеют связи в какой либо сиуации.
     */
    public interface Fly {
        void toTheMoon();

        void toTheHolidays();

        void offTheCliff();
    }

    /**
     * Как и в предыдущем примере, эти методы крайне сложно использовать вместе
     * и скорее всего будут избыточными.
     */
    public interface Share {
        void data();

        void cheeseCake();
    }
}
