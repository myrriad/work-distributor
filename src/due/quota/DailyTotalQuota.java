package due.quota;

import java.time.LocalDate;

import due.workunit.IObjective;
import due.workunit.WorkClumper;
import due.workunit.WorkQuantity;
@Deprecated
public class DailyTotalQuota extends DailyQuota {
	public DailyTotalQuota(LocalDate startIn, IObjective work) {
		super(startIn,work);
	}
	public DailyTotalQuota(LocalDate startIn, WorkQuantity... works) {
		this(startIn, WorkClumper.from(works));
	}
	
	
	public DailyTotalQuota(LocalDate startIn, DailyQuota... quotas) {
		this(startIn, WorkClumper.from(quotas));
	}

}
