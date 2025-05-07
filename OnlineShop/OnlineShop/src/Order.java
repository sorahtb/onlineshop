class Order {                             //это класс ордер здесь предосталяется заказ который
    // выбирает юзер
    private final int userId;                   //геттеры предоставляют доступ к полям
    private final String productName;
    private final int quantity;
    private final double totalSum;

    //добавляем сеттеры чтобы установить эти значения
    public Order(int userId, String productName, int quantity, double totalSum) {
        this.userId = userId;
        this.productName = productName;
        this.quantity = quantity;
        this.totalSum = totalSum;
    }

    //геттеры
    public int getUserId() {
        return userId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalSum() {
        return totalSum;
    }
}
