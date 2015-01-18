package bfdpkg;

public class Unit {
	private int unit_no, unit_rarity, unit_max_lv, unit_cost, unit_hp, unit_atk, unit_def, unit_rec;
	private String unit_name, unit_type;
	private boolean isHuman;
	
	public Unit(int no, int rarity, int lv, int cost, int hp, int atk, int def, int rec, String name, String type, String species) {
		unit_no = no;
		unit_rarity = rarity;
		unit_max_lv = lv;
		unit_cost = cost;
		unit_hp = hp;
		unit_atk = atk;
		unit_def = def;
		unit_rec = rec;
		unit_name = name;
		unit_type = type;
		
		if (species.equalsIgnoreCase("Y"))
			isHuman = true;
		else
			isHuman = false;
	}
	
	public int getNo() {return unit_no;}
	public int getRarity() {return unit_rarity;}
	public int getLv() {return unit_max_lv;}
	public int getCost() {return unit_cost;}
	public int getHP() {return unit_hp;}
	public int getATK() {return unit_atk;}
	public int getDEF() {return unit_def;}
	public int getREC() {return unit_rec;}
	public String getName() {return unit_name;}
	public String getType() {return unit_type;}
	public boolean getSpecies() {return isHuman;}
	
	public String statsOfType(String type) {
		int[] stats = new int[4];
		if (type.equalsIgnoreCase("anima")) {
			stats[0] = (int) (unit_hp * 1.1); stats[1] = unit_atk; stats[2] = unit_def; stats[3] = (int) (unit_rec + unit_rec * -.1); }
		if (type.equalsIgnoreCase("breaker")) {
			stats[0] = unit_hp; stats[1] = (int) (unit_atk * 1.1); stats[2] = (int) (unit_def + unit_def * -.1); stats[3] = unit_rec; }
		if (type.equalsIgnoreCase("guardian")) {
			stats[0] = unit_hp; stats[1] = (int) (unit_atk + unit_atk * -.1); stats[2] = (int) (unit_def * 1.1); stats[3] = unit_rec; }
		if (type.equalsIgnoreCase("oracle")) {
			stats[0] = (int) (unit_hp + unit_hp * -.1); stats[1] = unit_atk; stats[2] = unit_def; stats[3] = (int) (unit_rec * 1.1); }
		
		String result = "";
		for (int i = 0; i < stats.length; i++)
			result += stats[i] + " ";
			
		return result;
	}
	
	public String toString() {
		String unit = "";
		unit += " " + unit_no;
		unit += getSpaces(21 - unit_name.length()) + unit_name;
		unit += " " + unit_rarity;
		unit += getSpaces(4 - ("" + unit_max_lv).length()) + unit_max_lv;
		unit += getSpaces(3 - ("" + unit_cost).length()) + unit_cost;
		unit += " " + unit_hp;
		unit += " " + unit_atk;
		unit += " " + unit_def;
		unit += " " + unit_rec;
		
		if (isHuman == true)
			unit += " Human";
		else
			unit += " Other";
		
		return unit;
	}
	
	public String getSpaces(int amount) {
		String spaces = "";
		
		for (int i = 0; i < amount; i++)
			spaces += " ";
		
		return spaces;
	}
}