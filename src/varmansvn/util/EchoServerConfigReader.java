package varmansvn.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class EchoServerConfigReader {
	
	private Logger logger = Logger.getLogger(EchoServerConfigReader.class);
	
	private Properties echoServerProp = null;
	
	private static EchoServerConfigReader configReader = null;
	
	public static EchoServerConfigReader getInstance() {
		
		if(configReader == null) {
			configReader = new EchoServerConfigReader();
		}
		
		return configReader;
	}
	
	private EchoServerConfigReader() {
	
		echoServerProp = new Properties();
		 
	    String configFile = "config.properties";
	    
    	try {
    		echoServerProp.load(new FileInputStream(configFile));
  
    		logger.debug("read config file done");
    		
     	} catch (IOException ioEx) {
     		logger.debug(String.format("read failed %s", configFile), ioEx);   
     		
     	} catch(IllegalArgumentException iaEx) {
        	 logger.debug("the input stream contains a malformed Unicode escape sequence.", iaEx);
        	 
        }
    	
	}
	
	public String getPropertyValue(String key) {
		
		String value = "";
		
		if(key == null) {
			logger.debug("input key is null");
			return null;
		}
		
		value = echoServerProp.getProperty(key);
		if(value == null) {
			logger.debug(String.format("could not find match value for key: %s", key));
			return null;
		}
		
		return value;
	}

}
