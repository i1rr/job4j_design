package ru.job4j.solid;

/**
 * Non SRP code.
 */
public class SRP {
    /**
     * Пример абстрактой айПи телефонии. Класс принимает звонки и делает звонки.
     * Создаёт коннект.
     * Автоответичк умеет использовать.
     */
    interface IpCall {
        void call();

        void receiveCall();
    }

    class Call implements IpCall {

        private void createConnection() {
        }

        private void autoResponse() {

        }

        @Override
        public void call() {
            createConnection();

        }

        @Override
        public void receiveCall() {
            createConnection();
            autoResponse();
        }
    }

    /**
     * VideoPlayer умеет воспроиводить, захватывать картинку в экране.
     */
    interface Player {
        void play();

        void record();
    }

    class VideoPlayer implements Player {
        @Override
        public void play() {

        }

        @Override
        public void record() {

        }
    }

    /**
     * Timer умеет вклчать таймер и сохранять его данные.
     */
    interface Timer {
        void start();

        void save();
    }

    public class RunTimer implements Timer {
        @Override
        public void start() {

        }

        @Override
        public void save() {

        }
    }
}
