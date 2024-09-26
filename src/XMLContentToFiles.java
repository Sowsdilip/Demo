

import java.io.*;
import java.util.Base64;
import java.util.zip.GZIPInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class XMLContentToFiles {

    public static void main(String[] args) {
        // Path to the XML file
        String xmlFilePath = "pdfxml.xml";//"C:/Users/Sowmya/Downloads/pdfxml.xml";

        // Parse the XML file
        Document xmlDocument = parseXML(xmlFilePath);
        if (xmlDocument == null) {
            System.out.println("Failed to parse XML file.");
            return;
        }

        // Process each item in the XML
        NodeList items = xmlDocument.getElementsByTagName("item");
        for (int i = 0; i < items.getLength(); i++) {
            Element item = (Element) items.item(i);
            String filename = item.getElementsByTagName("index").item(0).getAttributes().getNamedItem("filename").getNodeValue();
            String content = item.getElementsByTagName("content").item(0).getTextContent();
            boolean isCompressed = "true".equalsIgnoreCase(item.getElementsByTagName("index").item(0).getAttributes().getNamedItem("isCompressed").getNodeValue());

            // Decode the base64 content
            byte[] fileData;
            try {
                byte[] compressedData = Base64.getDecoder().decode(content);
                System.out.println("file name "+filename+" is "+isCompressed);
                fileData = isCompressed ? decompressGzip(compressedData,filename) : compressedData;
            } catch (IllegalArgumentException | IOException e) {
                System.out.println("Failed to process content for file: " + filename);
                e.printStackTrace();
                continue;
            }

            // Determine the file extension and save accordingly
            if (filename.toLowerCase().endsWith(".png") || filename.toLowerCase().endsWith(".jpeg")) {
                saveAsImage(fileData, filename);  // Save as an image file
            } else if (filename.toLowerCase().endsWith(".pdf")) {
                saveAsPDF(fileData, filename);  // Save as a PDF file
            } else {
                System.out.println("Unsupported file format: " + filename);
            }
        }
    }

    // Method to parse the XML file
    private static Document parseXML(String filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(new File(filePath));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to decompress GZIP compressed data
    private static byte[] decompressGzip(byte[] compressedData,String filename) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(compressedData);
             GZIPInputStream gzipInputStream = new GZIPInputStream(bais);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int len;
            while ((len = gzipInputStream.read(buffer)) > 0) {
                baos.write(buffer, 0, len);
            }
            if (filename.toLowerCase().endsWith(".png") || filename.toLowerCase().endsWith(".jpeg")) {
            	// Save decompressed data directly as a file
            	try (FileOutputStream fos = new FileOutputStream("raw_output_image.jpeg")) {
            	    fos.write(baos.toByteArray());
            	    System.out.println("Image saved as raw_output_image.png");
            	} catch (IOException e) {
            	    e.printStackTrace();
            	}

            }
            return baos.toByteArray();
        }
    }

    // Method to save the decompressed data as an image (PNG or JPG)
    private static void saveAsImage(byte[] fileData, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(fileData);
            System.out.println("Image file " + fileName + " generated successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save image file: " + fileName);
            e.printStackTrace();
        }
    }

    // Method to save the decompressed data as a PDF
    private static void saveAsPDF(byte[] fileData, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.write(fileData);
            System.out.println("PDF file " + "image.jpeg" + " generated successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save PDF file: " + fileName);
            e.printStackTrace();
        }
    }
    
    
}

