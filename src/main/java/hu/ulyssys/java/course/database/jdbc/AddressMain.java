package hu.ulyssys.java.course.database.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
public class AddressMain {

    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/demo";
    private static final String DATABASE_USER = "postgres";
    private static final String DATABASE_PASSWORD = "postgres";
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            properties.setProperty("user", DATABASE_USER);
            properties.setProperty("password", DATABASE_PASSWORD);
            Connection connection = DriverManager.getConnection(DATABASE_URL, properties);
            insertInto(connection);
            System.out.println("Sikeresen végre hajtódott a program");
            // Exception demo  throw new Exception("Saját hiba/kivétel");
        } catch (SQLException throwables) {
            System.out.println("SQL exception ág");
            throwables.printStackTrace();
        } catch (Exception e) {
            System.out.println("Sima exception ág");
            e.printStackTrace();
        } finally {
            System.out.println("Vége a programunknak");
        }
    }

    private static void insertInto(Connection connection) throws SQLException {
        //   Statement statement = connection.createStatement();
        //  statement.execute("insert into dog_owner(first_name,last_name) values ('alma','körte')");
        PreparedStatement preparedStatement = connection.prepareStatement("insert into address (employee_id,ertek) values (?,?)");
        preparedStatement.setLong(1,3);
        preparedStatement.setString(2,"Valaki3");
        preparedStatement.execute();
    }

    private static void delete(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("delete from address where ertek=?");
        preparedStatement.setString(1,"Valaki2");
        preparedStatement.execute();
    }

    private static void update(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("update address set ertek=? where ertek=?");
        preparedStatement.setString(1,"Valaki"+System.currentTimeMillis());
        preparedStatement.setString(1,"Valaki");
        preparedStatement.execute();
    }

    private static void selectIdDemo(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select id from address where ertek=?");
        preparedStatement.setString(1,"Valaki3");
        ResultSet resultSet = preparedStatement.executeQuery();
        Long id = null;
        while (resultSet.next()) {
            System.out.println("Id értéke: "+resultSet.getLong("id"));
            id = resultSet.getLong("id");
        }
        System.out.println("Bálint id-ja: "+id);
    }

    private static void selectDogDemo(Connection connection, Long id) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM address where ertek=?");
        preparedStatement.setString(1,"Valaki3");
        List<Address> addressList = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Address address = new Address(resultSet.getLong("id"),
                resultSet.getLong("employee_id"),
                resultSet.getString("ertek"));
            addressList.add(address);
        }

        addressList.forEach(address -> System.out.println(address.getId() + " " + address.getEmployeeId() + " " + address.getValue()));
    }
}