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
	
	public int getAvg(String stat) {
		int total = 0;
		
		if (stat.equalsIgnoreCase("hp") || stat.equalsIgnoreCase("health"))
			for (int i = 0; i < units.size(); i++)
				total += units.get(i).getHP();
		else if (stat.equalsIgnoreCase("atk") || stat.equalsIgnoreCase("attack"))
			for (int i = 0; i < units.size(); i++)
				total += units.get(i).getATK();
		else if (stat.equalsIgnoreCase("def") || stat.equalsIgnoreCase("defense"))
			for (int i = 0; i < units.size(); i++)
				total += units.get(i).getDEF();
		else if (stat.equalsIgnoreCase("rec") || stat.equalsIgnoreCase("recovery"))
			for (int i = 0; i < units.size(); i++)
				total += units.get(i).getREC();
		else
			return -999;
		
		return total / units.size();
	}
	
	public void addUnit(Unit unit) {
		units.add(unit);
	}
	
	public String toString() {
		String units = "";
		for (int i = 0; i < this.units.size(); i++)
			units += this.units.get(i) + "\n";
		
		return units;
	}
	
	public void sortBy(String area) {
		switch (area) {
			case "name":
				for (int j = 0; j < units.size() - 1; j++) {
					int minIndex = j;
					for (int k = j + 1; k < units.size(); k++) 
						if (units.get(k).compareTo(units.get(minIndex), "name") == -1)
							minIndex = k;
					swap(j, minIndex);
				}
				break;
			case "attack":
				for (int j = 0; j < units.size() - 1; j++) {
					int minIndex = j;
					for (int k = j + 1; k < units.size(); k++) 
						if (units.get(k).compareTo(units.get(minIndex), "attack") == -1)
							minIndex = k;
					swap(j, minIndex);
				}
				break;
		}
	}
	
	public String search(String area, String search) {
		String str = "";
		switch (area) {
			case "number":
				for (int i = 0; i < units.size(); i++)
					if (search.equalsIgnoreCase("" + units.get(i).getNo()))
						return units.get(i).toString();
				break;
			case "name":
				for (int i = 0; i < units.size(); i++)
					if (units.get(i).getName().indexOf(search) > 0)
						str += units.get(i).toString() + "\n";
				break;
			case "rarity":
				for (int i = 0; i < units.size(); i++)
					if (search.equalsIgnoreCase("" + units.get(i).getRarity()))
						str += units.get(i).toString() + "\n";
				break;
			case "max level":
				for (int i = 0; i < units.size(); i++)
					if (search.equalsIgnoreCase("" + units.get(i).getLv()))
						str += units.get(i).toString() + "\n";
				break;
			case "cost":
				for (int i = 0; i < units.size(); i++)
					if (search.equalsIgnoreCase("" + units.get(i).getCost()))
						str += units.get(i).toString() + "\n";
				break;
			case "health":
				for (int i = 0; i < units.size(); i++)
					if (units.get(i).getHP() >= Integer.parseInt(search))
						str += units.get(i).toString() + "\n";
				break;
			case "attack":
				for (int i = 0; i < units.size(); i++)
					if (units.get(i).getATK() >= Integer.parseInt(search))
						str += units.get(i).toString() + "\n";
				break;
			case "defense":
				for (int i = 0; i < units.size(); i++)
					if (units.get(i).getDEF() >= Integer.parseInt(search))
						str += units.get(i).toString() + "\n";
				break;
			case "recovery":
				for (int i = 0; i < units.size(); i++)
					if (units.get(i).getREC() >= Integer.parseInt(search))
						str += units.get(i).toString() + "\n";
				break;
		}
		
		return str;
	}
	
	public void swap(int j, int k) {
		Unit temp = units.get(j);
		units.set(j, units.get(k));
		units.set(k, temp);
	}
}