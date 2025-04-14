// Base class
// TODO: Define a class called Animal with:
// - A protected String field called name
// - A constructor that takes a name and assigns it
// - A public void method called speak() that prints a generic sound
// - Override toString() to return "Animal: " + name
// - Override equals(Object o) to compare names if o is an Animal
class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void speak() {
        System.out.println("Generic sound playing...");
    }

    @Override
    public String toString() {
        return "Animal: " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Animal) {
            Animal other = (Animal) o;
            return this.name.equals(other.name);
        }
        return false;
    }
}
// Subclass
// TODO: Define a class called Mammal that extends Animal with:
// - A protected boolean field called warmBlooded (set to true)
// - A protected String field called dietType (e.g., "herbivore")
// - A protected int field called numLegs (e.g., 4)
// - A protected String field called sound (e.g., "growl")
// - A constructor that uses super to set name and sets these fields
// - Override speak() to print the value of sound prefixed by name
class Mammal extends Animal {
    protected boolean warmBlooded = true;
    protected String dietType;
    protected int numLegs;
    protected String sound;

    public Mammal(String name, boolean warmBlooded, String dietType, int numLegs, String sound) {
        super(name);
        this.warmBlooded = warmBlooded;
        this.dietType = dietType;
        this.numLegs = numLegs;
        this.sound = sound;
    }

    @Override
    public void speak() {
        System.out.println(name + " says: " + sound);
    }
}
// Subclasses of Mammal
// TODO: Define a class Dog that extends Mammal
// - Constructor takes name and passes name, true, "omnivore", 4, "Woof!" to super
// - Override speak() to print "<name> says: Woof!"
class Dog extends Mammal {
    public Dog(String name) {
        super(name, true, "omnivore", 4, "Woof!");
    }

    @Override
    public void speak() {
        System.out.println(name + " says: Woof!");
    }
}
// TODO: Define a class Cat that extends Mammal
// - Constructor takes name and passes name, true, "carnivore", 4, "Meow!" to super
// - Override speak() to print "<name> says: Meow!"
class Cat extends Mammal {
    public Cat(String name) {
        super(name, true, "carnivore", 4, "Meow!");
    }

    @Override
    public void speak() {
        System.out.println(name + " says: Meow!");
    }
}
// TODO: Define a final class Human that extends Mammal
// - Constructor takes name and passes name, true, "omnivore", 2, "Hello!" to super
final class Human extends Mammal {
    public Human(String name) {
        super(name, true, "omnivore", 2, "Hello!");
    }
}
// TODO: Define a class Reptile that extends Animal
// - Add fields: boolean warmBlooded (set to false), int numLegs, String dietType, String sound
// - Constructor should take all values and use super for name
// - Override speak() to print the value of sound prefixed by name
class Reptile extends Animal {
    boolean warmBlooded = false;
    int numLegs;
    String dietType;
    String sound;

    public Reptile(String name, boolean warmBlooded, int numLegs, String dietType, String sound) {
        super(name);
        this.warmBlooded = warmBlooded;
        this.numLegs = numLegs;
        this.dietType = dietType;
        this.sound = sound;
    }

    @Override
    public void speak() {
        System.out.println(name + " says: " + sound);
    }
}


// Main class to test
// TODO: Define class AnimalKingdomTest with a main method
// - Create Animal a1 = new Dog("Buddy")
// - Create Animal a2 = new Cat("Whiskers")
// - Call speak() on both (demonstrating polymorphism)
// - Print both using System.out.println
// - Use equals() to compare a1 to a new Dog("Buddy")
class AnimalKingdomTest {
    public static void main(String[] args) {
        Animal a1 = new Dog("Buddy");
        Animal a2 = new Cat("Whiskers");

        a1.speak();
        a2.speak();
        System.out.println(a1);
        System.out.println(a2);

        System.out.println(a1.equals(new Dog("Buddy")));    
    }
}

// Additional TODOs:
// 1. Create a new subclass of Animal (e.g., Bird) and override speak()

class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println(name + " says: Chirp!");
    }
}

// 2. Try to extend Human – what happens and why?

class Vir extends Human {
    public Vir(String name) {
        super(name);
    }
}
// Human cannot be inherited from because it is a final class.

// 3. Override equals() in Dog or Cat to also check the type



// 4. Add a method to Mammal called performTrick() and call it via downcasting


