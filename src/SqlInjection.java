import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JOptionPane;

public class SqlInjection {

	public static void main(String[] args) throws Exception {
		String email = JOptionPane.showInputDialog("Enter your email");
		String oldPassword = JOptionPane.showInputDialog("Enter your password");

		Connection connection = DBConnection.getDbConnection();
		Statement statement = connection.createStatement();

		String sql = "SELECT * FROM people WHERE email='" + email
				+ "' and password='" + oldPassword + "'";
		System.out.println(sql);
		try {
			ResultSet result = statement.executeQuery(sql);
			result.next();
			String password = result.getString("password");
			JOptionPane.showMessageDialog(null, "Your password: " + password);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Not found");
		}

	}
}
