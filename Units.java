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
}
