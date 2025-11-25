package vjezbeVIII;

public class Kuvar extends Zaposleni {

    public Kuvar(int id, String ime, String prezime, double plataPoSatu, double ukupnoSati) {
        super(id, ime, prezime, plataPoSatu, ukupnoSati);
    }

    @Override
    public double monthlySalary() {
        return 1500 + 4 * getUkupnoSati() * getPlataPoSatu();
    }

    @Override
    public String getTip() {
        return "Kuvar";
    }
}
