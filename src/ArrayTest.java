import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ArrayTest {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number");
		int number = in.nextInt();
		if (number % 2 == 0) {
			if (number > 6 && number < 20)
				System.out.println("Weird");
			else
			System.out.println("Not Weird");
		} else
			System.out.println("Weird");
	}
}