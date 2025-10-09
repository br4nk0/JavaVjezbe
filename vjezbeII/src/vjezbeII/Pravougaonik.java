package vjezbeII;
import java.util.Scanner;

public class Pravougaonik {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc = new Scanner(System.in);
				
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		
		double P = a*b;
		double O = 2*a+2*b;
		
		System.out.printf("Povrsina je:%.2f O=%.2f%n",P,O);
		
	}

}
