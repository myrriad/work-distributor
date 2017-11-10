package due;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

import due.workunit.IObjective;
public interface IDueable extends IObjective{
	
	// public IObjective getWork();
	
	public LocalDateTime start();
	public LocalDateTime due();
	/**
	 * Period in days
	 * @return
	 */
	public Period durDays();
	public default int intDays(){
		return durDays().getDays();
	}
	public default long intSecs(){
		return durSecs().getSeconds();
	}
	/**
	 * Duration in seconds
	 * @return
	 */
	public Duration durSecs();
	
}
