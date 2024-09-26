
public class Column {

	private String name;
	private String type;
	private String length;

	public Column() {
	}

	public Column(String name, String type,String length) {
		this.name = name;
		this.type = type;
		this.length = length;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getLength() {
		return type;
	}
	
	public void setLength(String length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "Column [name=" + name + ", type=" + type + ", length=" + length + "]";
	}
	
	

}
