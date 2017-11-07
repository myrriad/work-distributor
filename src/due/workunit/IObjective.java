package due.workunit;

import java.util.List;

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
	public List<WorkQuantity> getTypes();
	public double quantityOf(WorkType type);
}
