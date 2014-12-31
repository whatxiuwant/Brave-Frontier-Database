package bfdpkg;
import java.util.*;
import java.io.*;

public class Reader {
	public static void main(String[] args) throws IOException {
		File input = new File("Brave_Frontier_Database.csv");
		Scanner scan = new Scanner(input);
		Units units = new Units();
		
		while (scan.hasNextLine()) {
			String[] unitData = scan.nextLine().split(",");
			Unit unit = new Unit(Integer.parseInt(unitData[0]), Integer.parseInt(unitData[2]), 
					Integer.parseInt(unitData[4]), Integer.parseInt(unitData[5]), 
					Integer.parseInt(unitData[6]), Integer.parseInt(unitData[7]), 
					Integer.parseInt(unitData[8]), Integer.parseInt(unitData[9]),
					unitData[1], unitData[3], unitData[10]);
			
			units.addUnit(unit);
		}
		
		scan.close();
		
		System.out.println(units.sortByATK());
	}
}