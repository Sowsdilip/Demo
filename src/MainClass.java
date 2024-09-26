import java.io.IOException;

public class MainClass {
    public static void main(String[] args) {
        try {
            // Step 1: Convert image to byte array
            String imagePath = "C:/Users/Sowmya/Downloads/495defect.png";  // Replace with your image path
            byte[] imageBytes = ImageUtil.imageToByteArray(imagePath);
            
            // Step 2: Compress the byte array
            byte[] compressedBytes = CompressUtil.compressByteArray(imageBytes);
            
            // Step 3: Encode compressed byte array to Base64
            String base64Compressed = Base64Util.byteArrayToBase64(compressedBytes);
            
            System.out.println("Compressed Base64: " + base64Compressed);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
