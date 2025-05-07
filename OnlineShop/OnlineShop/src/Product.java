class Product {                         //консольный онлайн магаз
    private final String name;
    private final double price;              //это класс продакт где предостален товар в магазе
    // доступ к полям предоставляют геттеры и сеттеры
    private final int quantity;
    private final String description;
    //сетеры
    public Product(String name, double price, int quantity, String description) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    // добавляем геттеры чтобы получить значения полей
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    private Product updateProductQuantity(Product product, int quantity) {
        return new Product(product.getName(), product.getPrice(), product.getQuantity() - quantity, product.getDescription());
    }}
