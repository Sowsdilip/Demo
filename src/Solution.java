

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		if (s.length() == 0) {
			System.out.println("0");
		} else {
			s = s.replaceAll("[^a-zA-Z0-9]", " ");
			System.out.println(s);
			s = s.trim().replaceAll("\\s+", " ");//removes extra spaces between words in a sentence
			System.out.println(s);
			String[] strArray = s.split(" ");
			System.out.println(Arrays.toString(strArray));
			if (strArray.length == 1) {
				if (strArray[0].matches(".*[a-zA-Z].*")) {
					System.out.println(strArray.length);
					System.out.println(strArray[0]);
				} else
					System.out.println("0");
			}else{
				System.out.println(strArray.length);
				for (int i = 0; i < strArray.length; i++)
					System.out.println(strArray[i]);
			}
			scan.close();
		}
	}

}
