package presenter;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


/**
 * <h1>PropertiesHandler</h1><p>
 * This class handles the properties XML file using</br> the Properties class as the
 * object holder
 * 
 * @author Asi Belachow
 *
 */
public class PropertiesHandler {
	
	private static Properties properties;
	

	private PropertiesHandler(){

	}
	
	
	public static Properties getInstance() throws FileNotFoundException{
		
		if( properties == null)
			properties = readProperties("resources/properties/properties.xml");
		return properties;
	}
	
	
	public static void writeProperties(Properties properties, String filename) throws FileNotFoundException {

		XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));

		encoder.writeObject(properties);
		encoder.flush();
		encoder.close();
	}

	
	private static Properties readProperties(String filename) throws FileNotFoundException {
		XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)));
		Properties o = (Properties) decoder.readObject();
		decoder.close();
		return o;
	}
	
}
