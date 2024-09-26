

import java.util.Arrays;
import java.util.Scanner;

public class TestFibonacii {
	
//	static Scanner in = new Scanner(System.in);
	
	public static void main(String args[]){
//		 int num;
//		 long j=1;
//		 System.out.println("******************************");
//		 System.out.println("Enter how many numbers to be printed in fibonacii series....");
//		 num = in.nextInt();
//		 long[] sequence = new long[num];
//		 sequence[0]=0;
//		 for(int i=1;i<num;i++){
//			 sequence[i]=j+sequence[i-1];
//			 j=sequence[i-1];
//		 }
//		 System.out.println("******************************");
//		 System.out.println("fibonacii series....");
//		 System.out.print(Arrays.toString(sequence));

		        
		        Scanner sc=new Scanner(System.in);
		        String A=sc.next();
		        String B;
		        StringBuilder C = new StringBuilder();
		        String D;
		        int length = A.length();
		        System.out.println("Length......"+length);
		        if(length%2==0) {
		          B = A.substring(0,length/2);
		          System.out.println("B is..."+B);
		          C.append(A.substring(length/2,length)); 
		          System.out.println("C is....."+A.substring(length/2,length));
		          D = C.reverse().toString();    
		          System.out.println("D is..."+D);
		          if(B.contentEquals(D)) 
		           System.out.println("yes");
		          else
		          System.out.println("No");
		        }else{
		          B= A.substring(0,length/2);
		          System.out.println("B is..."+B);
		          C.append(A.substring(length/2+1,length)); 
		          System.out.println("C is....."+A.substring(length/2+1,length));
		          D = C.reverse().toString();  
		          System.out.println("D is..."+D);
		          if(B.contentEquals(D)) 
		           System.out.println("yes");
		          else
		          System.out.println("No");
		        }
		      sc.close();
		    }
		    
		




	}


