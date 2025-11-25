package vjezbeVIII;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Restoran {
    private String naziv;
    private String adresa;
    private String pib;
    private List<Zaposleni> zaposleni = new ArrayList<>();

    public Restoran(String naziv, String adresa, String pib) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.pib = pib;
    }

    public void dodajZaposlenog(Zaposleni z) {
        zaposleni.add(z);
    }

    public boolean ukloniZaposlenogPoId(int id) {
        Optional<Zaposleni> o = zaposleni.stream().filter(z -> z.getId() == id).findFirst();
        if (o.isPresent()) {
            zaposleni.remove(o.get());
            return true;
        }
        return false;
    }

    public Zaposleni nadjiPoId(int id) {
        return zaposleni.stream().filter(z -> z.getId() == id).findFirst().orElse(null);
    }

    
     // Generiše obračun plata za sve zaposlene za dati mjesec/godinu, ispiše tabelu i vraća listu obračuna.
    
    public List<ObracunPlate> generisiObracun(int mjesec, int godina) {
        List<ObracunPlate> rezultati = new ArrayList<>();

        System.out.printf("Obracun plata za %02d/%d - Restoran: %s\n", mjesec, godina, naziv);
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("%5s | %-10s | %-10s | %-8s | %-12s | %-10s\n", "ID", "Ime", "Prezime", "Tip", "Sati (nedeljno)", "Plata EUR");
        System.out.println("--------------------------------------------------------------------------------");

        for (Zaposleni z : zaposleni) {
            double iznos = z.monthlySalary();
            String napomena = "";
            if (z instanceof Konobar) {
                Konobar k = (Konobar) z;
                if (k.getPrekovremeniSati() > 0) {
                    napomena = "uračunat prekovremeni rad";
                }
            } else if (z instanceof Menadzer) {
                Menadzer m = (Menadzer) z;
                if (m.getBonus() != 0) {
                    napomena = "bonus: " + m.getBonus() + " EUR";
                }
            }

            ObracunPlate o = new ObracunPlate(mjesec, godina, z, iznos, napomena);
            rezultati.add(o);

            System.out.printf("%5d | %-10s | %-10s | %-8s | %-12.2f | %-10.2f\n",
                    z.getId(), z.getIme(), z.getPrezime(), z.getTip(), z.getUkupnoSati(), iznos);
        }

        System.out.println("--------------------------------------------------------------------------------");
        double ukupno = rezultati.stream().mapToDouble(ObracunPlate::getIznos).sum();
        System.out.printf("Ukupan trosak plata za %02d/%d: %.2f EUR\n", mjesec, godina, ukupno);

        return rezultati;
    }

    public double ukupniTrosakZaMesec(int mjesec, int godina) {
        return generisiObracun(mjesec, godina).stream().mapToDouble(ObracunPlate::getIznos).sum();
    }

    public List<Zaposleni> getZaposleni() {
        return new ArrayList<>(zaposleni);
    }
}