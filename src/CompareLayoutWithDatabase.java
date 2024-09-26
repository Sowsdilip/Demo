
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class CompareLayoutWithDatabase {

	public static void main(String[] args) {
		try {

			Set<String> xmlColumns = getXmlColumns("./table.xml");

			Set<String> dbColumns = getDatabaseColumns("jdbc:oracle:thin:@dev-ecobank:1521:TFGHDEV", "EXIMTRX",
					"EXIMTRX", "IMCO_STL_STTL");

			Set<String> missingColumns = new HashSet<>(xmlColumns);
			missingColumns.removeAll(dbColumns);

			List<Column> columns = getColumnObjects("./table.xml");
			Map<String, String> columnMap = getColumnMap(columns);

			if (missingColumns.isEmpty()) {
				System.out.println("All columns from the XML layout are present in the database.");
			} else {
				System.out.println("Missing columns in the database: " + missingColumns);
				for (String missingColumn : missingColumns)
					System.out.println("Missing Column Detials:  " + columnMap.get(missingColumn));
				// System.out.println("Missing column details: "+columns.get);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Map<String, String> getColumnMap(List<Column> columns) {
		Map<String, String> columnMap = new HashMap<>();
		for (Column column : columns)
			columnMap.put(column.getName(), column.toString());
		return columnMap;
	}

	private static List<Column> getColumnObjects(String filePath) {
		List<Column> columns = new ArrayList<>();
		try {
			// Create XmlMapper for XML to JSON conversion
			XmlMapper xmlMapper = new XmlMapper();
			String xmlContent = new String(Files.readAllBytes(Paths.get(filePath)));
			// Read XML into JsonNode
			JsonNode jsonNode = xmlMapper.readTree(xmlContent.getBytes());
			// Create ObjectMapper for converting JsonNode to JSON string
			ObjectMapper objectMapper = new ObjectMapper();
			// Convert JsonNode to JSON string
			String jsonData = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
			JsonNode rootNode = objectMapper.readTree(jsonData);
			JsonNode columnsNode = rootNode.path("COLUMN");
			if (columnsNode.isArray()) {
				for (JsonNode columnNode : columnsNode) {
					// Each employeeNode is a JSON object
					Column column = new Column();
					String name = columnNode.path("NAME").asText();
					String type = columnNode.path("TYPE").asText();
					String length = columnNode.path("LENGTH").asText();
					column.setName(name);
					column.setType(type);
					column.setLength(length);
					columns.add(column);
					// System.out.println("Name: " + name + ", Type: " + type);
				}
			} else
				System.out.println("not array");

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return columns;
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

	private static Set<String> getDatabaseColumns(String url, String user, String password, String tableName)
			throws Exception {
		Set<String> columns = new HashSet<>();
		Connection conn = DriverManager.getConnection(url, user, password);
		Statement stmt = conn.createStatement();
		// ResultSet rs = stmt.executeQuery("DESC EXIMTRX." + tableName);

		ResultSet rs = stmt.executeQuery("SELECT COLUMN_NAME\r\n" + "FROM ALL_TAB_COLUMNS\r\n"
				+ "WHERE TABLE_NAME = 'IMCO_STL_STTL'\r\n" + "ORDER BY COLUMN_NAME");

		while (rs.next()) {
			columns.add(rs.getString("COLUMN_NAME"));
		}
		rs.close();
		stmt.close();
		conn.close();
		return columns;
	}
}
