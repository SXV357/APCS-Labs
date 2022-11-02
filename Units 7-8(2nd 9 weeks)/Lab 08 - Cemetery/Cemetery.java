import java.util.*;
import java.io.*;

class Cemetery {
    private ArrayList<Tombstone> graves;

    public Cemetery(String fileName) throws IOException{
        Scanner file = new Scanner(new File(fileName));
		try {
        while(file.hasNextLine()){
            Scanner line = new Scanner(file.nextLine());
            String name = line.next();
            String burialDate = line.next();
            int age = line.nextInt();
            String address = line.next();
            Tombstone tombstone = new Tombstone(name, burialDate, age, address);
            graves.add(tombstone);
        }
	} catch (Exception e) {
		System.out.println("Error:" + e);
	}
    }

    //  takes the String version of a person's age (e.g. "11.5" or "22d") from the input file and return the (rounded) total number of days that person was alive when they were interred
    public static int parseAge(String ageString)
	{
		if (ageString.contains("d")) { //age supplied in days
			ageString = ageString.replaceAll("d", "");
			return Integer.parseInt(ageString);
		}
		
		int result = 0;
		
		boolean done = true;

		try { result = Integer.parseInt(ageString); } //is the String a whole number of years?
		
		catch (NumberFormatException n) { done = false; }
		
		if (done) //successfully parsed as an int, return value
			return 365 * result; //ignoring leap years
		
		double ageDouble = 0;
		
		done = true;
		
		try { ageDouble = Double.parseDouble(ageString); } //is the String a floating point number of years?
		
		catch (NumberFormatException n) { done = false; }
		
		if (done) { //successfully parse as a double, String doesn't contain any text
			return (int)(ageDouble * 365); //ignoring leap years, using 30 for days in a month
		}
		
		if (ageString.contains("w")) { //age is supplied in weeks, return appropriately
			ageString = ageString.replaceAll("w", "");
			return Integer.parseInt(ageString) * 7;
		}
		
		return 0;
	}
}
