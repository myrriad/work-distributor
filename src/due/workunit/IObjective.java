package due.workunit;

/**
 * Anything that needs to be done
 * For example, 3 pages AND 7 paragraphs
 * 
 *
 */
public interface IObjective {
	public WorkQuantity[] getTypes();
	public double quantityOf(WorkType type);
}
