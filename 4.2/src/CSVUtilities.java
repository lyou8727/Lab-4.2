import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVUtilities {
	ArrayList<String> CSVData;
	int numColumns;
	
	public CSVUtilities(String csv) {
        Path pathToFile = Paths.get(csv);

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");

                // adding book into ArrayList
                CSVData.add(line);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
	}
	public List<String> getColumnHeaders(){
		return Arrays.asList(CSVData.get(0).split(","));
	}
	public List<String> getDataString(int column){
		ArrayList<String> data = new ArrayList<String>();
		for (int x = 1; x < CSVData.size(); x++) 
		{
			String[] temp = CSVData.get(x).split(",");
			data.add(temp[column]);
		}
		return data;
	}
	public List<Integer> getDataInt(int column){
		ArrayList<Integer> data = new ArrayList<Integer>();
		for (int x = 1; x < CSVData.size(); x++)
		{
			String[] temp = CSVData.get(x).split(",");
			data.add(Integer.parseInt(temp[column]));
		}
		return data;
	}
	public List<Double> getDataDouble(int column){
		ArrayList<Double> data = new ArrayList<Double>();
		for (int x = 1; x < CSVData.size(); x++) 
		{
			String[] temp = CSVData.get(x).split(",");
			data.add(Double.parseDouble(temp[column]));
		}
		return data;
	}
}
