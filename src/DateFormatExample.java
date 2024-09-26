import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormatExample {
    public static void main(String[] args) {
        // Input date string in dd-MM-yyyy format
        String inputDateString = "10-01-2024";
        String dateFormat = null;//"2024-01-10";
        System.out.println("formatted date 1    " +changeDateFormat(dateFormat));
        String check = checkNullLength();
        System.out.println(check!=null?check.length()>0?check:null:null);
        // Define the input date format
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Parse the input string to LocalDate
        LocalDate date = LocalDate.parse(inputDateString, inputFormatter);

        // Define the desired output format
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Format the LocalDate to the desired output format
        String formattedDate = date.format(outputFormatter);

        // Print the result
        System.out.println("Original date: " + inputDateString);
        System.out.println("Formatted date: " + formattedDate);
    }
    
    private static String checkNullLength() {
		// TODO Auto-generated method stub
		return "";
	}

	private static String changeDateFormat(String date) {
		String formattedDateString = null;
		if (null != date) {
			SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd-MM-yyyy");
			try {
				Date originalDate = inputDateFormat.parse(date);
				formattedDateString = outputDateFormat.format(originalDate);
			} catch (Exception  e) {
				System.out.println("Exception while formatting date..." + e);
			}
			return formattedDateString;
		} else
			return date;
	}

}
