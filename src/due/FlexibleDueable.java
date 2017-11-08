package due;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import com.google.common.collect.ImmutableList;

import due.workunit.IObjective;
import due.workunit.WorkQuantity;
import due.workunit.WorkType;

/***
 * An implementation of IDueable.
 * supports times, ie. 3:25 pm
 *
 */
public class FlexibleDueable implements IDueable{
	
	private final IObjective work;
	private final LocalDateTime start;
	private final LocalDateTime due;
	private final Period numdays;
	private final Duration numsecs;
	public FlexibleDueable(LocalDateTime startIn, LocalDateTime dueIn, IObjective workIn){
		start = startIn;
		due = dueIn;
		work = workIn;
		numdays = Period.between(start.toLocalDate(), due.toLocalDate());
		// TODO do something with second accuracy
		numsecs = Duration.between(start, due);

	}
	public FlexibleDueable(LocalDate startIn, LocalDate dueIn, IObjective workIn){
		this(startIn.atStartOfDay(), dueIn.atStartOfDay(), workIn);
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
	public Period numDays() {
		return numdays;
	}
	public IObjective getUnderlyingWork() {
		return work;
	}
	@Override
	public ImmutableList<WorkQuantity> getTypes() {
		return work.getTypes();
	}
	@Override
	public Duration numSecs() {
		return numsecs;
	}
	@Override
	public double quantityOf(WorkType type) {
		return work.quantityOf(type);
	}

}
