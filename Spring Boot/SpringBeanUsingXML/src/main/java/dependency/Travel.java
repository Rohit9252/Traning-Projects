package dependency;

public class Travel {

    Vehicle v;
    //simple type
    int numberOFPerson;

    //Constructor Injection


    public Travel(Vehicle v, int numberOFPerson) {
        this.v = v;
        this.numberOFPerson = numberOFPerson;
    }

    //setter injection point for numberOfPerson
    public void setNumberOFPerson(int numberOFPerson) {
        this.numberOFPerson = numberOFPerson;
    }
    //setter injection point for v
    public void setV(Vehicle v) {
        this.v=v;
    }
    public void journey() {
        v.go();
        System.out.println("Jounrney started...");
        System.out.println("number of person are :"+numberOFPerson);


    }
}
