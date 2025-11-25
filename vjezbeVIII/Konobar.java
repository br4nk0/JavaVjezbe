package vjezbeVIII;

public class Konobar extends Zaposleni {
    private double prekovremeniSati;

    public Konobar(int id, String ime, String prezime, double plataPoSatu, double ukupnoSati, double prekovremeniSati) {
        super(id, ime, prezime, plataPoSatu, ukupnoSati);
        this.prekovremeniSati = prekovremeniSati;
    }

    public double getPrekovremeniSati() {
        return prekovremeniSati;
    }

    public void setPrekovremeniSati(double prekovremeniSati) {
        this.prekovremeniSati = prekovremeniSati;
    }

    @Override
    public double monthlySalary() {
        double regularWeekly = getUkupnoSati() * getPlataPoSatu();
        double overtimeWeekly = prekovremeniSati * getPlataPoSatu() * 1.2;
        return 4 * (regularWeekly + overtimeWeekly);
    }

    @Override
    public String getTip() {
        return "Konobar";
    }
}
