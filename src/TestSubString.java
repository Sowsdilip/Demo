import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Generated;

public class TestSubString {
	@SuppressWarnings("null")
	public static void main(String[] args) {
		String date = "01-10-2024";
		String templateName = null;
		String sample = "3, EGBEYEMI STREET, ILUPEJU, LAGOS,ILUPEJU, MUSHIN, LAGOS";
		System.out.println("length   "+sample.length());
		try {
			System.out.println("date   "+getDate(date));
			templateName = templateName.replaceAll("[\\s()]", "");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sample.replaceAll("[\\s()]",""));
	}	
		private static java.sql.Date getDate(String timeStamp) throws ParseException {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	        Date utilDate = sdf.parse(timeStamp);
			java.sql.Date date;
			 date = new java.sql.Date(utilDate.getTime());
			return date;
		}
		// String sample =
		// "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"
		// + "abcdefghijklmnopqrstuvwxyzabcdefghij";
//		String sample = null;
//		int index = 35;
		// int index1 = sample.indexOf("</MSG_TYPE>");
		
//			if (sample==null||sample.length() < 35)
//				System.out.println("sample string " + sample);
//			else if (sample.length() <= 70) {
//				System.out.println(sample.substring(0, index));
//				System.out.println(sample.substring(index, sample.length()));
//			} else if (sample.length() > 70) {
//				int index1 = 70;
//				System.out.println(sample.substring(0, index));
//				System.out.println(sample.substring(index, index1));
//				if (sample.length() < 105)
//					System.out.println(sample.substring(index1, sample.length()));
//				else
//					System.out.println(sample.substring(index1, 105));
//			}
		
	//	System.out.println("length of sample string " + sample.length());
	}


