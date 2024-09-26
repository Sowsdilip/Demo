
public class TestStringConcat {
	private static final String DATA_POWER_URL = "http://contracts.it.nednet.co.za/services/common-services/2013-07-01/FinSurvPayload/IDataPowerPayloadService/";
	public static void main(String[] args) {
		
		String stringconcat = DATA_POWER_URL+"GetPayLoadStatus";
		System.out.println(stringconcat);
		
		
	}

}
