class Bird {
    protected String name;

    public Bird(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " is eating");
    }
}

// Interface for flying behavior
interface Flyable {
    void fly();
}

// Eagle can fly, so it implements Flyable
class Eagle extends Bird implements Flyable {
    public Eagle(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying");
    }
}

// Penguin is a Bird, but not Flyable
class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }

    // No fly() method here — no LSP violation
}

// BirdTest class using LSP-safe design
class BirdTest {

    public static void main(String[] args) {
        Eagle eagle = new Eagle("Golden Eagle");
        Penguin penguin = new Penguin("Emperor Penguin");

        eagle.fly();// OK

        // penguin.fly(); // ❌ Compile-time error if uncommented — which is good!
        penguin.eat(); // Still works fine
    }

}
