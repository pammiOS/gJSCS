/**
 * 10th November 2014
 * 
 * @author The RoL
 * 
 */
public class BDDTest {
	public void should_return_Invalid_Argument_1() {
		//given 
		// no arguments to method
		
		//when
		// initial startup
		
		//then
		// print Invalid Argument
	}
	
	public void should_return_Invalid_Argument_2() {
		//given 
		String argumentOne = "aabcbdbfbebabcbdbfbebabcbdbfbebabcbdbfbebabcbdbfbebabcbdbfbebabcbdbfbebabcbdbfbebabcbdbfbebabcbdbfbeb";
		
		//when
		// initial startup
		
		//then
		// print Invalid Argument
	}
	public void should_return_Invalid_Argument_3() {
		//given 
		String argumentOne = "abcbdbfbebabcbdbfbebabcbdbfbebabcbdbfbebabcbdbfbebabcbdbfbebabcbdbfbebabcbdbfbebabcbdbfbebabcbdbfbeb";
		
		//when
		// initial startup
		
		//then
		// Print Pass
	}
	
	public void should_return_Pass_4() {
		//given 
		String argumentOne = "abcbdbfbebabcbdbfbebabcbdbfbebabcbdbfbebabcbdbfbebabcbdbfbebabcbdbfbebabcbdbfbebabcbdbfbebabcbdbfbeb";
		
		//when
		// initial startup
		
		//then
		// Print Pass
	}
	
	public void should_return_Problem_Reading_4() {
		//given 
		String argumentOne = "Ber Lin";
		
		//when
		// initial startup
		
		//then
		// Print Problem reading
	}
	
	public void should_return_Json_Data() {
		//given
		//while ((x = in.readLine()) != null) {js.append(x);}
		
		//when 
		// urlString = "http://api.goeuro.com/api/v2/position/suggest/en/Berlin"
		
		//then
		// Print contents of url entry
	}
	
	public void should_return_null() {
		//given
		// jsonObject.getAsJsonObject("geo_position1");
		
		//when
		// when converting json to csv
		
		//then
		//Output should return null
	}
	
	public void should_write_empty_space_to_csv() {
		//given
		// jsonObject.getAsJsonObject("geo_position1");
		
		//when
		// when converting json to csv
		
		//then
		//csv file should contain empty spaces in latitude and longitude
	}
	
	
}
