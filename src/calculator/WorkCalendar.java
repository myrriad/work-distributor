package calculator;

import java.util.ArrayList;
import java.util.List;

import due.Project;

public class WorkCalendar {
	WorkCalendarSolution solution;
	private final List<Project>projects=new ArrayList<>();
	public List<Project> getProjects() {
		return projects;
	}
	public void add(Project toadd) {
		projects.add(toadd);
	}
	public Project get(int at){
		return projects.get(at);
	}
	
}
