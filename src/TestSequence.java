import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSequence {
	
    public static void main(String[] args) {
//        // Database connection details
//        String url = "jdbc:sqlserver://;serverName=10.3.84.122;port=30133;databaseName=SCFDB";
//        String username = "SA";
//        String password = "Nedbank@2023";
//
//        try (
//            // Establish database connection
//            Connection connection = DriverManager.getConnection(url, username, password)
//        ) {
//            // Create a statement
//            Statement statement = connection.createStatement();
//
//            // Execute a query to retrieve the next value from the sequence
//            ResultSet resultSet = statement.executeQuery("SELECT NEXT VALUE FOR EXIMTRX.EE_MCPE_FINSERV_SEQ");
//
//            // Retrieve the next value from the result set
//            if (resultSet.next()) {
//                long nextValue = resultSet.getLong(1);
//                System.out.println("Next value from sequence: " + nextValue);
//            } else {
//                System.err.println("No value returned from sequence.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    System.out.println("existingGapiWarningMsg"+"\n"+"gapiWarningMsg");
   }
}
