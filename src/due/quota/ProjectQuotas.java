package due.quota;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.google.common.collect.ImmutableList;

import due.Project;

/**
 * Immutable
 * @author phlaxyr
 *
 */
public final class ProjectQuotas {
	public final Project linkedProject;
	
	// based on Project's first day
	final ImmutableList<DailyQuota> quotas;
	
	
	public ProjectQuotas(Project projectIn, ImmutableList<DailyQuota> quotas){
		
		
		this.quotas = quotas;
		this.linkedProject = projectIn;
	}
	/**
	 * 
	 * @param day
	 * from 0 to project.intDays() - 1;
	 * not based on a "universal time schedule", but the project internal clock
	 * for this reason, be careful!
	 * 
	 * @return
	 * The answer, relevant to the project
	 */
	public DailyQuota getByProject(int day) {
		return quotas.get(day);
	}
	/**
	 * Based on the start of the project
	 * @param day
	 * @return
	 */
	public DailyQuota getByDate(LocalDate day) {
		return getByProject((int) ChronoUnit.DAYS.between(linkedProject.start(), day));
	}
	
	
	public List<DailyQuota> quotas() {
		return quotas;
	}//*/
}
