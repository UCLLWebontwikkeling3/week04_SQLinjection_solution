import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    public static java.sql.Connection getDbConnection() throws SQLException {
        Properties properties = new Properties();
        String url = "jdbc:postgresql://databanken.ucll.be:51819/webontwerp?currentSchema=web3";
        properties.setProperty("user", "");
        properties.setProperty("password", "");
        Secret.setPass(properties);	// implements line 17 and 18
        properties.setProperty("ssl", "true");
        properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
        properties.setProperty("sslmode","prefer");

        java.sql.Connection connection;
        connection = DriverManager.getConnection(url, properties);
        return connection;
    }

}
