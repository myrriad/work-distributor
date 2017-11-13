package calculator;

import java.time.LocalDate;

import com.google.common.collect.ImmutableList;

import due.Project;
import due.quota.DailyQuota;
import due.quota.ProjectQuotas;

public class WorkCalendarSolution {
	private final ImmutableList<ProjectQuotas> quotas;
	public WorkCalendarSolution(ProjectQuotas...quotas) {
		this.quotas = ImmutableList.copyOf(quotas);
	}
	public ProjectQuotas get(Project p) {
		for(ProjectQuotas q : quotas) {
			if(q.linkedProject == p) {
				return q;
			}
		}
		return null;
	}
	public DailyQuota get(Project p, LocalDate day) {
		return get(p).getByDate(day);
	}
}
