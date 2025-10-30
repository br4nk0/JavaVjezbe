package vjezbeVI;

import java.util.ArrayList;

public class Treci {
	private String nazivPrijemnika;
	private String serijskiBroj;
	private float latitude;
	private float longitude;
	private float altitude;
	
	public String getNazivPrijemnika() {
		return nazivPrijemnika;
	}
	public void setNazivPrijemnika(String nazivPrijemnika) {
		this.nazivPrijemnika = nazivPrijemnika;
	}
	public String getSerijskiBroj() {
		return serijskiBroj;
	}
	public void setSerijskiBroj(String serijskiBroj) {
		this.serijskiBroj = serijskiBroj;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getAltitude() {
		return altitude;
	}
	public void setAltitude(float altitude) {
		this.altitude = altitude;
	}
	public Treci() {
		
		this(null, null, 0.0, 0.0, 0.0);
		}
	
	
	public Treci(String nazivPrijemnika, String serijskiBroj, float latitude, float longitude, float altitude) {
		super();
		this.nazivPrijemnika = nazivPrijemnika;
		this.serijskiBroj = serijskiBroj;
		this.latitude = latitude;
		this.longitude = longitude;
		this.altitude = altitude;
	}
	
	public static ArrayList<Treci> pronadjiPoSerijskomBroju(ArrayList<Treci> niz, String serijskiBroj) {
		for (Treci a : niz) {
			if(a.getSerijskiBroj().equals(serijskiBroj)) {
				return a;
			}
		return null;
	}
	

}
