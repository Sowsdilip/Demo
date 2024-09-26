
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateFile {

	public static void main(String[] args) throws IOException {
		File file;
		File tempFile;
		FileInputStream inputStream = null;
		FileInputStream input = null;
		FileOutputStream output = null;
		FileOutputStream outputStream = null;
		try{
		 file = new File("./Temp/sample.pdf");
		 inputStream = new FileInputStream(file);
		byte[] fileContent = new byte[(int) file.length()];
		inputStream.read(fileContent);
		inputStream.close();
		outputStream = new FileOutputStream("./Temp/temp");
		}catch(IOException e){
			System.out.println(e);
		}finally{
			inputStream.close();
			outputStream.close();
		}
		try{
	    tempFile = new File("./Temp/temp");
	    input = new FileInputStream(tempFile);
	    byte[] fileContent1 = new byte[(int) tempFile.length()];
		input.read(fileContent1);
		output = new FileOutputStream("./Temp/testtemp.pdf");
		inputStream.close();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			input.close();
			output.close();
		}
	    
	}
}
