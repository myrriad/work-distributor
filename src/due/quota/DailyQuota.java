package due.quota;

import java.time.LocalDate;

import due.FlexibleDueable;
import due.workunit.IObjective;
import due.workunit.WorkClumper;
import due.workunit.WorkQuantity;

public class DailyQuota extends FlexibleDueable{
	
	public DailyQuota(LocalDate datestart, IObjective work) {
		super(datestart, datestart.plusDays(1), work);
	}
	public DailyQuota(LocalDate datestart, WorkQuantity work) {
		this(datestart, WorkClumper.from(work));
	}
	@Override
	public int intDays(){
		return 1;
	}
}
