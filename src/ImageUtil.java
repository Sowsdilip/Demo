import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class ImageUtil {

    // Method to read image and convert it to byte array
    public static byte[] imageToByteArray(String imagePath) throws IOException {
        BufferedImage image = ImageIO.read(new File(imagePath));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos); // Change "jpg" to the format of your image (e.g., "png" or "jpeg")
        return baos.toByteArray();
    }
}
