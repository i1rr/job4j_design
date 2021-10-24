package ru.job4j.solid;

public class LSP {

    /**
     * Усиление условия в подклассе.
     */
    class Computer {
        private int batteryLevel;

        public Computer(int batteryLevel) {
            this.batteryLevel = batteryLevel;
        }

        public void energySavingMode() {
        }

        public void batterySavingMode(int batteryLevel) {
            if (batteryLevel < 20) {
                energySavingMode();
            }
        }

        class Laptop extends Computer {
            public Laptop(int batteryLevel) {
                super(batteryLevel);
            }

            public void batterySavingMode() {
                if (batteryLevel < 25) {
                    energySavingMode();
                }
            }
        }
    }

    /**
     * Ослабление условия.
     */

    class HealthyFood {
        private int calories;

        public HealthyFood(int calories) {
            this.calories = calories;
        }

        public boolean isHealthy(int calories) {
            if (calories > 2000) {
                return false;
            }
            return true;
        }
    }

    class Burger extends HealthyFood {
        public Burger(int calories) {
            super(calories);
        }

        public boolean isHealthy(int calories) {
            return true;
        }
    }

    /**
     * Нарушение инвариантности.
     */
    class SpeedLimit {
        private int kmh;

        public SpeedLimit(int kmh) {
            validate(kmh);
            this.kmh = kmh;
        }

        public void validate(int kmh) {
            if (kmh > 50) {
                throw new IllegalArgumentException("Speed limit exceeded");
            }
        }
    }

    class CitySpeedLimit extends SpeedLimit {
        public CitySpeedLimit(int kmh) {
            super(kmh);
        }
    }
}
