package due.workunit;

import com.google.common.collect.ImmutableList;

/***
 * 
 * IMMUTABLE!
 * Exactly one type of work, plus its quantity
 * @author phlaxyr
 *
 */
public final class WorkQuantity implements IObjective {
	private final double quantity;
	private final WorkType unit;
	public WorkQuantity(WorkType unit, double quantity){
		this.quantity = quantity;
		this.unit = unit;
	}
	public WorkType type() {
		return unit;
	}
	
	public double quantity() {
		return quantity;
	}
	/***
	 * Returns a WorkAmount which is the sum of this and the parameter.
	 * 
	 * @param toAdd
	 * @return
	 * The sum of this and the parameter toAdd. If the types are incompatible, then null isreturned.
	 */
	public WorkQuantity plus(WorkQuantity toAdd){
		if(unit.equals(toAdd.type())) {
			return new WorkQuantity(unit, quantity + toAdd.quantity());
		}
		return null;
	}
	/**
	 * Can throw an arithmeticexception if it can't be converted
	 * @return
	 */
	public double convertToHours(){
		return unit.getHoursPerUnit();
	}
	public boolean canConvertToHours(){
		return unit.canConvert();
	}
	/**
	 * This is safe to use -- however, if you're seeing this,
	 * then you should use the `quantity()` and `type()` methods instead,
	 * so as to not wrap the things into immutablelists
	 */
	@Deprecated
	@Override
	public ImmutableList<WorkQuantity> getTypes() {
		return ImmutableList.of(this);
	}
	@Deprecated
	@Override
	public double quantityOf(WorkType type) {
		if(type == this.type()) return quantity();
		return 0;
	}
	
	
}
