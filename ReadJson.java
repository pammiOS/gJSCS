/**
 *  10th November 2015
 *  
 *  @author The Ocean
 *  @TODO If need to read more complex stuffs from json data use :
 *  	GsonBuilder
 *      registerTypeAdapter
 *  	gsonBuilder.create(); 
 *  
 *  ReadJson is used to get the JSON data 
 *  The method retrieveData returns a StringBuilder
 *  Method List:
 *  	retrieveData
 *  		Arguments: String url
 *  		Return: String of json data
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.JsonArray;

public class ReadJson implements FileFormatReadBehavior {

	public String retrieveData(String urlString) {
		// Hardcode the link - Better to be in a config file but then would have to pass
		// the config file on the command line which is not a requirement
		JsonArray jsonArray = new JsonArray();
	    StringBuilder jsonString = new StringBuilder();
	    BufferedReader inputData = null;
		try {
			// Create an instance of the url
			URL url = new URL(urlString);
			
			// Set format and create and instance to read the url
			inputData = new BufferedReader(
			        new InputStreamReader(url.openStream(), "utf-8"));
			
			// read each line from URL and append data to jsonString
	        String inpLine;
	        while ((inpLine = inputData.readLine()) != null) {
	        	jsonString.append(inpLine);
	        }
		} catch (MalformedURLException e) {
			System.out.println("URL is malformed: " + e.getMessage());
		} catch (UnsupportedEncodingException e) {
			System.out.println("Strange encoding!: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Problem reading!: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Other Exception: " + e.getMessage());
		} finally {
			// Do this to prevent leaking
			try {
			 if (inputData != null) {
				 inputData.close();
			 }
			} catch (IOException e) {
				System.out.println("IO Problem with file: " + e.getMessage());
			}
		}
		return jsonString.toString(); 
	}
}
