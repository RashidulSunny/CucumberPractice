package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadConfigFiles {

    private static final  Logger LOGGER = LogManager.getLogger(LoadConfigFiles.class);
    public Properties readPropertyValues() throws IOException {
        //create object of Properties---this is class
        Properties prop = new Properties();
        //read any file use InputStream---this is class
        InputStream inputstream = null;
        //For exception handling use try catch and use logger for log the exception
        try{
            //create property file name
            String propFileName = "config.properties";
            //load the file for read it
            inputstream = getClass().getClassLoader().getResourceAsStream(propFileName);
            //read the variable inputstream
            if(inputstream != null){
                prop.load(inputstream);

            }else {
                throw new FileNotFoundException("Property File " + propFileName + " not found in the classpath");
            }

        }catch (Exception e){
            LOGGER.error("Exception is : " + e.getMessage());
//close the file
        }finally {
            inputstream.close();

        }
        return prop;
    }
}
