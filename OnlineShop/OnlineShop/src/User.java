import java.util.ArrayList;

class User {
    private final int id;
    private final String name;
    private double balance;
    private final ArrayList<Order> orders;
    private Subscription subscription;

    public User(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.orders = new ArrayList<>();
        this.subscription = subscription;
    }

    public Subscription getSubscription() {
        return subscription;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
    public double applySubscriptionDiscount(double amount) {
        return subscription.applyDiscount(amount);
    }
}



