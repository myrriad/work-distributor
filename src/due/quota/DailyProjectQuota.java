package due.quota;

import java.time.LocalDate;

import due.FlexibleDueable;
import due.Project;
import due.workunit.WorkClumper;
import due.workunit.WorkQuantity;

public class DailyProjectQuota extends FlexibleDueable {
	private Project linkedProject;
	
	public Project getProject() {
		return linkedProject;
	}
	public DailyProjectQuota(Project attachedProject, LocalDate datestart, WorkQuantity work) {
		super(datestart, datestart.plusDays(1), WorkClumper.from(work));
	}
}
