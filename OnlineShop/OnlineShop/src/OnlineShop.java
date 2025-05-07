import java.util.ArrayList;

class OnlineShop {                        //класс онлайн магаза тут просто выбираешь товар/смотришь список
    private final ArrayList<User> users;       //добавл юзера/возврат товара/список юзеров/история заказов
    private final ArrayList<Product> products;
    private final ArrayList<Order> orderHistory;

    public OnlineShop() {
        this.users = new ArrayList<>();
        this.products = new ArrayList<>();
        this.orderHistory = new ArrayList<>();
    }

    // добавляем метод для показа продуктов пользователю
    public void showProductsList() {
        System.out.println("Список продуктов:");
        for (Product product : products) {
            System.out.println(product.getName() + " - .тг" + product.getPrice());
        }
        System.out.println();
    }

    // метод выбора продукта
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Проодукт успешно добавлен!\n");
    }

    // добавление оового пользователя
    public void addUser(User user) {
        users.add(user);
        System.out.println("Пользователь успешно добавлен!\n");
    }

    // покупка продукта
    public void buyProduct(int userId, String productName, int quantity) {
        // ищем пользлвателя
        User user = findUserById(userId);

        // ищем продкт
        Product product = findProductByName(productName);

        if (user != null && product != null) {
            //здесь мы смотрим хватает ли баланса на счету пользователя
            double totalCost = product.getPrice() * quantity;
            if (user.getBalance() >= totalCost && product.getQuantity() >= quantity) {
                //обновляем баланс и кол-во продуктов
                user.setBalance(user.getBalance() - totalCost);
                product = updateProductQuantity(product, quantity);

                // типо история заказов пользователя/ добавление покупок
                Order order = new Order(userId, productName, quantity, totalCost);
                user.addOrder(order);
                orderHistory.add(order);

                System.out.println("Покупка прошла успешно!\n");
            } else {
                System.out.println("Недостаточный баланс или товара нет вв наличии\n");
            }
        } else {
            System.out.println("Пользователь или продукт не найден!\n");
        }
    }

    // здесь уже идет метод возвратта покупок пользователя

    public void returnProduct(int orderId) {
        // ищем покупку в истории покупок
        Order order = findOrderById(orderId);

        if (order != null) {
            // тоже самое поиск пользователя((((
            User user = findUserById(order.getUserId());

            // поиск продукта
            Product product = findProductByName(order.getProductName());

            // обновляям баланс и историю пользлвателя
            user.setBalance(user.getBalance() + order.getTotalSum());
            product = updateProductQuantity(product, -order.getQuantity());

            // удаляем всю историю заказов/ яусталь((
            user.getOrders().remove(order);
            orderHistory.remove(order);

            System.out.println("Возврат успешно обработан!\n");
        } else {
            System.out.println("Пользователь не найден!\n");
        }
    }

    // показ всех пользователей
    public void showAllUsers() {
        System.out.println("Все пользователи:");
        for (User user : users) {
            System.out.println("ID пользователя: " + user.getId() + ", Имя: " + user.getName() + ", Счет:  .тг" + user.getBalance());
        }
        System.out.println();
    }

    // отображаем заказы определенного пользоватея которого мы выбрали
    public void showUserOrders(int userId) {
        // опять поиск....пользоватьеля
        User user = findUserById(userId);

        if (user != null) {
            System.out.println("Заказы пользователя " + userId + ":");
            for (Order order : user.getOrders()) {
                System.out.println("ID заказа: " + order.getUserId() + ", Продукт: " + order.getProductName() +
                        ", Количсетво: " + order.getQuantity() + ", Общая сумма:  .тг" + order.getTotalSum());
            }
            System.out.println();
        } else {
            System.out.println("Пользователь не найден!\n");
        }
    }

    // поиск айдишки пользователя
    private User findUserById(int userId) {
        for (User user : users) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }

    // поиск продукта по названию
    private Product findProductByName(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    //поиск заказа по истории
    private Order findOrderById(int orderId) {
        for (Order order : orderHistory) {
            if (order.getUserId() == orderId) {
                return order;
            }
        }
        return null;
    }

    // добавляем номер заказа
    private Product updateProductQuantity(Product product, int quantity) {
        product = new Product(product.getName(), product.getPrice(), product.getQuantity() - quantity, product.getDescription());
        return product;
    }
}
