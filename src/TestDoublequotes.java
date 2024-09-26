import java.text.DecimalFormat;
import java.util.ArrayList;

public class TestDoublequotes {
	public static void main(String[] args) {
		String returnCode = "12345";
		
		String accountNumber = "Account Number";
		System.out.println("{\"Error Code\":"+"\""+returnCode+"\""+" , \"Account Number\":"+"\""+accountNumber+"\"}");
		//System.out.println(accountNumber.substring(0, 34));
		String applicantName = null;
		System.out.println(getApplicantName(applicantName));
		ArrayList<String> items = new ArrayList<>();
		items.add("test1");
		items.add("test2");
		items.add("test3");
		if(!items.isEmpty()){
			for (String item :items)
				System.out.println(item);
		}
		Double d = Double.valueOf(returnCode);
		System.out.println(new DecimalFormat("#").format(d));
		Double d1 = 1000d;
		System.out.println("Normal value :"+d1);
		
		System.out.println("Without decimal points :"+d1.longValue());
		
	}
	
	private static String getApplicantName(String applicantName) {
	       if(applicantName!=null && applicantName.length()>35)
	    	   applicantName = applicantName.substring(0,34);
			return applicantName;
		}

}
