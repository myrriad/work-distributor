package calculator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import due.Project;

/**
 * ALL MUTABLE
 * Not solved; purely just boilerplate.
 * @author phlaxyr
 *
 */
public class WorkCalendarTemplate {
	
	LocalDateTime start;
	final List<Project> project = new ArrayList<>();
	public WorkCalendarTemplate(LocalDateTime start) {
		this.start = start;
	}
	public void addProject(Project p) {
		project.add(p);
	}
	
	
}
