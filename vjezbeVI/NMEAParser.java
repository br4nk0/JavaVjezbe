package vjezbeVI;


public class NMEAParser {

     public static void main(String[] args) {
        System.out.print(NMEAParser.dekodiraj("$GNGGA,151603.00,4225.05090,N,01846.12270,E,4,12,0.54,22.1,M,36.8,M,1.0,0004*52"));
    }

	 private static char[] dekodiraj(String string) {
		 String[] parts = string.split(",");
		 if(parts[0].equals("$GNGGA")) {
			 String latitude = parts[2];
			 String longitude = parts[4];
			 String latHemisphere = parts[3];
			 String lonHemisphere = parts[5];
			 
			 double latDegrees = Double.parseDouble(latitude.substring(0, 2));
			 double latMinutes = Double.parseDouble(latitude.substring(2));
			 double lonDegrees = Double.parseDouble(longitude.substring(0, 3));
			 double lonMinutes = Double.parseDouble(longitude.substring(3));
			 
			 double latDecimal = latDegrees + (latMinutes / 60);
			 double lonDecimal = lonDegrees + (lonMinutes / 60);
			 
			 if(latHemisphere.equals("S")) {
				 latDecimal = -latDecimal;
			 }
			 if(lonHemisphere.equals("W")) {
				 lonDecimal = -lonDecimal;
			 }
			 
			 String result = String.format("Latitude: %.6f, Longitude: %.6f", latDecimal, lonDecimal);
			 return result.toCharArray();
		 }
		return null;
	 }
}
