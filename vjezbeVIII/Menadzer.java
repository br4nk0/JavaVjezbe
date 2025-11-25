package vjezbeVIII;

public class Menadzer extends Zaposleni {
    private double bonus;

    public Menadzer(int id, String ime, String prezime, double plataPoSatu, double ukupnoSati, double bonus) {
        super(id, ime, prezime, plataPoSatu, ukupnoSati);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double monthlySalary() {
        return 1300 + 4 * getUkupnoSati() * getPlataPoSatu() + bonus;
    }

    @Override
    public String getTip() {
        return "Menadzer";
    }
}
