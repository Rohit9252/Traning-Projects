package com.dependencyInversion;

public class AvoidDependencyInversion {

// if i need to switch off the table lamp then its not possible because the switch is directly dependent on the LightBulb
    public static void main(String[] args) {

    }


    // Bad Example - Violates DIP
    static  class LightBulb {
        void turnOn() {
            // Implementation
        }
        void turnOff() {
            // Implementation
        }
    }

    static  class Switch {
        private LightBulb bulb;  // Depends on concrete implementation

        public Switch() {
            bulb = new LightBulb();
        }

        void operate() {
            // Direct dependency on LightBulb
        }
    }
}


