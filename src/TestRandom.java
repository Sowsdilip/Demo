import java.util.concurrent.ThreadLocalRandom;

public class TestRandom {
	public static void main(String[] args) {
		int randomNum = ThreadLocalRandom.current().nextInt(10, 100000 + 1);
		String num = randomNum+" ";
		System.out.println("Random Number "+randomNum);
		System.out.println("num "+num);
	
	}
	
}
