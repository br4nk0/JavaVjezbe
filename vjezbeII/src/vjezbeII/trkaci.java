package vjezbeII;
import java.util.Scanner;

public class trkaci {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	    
		System.out.println("unesi kortinate centra");
		double cx = sc.nextDouble();
		double cy = sc.nextDouble();
	
		System.out.println("unesi kortinate prvog kruga");
		double r1 = sc.nextDouble();
		
		System.out.println("unesi kortinate drugog kruga");
		double r2 = sc.nextDouble();
		
		System.out.println("unesi broj trkaca");
		int N = sc.nextInt();
		
		int naStazi = 0;
		
		for (int i=0; i<N; i++) {
			
			System.out.println("unesite x trkaca");
			double x = sc.nextDouble();
			
			System.out.println("unesite y trkaca");
			double y = sc.nextDouble();
			
			
			double d = Math.sqrt(Math.pow(x-cx, 2)+Math.pow(y-cy, 2));
			
			if(d>=r1&&d<=r2 && i > cy) {
				naStazi ++;
			}
			
		}
		
		

	}

}
