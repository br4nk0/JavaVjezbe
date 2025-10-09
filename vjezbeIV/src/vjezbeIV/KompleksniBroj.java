package vjezbeIV;

public class KompleksniBroj {
	// atruibuti klase
	private float realniDio;
	private float imaginarniDio;
	
	// konstruktor
	public KompleksniBroj() {
		realniDio = 0;
		imaginarniDio = 0;
	}
	public KompleksniBroj(float a, float b) {
		realniDio = a;
		imaginarniDio = b;
	}
	public KompleksniBroj(float a) {
		realniDio = a;
		imaginarniDio = 0;
	}
	 //geteri i seteri
	public float getRealniDio() {
		return realniDio;
	}
	public float getImaginarniDio() {
		return imaginarniDio;
	}
	public void postaviRealniDio(float a) {
		realniDio = a;
	}
	public void postaviImaginarniDio(float b) {
		imaginarniDio = b;
	}
	public void odstampaj() {
		if(imaginarniDio > 0)
			System.out.printf("%.2f + %.2fi%n", realniDio, imaginarniDio);
		else
		System.out.printf("%.2f - %.2fi%n", realniDio, -imaginarniDio);
	}
	public float modul () {
		return (float) Math.sqrt(realniDio * realniDio + imaginarniDio * imaginarniDio);
	}
	
	//sabiranje
	public KompleksniBroj saberi(KompleksniBroj z) {
		KompleksniBroj rez = new KompleksniBroj();
		rez.realniDio = realniDio + z.realniDio;
		rez.imaginarniDio = imaginarniDio + z.imaginarniDio;
		return rez;
	}	
}
