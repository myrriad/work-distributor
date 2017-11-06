package due.workunit;

public class WorkType {
	/**
	 * If your unit cannot be converted to hours, then pass a 0 to the constructor.
	 * @param toHours
	 * pass a 0 if the unit can't be converted into hours
	 */
	public WorkType(double toHours, String name) {
		this.toHours = toHours;
		this.name = name;
	}
	private final String name;
	private final double toHours;
	/**
	 * Can throw an arithmetic exception if not checked.
	 * @return
	 */
	public double getHoursPerUnit(){
		if(!canConvert()) throw new ArithmeticException("Cannot convert!");
		return toHours;
	}
	public boolean canConvert() {
		return toHours != 0;
	}
	public String unitName() {
		return name;
	}
	public String unitNamePlural(){
		return unitName() + "s";
	}
	
	
}
