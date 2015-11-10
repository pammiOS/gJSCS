/**
 * 10th November 2015
 * 
 * @author The RoL
 * Class inherits from JSONClass and does what it needs  to do only
 * It should override any methods that it deems necessary from JSONClass
 * Purpose of JSONClass is to be generic
 * 
 */
public class GeoJson extends JSONClass {
	public GeoJson() {
		readBehavior = new ReadJson();
		convertBehavior =  new ConvertJson();
	}
}
