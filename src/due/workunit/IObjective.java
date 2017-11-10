package due.workunit;

import com.google.common.collect.ImmutableList;

/**
 * Anything that needs to be done
 * For example, 3 pages AND 7 paragraphs
 * 
 *
 */
public interface IObjective {
	/**
	 * Make it an immutable list
	 * @return
	 */
	public ImmutableList<WorkQuantity> getQuantities();
	public double quantityOf(WorkType type);
}
