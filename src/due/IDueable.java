package due;

import java.time.LocalDateTime;
import java.time.Period;

import due.workunit.WorkAmount;
public interface IDueable<W extends WorkAmount> {
	
	public W getWork();
	
	public LocalDateTime start();
	public LocalDateTime due();
	public Period duration();
	public default int durationDays(){
		return duration().getDays();
	}
	
}
