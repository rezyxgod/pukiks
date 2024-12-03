package com.mycompany.botmain;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTelegramBot extends TelegramLongPollingBot {

    private static final String DB_URL = "jdbc:mysql://1208-1:3306/db04";
    private static final String DB_USER = "login4";
    private static final String DB_PASSWORD = "password4";

    private Map<Long, String> userStates = new HashMap<>();
    private Map<Long, List<String>> availablePackages = new HashMap<>();
    private Map<Long, List<String>> availableTickets = new HashMap<>();
    private Map<Long, String> userLogins = new HashMap<>();
    private Map<Long, Integer> selectedPackageId = new HashMap<>();
    private Map<Long, List<String>> bookedPackages = new HashMap<>();
    private Map<Long, List<String>> wishPackages = new HashMap<>();

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            SendMessage message = new SendMessage();
            message.setChatId(String.valueOf(chatId));

            switch (userStates.getOrDefault(chatId, "")) {
                case "":
                    if (messageText.equals("/start")) {
                        handleStartCommand(chatId, message);
                    } else {
                        sendDefaultMessage(chatId, message);
                    }
                    break;
                case "LOGIN":
                    handleLogin(chatId, messageText, message);
                    break;
                case "AUTHENTICATED":
                    handleAuthenticated(chatId, messageText, message);
                    break;
                case "BOOK_PACKAGE":
                    handleBookPackage(chatId, messageText, message);
                    break;
                case "SELECT_TICKET":
                    handleSelectTicket(chatId, messageText, message);
                    break;
                case "BUY_PACKAGE":
                    handleBuyPackageSelection(chatId, messageText, message);
                    break;
                case "MANAGER_AUTHENTICATED":
                    handleManagerAuthenticated(chatId, messageText, message);
                    break;
                case "WISH_SELECT_PACKAGE":
                    handleWishSelectPackage(chatId, messageText, message);
                    break;
                case "WISH":
                    handleWish(chatId, messageText, message);
                    break;
                default:
                    sendDefaultMessage(chatId, message);
                    break;
            }
        }
    }

    private void handleStartCommand(long chatId, SendMessage message) {
        userStates.put(chatId, "LOGIN");
        message.setText("Введите логин и пароль через пробел (например, login password):");
        sendMessage(message);
    }

    private void handleLogin(long chatId, String messageText, SendMessage message) {
        String[] parts = messageText.split(" ");
        if (parts.length == 2) {
            String login = parts[0];
            String password = parts[1];
            if (authenticateUser(login, password)) {
                String fullName = getUserFullName(login);
                message.setText("Здравствуйте, " + fullName + "!");
                userLogins.put(chatId, login);
                if (isManager(login)) {
                    userStates.put(chatId, "MANAGER_AUTHENTICATED");
                    showManagerMenu(chatId, message);
                } else {
                    userStates.put(chatId, "AUTHENTICATED");
                    showClientMenu(chatId, message);
                }
                sendMessage(message);
            } else {
                message.setText("Неверный логин или пароль.");
                sendMessage(message);
            }
        } else {
            message.setText("Используйте формат логин пароль (например, login password):");
            sendMessage(message);
        }
    }

    private void handleAuthenticated(long chatId, String messageText, SendMessage message) {
        if (messageText.equals("Купить билет")) {
            handleBuyPackageCommand(chatId, message);
        } else if (messageText.equals("Бронировать билет")) {
            handleBookPackageCommand(chatId, message);
        } else if (messageText.equals("Пожелания")) {
            handleWishCommand(chatId, message);
        } else if (messageText.equals("Статус путевки")) {
            handlePackageStatusCommand(chatId, message);
        } else if (messageText.equals("Просмотр всех предложений")) {
            handleViewAllOffers(chatId, message);
        } else {
            message.setText("Неверная команда.");
            sendMessage(message);
        }
    }

    private void handleManagerAuthenticated(long chatId, String messageText, SendMessage message) {
        if (messageText.equals("Анализ туров")) {
            handleTourAnalysis(chatId, message);
        } else {
            message.setText("Неверная команда.");
            sendMessage(message);
        }
    }

    private void handleBookPackageCommand(long chatId, SendMessage message) {
        userStates.put(chatId, "BOOK_PACKAGE");
        List<String> packages = getAvailablePackages();
        availablePackages.put(chatId, packages);
        message.setText("Доступные пакеты:\n" + String.join("\n", packages) + "\nВведите ID пакета для бронирования:");
        sendMessage(message);
    }

    private void handleBuyPackageCommand(long chatId, SendMessage message) {
        userStates.put(chatId, "BUY_PACKAGE");
        List<String> bpackages = getBookedPackages(chatId);
        bookedPackages.put(chatId, bpackages);
        message.setText("Забронированные пакеты:\n" + String.join("\n", bpackages) + "\nВведите ID пакета для покупки:");
        sendMessage(message);
    }

    private void handleWishCommand(long chatId, SendMessage message) {
        userStates.put(chatId, "WISH_SELECT_PACKAGE");
        List<String> wishPackages = getWishPackages(chatId);
        this.wishPackages.put(chatId, wishPackages);
        message.setText("Доступные пакеты для пожеланий:\n" + String.join("\n", wishPackages) + "\nВведите ID пакета для пожелания:");
        sendMessage(message);
    }

    private void handlePackageStatusCommand(long chatId, SendMessage message) {
        List<String> packageStatuses = getPackageStatuses(chatId);
        message.setText("Статус путевок:\n" + String.join("\n", packageStatuses));
        sendMessage(message);
    }

    private void handleViewAllOffers(long chatId, SendMessage message) {
        List<String> packages = getAvailablePackages();
        List<String> tickets = getAvailableTickets();
        message.setText("Все доступные пакеты:\n" + String.join("\n", packages) + "\n\nВсе доступные билеты:\n" + String.join("\n", tickets));
        sendMessage(message);
    }

    private void handleBookPackage(long chatId, String messageText, SendMessage message) {
        List<String> packages = availablePackages.get(chatId);
        if (packages != null) {
            for (String pkg : packages) {
                if (pkg.contains("ID: " + messageText)) {
                    selectedPackageId.put(chatId, Integer.parseInt(messageText));
                    List<String> tickets = getAvailableTickets();
                    availableTickets.put(chatId, tickets);
                    userStates.put(chatId, "SELECT_TICKET");
                    message.setText("Доступные билеты:\n" + String.join("\n", tickets) + "\nВведите ID билета для бронирования:");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Неверный ID пакета.");
        } else {
            message.setText("Неверный ID пакета.");
        }
        sendMessage(message);
    }

    private void handleSelectTicket(long chatId, String messageText, SendMessage message) {
        List<String> tickets = availableTickets.get(chatId);
        if (tickets != null) {
            for (String ticket : tickets) {
                if (ticket.contains("ID: " + messageText)) {
                    boolean success = bookPackage(chatId, Integer.parseInt(messageText));
                    message.setText(success ? "Билет успешно забронирован." : "Ошибка при бронировании билета.");
                    userStates.put(chatId, "AUTHENTICATED");
                    showClientMenu(chatId, message);
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Неверный ID билета.");
        } else {
            message.setText("Неверный ID билета.");
        }
        sendMessage(message);
    }

    private void handleBuyPackageSelection(long chatId, String messageText, SendMessage message) {
        List<String> packages = bookedPackages.get(chatId);
        if (packages != null) {
            for (String pkg : packages) {
                if (pkg.contains("ID: " + messageText)) {
                    boolean success = buyPackage(chatId, messageText);
                    message.setText(success ? "Билет успешно куплен." : "Ошибка при покупке билета.");
                    userStates.put(chatId, "AUTHENTICATED");
                    showClientMenu(chatId, message);
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Неверный ID пакета.");
        } else {
            message.setText("Неверный ID пакета.");
        }
        sendMessage(message);
    }

    private void handleWishSelectPackage(long chatId, String messageText, SendMessage message) {
        List<String> packages = wishPackages.get(chatId);
        if (packages != null) {
            for (String pkg : packages) {
                if (pkg.contains("ID: " + messageText)) {
                    selectedPackageId.put(chatId, Integer.parseInt(messageText));
                    userStates.put(chatId, "WISH");
                    message.setText("Введите ваше пожелание:");
                    sendMessage(message);
                    return;
                }
            }
            message.setText("Неверный ID пакета.");
        } else {
            message.setText("Неверный ID пакета.");
        }
        sendMessage(message);
    }

    private void handleWish(long chatId, String messageText, SendMessage message) {
        int packageSaleId = selectedPackageId.get(chatId);
        int userId = getUserIdFromChatId(chatId);
        System.out.println("Package Sale ID: " + packageSaleId);
        System.out.println("User ID: " + userId);
        if (packageSaleId != -1 && userId != -1) {
            boolean success = saveWish(userId, packageSaleId, messageText);
            if (success) {
                message.setText("Ваше пожелание сохранено.");
            } else {
                message.setText("Ошибка при сохранении пожелания.");
            }
        } else {
            message.setText("Ошибка при определении пакета или пользователя.");
        }
        userStates.put(chatId, "AUTHENTICATED");
        showClientMenu(chatId, message);
        sendMessage(message);
    }

    private void showClientMenu(long chatId, SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("Купить билет");
        row.add("Бронировать билет");
        KeyboardRow row2 = new KeyboardRow();
        row2.add("Пожелания");
        row2.add("Статус путевки");
        KeyboardRow row3 = new KeyboardRow();
        row3.add("Просмотр всех предложений");
        keyboard.add(row);
        keyboard.add(row2);
        keyboard.add(row3);
        keyboardMarkup.setKeyboard(keyboard);

        message.setChatId(String.valueOf(chatId));
        message.setReplyMarkup(keyboardMarkup);
        message.setText("Выберите действие:");

        sendMessage(message);
    }

    private void showManagerMenu(long chatId, SendMessage message) {
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("Анализ туров");
        keyboard.add(row);
        keyboardMarkup.setKeyboard(keyboard);

        message.setChatId(String.valueOf(chatId));
        message.setReplyMarkup(keyboardMarkup);
        message.setText("Выберите действие:");

        sendMessage(message);
    }

    private void handleTourAnalysis(long chatId, SendMessage message) {
        List<String> tourAnalysis = getTourAnalysis();
        message.setText("Анализ туров:\n" + String.join("\n", tourAnalysis));
        sendMessage(message);
    }

    private boolean authenticateUser(String login, String password) {
        return executeQuery("SELECT * FROM users WHERE login = ? AND password = ?", login, password);
    }

    private boolean isManager(String login) {
        int userId = getUserId(login);
        return executeQuery("SELECT * FROM manager WHERE manager_user = ?", userId);
    }

    private String getUserFullName(String login) {
        return executeQuery("SELECT Imya, Familiya FROM users WHERE login = ?", login) ? getUserFullNameFromResultSet(login) : "Пользователь";
    }

    private List<String> getAvailablePackages() {
        return executeQueryAndGetPackages("SELECT package_id, destination, price, type, start_date, end_date FROM packages");
    }

    private List<String> getBookedPackages(long chatId) {
        return executeQueryAndGetBookedPackages("""
            SELECT ps.package_sale_id, p.package_id, p.destination, t.name_ticket
            FROM package_sales ps
            JOIN packages p ON ps.package_id = p.package_id
            JOIN ticket t ON ps.id_ticket = t.id_ticket
            WHERE ps.client_id = ? AND ps.status = 'Забронирован'
        """, getUserIdFromChatId(chatId));
    }

    private List<String> getWishPackages(long chatId) {
        return executeQueryAndGetWishPackages("""
            SELECT ps.package_sale_id, p.destination, t.name_ticket
            FROM package_sales ps
            JOIN packages p ON ps.package_id = p.package_id
            JOIN ticket t ON ps.id_ticket = t.id_ticket
            WHERE ps.client_id = ? AND ps.status = 'Куплен'
        """, getUserIdFromChatId(chatId));
    }

    private List<String> getAvailableTickets() {
        return executeQueryAndGetTickets("SELECT id_ticket, name_ticket, flight_number FROM ticket");
    }

    private List<String> getPackageStatuses(long chatId) {
        return executeQueryAndGetPackageStatuses("""
            SELECT ps.package_sale_id, p.destination, t.name_ticket, ps.status
            FROM package_sales ps
            JOIN packages p ON ps.package_id = p.package_id
            JOIN ticket t ON ps.id_ticket = t.id_ticket
            WHERE ps.client_id = ?
        """, getUserIdFromChatId(chatId));
    }

    private boolean bookPackage(long chatId, int ticketId) {
        int userId = getUserIdFromChatId(chatId);
        int packageId = selectedPackageId.get(chatId);
        return executeUpdate("INSERT INTO package_sales (sale_date, client_id, package_id, id_ticket, status) VALUES (?, ?, ?, ?, 'Забронирован')", LocalDate.now(), userId, packageId, ticketId);
    }

    private boolean buyPackage(long chatId, String packageSaleId) {
        int userId = getUserIdFromChatId(chatId);
        int packageId = getPackageIdFromPackageSaleId(packageSaleId);
        int ticketId = getTicketIdFromPackageSaleId(packageSaleId);
        double packagePrice = getPackagePrice(packageId);
        double ticketPrice = getTicketPrice(ticketId);
        double totalPrice = packagePrice + ticketPrice;

        boolean updateSuccess = executeUpdate("UPDATE package_sales SET sale_date = ?, total_price = ?, status = 'Куплен' WHERE package_sale_id = ?", LocalDate.now(), totalPrice, packageSaleId);
        return updateSuccess;
    }

    private int getUserIdFromChatId(long chatId) {
        String login = userLogins.get(chatId);
        return getUserId(login);
    }

    private int getUserId(String login) {
        return executeQuery("SELECT idusers FROM users WHERE login = ?", login) ? getUserIdFromResultSet(login) : -1;
    }

    private int getClientIdFromUserId(int userId) {
        return executeQuery("SELECT idClient FROM client WHERE client_user = ?", userId) ? getClientIdFromResultSet(userId) : -1;
    }

    private int getPackageIdFromClientId(int clientId) {
        return executeQuery("SELECT package_id FROM package_sales WHERE client_id = ?", clientId) ? getPackageIdFromResultSet(clientId) : -1;
    }

    private int getPackageIdFromPackageSaleId(String packageSaleId) {
        return executeQuery("SELECT package_id FROM package_sales WHERE package_sale_id = ?", packageSaleId) ? getPackageIdFromResultSet(packageSaleId) : -1;
    }

    private int getTicketIdFromPackageSaleId(String packageSaleId) {
        return executeQuery("SELECT id_ticket FROM package_sales WHERE package_sale_id = ?", packageSaleId) ? getTicketIdFromResultSet(packageSaleId) : -1;
    }

    private double getPackagePrice(int packageId) {
        return executeQuery("SELECT price FROM packages WHERE package_id = ?", packageId) ? getPackagePriceFromResultSet(packageId) : 0.0;
    }

    private double getTicketPrice(int ticketId) {
        return executeQuery("SELECT price FROM ticket WHERE id_ticket = ?", ticketId) ? getTicketPriceFromResultSet(ticketId) : 0.0;
    }

    private boolean saveWish(int userId, int packageSaleId, String wishDescription) {
        if (packageSaleIdExists(packageSaleId)) {
            boolean success = executeUpdate("INSERT INTO package_wishes (wish_description, user_id, packagesale_id) VALUES (?, ?, ?)", wishDescription, userId, packageSaleId);
            if (success) {
                System.out.println("Пожелание успешно сохранено: " + wishDescription);
            } else {
                System.out.println("Ошибка при сохранении пожелания: " + wishDescription);
            }
            return success;
        } else {
            System.out.println("Ошибка: packageSaleId не существует: " + packageSaleId);
            return false;
        }
    }

    private boolean packageSaleIdExists(int packageSaleId) {
        return executeQuery("SELECT 1 FROM package_sales WHERE package_sale_id = ?", packageSaleId);
    }

    private boolean executeQuery(String query, Object... params) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private List<String> executeQueryAndGetPackages(String query, Object... params) {
        List<String> packages = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String packageInfo = "ID: " + rs.getInt("package_id")
                        + ", Место прибытия: " + rs.getString("destination")
                        + ", Цена: " + rs.getString("price")
                        + ", Тип: " + rs.getString("type")
                        + ", Дата начала: " + rs.getString("start_date")
                        + ", Дата окончания: " + rs.getString("end_date");
                packages.add(packageInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return packages;
    }

    private List<String> executeQueryAndGetBookedPackages(String query, Object... params) {
        List<String> packages = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String packageInfo = "ID: " + rs.getInt("package_sale_id")
                        + ", Место прибытия: " + rs.getString("destination")
                        + ", Название билета: " + rs.getString("name_ticket");
                packages.add(packageInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return packages;
    }

    private List<String> executeQueryAndGetWishPackages(String query, Object... params) {
        List<String> packages = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String packageInfo = "ID: " + rs.getInt("package_sale_id")
                        + ", Место прибытия: " + rs.getString("destination")
                        + ", Название билета: " + rs.getString("name_ticket");
                packages.add(packageInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return packages;
    }

    private List<String> executeQueryAndGetTickets(String query, Object... params) {
        List<String> tickets = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String ticketInfo = "ID: " + rs.getInt("id_ticket")
                        + ", Название билета: " + rs.getString("name_ticket")
                        + ", Номер рейса: " + rs.getString("flight_number");
                tickets.add(ticketInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    private List<String> executeQueryAndGetPackageStatuses(String query, Object... params) {
        List<String> packageStatuses = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String packageStatusInfo = "ID: " + rs.getInt("package_sale_id")
                        + ", Место прибытия: " + rs.getString("destination")
                        + ", Название билета: " + rs.getString("name_ticket")
                        + ", Статус: " + rs.getString("status");
                packageStatuses.add(packageStatusInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return packageStatuses;
    }

    private boolean executeUpdate(String query, Object... params) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                stmt.setObject(i + 1, params[i]);
            }
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String getUserFullNameFromResultSet(String login) {
        String query = "SELECT Imya, Familiya FROM users WHERE login = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("Imya") + " " + rs.getString("Familiya");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Пользователь";
    }

    private int getUserIdFromResultSet(String login) {
        String query = "SELECT idusers FROM users WHERE login = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("idusers");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private int getClientIdFromResultSet(int userId) {
        String query = "SELECT idClient FROM client WHERE client_user = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("idClient");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private int getPackageIdFromResultSet(int clientId) {
        String query = "SELECT package_id FROM package_sales WHERE client_id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, clientId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("package_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private int getPackageIdFromResultSet(String packageSaleId) {
        String query = "SELECT package_id FROM package_sales WHERE package_sale_id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, packageSaleId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("package_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private int getTicketIdFromResultSet(String packageSaleId) {
        String query = "SELECT id_ticket FROM package_sales WHERE package_sale_id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, packageSaleId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_ticket");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private double getPackagePriceFromResultSet(int packageId) {
        String query = "SELECT price FROM packages WHERE package_id = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, packageId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Double.parseDouble(rs.getString("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    private double getTicketPriceFromResultSet(int ticketId) {
        String query = "SELECT price FROM ticket WHERE id_ticket = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, ticketId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("price");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    private List<String> getTourAnalysis() {
        List<String> analysis = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement stmt = conn.prepareStatement("""
                 SELECT p.destination, COUNT(ps.package_sale_id) as count
                 FROM packages p
                 LEFT JOIN package_sales ps ON p.package_id = ps.package_id
                 GROUP BY p.destination
             """)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String destination = rs.getString("destination");
                int count = rs.getInt("count");
                analysis.add("Место прибытия: " + destination + ", Количество покупок: " + count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return analysis;
    }

    private void sendMessage(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void sendDefaultMessage(long chatId, SendMessage message) {
        message.setText("Пока не готово ничего");
        sendMessage(message);
    }

    @Override
    public String getBotUsername() {
        return "@flammGoo_bot";
    }

    @Override
    public String getBotToken() {
        return "7692364149:AAEMw_ZGRs1EJU91WsH37Dlpsw8OI2pxjAk";
    }
}