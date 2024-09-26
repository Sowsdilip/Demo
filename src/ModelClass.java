
public class ModelClass {
	
	private int counter;
	private String name;
	
	public ModelClass() {
	}
	public ModelClass(int counter, String name) {
		this.counter = counter;
		this.name = name;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "ModelClass [counter=" + counter + ", name=" + name + "]";
	}
	
	

}
