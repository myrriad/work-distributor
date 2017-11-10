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
	public WorkType getType() {
		return unit;
	}
	
	public double getQuantity() {
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
		if(unit.equals(toAdd.getType())) {
			return new WorkQuantity(unit, quantity + toAdd.getQuantity());
		}
		return null;
	}
	/**
	 * Can throw an arithmeticexception if it can't be converted
	 * @return
	 */
	public double convertToHours(){
		return unit.getHoursPerUnit() * getQuantity();
	}
	public boolean canConvertToHours(){
		return unit.canConvert();
	}
	/**
	 * This is safe to use -- however, if you're seeing this,
	 * then you should use the `quantity()` and `type()` methods and `this` instead,
	 * so as to not wrap the things into immutablelists
	 */
	@Deprecated
	@Override
	public ImmutableList<WorkQuantity> getQuantities() {
		return ImmutableList.of(this);
	}
	/**
	 * This is safe to use -- however, if you're seeing this,
	 * then you should use the `quantity()` and `type()` methods and `this` instead,
	 * so as to not wrap the things into immutablelists
	 */
	@Deprecated
	@Override
	public double quantityOf(WorkType type) {
		if(type == this.getType()) return getQuantity();
		return 0;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(quantity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkQuantity other = (WorkQuantity) obj;
		if (Double.doubleToLongBits(quantity) != Double.doubleToLongBits(other.quantity))
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		return true;
	}
	
	
}
