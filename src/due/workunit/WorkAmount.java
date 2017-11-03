package due.workunit;

public class WorkAmount {
	private double quantity;
	private WorkUnit unit;
	public WorkAmount(WorkUnit unit, double quantity){
		this.quantity = quantity;
		this.unit = unit;
	}
	public WorkUnit unitType() {
		return unit;
	}
	
	public double quantity() {
		return quantity;
	}
	
	
}
