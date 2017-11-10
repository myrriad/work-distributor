package due;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import com.google.common.collect.ImmutableCollection;
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
	public Period durDays() {
		return numdays;
	}
	public IObjective getUnderlyingWork() {
		return work;
	}
	@Override
	public ImmutableList<WorkQuantity> getQuantities() {
		return work.getQuantities();
	}
	@Override
	public Duration durSecs() {
		return numsecs;
	}
	@Override
	public double quantityOf(WorkType type) {
		return work.quantityOf(type);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((due == null) ? 0 : due.hashCode());
		result = prime * result + ((numdays == null) ? 0 : numdays.hashCode());
		result = prime * result + ((numsecs == null) ? 0 : numsecs.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result + ((work == null) ? 0 : work.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlexibleDueable other = (FlexibleDueable) obj;
		if (due == null) {
			if (other.due != null)
				return false;
		} else if (!due.equals(other.due))
			return false;
		if (numdays == null) {
			if (other.numdays != null)
				return false;
		} else if (!numdays.equals(other.numdays))
			return false;
		if (numsecs == null) {
			if (other.numsecs != null)
				return false;
		} else if (!numsecs.equals(other.numsecs))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (work == null) {
			if (other.work != null)
				return false;
		} else if (!work.equals(other.work))
			return false;
		return true;
	}

}
