package due;

import java.time.LocalDate;

import due.workunit.IObjective;

public class Project extends FlexibleDueable {

	public Project(LocalDate start, LocalDate due, IObjective work) {
		super(start,due,work);
	}

}
