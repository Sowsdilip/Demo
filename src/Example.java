

import java.io.PrintStream;
import java.util.*;

public class Example {
	public static void main(String[] args) {
//		StringBuilder str = new StringBuilder("Hello World!");
//		System.out.println(str.toString());
//		str.reverse();
//		System.out.println(str.toString());
		 PrintStream stream = new PrintStream(System.out); 
		String a ="apple";
		String b ="eaplp";
		char[] aCopy = a.toCharArray();
	    char[] bCopy = b.toCharArray();
	    Arrays.sort(aCopy);
	     stream.println(aCopy);
//	    Arrays.sort(bCopy);
//	     stream.println(bCopy);
	    char temp;
	    for(int i=0;i<bCopy.length;i++){
	    	for(int j=i+1;j<bCopy.length;j++){
	    		if(bCopy[j]<bCopy[i]){
	    			temp=bCopy[j];
	    			bCopy[j]=bCopy[i];
	    			bCopy[i]=temp;
	    		}
	    	}
	    }
	   
	    stream.println(bCopy);
	}
}