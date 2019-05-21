package main.java.database;

import main.java.BL.Contract.*;
import main.java.common.CommonUtils;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import static java.sql.Types.NULL;


public class DatabaseController {


    public static void main(String[] args) throws ParseException {
        //Adding simple User test
//        User user = new User();
//        user.setFirstName("test");
//        user.setLastName("dla");
//        user.setAge("11");
//        user.setDateOfBirth("1/1/1993");
//        user.setPhoneNmuber("0547504868");
//        addUser(user);

        //Adding simple Restaurant
//        Restaurant restaurant = new Restaurant();
//        restaurant.setId(1);
//        restaurant.setName("zvikush");
//        addRestaurant(restaurant);


        //Adding simple provider
//        Provider provider = new Provider();
//        provider.setId(1);
//        provider.setCompanyName("great company");
//        provider.setContactName("elinush");
////        addProvider(provider);

        //Adding product sample
//        Product product = new Product();
//        product.setProductId(1);
//        product.setProductName("yolo");
//        product.setPrice("25");
//        product.setExpirationDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1993"));
//        product.setCurrentpProductAmount(21);
//        product.setRequiredAmount(22);
//        product.setProvider("Noga tm");
//        addProduct(product);

//        adding order sample
//        Order order = new Order();
//        order.setOrderId(1);
//        order.setProductType("Hairline");
//        order.setProvider(provider);
//        order.setDeliveryDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1993"));
//        order.setTotalAmount(22.56);
//        addOrder(order);
//        getUserById(1);
        getAllProviderCompanyName();
    }

    public static void addUser(User user) {
        int id = user.getId();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String age = Integer.toString(user.getAge());
        String dateOfBirth = user.getDateOfBirth();
        String username = user.getUserName();
        String phoneNumber = user.getPhoneNmuber();

        String sql = "INSERT INTO user(id,first_name,last_name,age,date_of_birth,username,phone_number) VALUES(?,?,?,?,?,?,?)";
        Connection conn = DatabaseAccessManager.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, age);
            pstmt.setString(5, dateOfBirth);
            pstmt.setString(6, username);
            pstmt.setString(7, phoneNumber);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DatabaseAccessManager.closeConnection(conn);
        }
    }

    public static void addRestaurant(Restaurant restaurant) {
        String name = restaurant.getName();
        int id = restaurant.getId();
        String sql = "INSERT INTO restaurant(id,name) VALUES(?,?)";
        Connection conn = DatabaseAccessManager.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DatabaseAccessManager.closeConnection(conn);
        }
    }

    public static void addProvider(Provider provider) {
        int id = provider.getId();
        String companyName = provider.getCompanyName();
        String contactName = provider.getContactName();
//        List<Integer> productType = provider.getProductType(); //TODO - @Dana , why list of integers for product type?
        String sql = "INSERT INTO provider(id,company_name,contact_name) VALUES(?,?,?)";
        Connection conn = DatabaseAccessManager.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, companyName);
            pstmt.setString(3, contactName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DatabaseAccessManager.closeConnection(conn);
        }
    }

    public static void addProduct(Product product) {
        String id = product.getProductId();
        String name = product.getProductName();
        String price = product.getPrice();
        String expirationDate = String.valueOf(product.getExpirationDate()); //todo string casting might cause issues...need to check
        int currentAmount = product.getCurrentProductAmount();
        int requiredAmount = product.getRequiredAmount();
        String provider = product.getProviderId();
        String sql = "INSERT INTO product(id,name,price,expiration_date,current_amount,required_amount,provider) VALUES(?,?,?,?,?,?,?)";
        Connection conn = DatabaseAccessManager.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, price);
            pstmt.setString(4, expirationDate);
            pstmt.setInt(5, currentAmount);
            pstmt.setInt(6, requiredAmount);
            pstmt.setString(7, provider);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DatabaseAccessManager.closeConnection(conn);
        }
    }


    public static List<Product> getProductList(int providerId) {
        String sql = "SELECT* FROM product WHERE providerId = ? ";
        Connection conn = DatabaseAccessManager.getConnection();
        List<Product> products = new ArrayList<>();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, providerId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                Product product = new Product();
                product.setProductId(rs.getString("id"));
                product.setProductName(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DatabaseAccessManager.closeConnection(conn);
        }
        return products;
    }

    public static List<Product> GetProviderByCategory(int providerId) {
        String sql = "SELECT* FROM product WHERE providerId = ? ";
        Connection conn = DatabaseAccessManager.getConnection();
        List<Product> products = new ArrayList<>();

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, providerId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                Product product = new Product();
                product.setProductId(rs.getString("id"));
                product.setProductName(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DatabaseAccessManager.closeConnection(conn);
        }
        return products;
    }


    public static void addOrder(Order order) {
        int id = order.getOrderId();
        String productType = String.join(",", order.getProductIds()); //String.join(",",order.getProductIds());
        String provider = String.join(",", order.getProvider());
        Date deliveryDate = order.getDeliveryDate();
        Double totalAmount = order.getTotalAmount();
        String sql = "INSERT INTO orders(id,product_id,provider,delivery_date,total_amount) VALUES(?,?,?,?,?)";
        Connection conn = DatabaseAccessManager.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, productType);
            pstmt.setObject(3, provider);
            pstmt.setString(4, String.valueOf(deliveryDate));
            pstmt.setDouble(5, totalAmount);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DatabaseAccessManager.closeConnection(conn);
        }
    }

    public static Order getOrderById(int id) {
        Order order = new Order();
        String sql = "SELECT * FROM orders WHERE id = " + id;
        Connection conn = DatabaseAccessManager.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
            order.setOrderId(rs.getInt("id"));
            List<String> d = new ArrayList<String>(Arrays.asList(rs.getString("product_id").split(",")));
            order.setProductIds(new ArrayList<String>(Arrays.asList(rs.getString("product_id").split(","))));
            order.setProvider(new ArrayList<String>(Arrays.asList(rs.getString("provider").split(","))));
            order.setDeliveryDate(rs.getDate("delivery_date"));
            order.setTotalAmount(rs.getDouble("total_amount"));

//        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DatabaseAccessManager.closeConnection(conn);
        }
        return order;
    }

    public static User getUserById(int id) {
        User user = new User();
        String sql = "SELECT * FROM user WHERE id = " + id;
        Connection conn = DatabaseAccessManager.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
//            while (rs.next()) {
            user.setId(rs.getInt("id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setAge(rs.getInt("age"));
            user.setDateOfBirth(rs.getString("date_of_birth"));
            user.setUserName(rs.getString("username"));
            user.setPhoneNmuber(rs.getString("phone_number"));
//        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DatabaseAccessManager.closeConnection(conn);
        }
        return user;
    }
    /*
     SQLite Reset Primary Key Field (mostly will be used for auto autoincrement for ids) run the following queries:
    delete from your_table;
    delete from sqlite_sequence where name='your_table';
     */

    public static Vector<String> getAllProviderCompanyName() {
        Vector<String> providersNames = new Vector<>();
        String sql = "SELECT distinct company_name FROM provider";
        Connection conn = DatabaseAccessManager.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                providersNames.add(rs.getString("company_name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DatabaseAccessManager.closeConnection(conn);
        }
        return providersNames;
    }
}