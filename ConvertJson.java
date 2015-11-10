import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * 10th November 2015
 * 
 * @author The RoL
 * @ TODO:
 * 		If more complex stuffs needed for CSV use :JAR File from https://code.google.com/p/opencsv/
 * 
 * This method uses the json data and retrieve "_id, name, type, latitude, longitude" elements
 * and are comma separated one line at a time 
 * 
 * Method List:
 * 		convertJSONtoCSV:
 * 			Arguments: String jsonString to be converted to CSV , String csv file to write to
 * 			Return: none
 */
public class ConvertJson implements FileFormatConvertBehavior {
	public void convertJSONtoCSV(String jsonStringToConvert, String locationofcsvOnDisk) {
		// Json String data sent to jsonArray 
		JsonArray jsonArray = new JsonArray();
        jsonArray = new JsonParser().parse(jsonStringToConvert).getAsJsonArray(); 
        Writer writer = null;
        try {
        	// Create and specify the file to write to
        	writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(locationofcsvOnDisk), "utf-8"));
        	
	 		writer.write("_id, name, type, latitude, longitude");
	 		writer.write(System.lineSeparator());  
	 		
        	// Write csv file to the file specified
    	 	for(JsonElement jsArrElement : jsonArray ) {
	            JsonObject jsonObject = jsArrElement.getAsJsonObject();
	            JsonElement je = jsonObject.getAsJsonPrimitive("_id");
	            String jeString ="";
	            jeString = (null == je) ? "":je.toString();    
	            writer.write(jeString.trim());
	            writer.write(", ");
	            je = jsonObject.getAsJsonPrimitive("name");
	            jeString = (null == je) ? "":je.toString(); 
	            writer.write(jeString.trim());
	            writer.write(", ");
	            je = jsonObject.getAsJsonPrimitive("type");
	            jeString = (null == je) ? "":je.toString(); 
	            writer.write(jeString.trim());
	            writer.write(",");
	            JsonObject jo = jsonObject.getAsJsonObject("geo_position");
	            jeString = (null == jo) ? "":jo.getAsJsonPrimitive("latitude").toString(); 
	            writer.write(jeString.trim());
	            writer.write(",");
	            jo = jsonObject.getAsJsonObject("geo_position");
	            jeString = (null == jo) ? "":jo.getAsJsonPrimitive("longitude").toString(); 
	            writer.write(jeString.trim());
	            writer.write(System.lineSeparator());      	
	        }
        	 	
        } catch (UnsupportedEncodingException e) {
			System.out.println("Encoding Not supported: " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("Null Pointer Exception: " + e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("Problem with a File: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO Failed:" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Other Exception: " + e.getMessage());
		} 
        finally {
			// to prevent leaking
			try {
				if(writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				System.out.println("IO Failed!: " + e.getMessage());
			}
		}
	}
}
