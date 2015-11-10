import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 
 * 10th November 2015
 * @author The RoL
 * Design:
 * 		ReadJson implements FileFormatReadBehavior
 * 		ConvertJson implements FileFormatConvertBehavior
 * 		FileFormat is an abstract class
 * 		GeoJson extends JSONClass
 * 		JSONClass is a standalone abstract class
 * 
 */
public class GeoMain {
	static int PASS = 0;
	static int FAIL = 1;
	static int MAXLENGTHCITY = 100;
	static String URLFIRSTPART = "http://api.goeuro.com/api/v2/position/suggest/en/";
	
	static int parseArguments(String[] args) {
		if (args.length != 1 || args[0].length() > MAXLENGTHCITY) {
			return FAIL;
		}
		return PASS;
	}
	
	public static void main(String[] args) {
		// Create an instance to convert JSON to CSV
		JSONClass gejs = new GeoJson(); 
		
		int error = parseArguments(args);
	
		if (FAIL == error) {
			System.out.println("Invalid Argument");
			return;
		}
		// retrieve the JSON data
		String urlStringPath = URLFIRSTPART + args[0];
		
		// Ensure that space and other characters will get through
		try {
			System.out.println("URL to parse: " + URLEncoder.encode(urlStringPath, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			System.out.println("URL encoding failed");
			e.printStackTrace();
		}
		gejs.readJsonfromURL(urlStringPath);
		
		//convert the JSON data to CSV
		String locationofcsvOnDisk = "geo.csv";
		gejs.convertJsontocsv(locationofcsvOnDisk);
	}
}
