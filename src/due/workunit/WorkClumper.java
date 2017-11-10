package due.workunit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;

import due.IDueable;

/**
 * Immutable!
 * @author phlaxyr
 *
 */
public class WorkClumper {
	public static IObjective from(List<WorkQuantity>quantities){
		return immute(quantities);
	}
	public static IObjective from(WorkQuantity...quantities) {
		return immute(quantities);
	}
	private static Clump immute(List<WorkQuantity>quantities){
		return new Clump(ImmutableList.copyOf(quantities));
	}
	private static Clump immute(WorkQuantity...quantities){
		return new Clump(ImmutableList.copyOf(quantities));
	}
	//  3 practically exact same declarations
	public static IObjective from(IDueable... dueables) {
		List<WorkQuantity> amounts = new ArrayList<>();
		for (IDueable due : dueables) {
			for (WorkQuantity work : due.getQuantities()) {
				amounts.add(work);
			}
		}
		return immute(amounts);
	}
	public static IObjective merge(Clump...composites){
		List<WorkQuantity> temp = new ArrayList<>();
		for(Clump composite : composites) {
			for(WorkQuantity amount : composite.getQuantities()) {
				temp.add(amount);
			}
		}
		return immute(temp);
	}
	public static IObjective merge(Iterable<Clump> composites) {
		List<WorkQuantity> temp = new ArrayList<>();
		for(Clump composite : composites) {
			for(WorkQuantity amount : composite.getQuantities()) {
				temp.add(amount);
			}
		}
		return immute(temp);
	}
	
	public static class Clump implements IObjective {
		
		/**
		 * Assume that it's fixed size
		 */
		private final ImmutableList<WorkQuantity> works;
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((works == null) ? 0 : works.hashCode());
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
			Clump other = (Clump) obj;
			if (works == null) {
				if (other.works != null)
					return false;
			} else if (!works.equals(other.works))
				return false;
			return true;
		}

		/**
		 * YAY ImmutableList
		 */
		Clump(ImmutableList<WorkQuantity> works) { 
			Map<WorkType, WorkQuantity> dedup = new HashMap<>();
			for(WorkQuantity work : works) {
				WorkType type = work.getType();
				if(dedup.containsKey(type)) {
					WorkQuantity old = dedup.get(type);
					dedup.put(type, old.plus(work));
				} else {
					dedup.put(type, work);
				}
			}
			this.works = ImmutableList.copyOf(works);
		}
		/*
		public WorkMulti(IDueable... dues) {
			List<WorkQuantity> amounts = new ArrayList<>();
			for(IDueable due: dues) {
				for(WorkQuantity work : due.getTypes()) {
					amounts.add(work);
				}
			}
			works = toArray(amounts);
		}*/
				
		public ImmutableList<WorkQuantity> getQuantities(){
			return works;
		}
		public double quantityOf(WorkType type){
			double total = 0;
			for(WorkQuantity w : works) {
				if(w.getType().equals(type)) {
					total += w.getQuantity();
				}
			}
			return total;
		}
	}
}
