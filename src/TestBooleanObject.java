import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class TestBooleanObject {
	
	
	public static void main(String args[]) {
		String responseData = "{\"data\":{\"success\":true,\"loanNumber\":\"002233\"},\"metadata\":{\"resultData\":[{\"resultDetail\":[{\"result\":\"R00\",\"status\":\"SUCCESS\",\"reason\":\"NO_ERROR\"}]}]}}";
		Boolean status = false;
		JSONObject jsonObject = (JSONObject) JSONValue.parse(responseData);
		JSONObject data=(JSONObject) jsonObject.get("data");
		status=(Boolean) data.get("success");
		System.out.println(status);
		if(!status)
			System.out.println(status);
		String number ="0";
		double num =  Double.parseDouble(number);
		System.out.println(num);

	}
	
	public void testMethod(){
		String number = "1000725";
		int num =  Integer.parseInt(number);
		System.out.println(num);
	}
	
}
