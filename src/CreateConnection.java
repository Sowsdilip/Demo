

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnection {

	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/entitytest",
					"Sowmya", "password");
			System.out.println(connection);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
