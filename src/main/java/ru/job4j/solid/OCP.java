package ru.job4j.solid;

/**
 * Non OCP code.
 */
public class OCP {
    class Airplane {
        public void fly() {
        }
    }

    class JetPack extends Airplane {
        @Override
        public void fly() {
            /**
             * JetPack может летать но нарушено состояние объекта. Ранец и самолёт разные вещи.
             */
        }
    }

    class Villa {
        /**
         * Класс вилла  не расширяется, т.к. чётко обозначено состояние. Правильно было бы
         * привести к общему названию. Например Property.
         */
    }

    interface Sizable {
        void increaseLength();
    }

    class Length implements Sizable {
        @Override
        public void increaseLength() {
            /**
             * Тут опять же метод имеет слишком сильное состояние для интерфейса с таким названием.
             * Правильно было бы назвать метод просто increase либо resize;
             */
        }
    }
}
