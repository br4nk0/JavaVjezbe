package vjezbeIII;

public class televizor {
    // Polja
    private int brojKanala;
    private String nazivKanala;
    private int jacinaTona;

    // Getteri
    public int getBrojKanala() { return brojKanala; }
    public String getNazivKanala() { return nazivKanala; }
    public int getJacinaTona() { return jacinaTona; }

    // Setter za broj kanala
    public void setBrojKanala(int brojKanala) {
        if (brojKanala >= 1) this.brojKanala = brojKanala;
        else this.brojKanala = 1;
    }

    // Konstruktor
    public televizor(int brojKanala, String nazivKanala, int jacinaTona) {
        setBrojKanala(brojKanala);
        this.nazivKanala = nazivKanala;
        if (jacinaTona >= 0 && jacinaTona <= 10) {
            this.jacinaTona = jacinaTona;
        } else {
            this.jacinaTona = 5; // podrazumijevana vrijednost
        }
    }

    // Metod za pojacavanje tona
    public void pojacajTon() {
        if (jacinaTona < 10) {
            jacinaTona++;
        } else {
            System.out.println("ton je na maks");
        }
    }
}