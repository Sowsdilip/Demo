import java.util.HashMap;
import java.util.Map;

public class TestArrayList {
	
	public static void main(String[] args) {
		Map<String,String> checkMap = new HashMap<>();
		checkMap.put("a","1");
		System.out.println(checkMap);
		checkMap.put("a","2");
		System.out.println(checkMap.get("a"));
		System.out.println(checkMap);
		String c = checkMap.get("a");
	     System.out.println(c);	
	}

}
