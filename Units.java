package bfdpkg;
import java.util.*;

public class Units {
	private ArrayList<Unit> units;
	
	public Units() {
		units = new ArrayList<Unit>();
	}
	
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
		String data = "";
		if (name.equalsIgnoreCase("name"))
			data = sortByName();
		
		return data;	
	}
	
	public String sortByName() {
		String data = "";
		ArrayList<Unit> temp = new ArrayList<Unit>();
		
		for (int i = 0; i < units.size() - 1; i++) {
			for (int j = 0; j < units.size() - 1; j++) {
				if (units.get(i).getName().compareTo(units.get(j).getName()) > 0)
					temp.add(units.get(i));
				else
					temp.add(units.get(j));
		}}
		
		for (int i = 0; i < temp.size(); i++)
			data += temp.get(i) + "\n";
		
		return data;
	}
}