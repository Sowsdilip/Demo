
public class ExceptionHandling {
	
	public static void add(int a, int b) throws Exception{
		try{
			System.out.println("add");
		System.out.println(a+b);
		//if(b==1) throw new Exception();
		}catch(Exception e){
			System.out.println("Exception in add   "+e);
			throw e;
		}
	}
	
	public static void substract(int a, int b){
		try{
			System.out.println("substract");
		System.out.println(a-b);
		}catch(Exception e){
			System.out.println("Exception in subsract   "+e);
			throw e;
		}
	}
	
	public static void multiply(int a, int b){
		try{
			System.out.println("multiply");
		System.out.println(a*b);
		}catch(Exception e){
			System.out.println("Exception in multiply  "+e);
			throw e;
		}
	}
	
	public static void divide(int a, int b){
		try{
			System.out.println("divide");
		System.out.println(a/b);
		}catch(Exception e){
			System.out.println("Exception in divide   "+e);
			throw e;
		}
	}
	
	public static void main(String args[]){
		int counter = 0;
		int a=1;
		for(int b=0;b<=4;b++){
			try{
				System.out.println("a="+a+" b="+b);
				if(b==2)
					continue;
				add(a,b);
				divide(a,b);
				substract(a,b);
				multiply(a,b);
				a++;
//				 if(counter==0)
//					 counter++;
//				 else 
//					break;
//					b=-1;
				
			}catch(Exception e){
				System.out.println("Exception in main   "+e);
			}
		}
		
	}

}
