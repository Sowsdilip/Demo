import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XmlToObjectListExample {
    public static void main(String[] args) {
        String xmlData = "<people>" +
                     "    <person><name>John</name><age>30</age></person>" +
                     "    <person><name>Jane</name><age>25</age></person>" +
                     "</people>";

        try {
            // Create XmlMapper for XML to JSON conversion
            XmlMapper xmlMapper = new XmlMapper();

            // Read XML into JsonNode
            JsonNode jsonNode = xmlMapper.readTree(xmlData.getBytes());

            // Create ObjectMapper for converting JsonNode to JSON string
            ObjectMapper objectMapper = new ObjectMapper();

            // Convert JsonNode to JSON string
            String jsonData = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
            JsonNode rootNode = objectMapper.readTree(jsonData);
            // Print JSON data
            System.out.println(jsonData);
           JsonNode employeesNode = rootNode.path("person");
            if (employeesNode.isArray()) {
                for (JsonNode employeeNode : employeesNode) {
                    // Each employeeNode is a JSON object
                    String name = employeeNode.path("name").asText();
                    int age = employeeNode.path("age").asInt();
                    System.out.println("Employee Name: " + name + ", Age: " + age);
                }
            }else
            	System.out.println("not array");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
