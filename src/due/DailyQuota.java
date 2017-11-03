package due;

import java.time.LocalDate;

public class DailyQuota extends DayDueable {

	
	
	public DailyQuota(LocalDate datestart) {
		super(datestart, datestart.plusDays(1));
	}

}
