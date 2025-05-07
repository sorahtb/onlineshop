import java.util.Scanner;

interface Subscription {
    double applyDiscount(double amount);
}

class PremiumSubscription implements Subscription {
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.85;
    }
}

class OrdinarySubscription implements Subscription {
    @Override
    public double applyDiscount(double amount) {
        return amount;
    }
}
