package vjezbeII;
import java.util.Scanner;
public class pitagora {

	public static void main(String[] args) {
		
     	Scanner sc = new Scanner(System.in);
     	
     	double xH = sc.nextDouble(),yH= sc.nextDouble(); //HRAST
     	double xK = sc.nextDouble(),yK= sc.nextDouble(); //KUCA
     	double xB = xK+2;
     	double yB = yK-3;
     	
     	double HB = Math.sqrt(Math.pow((yB-yH),2)+Math.pow((xB-xH),2));
     	
     	System.out.printf("Udaljenost od hrasta do blaga je %.2f",HB);
     	

	}

}
