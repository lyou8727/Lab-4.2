package lab4_2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVUtilities {
	private static ArrayList<String> CSVData = new ArrayList<String>();
	int numColumns;
	
	public CSVUtilities(File sat) throws IOException {
		FileReader pathToFile = new FileReader(sat);

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = new BufferedReader(pathToFile)) {
            String line = br.readLine();
            while (line != null) {
                CSVData.add(line);
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
	}
	
	public List<String> getColumnHeaders(){
		return Arrays.asList(CSVData.get(0).split(","));
	}
	
	public static List<String> getDataString(int column){
		ArrayList<String> data = new ArrayList<String>();
		for (int x = 1; x < CSVData.size(); x++) 
		{
			String[] temp = CSVData.get(x).split(",");
			data.add(temp[column]);
		}
		return data;
	}
	public static List<Integer> getDataInt(int column){
		ArrayList<Integer> data = new ArrayList<Integer>();
		for (int x = 1; x < CSVData.size(); x++)
		{;
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
