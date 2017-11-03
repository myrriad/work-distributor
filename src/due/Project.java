package due;

import java.time.LocalDate;

import due.workunit.WorkAmount;

public class Project extends DueableByDays {

	public Project(LocalDate start, LocalDate due, WorkAmount work) {
		super(start, due, work);
	}

}
