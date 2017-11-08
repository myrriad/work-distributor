package due.quota;

import java.util.List;

import com.google.common.collect.ImmutableList;

/**
 * Immutable
 * @author phlaxyr
 *
 */
public final class ProjectQuotas {
	final ImmutableList<DailyProjectQuota> quotas;
	
	
	public ProjectQuotas(ImmutableList<DailyProjectQuota> quotas){
		this.quotas = quotas;
	}
	
	
	public List<DailyProjectQuota> quotas() {
		return quotas;
	}//*/
}
