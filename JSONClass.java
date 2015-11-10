/**
 * 10th November 2015
 * 
 * @author The Ocean
 * In the future use this to compile all the methods that 
 * are common for a JSON file
 *
 */
public abstract class JSONClass {
	FileFormatReadBehavior readBehavior;
	FileFormatConvertBehavior convertBehavior;
	private String datajson;
	
	protected void readJsonfromURL(String urlPath) {
		 datajson = readBehavior.retrieveData(urlPath);
	}
	
	protected String getJSONData() {
		return datajson;
	}
	
	public void convertJsontocsv(String locatCSVFile) {
		convertBehavior.convertJSONtoCSV(getJSONData(), locatCSVFile);
	}	
}
