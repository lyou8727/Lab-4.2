import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import lab4_2.CSVUtilities;

public class Runner {

	public static void main(String[] args) throws IOException 
	{
		File sat = new File("SATRESULTS.csv");
		
		CSVUtilities csv = new CSVUtilities(sat);
		
		List<String> heading = csv.getColumnHeaders();
		for (String x: heading) 
		{
			System.out.println(x);
		}
		List<String> DBN = CSVUtilities.getDataString(0);
		for(String x : DBN)
		{
			System.out.print(x+ " ");
		}
		System.out.println();
		//test string
		List<String> School = CSVUtilities.getDataString(1);
		for(String x : School)
		{
			System.out.print(x+ " ");
		}
		System.out.println();
		//test int
		List<String> Takers = CSVUtilities.getDataString(2);
		for(String x : Takers)
		{
			System.out.print(x+ " ");
		}
		System.out.println();
		List<Integer> Reading = CSVUtilities.getDataInt(3);
		for(int x : Reading)
		{
			System.out.print(x+ " ");
		}
		System.out.println();
		List<Integer> Math = CSVUtilities.getDataInt(4);
		for(int x : Math)
		{
			System.out.print(x+ " ");
		}
		System.out.println();
		List<Integer> Writing = CSVUtilities.getDataInt(5);
		for(int x : Writing)
		{
			System.out.print(x+ " ");
		}
		System.out.println();
	 }
	
}
