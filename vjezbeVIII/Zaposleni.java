package vjezbeVIII;

public abstract class Zaposleni {
    private int id;
    private String ime;
    private String prezime;
    private double plataPoSatu; 
    private double ukupnoSati; 

    public Zaposleni(int id, String ime, String prezime, double plataPoSatu, double ukupnoSati) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.plataPoSatu = plataPoSatu;
        this.ukupnoSati = ukupnoSati;
    }

    public int getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public double getPlataPoSatu() {
        return plataPoSatu;
    }

    public void setPlataPoSatu(double plataPoSatu) {
        this.plataPoSatu = plataPoSatu;
    }

    public double getUkupnoSati() {
        return ukupnoSati;
    }

    public void setUkupnoSati(double ukupnoSati) {
        this.ukupnoSati = ukupnoSati;
    }

    public abstract double monthlySalary();

    public abstract String getTip();
}
