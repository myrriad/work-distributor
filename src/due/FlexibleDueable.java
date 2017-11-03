package due;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.TemporalUnit;

import due.workunit.WorkAmount;

/***
 * 
 * supports times, ie. 3:25 pm
 *
 */
class FlexibleDueable implements IDueable{

	private final WorkAmount work;
	private final LocalDateTime start;
	private final LocalDateTime due;
	private final Period duration;
	
	public FlexibleDueable(LocalDateTime start, LocalDateTime due, WorkAmount work){
		this.start = start;
		this.due = due;
		this.duration = Period.between(start.toLocalDate(), due.toLocalDate());
		this.work = work;
	}
	
	@Override
	public LocalDateTime start() {
		return start;
	}

	@Override
	public LocalDateTime due() {
		return due;
	}

	@Override
	public Period duration() {
		return duration;
	}
	@Override
	public WorkAmount getWork() {
		return work;
	}

}
