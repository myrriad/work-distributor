package due;

import java.time.LocalDate;

import due.workunit.IObjective;

/**
 * Immutable
 * Start is the assignment date
 * Due is due
 * @author phlaxyr
 *
 */
public class Project extends FlexibleDueable {

	public Project(LocalDate start, LocalDate due, IObjective work) {
		super(start,due,work);
	}

}
