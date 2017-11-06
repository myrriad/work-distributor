package due;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

import due.workunit.IObjective;
public interface IDueable extends IObjective{
	
	// public IObjective getWork();
	
	public LocalDateTime start();
	public LocalDateTime due();
	public Period numDays();
	public Duration numSecs();
	
}
