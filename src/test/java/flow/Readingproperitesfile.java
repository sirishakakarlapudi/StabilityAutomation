package flow;

import java.io.FileInputStream;
import java.util.Properties;

public class Readingproperitesfile {
	public String readingPropertiesurl() throws Exception {
		                         //location of properties file
		FileInputStream propfile = new FileInputStream(System.getProperty("user.div")+"\\Test data\\loginDetails.proeprties");
		                                 //loading data into properties file
		Properties propertyobj=new Properties();
		propertyobj.load(propfile);
		                                //reading the data from properties file
		String url=propertyobj.getProperty("appurl");
		System.out.println("read the data");
		return url;
	}
	
	
	public String readingPropertiesloginDetails(String username, String password) throws Exception {
        //location of properties file
FileInputStream propfile = new FileInputStream(System.getProperty("user.div")+"\\Test data\\loginDetails.proeprties");
                //loading data into properties file
Properties propertyobj=new Properties();
propertyobj.load(propfile);
		return username=propertyobj.getProperty("appusername");
	
	}

}

