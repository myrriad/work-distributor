package due.quota;

import java.time.LocalDate;

import due.DueableByDays;
import due.Project;
import due.workunit.WorkAmount;

public class DailyProjectQuota extends DueableByDays implements Quota{
	private Project linkedProject;
	
	public Project getProject() {
		return linkedProject;
	}
	
	
	public DailyProjectQuota(LocalDate datestart, WorkAmount work) {
		super(datestart, datestart.plusDays(1), work);
	}

}
