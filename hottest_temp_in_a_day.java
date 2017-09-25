
/**
 * Write a description of class hottest_temp_in_a_day here.
 * 
 * @author (Mou) 
 * @version (a version number or a date)
 */
 import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class hottest_temp_in_a_day
{
  
    
    public CSVRecord maxTempInCSVFile(CSVParser parser) {
		
		CSVRecord largestSoFar = null;
		
		for (CSVRecord currentRow : parser) {
			
			if (largestSoFar == null) {
				largestSoFar = currentRow;
			}
			
			else {
				double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
				double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
				
				if (currentTemp > largestTemp) {
					
					largestSoFar = currentRow;
			}
		}
		
		
	}
         return largestSoFar;
}


	public void testHottestTempInDay () 
	{
		FileResource fr = new FileResource();
		CSVParser parser =fr.getCSVParser();
		CSVRecord hottestHour = maxTempInCSVFile(parser);
		System.out.println("Hottest temperature :  " + hottestHour.get("TemperatureF") +
				   " at  time " + hottestHour.get("TimeEST"));
	}
}
