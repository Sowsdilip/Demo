import java.text.DecimalFormat;

public class TestNumberFormat {

	public static void main(String[] args) {
		String numberString = "4567384234.29";

		// Parse the string to a double
		double number = Double.parseDouble(numberString);

		// Create a DecimalFormat object with comma separators
		DecimalFormat decimalFormat = new DecimalFormat("#,###.00");

		// Format the number with commas
		String formattedNumber = decimalFormat.format(number);

		// Print the formatted number
		System.out.println("Formatted Number: " + formattedNumber);
	}

}
