package due;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

import due.workunit.WorkAmount;

public class DayDueable implements IDueable{

	private LocalDateTime start;
	LocalDateTime due;
	private Period duration;
	
	public DayDueable(LocalDateTime start, LocalDateTime due){
		this.start = start;
		this.due = due;
		this.duration = Period.between(start.toLocalDate(), due.toLocalDate());
	}
	public DayDueable(LocalDate start, LocalDate due){
		this.start = start.atStartOfDay();
		this.due = due.atStartOfDay();
		this.duration = Period.between(start, due);
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
		// TODO Auto-generated method stub
		return null;
	}

}
