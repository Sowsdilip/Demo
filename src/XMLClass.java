import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;

public class XMLClass {
    public static void main(String[] args) {
        // Example XML string
        String xml = "<StatusDTO xmlns:ns=\"http://example.com/schema\" xmlns=\"http://example.com/schema\"><statusCode xmlns=\"http://example.com/schema\">200</statusCode></StatusDTO>";

        // Remove namespaces from XML
        String xmlWithoutNamespaces = removeNamespaces(xml);
        System.out.println("XML without namespaces:");
        System.out.println(xmlWithoutNamespaces);
    }

    private static String removeNamespaces(String xml) {
        try {
            // Parse XML string into DOM Document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true); // Enable namespace awareness
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xml)));

            // Remove namespaces from elements and attributes
            removeNamespaces(document.getDocumentElement());

            // Serialize modified DOM Document back to XML string
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(document), new StreamResult(writer));
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void removeNamespaces(Node node) {
        // Remove namespace prefix from element name
        node.setPrefix(null);
        node.getAttributes().removeNamedItem("xmlns");

        // Remove namespace prefix from child elements
        for (Node child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                removeNamespaces(child);
            }
        }
    }
}
