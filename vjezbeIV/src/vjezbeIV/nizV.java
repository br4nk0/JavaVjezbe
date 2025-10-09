package vjezbeIV;

public class nizV {

	public static void main(String[] args) {
		// Niz sa brojem posjeta za poslednjih 10 fudbalskih utakmica
		int[] posjete = {1200, 1500, 989, 2000, 2882, 3};
		int max = posjete[0];
		for (int i = 1; i < posjete.length; i++) {
			if (posjete[i] > max) {
				max = posjete[i];
			}
		}
		System.out.println("Najvise posjeta u jednom danu: " + max);
	}
}