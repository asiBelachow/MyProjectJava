/*
 * 
 */
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
 * This class handles the properties XML file using</br> the
 * {@link Properties} class as the object holder. use singleton architecture
 * @author Asi Belachow
 * @version 1.0
 * @since 2016-10-19
 *
 */
public class PropertiesHandler {
	
	//------------------------------Data Members-------------------------//
	
	private static Properties properties;
	
	//------------------------------Constructors-------------------------//
	
	/**
	 * <h1>PropertiesHandler()</h1><p>
	 * <i><ul>private PropertiesHandler()<i><p>
	 * A private constructor 
	 */
	private PropertiesHandler(){

	}
	
	/**
	 * <h1>getInstance()</h1><p>
	 * <i><ul>static Properties getInstance()<i><p>
	 * Method to create a properties using singleton architecture
	 */
	public static Properties getInstance() throws FileNotFoundException{
		
		if( properties == null)
			properties = readProperties("resources/properties/properties.xml");
		return properties;
	}
	
	/**
	 * <h1>writeProperties</h1><p>
	 * <i><ul>static void writeProperties(Properties properties, String filename)<i><p>
	 *  This method write the properties to an XML file<br> .
	 * @param properties - properties
	 * @param filename -filename
	 * @throws FileNotFoundException - file not found exception
	 */
	public static void writeProperties(Properties properties, String filename) throws FileNotFoundException {

		XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));

		encoder.writeObject(properties);
		encoder.flush();
		encoder.close();
	}

	/**
	 * <h1>readProperties</h1><p>
	 * <i><ul>static Properties readProperties(String filename)<i><p>
	 *  This method read a XML file into properties class<br> .
	 * @param filename - filename
	 * @return the properties
	 * @throws FileNotFoundException - file not found exception
	 */
	private static Properties readProperties(String filename) throws FileNotFoundException {
		XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)));
		Properties o = (Properties) decoder.readObject();
		decoder.close();
		return o;
	}
	
}
