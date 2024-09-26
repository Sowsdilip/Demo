import java.io.File;
import java.util.HashSet;
import java.util.Set;

import javax.lang.model.element.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXMLClass {
	
	public static void main(String[] args) {
		String filePath = "./table.xml";
		try {
			System.out.println(getXmlColumns(filePath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static Set<String> getXmlColumns(String filePath) throws Exception {
        Set<String> columns = new HashSet<>();
        File xmlFile = new File(filePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
       Document doc = dBuilder.parse(xmlFile);
       doc.getDocumentElement().normalize();
       NodeList nodeList = doc.getElementsByTagName("NAME");
        for (int i = 0; i < nodeList.getLength(); i++) {
        	columns.add(nodeList.item(i).getTextContent());
        }
        return columns;
    }

}
