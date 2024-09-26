import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestClass {

	private static FileInputStream fis = null;
	private static Properties prop = null;

	public static void main(String args[]) {
		try {
			fis = new FileInputStream("./switch.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String check = prop.getProperty("amendfunction");
		prop.setProperty("check test", "value");
		System.out.println(prop.getProperty("check test"));
		System.out.println("check   "+check);
		// if(check.equalsIgnoreCase("Yes")){
		// System.out.println(prop.getProperty("Amend_Fucntion"));
		// }else
		// System.out.println("No");
		// }
		// Map<String,String> testMap = new HashMap<String,String>
	}
}
