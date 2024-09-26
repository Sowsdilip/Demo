

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegPattern	{
		public static void main(String[] args){
			Scanner in = new Scanner(System.in);
			int testCases = Integer.parseInt(in.nextLine());
	        String[] array = new String[testCases];
			while(testCases>0){
				String pattern = in.nextLine();
	             array[testCases-1]= pattern;
	            testCases--;
			}
			testCases=array.length;
	        while(testCases>0){
	         try{	
	        	Pattern.compile(array[testCases-1]);
	        	System.out.println("Valid");
	         }catch(Exception e){
	           System.out.println("Invalid");
	          }
	            
	            testCases--;
	        }
		}
	}





