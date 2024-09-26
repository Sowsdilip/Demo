import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberTest {
	public static List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (digits == null || digits.length() == 0) {
			return result;
		}

		Map<Character, String> digitToLetters = new HashMap<>();
		digitToLetters.put('2', "abc");
		digitToLetters.put('3', "def");
		digitToLetters.put('4', "ghi");
		digitToLetters.put('5', "jkl");
		digitToLetters.put('6', "mno");
		digitToLetters.put('7', "pqrs");
		digitToLetters.put('8', "tuv");
		digitToLetters.put('9', "wxyz");

		backtrack(result, digits, 0, "", digitToLetters);
		return result;
	}

	private static void backtrack(List<String> result, String digits, int index, String current, Map<Character, String> digitToLetters) {
	        if (index == digits.length()) {
	            result.add(current);
	            return;
	        }

	        char digit = digits.charAt(index);
	        String letters = digitToLetters.get(digit);

	        for (char letter : letters.toCharArray()) {
	            backtrack(result, digits, index + 1, current + letter, digitToLetters);
	        }
	    }

	public static void main(String[] args){
		System.out.println(letterCombinations("234"));
	}

}