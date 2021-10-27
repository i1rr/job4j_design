package ru.job4j.solid;

/**
 * Examples of faulty DIP. (Dependency Inversion Principle)
 */
public class DIP {
    public class ConnectionToDB {
        /**
         * подключение к БД.
         * Такой класс нельзя испольовать в коде напрямую, т.к. при расширении придётся
         * изменять сам код. Он должен быть имплементирован от интерфейса.
         */
    }

    public class Robot {
        private void answer() {
            System.out.println("bla bla bla");
        }
        /**
         * System.out.pintln - это вывод имеющий сильную зависимость с консолью.
         * Должен работать через интерфейс.
         */
    }

    public class PieBakery {
        private void bakePie() {
            /**
             * этот метод и класс будет крайне трудно расширять. Нужен интерфейс Bakery
             * с методом Bake() а наш класс уже имплементировать от него, и передавать в
             * метод уже определенный тип продукции.
             */
        }
    }
}
