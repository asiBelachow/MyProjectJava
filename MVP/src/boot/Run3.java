package boot;

import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import presenter.Properties;

public class Run3 {

	public static void main(String[] args) {
			XMLEncoder encoder;
			try {
				encoder = new XMLEncoder(new FileOutputStream("properties.xml"));
				Properties properties = new Properties();
				encoder.writeObject(properties);
				encoder.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		

	}

}
