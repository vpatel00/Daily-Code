public class CoffeeShop {
    // TODO 1: Change the class name to CoffeeShop

    public static void main(String[] args) {
        // TODO 2: Create three CoffeeOrder objects
        // Use a different constructor each time
        CoffeeOrder marcsCoffeeOrder = new CoffeeOrder();
        CoffeeOrder tonysCoffeeOrder = new CoffeeOrder("small");
        CoffeeOrder henrysCoffeeOrder = new CoffeeOrder("medium", "femboy latte");
        // TODO 3: Call describeOrder() on each and print the result
        marcsCoffeeOrder.describeOrder();
        tonysCoffeeOrder.describeOrder();
        henrysCoffeeOrder.describeOrder();
        // TODO 4: Print the total number of orders using
        // CoffeeOrder.getTotalOrders()
        System.out.println(CoffeeOrder.getTotalOrders());
    }
}
