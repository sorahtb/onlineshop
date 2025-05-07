import java.util.ArrayList;
import java.util.Scanner;
public class Main {                                                // ну а это главный класс где выходит консольа ждля работы магаза
    public static void main(String[] args) {
        OnlineShop onlineShop = new OnlineShop();      //огнлайн шоп используют для обработки выбора и тд юзера
        Scanner scanner = new Scanner(System.in);
// используем цикл вайл
        while (true) {
            System.out.println("Добро пожаловать! Вам доступны следующие функции:");
            System.out.println("1) Список продуктов");
            System.out.println("2) Выберите продукт");
            System.out.println("3) Добавить нового пользователя");
            System.out.println("4) Приобрести продукт");
            System.out.println("5) Возврат продукта");
            System.out.println("6) Показать всех пользователей");
            System.out.println("7) Показать покупки пользователя.");

            int choice = scanner.nextInt();
//используем кейсы для вывода на консоль и выбора определенной функции
            switch (choice) {
                case 1:
                    onlineShop.showProductsList();
                    break;
                case 2:
                    System.out.println("Добавьте детали заказа");
                    System.out.print("Название: ");
                    String name = scanner.next();
                    System.out.print("Цена:  .тг");
                    double price = scanner.nextDouble();
                    System.out.print("Количество: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Описание: ");
                    String description = scanner.next();
                    onlineShop.addProduct(new Product(name, price, quantity, description));
                    break;
                case 3:
                    System.out.println("Добавить детали пользователя:");
                    System.out.print("ID пользователя: ");
                    int userId = scanner.nextInt();
                    System.out.print("Имя: ");
                    String userName = scanner.next();
                    System.out.print("Счет:  .тг");
                    double balance = scanner.nextDouble();
                    onlineShop.addUser(new User(userId, userName, balance));
                    break;
                case 4:
                    System.out.println("Введите детали покупки:");
                    System.out.print("ID пользователя: ");
                    int purchaseUserId = scanner.nextInt();
                    System.out.print("Название продукта: ");
                    String purchaseProductName = scanner.next();
                    System.out.print("Количество: ");
                    int purchaseQuantity = scanner.nextInt();
                    onlineShop.buyProduct(purchaseUserId, purchaseProductName, purchaseQuantity);
                    break;
                case 5:
                    System.out.print("Выберите ID для возврата: ");
                    int returnOrderId = scanner.nextInt();
                    onlineShop.returnProduct(returnOrderId);
                    break;
                case 6:
                    onlineShop.showAllUsers();
                    break;
                case 7:
                    System.out.print("Введите ID пользователя: ");
                    int showUserOrdersId = scanner.nextInt();
                    onlineShop.showUserOrders(showUserOrdersId);
                    break;
                default:
                    System.out.println("Не правильный выбор.Повторите попытку."); //типо ошибка/не праильный выбор
                    break;
            }
        }   // это все бесконечный цикл где можно покупать и возвращать товары много раз/ юзер задает действие а программа выполняет заданное действие
    } // этот код содержит классы которые отвечают за определенные функции в каждом классе по разному
}
