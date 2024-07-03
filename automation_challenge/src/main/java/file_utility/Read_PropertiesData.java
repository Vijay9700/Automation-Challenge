package file_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Vijay Ganesan
 */
public class Read_PropertiesData {
	FileInputStream fis;
	public String read_Property(String key)
	{
		//properties file path
		String path="./src/test/resources/common_data/url.properties";
		//get the object of properties file
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//create an object for properties file
		Properties prob=new Properties();
		//load
		try {
			prob.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//get data
		String data = prob.getProperty(key);
		//return data
		return data;
	}

}
