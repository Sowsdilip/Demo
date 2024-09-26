import java.io.File;

public class DeleteFile {
	public static void main(String[] args) {
		 File myObj = new File("./temp.xml"); 
		 myObj.delete();
	}
}