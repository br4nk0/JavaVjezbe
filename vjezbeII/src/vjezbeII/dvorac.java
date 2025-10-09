package vjezbeII;
import java.util.Scanner;
public class dvorac {
//dvorac, katapult, rastojanje, health, damage
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int N = sc.nextInt(); // broj katapulta
		long D = sc.nextLong(); // maksimalno rastojanje
		long HD = sc.nextLong(); // health dvorca
		long KA = sc.nextLong(); // damage po katapultu
		int brojprijetnji = 0;
		for (int i=0; i < N; i++) {
			long x = sc.nextLong();
			long y = sc.nextLong();
			long menheten = Math.abs(x) + Math.abs(y);
			if (menheten <= D) {
				brojprijetnji++;
			}
		}
		long totalDamage = brojprijetnji * KA;
		System.out.printf("Nas dvorac ukupno ugrozava %d katapulta.\n", brojprijetnji);
		System.out.printf("Ukupan damage je %d.\n", totalDamage);
		if (totalDamage >= HD) {
			System.out.println("Dvorac je srusen.");
		} else {
			System.out.println("Dvorac NIJE srusen.");
		}
		sc.close();
	}
}