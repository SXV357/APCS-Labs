public class GeolocationRunner{
    public static void main(String[] args){
        GeoLocation loc1 = new GeoLocation(33.123691, -96.798735);
        Place p1 = new Place("Frisco ISD Admin Building", "5515 Ohio Drive, Frisco, TX, 75035" ,loc1);
        System.out.println(p1.toString());
        Place p2 = new Place("Liberty High School", "15250 Rolater Rd, Frisco, TX, 75035", new GeoLocation(33.1407, 96.7425));
        System.out.println(p2.toString());
        System.out.println(p2.distanceTo(p1));

    }
}

class GeoLocation{
    private double latitude;
    private double longitude;  

    public GeoLocation(double lati, double longi){
        latitude = lati;
        longitude = longi;
    }

    public String toString(){
        return "Latitude: " + latitude + " Longitude: " + longitude;
    }

    public double distanceTo(GeoLocation other){
        double lat1 = Math.toRadians(latitude);
        double long1 = Math.toRadians(longitude);
        double lat2 = Math.toRadians(other.latitude);
        double long2 = Math.toRadians(other.longitude);

        double theCos = Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(long1 - long2);
        double arcLength = Math.acos(theCos);

        return arcLength * 3963.1676;
    }
}

// uses objects of Geolocation class
class Place{
    private String name;
    private String address;
    private GeoLocation location;

    public Place(String n, String a, double lati, double longi){
        name = n;
        address = a;
        location = new GeoLocation(lati, longi);
    }

    public Place(String n, String a, GeoLocation loc){
        name = n;
        address = a;
        location = loc;
    }

    public double distanceTo(Place other){
        return location.distanceTo(other.location);
    }

    public String toString(){
        return "Name: " + name + " \n" + " Address: " + address + " \n" + location;
    }
}
