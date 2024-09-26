import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "people")
@XmlType(propOrder = {"personList"})
public class People {
	@XmlElementRef(name = "personList")
    private List<Person> personList;

    
    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}

