package due.workunit;

/**
 * These units cannot be converted to hours.
 * @author phlaxyr
 *
 */
public class WorkUnitStandard {
	public static final WorkType PAGE = new WorkType(0, "page");
	public static final WorkType PARAGRAPH = new WorkType(0, "paragraph");
	public static final WorkType LINE = new WorkType(0, "line");
	public static final WorkType WORD = new WorkType(0, "word");
	public static final WorkType QUESTION = new WorkType(0, "question");
	
	
	public static final WorkType HOUR = new WorkType(1, "hour");
}
