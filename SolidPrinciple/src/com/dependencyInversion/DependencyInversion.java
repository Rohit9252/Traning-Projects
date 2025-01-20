package com.dependencyInversion;

public class DependencyInversion {

    public static void main(String[] args) {
        Switchable lightBulb = new LightBulb();
        Switchable fan = new Fan();

        Switch bulbSwitch = new Switch(lightBulb);
        Switch fanSwitch = new Switch(fan);

        bulbSwitch.device.turnOff();

    }
}



interface Switchable {
    void turnOn();
    void turnOff();
}




class LightBulb implements Switchable {
    public void turnOn() {
        // Implementation
        System.out.println("LightBulb: Light turned on...");
    }
    public void turnOff() {
        // Implementation
        System.out.println("LightBulb: Light turned off...");
    }
}


class Fan implements Switchable {
    public void turnOn() {
        // Implementation
        System.out.println("Fan: Fan turned on...");
    }
    public void turnOff() {
        // Implementation
        System.out.println("Fan: Fan turned off...");
    }
}

class Switch {
     Switchable device;  // Depends on abstraction

    public Switch(Switchable device) {
        this.device = device;
    }


}