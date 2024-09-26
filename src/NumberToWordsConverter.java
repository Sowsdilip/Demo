public class NumberToWordsConverter {
    
    // Define arrays for units, teens, tens, and thousands
    private static final String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] teens = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] thousands = {"", "Thousand", "Million", "Billion", "Trillion"};
    
    // Function to handle numbers less than 1000
    private static String convertLessThanThousand(int num) {
        if (num == 0) {
            return "";
        } else if (num < 10) {
            return units[num];
        } else if (num < 20) {
            return teens[num - 10];
        } else if (num < 100) {
            return tens[num / 10] + " " + convertLessThanThousand(num % 10);
        } else {
            return units[num / 100] + " Hundred " + convertLessThanThousand(num % 100);
        }
    }
    
    // Main function to convert number to words
    public static String convertNumberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        String words = "";
        int i = 0;
        boolean first = true;
        while (num > 0) {
            if (num % 1000 != 0) {
                String and = " ";
//                if (!first) {
//                    and = " and ";
//                }
                words = convertLessThanThousand(num % 1000) + " " + thousands[i] + and + words;
            }
            if (num % 1000 < 100 && num % 1000 > 0) {
                words = "and " + words;
            }
            first = false;
            num /= 1000;
            i++;
        }
        
        return words.trim();
    }
    
    // Test the function
    public static void main(String[] args) {
        int number = 123000706;
        System.out.println(convertNumberToWords(number));
    }
}
