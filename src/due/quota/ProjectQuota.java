package due.quota;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import due.DueableByDays;
import due.IDueable;
import due.Project;
import due.workunit.WorkAmount;

public class ProjectQuota implements IDueable, Quota{
	private Project linkedProject;
	
	public Project getProject() {
		return linkedProject;
	}
	
	
	


	@Override
	public WorkAmount getWork() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public LocalDateTime start() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public LocalDateTime due() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Period duration() {
		// TODO Auto-generated method stub
		return null;
	}
}
