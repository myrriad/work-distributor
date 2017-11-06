package due.quota;

import java.time.LocalDate;

import due.FlexibleDueable;
import due.workunit.IObjective;
import due.workunit.WorkClumper;
import due.workunit.WorkQuantity;

public class DailyTotalQuota extends FlexibleDueable {
	public DailyTotalQuota(LocalDate startIn, IObjective work) {
		super(startIn,startIn.plusDays(1),work);
	}

	public DailyTotalQuota(LocalDate startIn, WorkQuantity... works) {
		this(startIn, WorkClumper.from(works));
	}
	
	public DailyTotalQuota(LocalDate startIn, DailyProjectQuota... quotas) {
		this(startIn, WorkClumper.from(quotas));
	}

}
