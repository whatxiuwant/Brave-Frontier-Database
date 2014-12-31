package bfdpkg;
import java.util.*;

public class Units {
	private ArrayList<Unit> units;
	
	public Units() {
		units = new ArrayList<Unit>();
	}
	
	public int getLength() {return units.size();}
	public Unit getUnit(int idx) {return units.get(idx);}
	public ArrayList<Unit> getUnits() {return units;}
	
	public void addUnit(Unit unit) {
		units.add(unit);
	}
	
	public String toString() {
		String units = "";
		for (int i = 0; i < this.units.size(); i++)
			units += this.units.get(i) + "\n";
		
		return units;
	}

	public String sortBy(String name) {
		if (name.equalsIgnoreCase("name"))
			return sortByName();
		
		return "Could not sort.";	
	}
	
	public String sortByName() {
		String data = "";
		String[] temp = new String[units.size()];
		
		for (int i = 0; i < units.size(); i++)
			temp[i] = units.get(i).getName();
		
		Arrays.sort(temp);
		
		for (int i = 0; i < temp.length; i++)
			for (int j = 0; j < units.size(); j++)
				if (temp[i].equals(units.get(j).getName()))
					data += units.get(j) + "\n";
		
		return data;
	}
	
	public String sortByATK() {
		String data = "";
		int[] temp = new int[units.size()];
		
		for (int i = 0; i < units.size(); i++)
			temp[i] = units.get(i).getATK();
		
		Arrays.sort(temp);
		
		for (int i = temp.length - 1; i >= 0; i--)
			for (int j = 0; j < units.size(); j++)
				if (temp[i] == units.get(j).getATK())
					data += units.get(j) + "\n";
		
		return data;
	}
}