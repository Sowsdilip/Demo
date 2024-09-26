import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Base64;

import javax.xml.parsers.DocumentBuilder;
	import javax.xml.parsers.DocumentBuilderFactory;
	import org.w3c.dom.Document;
	import org.w3c.dom.Element;
	import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
	
public class TestZipContent {
	
	  private static String readFileToString(String filePath) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        }

        return stringBuilder.toString();
    }
	
	    public static void main(String[] args) {
	    	String filePath = "./sample.xml"; // Replace with the actual path to your XML file
	    	String xmlString = null;

	        try {
	            // Read the XML file into a string
	             xmlString = readFileToString(filePath);

	            // Print the XML content
	            System.out.println("XML Content:\n" + xmlString);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    

	        try {
	            System.out.println("Parse the XML string");
	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = factory.newDocumentBuilder();
	            Document document = builder.parse(new InputSource(new StringReader(xmlString)));
	            Element sendElement = (Element) document.getElementsByTagName("send-item").item(0);
	            String hasAttachValue = sendElement.getAttribute("hasAttach");
	            System.out.println(hasAttachValue);
	            // Find the content node
	            Element contentElement = (Element) document.getElementsByTagName("content").item(0);
                
	            // Get the value of the content node
	            String contentValue = contentElement.getTextContent();

	            // Print the value of the content
	            System.out.println("Content Value: " + contentValue);
	            byte[] imageByteArray = Base64.getDecoder().decode(contentValue.getBytes());
	           // contentValue = CompressUtil
				//		.compressByBase64(imageByteArray);

	            // Replace the content with the zipped content
	            String zippedContent = zipContent(contentValue);
	            contentElement.setTextContent(zippedContent);

	            // Print the updated XML
	            String updatedXmlString = convertDocumentToString(document);
	            System.out.println("Updated XML:\n" + updatedXmlString);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    private static String zipContent(String content) {
	        // Implement your logic to zip the content
	        // This part depends on how you want to zip the content
	        // You can use java.util.zip or any other library for zipping

	        // For example:
	        // byte[] contentBytes = content.getBytes(StandardCharsets.UTF_8);
	        // byte[] zippedBytes = yourZipFunction(contentBytes);
	        // return Base64.getEncoder().encodeToString(zippedBytes);

	        return ""; // Replace with your actual zipping logic
	    }

	    private static String convertDocumentToString(Document document) {
	        // Implement the conversion logic similar to the previous example
	        // This is used to convert the Document back to a string after modification
	        // Omitted for brevity
	        return "";
	    }
	}



