// SuperStore Exercise: Access Modifiers & Object Modeling Focus

// TODO: Define a class called Product with:
// - A protected String field called name
// - A protected double field called price
// - A private final int productId
// - A public static int nextId to help generate unique IDs
// - A constructor that sets name, price, and assigns a unique ID
// - Public getters for all fields
// - Override toString() to return formatted product details
// - Override equals(Object o) to compare name and productId
class Product {
    protected String name;
    protected double price;
    private final int productId;
    public static int nextId;
    
    public Product(String name, double price, int nextId) {
        this.name = name;
        this.price = price;
        this.productId = nextId++;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getProductId() {
        return productId;
    }

    public static int getNextId() {
        return nextId;
    }

    @Override
    public String toString() {
        return String.format(); // fill this in later
    }

    @Override
    public boolean equals(Object o) {
        // fill this in later
    }

}

// TODO: Define a subclass Electronics that extends Product
// - Add a private String field called brand
// - Add a private boolean field called hasBattery
// - Constructor takes all fields and uses super for shared ones
// - Override toString() to include brand and battery status
class Electronics extends Product {
    private String brand;
    private boolean hasBattery;

    public Electronics(String name, double price, int nextId, String brand, boolean hasBattery) {
        super(name, price, nextId);
    }

    @Override
    public String toString() {
        return ; // fill this in later
    }

    final void warrantyInfo() {
        System.out.println("Warranty info: " + "blahblahblahblahblah");
    }

}

// TODO: Define a subclass Grocery that extends Product
// - Add a private double field called weight (in kg)
// - Add a private boolean field called isPerishable
// - Constructor takes all fields and uses super for shared ones
// - Override toString() to include weight and perishability
class Grocery extends Product {
    private double weight;
    private boolean isPerishable;

    public Grocery(String name, double price, int nextId, double weight, boolean isPerishable) {
        super(name, price, nextId);
    }

    @Override
    public String toString() {
        return ; // fill this in later
    }
}

// TODO: Define a final class Toy that extends Product
// - Add a private int field called minAge
// - Constructor takes all fields and uses super for shared ones
// - Override toString() to include minAge
final class Toy extends Product {
    private int minAge;

    public Toy(String name, double price, int nextId, int minAge) {
        super(name, price, nextId);
    }

    @Override
    public String toString() {
        return ; // fill this in later
    }
}


// TODO: Define class SuperStoreTest with a main method
// - Create at least one instance of each subclass
// - Store them in a Product[] array
// - Loop through and print each item
// - Call equals() to compare two products with the same ID and name
class SuperStoreTest {
    public static void main(String[] args) {
        Product product = new Product("Generic Product", 9.99, 1);
        Electronics phone = new Electronics("iPhone", 999.99, 2, "Apple", true);
        Grocery milk = new Grocery("Milk", 5.00, 3, 3.9, true);
        Toy uhhh = new Toy("REDACTED", 69.42, 4, 18); // 😈
        Product[] products = {product, phone, milk, uhhh};

        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i]);
        }

        System.out.println(); // fill this in later

    }
}


// Additional TODOs:
// 1. Try to extend Toy — what happens and why?

class lego extends Toy {

}

// It says that Toy cannot be applied to this because Toy is a final class.

// 2. Make a class Coupon with a final discountRate and apply it to a Product

class Coupon {
    final static double discountRate;
}

// 3. Add a method to Electronics called warrantyInfo() and mark it final



// 4. Use access modifiers appropriately and explain your choices in comments

// I made discountRate static so it is accessible.
