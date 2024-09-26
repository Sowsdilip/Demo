import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "person")
@XmlType(propOrder = {"name", "age"})
public class Person {
    private String name;
    private int age;

    // Default constructor is needed for deserialization
    public Person() {
    	
    	StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		String callingMethod = stackTrace[2].getMethodName();
		System.out.println("calling method "+callingMethod);
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
