import java.util.Base64;

public class Base64Util {

    // Method to convert byte array to Base64 string
    public static String byteArrayToBase64(byte[] imageBytes) {
        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
