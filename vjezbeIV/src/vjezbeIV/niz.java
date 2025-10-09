package vjezbeIV;

public class niz {
    public static void main(String[] args) {
        int[] niz = new int[10];
        // Popunjavanje niza brojevima od 1 do 10
        for (int i = 0; i < niz.length; i++) {
            niz[i] = i + 1;
        }
        // Ispis elemenata niza u obrnutom redosledu
        for (int i = niz.length - 1; i >= 0; i--) {
            System.out.print(niz[i] + " ");
        }
        System.out.println();
    }
}