package due;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import due.workunit.WorkAmount;

/***
 * Immutable
 * 
 *
 */
public class DueableByDays extends FlexibleDueable{

	public DueableByDays(LocalDateTime start, LocalDateTime due, WorkAmount work) {
		super(start.truncatedTo(ChronoUnit.DAYS), due.truncatedTo(ChronoUnit.DAYS), work);
	}
	public DueableByDays(LocalDate start, LocalDate due, WorkAmount work) {
		super(start.atStartOfDay(), due.atStartOfDay(), work);
	}

	

}
